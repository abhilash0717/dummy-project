package com.infy.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.infy.model.Data;
import com.infy.service.ProjectService;

@CrossOrigin
@RestController
@RequestMapping(value = "/ApiTesting")
public class Api {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private Environment environment;
	
	@PostMapping(value = "/storeTheData")
	public ResponseEntity<String> validUser(@RequestBody Data data) throws Exception{
		try {
			String[] books = data.getBookIds();
			System.out.println(books);
			for(String s : books) {
				System.out.println(s);
			}
			String s = projectService.Store(data);
			ResponseEntity<String> response = new ResponseEntity<String>(s,HttpStatus.CREATED);
			return response;
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(e.getMessage()));
		}
	}
}
