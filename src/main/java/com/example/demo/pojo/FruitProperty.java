package com.example.demo.pojo;

import java.util.List;
import java.util.Map;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// 'org.projectlombok:lombok'
// @ConfigurationProperties ���� �ش� Ŭ������ ��������� �Ѵ�.
// �پ��� ������Ƽ���� ������ �� �ִ�. ����Ʈ<��>	
@Data
@Component
@ConfigurationProperties("fruit")
public class FruitProperty {

	private List<Map> list;
	// compileOnly 'org.projectlombok:lombok'
	// @ConfigurationProperties ���� �ش� Ŭ������ ��������� �Ѵ�.
	// �پ��� ������Ƽ���� ������ �� �ִ�. ����Ʈ<��>

}
