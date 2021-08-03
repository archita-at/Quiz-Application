package com.example.quizbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizbackend.model.Question;
import com.example.quizbackend.service.QuestionService;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping("/questions")
	public ResponseEntity<List<Question>> get(){
		List<Question> questions = questionService.findAll();
		return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
	}
	
	@PostMapping("/add-question")
	public ResponseEntity<Question> save(@RequestBody Question question){
		System.out.println("in add question");
		Question newQuestion = questionService.save(question);
		System.out.println(newQuestion);
		return new ResponseEntity<Question>(newQuestion, HttpStatus.OK);
	}
}
