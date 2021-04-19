package com.glasscube.Exercise.service;

import java.util.List;
import java.util.Map;

public interface CountService {
    public Map<String, Integer> retrieveWords(int words, Map<String, Integer> wordsMap);
}
