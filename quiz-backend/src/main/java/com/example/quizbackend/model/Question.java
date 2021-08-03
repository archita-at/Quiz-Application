package com.example.quizbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {
	private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long questionId;
	private String questionStatement;
	private String correctAnswer;
	
	public Question() {}
	
	public Question(String questionStatement, String correctAnswer) {
		this.questionStatement = questionStatement;
		this.correctAnswer = correctAnswer;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getQuestionStatement() {
		return questionStatement;
	}

	public void setQuestionStatement(String questionStatement) {
		this.questionStatement = questionStatement;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
}
