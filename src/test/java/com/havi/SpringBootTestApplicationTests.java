package com.havi;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
/* @SpringBootTest
 * 안에 value 와 properties 중 한개의 형식으로 만사용가능하다.
 * 
 */	
//@SpringBootTest(value = "value=test", properties = { "property.value=propertyTest" }, classes = {
//		SpringBootTestApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@SpringBootTest(value = "value=test", classes = {
//		SpringBootTestApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SpringBootTest(properties = { "property.value=propertyTest" }, classes = {
		SpringBootTestApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootTestApplicationTests {

	
//	@Value("${value}")
//	private String value;

	@Value("${property.value}")
	private String propertyValue;

	@Test
	public void contextLoads() {
//		assertThat(value, is("test"));
		assertThat(propertyValue, is("propertyTest"));
	}

}