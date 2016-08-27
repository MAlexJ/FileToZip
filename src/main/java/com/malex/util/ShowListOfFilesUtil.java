package com.malex.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * Class {@link ShowListOfFilesUtil} shows the contents of a directory using a filter.
 *
 * @author malex
 */
public class ShowListOfFilesUtil {

    /**
     * Show files in directory with use filter {@link DirFilter}
     * Example:
     * show mp3 files: .*\.mp3
     * show txt files: .*\.txt
     *
     * @param pathToFile the path to file
     * @param expression RegEx expression
     */
    public static void showFilesInDirectory(String pathToFile, String expression) {
        File path = new File(pathToFile);

        String[] list = path.list(new DirFilter(expression));

        for (String item : list) {
            System.out.println(item);
        }

    }

    /**
     * Class implements FilenameFilter.
     */
    private static class DirFilter implements FilenameFilter {
        private Pattern pattern;

        DirFilter(String expressionRegEx) {
            pattern = Pattern.compile(expressionRegEx);
        }

        @Override
        public boolean accept(File dir, String name) {
            return pattern.matcher(name).matches();
        }
    }

}
