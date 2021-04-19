package com.glasscube.Exercise;

import com.glasscube.Exercise.service.ReadFileService;
import com.glasscube.Exercise.service.ReadFileServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinderApplication {

	public static void main(String[] args) {
		final ReadFileService service = new ReadFileServiceImpl();
		service.readFiles("files");

		//SpringApplication.run(FinderApplication.class, args);
	}

}
