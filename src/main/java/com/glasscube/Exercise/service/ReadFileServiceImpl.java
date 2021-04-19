package com.glasscube.Exercise.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

@Service
public class ReadFileServiceImpl implements ReadFileService {
    private static final Properties APPLICATION_PROPERTIES = new Properties();
    private static final String RESOURCES_RELATIVE_PATH = "src/main/resources/";
    private final File folder = new File("D:/files");

    @Override
    public Map<String, Integer> readFiles(final String folderName) {
        final File[] listOfFiles = folder.listFiles();
        folder.list();
        Map wordsMap = new HashMap();

        wordsMap = readFile(null, wordsMap);

        for (File file : listOfFiles) {
            if (file.isFile()) {
                wordsMap = readFile(file, wordsMap);
            }
        }

        return wordsMap;
    }

    private Map<String, Integer> readFile(File file, Map<String, Integer> wordsMap) {
        final String relativePath = "src/main/resources/files/file1.txt";

        try (BufferedReader br = Files.newBufferedReader(Paths.get(relativePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                final List<String> rawRead = new ArrayList<>();
                rawRead.addAll(removeSpecialCharacters(formatedLine(line)));

                rawRead.forEach(currentWord -> {
                    if (!wordsMap.containsKey(currentWord)) {
                        wordsMap.put(currentWord, 1);
                    } else {
                        final Integer count = wordsMap.get(currentWord);
                        wordsMap.put(currentWord, count+1);
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return wordsMap;
    }

    private List<String> removeSpecialCharacters(final List<String> inputString) {
        return inputString;
    }
}
