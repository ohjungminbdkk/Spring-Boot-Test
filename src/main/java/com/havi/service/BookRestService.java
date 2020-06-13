package com.havi.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.havi.domain.Book;

@Service
public class BookRestService {	
	// RestTemplate 특정 URL로 비동기 요청을 처리하는 서비스
	private final RestTemplate restTemplate;
	
	public BookRestService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.rootUri("/rest/test").build();
	}
	
	public Book getRestBook() {
		return this.restTemplate.getForObject("/rest/test", Book.class);
	}
	
}
