package com.glasscube.Exercise.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReadFileServiceImpl implements ReadFileService {
    private static final String RESOURCES_RELATIVE_PATH = "./src/main/resources/files";

    @Override
    public Map<String, Integer> readFiles(final String folderName) {
        final File[] listOfFiles = new File(RESOURCES_RELATIVE_PATH).listFiles();
        Map wordsMap = new HashMap();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                wordsMap = readFile(file, wordsMap);
            }
        }

        return wordsMap;
    }

    private Map<String, Integer> readFile(File file, Map<String, Integer> wordsMap) {
        try (BufferedReader br = Files.newBufferedReader(file.getAbsoluteFile().toPath())) {
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
        return inputString.stream().map(s -> s.replaceAll("\\W", ""))
                .collect(Collectors.toList());
    }
}
