package utils;

import com.codeborne.pdftest.PDF;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Files {
    public static String readTextFromFile(File file) throws IOException {
        return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
    }

    public static String readTextFromPath(String path) throws IOException {
        return readTextFromFile(getFile(path));
    }

    public static File getFile(String path) {
        return new File(path);
    }

    public static PDF getPdf(String path) throws IOException {
        return new PDF(getFile(path));
    }
}