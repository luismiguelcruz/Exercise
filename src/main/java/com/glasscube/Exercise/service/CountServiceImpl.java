package com.glasscube.Exercise.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CountServiceImpl implements CountService {
    @Override
    public Map<String, Integer> retrieveWords(int numberOfWords, Map<String, Integer> wordsMap) {
        final Map<String, Integer> words = new HashMap<>();
        int addedWords = 0;

        for (Map.Entry<String, Integer> currentWordMapEntry : wordsMap.entrySet()) {
            if (addedWords < numberOfWords) {
                words.put(currentWordMapEntry.getKey(), currentWordMapEntry.getValue());
            } else {
                final List<Map.Entry<String, Integer>> listWords = words.entrySet().stream()
                        .filter(entry -> entry.getValue() < currentWordMapEntry.getValue()).collect(Collectors.toList());

                Collections.sort(listWords, new Comparator<Map.Entry<String, Integer>>(){
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
                        return o1.getKey().compareTo(o2.getKey()); // for example
                    }
                });

                if (!listWords.isEmpty()) {
                    Map.Entry<String, Integer> lessNumberOfOccurrencesWordEntry = listWords.get(0);
                    words.remove(lessNumberOfOccurrencesWordEntry.getKey());
                    words.put(currentWordMapEntry.getKey(), currentWordMapEntry.getValue());
                }
            }

            addedWords++;
        }

        return words;
    }
}
