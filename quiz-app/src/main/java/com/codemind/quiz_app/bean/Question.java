package com.codemind.quiz_app.bean;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Nullable;

public class Question {
	

	private Long id;
	private String question;
	private String description;
	private String category;
	private String difficulty;
	
	@JsonProperty("answers")
	private Map<String, String> answers;
	
	@JsonProperty("multiple_correct_answers")
    private String multipleCorrectAnswers;
	
	@JsonProperty("correct_answers")
	private Map<String, String> correctAnswers;
	
	@JsonProperty("correct_answer")
    private String correctAnswer;

    private String explanation;
    private String tip;
    
    @JsonProperty("tags")
    @Nullable
    private List<Tag> tags; 

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getQuestion() {
		return question;
	}



	public void setQuestion(String question) {
		this.question = question;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getDifficulty() {
		return difficulty;
	}



	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}



	public Map<String, String> getAnswers() {
		return answers;
	}



	public void setAnswers(Map<String, String> answers) {
		this.answers = answers;
	}



	public String getMultipleCorrectAnswers() {
		return multipleCorrectAnswers;
	}



	public void setMultipleCorrectAnswers(String multipleCorrectAnswers) {
		this.multipleCorrectAnswers = multipleCorrectAnswers;
	}



	public Map<String, String> getCorrectAnswers() {
		return correctAnswers;
	}



	public void setCorrectAnswers(Map<String, String> correctAnswers) {
		this.correctAnswers = correctAnswers;
	}



	public String getCorrectAnswer() {
		return correctAnswer;
	}



	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}



	public String getExplanation() {
		return explanation;
	}



	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}



	public String getTip() {
		return tip;
	}



	public void setTip(String tip) {
		this.tip = tip;
	}



	public List<Tag> getTags() {
		return tags;
	}



	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}



    
    
    
    public static class Tag {
        private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
        
        
        
        
        
    }
	
}
