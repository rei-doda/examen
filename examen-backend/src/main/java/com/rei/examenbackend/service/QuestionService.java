package com.rei.examenbackend.service;

import com.rei.examenbackend.dto.question.QuestionRequest;
import com.rei.examenbackend.dto.question.QuestionResponse;

import java.util.List;

public interface QuestionService {

    QuestionResponse create(QuestionRequest request);

    QuestionResponse update(Long id, QuestionRequest request);

    void delete(Long id);

    QuestionResponse getById(Long id);

    List<QuestionResponse> getAll();

    List<QuestionResponse> getByCategory(Long categoryId);
}
