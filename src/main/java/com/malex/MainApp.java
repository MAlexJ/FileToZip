package com.malex;

import com.malex.util.AnalyzeFileUtil;

import java.io.File;
import java.util.Arrays;

/**
 * @author malex
 */
public class MainApp {

    /**
     * The path to local files.
     */
    private static final String PATH_TO_FILES = "log/";

    /**
     * Start app.
     *
     * @param args the array of strings
     */
    public static void main(String[] args) {
        File[] listFiles = AnalyzeFileUtil.getListFiles(PATH_TO_FILES);

        System.out.println(Arrays.toString(listFiles));
    }
}
