package com.glasscube.Exercise.service;

import com.google.common.collect.ImmutableMap;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CountServiceImplTest {
    private CountService countService;

    @Before
    public void setUp() {
        countService = new CountServiceImpl();
    }

    @Test
    public void testRetrieveWordsReturnsWordsThatHaveMoreOccurences() {
        final Map<String, Integer> immutableMap
                = ImmutableMap.of("Word1", 3, "Word2", 5, "Word3", 6, "Word4", 1);

        final Map<String, Integer> values = countService.retrieveWords(2, immutableMap);

        assertThat(values).containsKey("Word2");
        assertThat(values).containsKey("Word3");
    }

}