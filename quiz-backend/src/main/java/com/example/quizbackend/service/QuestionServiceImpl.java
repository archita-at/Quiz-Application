package com.example.quizbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizbackend.model.Question;
import com.example.quizbackend.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	QuestionRepository questionRepository;

	@Override
	public List<Question> findAll() {
		return questionRepository.findAll();
	}

	@Override
	public Question save(Question question) {
		questionRepository.save(question);
		return question;
	}

	@Override
	public void delete(Long id) {
		Question question = findById(id);
		questionRepository.delete(question);
	}

	@Override
	public Question findById(Long id) {
		if(questionRepository.findById(id).isPresent()) {
			return questionRepository.findById(id).get();
		}
		
		return null;
	}

}
