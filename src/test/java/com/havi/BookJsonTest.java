package com.havi;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import com.havi.domain.Book;

@RunWith(SpringRunner.class)
@JsonTest
public class BookJsonTest {

	@Autowired
	private JacksonTester<Book> json;
	
	@Test
	public void json_�׽�Ʈ() throws Exception{
		Book book = Book.builder().title("�׽�Ʈ").build();
		
		String content = "{\"title\":\"�׽�Ʈ\"}";
		
		assertThat(this.json.parseObject(content).getTitle()).isEqualTo(book.getTitle());
		
		assertThat(this.json.parseObject(content).getPublishedAt()).isNull();
		assertThat(this.json.write(book)).isEqualToJson("/test.json");
		assertThat(this.json.write(book)).hasJsonPathStringValue("title");
		assertThat(this.json.write(book)).extractingJsonPathStringValue("title").isEqualTo("abc");
		
		
		
	}
	
}
