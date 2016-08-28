package com.malex.util;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;

/**
 * @author malex
 */
public class AnalyzeFileUtil {

    /**
     * Analyze the file.
     *
     * @param pathToFile the path to file.
     * @link http://stackoverflow.com/questions/2723838/determine-file-creation-date-in-java#2723838
     */
    public static void analyze(String pathToFile) {
        /*
        *  Simple solution
        */
//        File file = new File(path);
//        long date = file.lastModified();
//        System.out.println(new Date(date));

        Path path = Paths.get(pathToFile);
        BasicFileAttributes attr;
        try {
            attr = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println("Creation date: " + attr.creationTime());
            System.out.println("Last access date: " + attr.lastAccessTime());
            System.out.println("Last modified date: " + attr.lastModifiedTime());
        } catch (IOException e) {
            System.out.println("oops un error! " + e.getMessage());
        }
    }

    /**
     * Get date modified or crete the file.
     *
     * @param pathToFile the path to file.
     * @return the date modified or create file.
     * @throws IllegalArgumentException if file not exist.
     * @link http://ru.stackoverflow.com/questions/122845/%D0%94%D0%B0%D1%82%D0%B0-%D0%B8-%D0%B2%D1%80%D0%B5%D0%BC%D1%8F-%D1%81%D0%BE%D0%B7%D0%B4%D0%B0%D0%BD%D0%B8%D1%8F-%D1%84%D0%B0%D0%B9%D0%BB%D0%B0
     */
    public static Date getDateModifiedOrCreateFile(String pathToFile) {

        File file = new File(pathToFile);

        if (file.exists()) {
            return new Date(file.lastModified());
        }

        throw new IllegalArgumentException("File not exist!");
    }


    /**
     * Checks the file, created or modified today.
     *
     * @param pathToFile the path to files
     * @return true if the file created or modified today
     * @link http://stackoverflow.com/questions/32043644/how-to-compare-current-date-and-last-modified-date-in-android
     */
    public static boolean checkFileCreatedOrModifyToday(String pathToFile) {
        File file = new File(pathToFile);
        Date date = new Date(file.lastModified());
        return (new Date().getTime() - date.getTime()) <= TIME_FULL_DAY;
    }


    /**
     * Get list of files
     *
     * @param pathToFile the path to file
     * @link http://stackoverflow.com/questions/15132693/java-check-file-name-against-current-date
     */
    public static File[] getListFiles(String pathToFile) {
        File dir = new File(pathToFile);
        return dir.listFiles(new CurrentDayFileFilter());
    }

    /**
     *
     */
    private static class CurrentDayFileFilter implements FileFilter {
        public boolean accept(File f) {
            Date date = new Date(f.lastModified());
            return System.currentTimeMillis() - date.getTime() <= TIME_FULL_DAY;
        }
    }

    /**
     * The time of full day.
     * 24 Hour, 60 Seconds, 60 Minutes and 1000 Milliseconds.
     */
    private final static int TIME_FULL_DAY = 24 * 60 * 60 * 1000;


}
