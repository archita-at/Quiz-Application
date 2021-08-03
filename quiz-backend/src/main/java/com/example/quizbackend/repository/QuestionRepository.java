package com.example.quizbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizbackend.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
