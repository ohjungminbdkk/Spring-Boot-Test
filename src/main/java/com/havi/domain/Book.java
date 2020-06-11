package com.havi.domain;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Book {
	@Id
    @GeneratedValue
	private Integer idx;
	private String title;
	private LocalDateTime publishedAt;
	
	@Builder
	public Book(String title, LocalDateTime publishedAt) {
		this.title = title;
		this.publishedAt = publishedAt;
	}
	
}
