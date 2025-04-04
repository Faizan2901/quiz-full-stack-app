package com.codemind.quiz_app.bean;

import java.util.List;
import java.util.Map;

public class QuizSubmission {
	
	private Map<Integer, String> selectedAnswers;
	private List<Question> questions;
	public Map<Integer, String> getSelectedAnswers() {
		return selectedAnswers;
	}
	public void setSelectedAnswers(Map<Integer, String> selectedAnswers) {
		this.selectedAnswers = selectedAnswers;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	

}
