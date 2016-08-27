package com.malex.model;

/**
 * Created by malex on 27.08.16.
 */
public class ZipModel {

    private String nameFile;

    private byte[] archiveFiles;


    public ZipModel(String nameFile, byte[] archiveFiles) {
        this.nameFile = nameFile;
        this.archiveFiles = archiveFiles;
    }


    public String getNameFile() {
        return nameFile;
    }


    public byte[] getArchiveFiles() {
        return archiveFiles;
    }

    @Override
    public String toString() {
        return "ZipModel{" +
                "nameFile='" + nameFile + '\'' +
                '}';
    }
}
