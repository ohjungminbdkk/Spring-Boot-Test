package com.example.demo.pojo;

import java.util.List;
import java.util.Map;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// 'org.projectlombok:lombok'
// @ConfigurationProperties 사용시 해당 클래스를 선언해줘야 한다.
// 다양한 프로퍼티값을 매핑할 수 있다. 리스트<맵>	
@Data
@Component
@ConfigurationProperties("fruit")
public class FruitProperty {

	private List<Map> list;
	// compileOnly 'org.projectlombok:lombok'
	// @ConfigurationProperties 사용시 해당 클래스를 선언해줘야 한다.
	// 다양한 프로퍼티값을 매핑할 수 있다. 리스트<맵>

}
