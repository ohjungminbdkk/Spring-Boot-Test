package com.havi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withServerError;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.HttpServerErrorException;

import com.fasterxml.jackson.core.io.UTF8Writer;
import com.havi.domain.Book;
import com.havi.service.BookRestService;

@RunWith(SpringRunner.class)
@RestClientTest(BookRestService.class)
public class BookRestTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Autowired
	private BookRestService bookRestService;

	@Autowired
	private MockRestServiceServer server;

	@Test
	public void rest_�׽�Ʈ() {
		this.server.expect(requestTo("/rest/test"))
				.andRespond(withSuccess(new ClassPathResource("/test.json", getClass()), MediaType.APPLICATION_JSON));
		Book book = this.bookRestService.getRestBook();
		assertThat(book.getTitle()).isEqualTo("�׽�Ʈ");
	}

	@Test
	public void rest_error_�׽�Ʈ() {
		this.server.expect(requestTo("/rest/test")).andRespond(withServerError());
		this.thrown.expect(HttpServerErrorException.class);
		this.bookRestService.getRestBook();
	}
}
