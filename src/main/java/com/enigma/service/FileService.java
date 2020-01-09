package com.enigma.service;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private static Path currentRelativePath = Paths.get("src");
    private static File fileDirectory = new File(currentRelativePath + "/main/resources");

    public static List<String> parseFile(String fileName){
        List<String> commandLines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileDirectory + "/" + fileName))) {
            while (true) {
                String line= br.readLine();
                if(line==null)break;
                commandLines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return commandLines;
    }
}
