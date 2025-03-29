package com.codemind.quiz_app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codemind.quiz_app.bean.Question;
import com.codemind.quiz_app.bean.QuizSubmission;
import com.codemind.quiz_app.service.QuizService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	@GetMapping("/questions")
	public List<Question> getQuizQuestions(@RequestParam Integer limit,@RequestParam String category) throws Exception{
		return quizService.getQuizQuestions(String.valueOf(limit), category);
	}
	
	@PostMapping("/submit")
	public int submitQuiz(@RequestBody QuizSubmission quizSubmission) {
		int score=0;
		
		for(Map.Entry<Integer,String> entry:quizSubmission.getSelectedAnswers().entrySet()) {
			int questionIndex=entry.getKey();
			String selectAnswer=entry.getValue();
			
			if(quizSubmission.getQuestions().get(questionIndex).getCorrectAnswers().get(selectAnswer+"_correct").equals("true")) {
				score++;
			}
			
		}
		
		return score;
		
	}

}
