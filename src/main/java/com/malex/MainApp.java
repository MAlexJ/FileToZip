package com.malex;

import com.malex.util.AnalyzeFileUtil;

import java.util.Date;

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
        Date dateModifiedOrCreateFile = AnalyzeFileUtil.getDateModifiedOrCreateFile(PATH_TO_FILES);
        System.out.println(dateModifiedOrCreateFile);
        System.out.println(new Date());
    }
}
