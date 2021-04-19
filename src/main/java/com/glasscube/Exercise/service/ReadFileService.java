package com.glasscube.Exercise.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public interface ReadFileService {
    Map<String, Integer> readFiles(final String relativePath);

    default List<String> formatedLine(final String input) {
        return Arrays.asList(input.split(" ", -1));
    }
}
