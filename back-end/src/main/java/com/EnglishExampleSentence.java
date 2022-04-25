package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : whz
 */
@SpringBootApplication
@MapperScan("com.mapper")
public class EnglishExampleSentence {
	public static void main(String[] args) {
		SpringApplication.run(EnglishExampleSentence.class, args);
	}
}
