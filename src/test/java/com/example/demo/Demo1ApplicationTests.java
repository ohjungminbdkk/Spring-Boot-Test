package com.example.demo;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class Demo1ApplicationTests {

	@Value("${property.test.name}")
	private String propertyTestName;
	
	@Value("${propertyTest}")
	private String propertyTest;
	
	// nokey→해당 변수에 노키의 설정치를 주입
	@Value("${nokey:default value}")
	private String defaultValue;

	
	@Value("${propertyTestList}")
	private String[] propertyTestArray;
	
	@Value("#{'${propertyTestList}'.split(',')}")
	private List<String> propertyTestList;
	
	@Test
	void testValue() {
		
		assertThat(propertyTestName, is("property depth test"));
		assertThat(propertyTest, is("test"));
		assertThat(defaultValue, is("default value"));
		
		assertThat(propertyTestArray[0], is("a"));
		assertThat(propertyTestArray[1], is("b"));
		assertThat(propertyTestArray[2], is("c"));

		assertThat(propertyTestList.get(0), is("a"));
		assertThat(propertyTestList.get(1), is("b"));
		assertThat(propertyTestList.get(2), is("c"));
		
		
	}

}
