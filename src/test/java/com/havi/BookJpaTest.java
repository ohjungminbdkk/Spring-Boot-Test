package com.havi;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.havi.domain.Book;
import com.havi.repository.BookRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookJpaTest {
	private final static String BOOT_TEST_TITLE = "Spring Boot Test Book";

	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	private BookRepository bookRepository;

	@Test
	public void Book_저장하기_테스트() {
		Book book = Book.builder().title(BOOT_TEST_TITLE).publishedAt(LocalDateTime.now()).build();
		testEntityManager.persist(book);
		assertThat(bookRepository.getOne(book.getIdx()), is(book));
	}

	@Test
	public void BookList_저장하기_검색_테스트() {
		Book book1 = Book.builder().title(BOOT_TEST_TITLE + "1").publishedAt(LocalDateTime.now()).build();
		testEntityManager.persist(book1);
		Book book2 = Book.builder().title(BOOT_TEST_TITLE + "2").publishedAt(LocalDateTime.now()).build();
		testEntityManager.persist(book2);
		Book book3 = Book.builder().title(BOOT_TEST_TITLE + "3").publishedAt(LocalDateTime.now()).build();
		testEntityManager.persist(book3);

		List<Book> bookList = bookRepository.findAll();
		List<Book> bookList2 = new ArrayList();
		bookList2.add(book1);
		bookList2.add(book2);
		bookList2.add(book3);
		
		// bookRepository.findAll();
		System.out.println("bookList"+ bookList);
		
		assertThat(bookList, hasSize(3));
		assertThat(bookList, contains(book1, book2, book3));


		// bookList2 bookList2.add(book1); bookList2.add(book2); bookList2.add(book3);
		System.out.println("bookList2"+ bookList2);
		
		assertThat(bookList2, hasSize(3)); 

		// 삭제 테스트
		bookRepository.deleteAll();
		
		assertThat(bookRepository.findAll(), IsEmptyCollection.empty()); 
	}
	
	@Test
	public void BookList_저장하고_삭제_테스트() {
		Book book1 = Book.builder().title(BOOT_TEST_TITLE + "1").publishedAt(LocalDateTime.now()).build();
		testEntityManager.persist(book1);
		Book book2 = Book.builder().title(BOOT_TEST_TITLE + "2").publishedAt(LocalDateTime.now()).build();
		testEntityManager.persist(book2);
		
		bookRepository.deleteAll();
		
		assertThat(bookRepository.findAll(), IsEmptyCollection.empty()); 

	}
	

}
