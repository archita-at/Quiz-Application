package com.example.quizbackend.service;

import java.util.List;

import com.example.quizbackend.model.Question;

public interface QuestionService {
	List<Question> findAll();
	
	Question save(Question question);
	
	Question findById(Long id);
	
	void delete(Long id);
}
