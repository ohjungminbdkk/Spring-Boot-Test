package com.havi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.havi.domain.Book;
import com.havi.service.BookRestService;

@RestController
public class BookRestController {

	@Autowired
	private BookRestService bookrestService;
	
	@GetMapping(path = "/rest/test", produces = MediaType.APPLICATION_JSON_VALUE)
	public Book getRestBooks() {
		return bookrestService.getRestBook();
	}
	
}
