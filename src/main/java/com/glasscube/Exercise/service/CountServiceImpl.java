package com.glasscube.Exercise.service;

import java.util.HashMap;
import java.util.Map;

public class CountServiceImpl implements CountService {
    private Map<String, Integer> words;

    @Override
    public Map<String, Integer> retrieveWords(int numberOfWords, Map<String, Integer> wordsMap) {
        words = new HashMap<>();

        for (Map.Entry<String, Integer> currentWordMapEntry : wordsMap.entrySet()) {
            int i = 0;

            if (i < numberOfWords) {
                words.put(currentWordMapEntry.getKey(), currentWordMapEntry.getValue());
            } else {
                // TODO: Didn't have time to finish this method. It will replace a word with less count number with the current ont
                for (Map.Entry<String, Integer> entry : words.entrySet()) {
                    if (entry.getValue() < currentWordMapEntry.getValue()) {
                        words.remove(entry.getKey());
                        words.put(currentWordMapEntry.getKey(), currentWordMapEntry.getValue());
                    }
                }
            }

            i++;
        }
        return null;
    }
}
