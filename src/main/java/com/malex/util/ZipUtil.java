package com.malex.util;

import com.malex.model.ZipModel;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Util class.
 * Class represents the implementation to archiving of files into directory log.
 */
public class ZipUtil {

    private static final String FILE_PATH = "log/";

    /**
     * Expansion of the archive file.
     */
    private static final String EXTENSION_ZIP_FILE = ".zip";

    /**
     * The name archive file.
     */
    private static final String NAME_LOG_FILE = "Log_report_";

    /**
     * Get zip archive log-files.
     *
     * @return byte array zip log-files.
     */
    public static ZipModel getArchiveFiles() {

        String nameArchiveLogs = NAME_LOG_FILE + new Date() + EXTENSION_ZIP_FILE;

        byte[] archiveLogFiles = null;

        File file = new File(FILE_PATH);
        if (file.exists() && file.isDirectory()) {
            try {
                archiveLogFiles = createZip(FILE_PATH);
            } catch (IOException ex) {
                nameArchiveLogs = "Error creating archive log-files!";
                System.out.println(" >>>> ERROR >>>>>> " + nameArchiveLogs);
            }
        }

        return new ZipModel(nameArchiveLogs, archiveLogFiles);
    }

    /**
     * Create zip archive log-files.
     *
     * @param sourceDirPath log directory.
     * @return byte array.
     * @throws IOException if error creating archive log-files.
     */
    private static byte[] createZip(String sourceDirPath) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try (ZipOutputStream zs = new ZipOutputStream(byteArrayOutputStream)) {
            //set level compression
            zs.setLevel(Deflater.BEST_COMPRESSION);

            Path pathFile = Paths.get(sourceDirPath);
            Files.walk(pathFile)
                    .filter(path -> !Files.isDirectory(path))
                    .forEach(path -> {
                        String sp = path.toAbsolutePath().toString().replace(pathFile.toAbsolutePath().toString(), "").replace(path.getFileName().toString(), "");
                        ZipEntry zipEntry = new ZipEntry(sp + "/" + path.getFileName().toString());
                        try {
                            zs.putNextEntry(zipEntry);
                            zs.write(Files.readAllBytes(path));
                            zs.closeEntry();
                        } catch (IOException e) {
                            System.out.println(" >>>> ERROR >>>>>> Error creating zip file!");
                        }
                    });
        }

        return byteArrayOutputStream.toByteArray();
    }

}
