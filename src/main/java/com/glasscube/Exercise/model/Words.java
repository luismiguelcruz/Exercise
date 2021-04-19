package com.glasscube.Exercise.model;

import java.util.HashMap;
import java.util.Map;

public class Words {
    public Map<String, Integer> readWords;

    public Words(Map readWords) {
        this.readWords = new HashMap();
    }

    public Map<String, Integer> getReadWords() {
        return readWords;
    }
}
