package com.codemind.quiz_app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Configuration
@PropertySource(ignoreResourceNotFound = true, value = "classpath:application.properties")
public class ApplicationProperties {
	
	
	@Value("${quiz.api.url}")
	private String quizApi;
	
	@Value("${quiz.api.key}")
	private String quizApiKey;
	
	@Value("${jwt.secret}")
	private String jwtKey;
	
	@Value("${jwt.expiration}")
	private Long jwtExpiration;
	
	
	public String getQuizApi() {
		return quizApi;
	}

	public void setQuizApi(String quizApi) {
		this.quizApi = quizApi;
	}

	public String getQuizApiKey() {
		return quizApiKey;
	}

	public void setQuizApiKey(String quizApiKey) {
		this.quizApiKey = quizApiKey;
	}

	public String getJwtKey() {
		return jwtKey;
	}

	public void setJwtKey(String jwtKey) {
		this.jwtKey = jwtKey;
	}

	public Long getJwtExpiration() {
		return jwtExpiration;
	}

	public void setJwtExpiration(Long jwtExpiration) {
		this.jwtExpiration = jwtExpiration;
	}
	
	


}
