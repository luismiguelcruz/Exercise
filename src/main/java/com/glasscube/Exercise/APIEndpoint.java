package com.glasscube.Exercise;


import com.glasscube.Exercise.service.CountService;
import com.glasscube.Exercise.service.ReadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping(path="/hello/{number}")
	public String test(@PathVariable final int number) {
		final Map<String, Integer> mapWords = readFileService.readFiles("files");
		final Map<String, Integer> retrievedWords = countService.retrieveWords(number, mapWords);

		final StringBuilder response = new StringBuilder("The " + number + " words with the most occurrence files are:\n");
		retrievedWords.forEach((word, ocurrences) -> {
			response.append(word + ": "+ocurrences+"\n");
		});

		return response.toString();
	}
}