package com.malex.util;

import java.io.File;

/**
 * The class {@link FileAnalyzerUtil} analyzes the selected files
 *
 * @author malex
 */
public class FileAnalyzerUtil {

    /**
     * Search the file in directory by name
     *
     * @param pathToFiles the path to file
     * @param nameOfFile  the name of file
     * @return true if file is found
     */
    public static boolean analyzeFileByName(String pathToFiles, String nameOfFile) {

        File[] files = validateIncomingParameters(pathToFiles, nameOfFile);

        for (File file : files) {
            if (file.getName().equals(nameOfFile)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Search the file in directory by extension
     *
     * @param pathToFiles the path to file
     * @param extension   the extension of file
     * @return true if file is found
     */
    public static boolean analyzeFileByExtension(String pathToFiles, String extension) {

        File[] files = validateIncomingParameters(pathToFiles, extension);

        for (File file : files) {
            if (file.getName().endsWith(extension)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Validate incoming parameters pathToFiles: String pathToFiles
     * and expression: String extension, String nameOfFile.
     *
     * @param pathToFiles path to files.
     * @param expression  extension or nameOfFile.
     * @return the array of files if the parameters are validate.
     * @throws IllegalArgumentException if incorrect path to file.
     * @throws IllegalArgumentException if incorrect expression: nameOfFile or extension value.
     * @throws IllegalArgumentException if path to file is not a directory.
     * @throws IllegalArgumentException if directory is empty.
     */
    private static File[] validateIncomingParameters(String pathToFiles, String expression) {

        if (pathToFiles == null || pathToFiles.isEmpty()) {
            throw new IllegalArgumentException("Incorrect path to file!");
        }
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("Incorrect expression value!");
        }

        File directory = new File(pathToFiles);
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("The file path " + pathToFiles + "is not a directory!");
        }

        File[] files = directory.listFiles();
        if (files == null) {
            throw new IllegalArgumentException("Directory is empty!");
        }

        return files;
    }

}
