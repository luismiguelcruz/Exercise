package com.glasscube.Exercise;


import com.glasscube.Exercise.service.CountService;
import com.glasscube.Exercise.service.ReadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
public class APIEndpoint
{
	@Autowired
	private ReadFileService readFileService;
	@Autowired
	private CountService countService;

	@RequestMapping(value="/hello")
	public String test() {
		int x = 5;
		final Map<String, Integer> mapWords = readFileService.readFiles("files");
		final Map<String, Integer> retrievedWords = countService.retrieveWords(x, mapWords);
		return "Finder says hello ";
	}
}