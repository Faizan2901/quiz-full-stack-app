package com.codemind.quiz_app.service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codemind.quiz_app.bean.Question;
import com.codemind.quiz_app.config.ApplicationProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class QuizService {

	private final ApplicationProperties applicationProperties;
	private final CloseableHttpClient client;

	@Autowired
	public QuizService(ApplicationProperties applicationProperties) {
	    this.applicationProperties = applicationProperties;
	    this.client = HttpClients.createDefault();
	}

	public List<Question> getQuizQuestions(String limit, String category) throws Exception {
		List<Question> questions = new ArrayList<>();

		// Set API parameters
		List<NameValuePair> queryParams = new ArrayList<>();
		queryParams.add(new BasicNameValuePair("apiKey", applicationProperties.getQuizApiKey()));
		queryParams.add(new BasicNameValuePair("limit", limit));
		queryParams.add(new BasicNameValuePair("category", category));

		// Construct API URL
		String quizApi = applicationProperties.getQuizApi();
		HttpGet request = new HttpGet(quizApi);
		URIBuilder uriWithParams = new URIBuilder(request.getURI());

		for (NameValuePair pair : queryParams) {
			uriWithParams.addParameter(pair.getName(), pair.getValue());
		}

		// Execute the request
		URI uri = uriWithParams.build();
		request.setURI(uri);
		HttpResponse httpResponse = client.execute(request);

		// Parse response JSON
		InputStream inputStream = httpResponse.getEntity().getContent();
		ObjectMapper objectMapper = new ObjectMapper();
		questions = objectMapper.readValue(inputStream, new TypeReference<List<Question>>() {});

		return questions;
	}
}
