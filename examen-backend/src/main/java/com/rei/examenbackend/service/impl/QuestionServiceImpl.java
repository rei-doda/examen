package com.rei.examenbackend.service.impl;

import com.rei.examenbackend.dto.answer.AnswerResponse;
import com.rei.examenbackend.dto.category.CategoryResponse;
import com.rei.examenbackend.dto.question.QuestionRequest;
import com.rei.examenbackend.dto.question.QuestionResponse;
import com.rei.examenbackend.model.Category;
import com.rei.examenbackend.model.Question;
import com.rei.examenbackend.repository.CategoryRepository;
import com.rei.examenbackend.repository.QuestionRepository;
import com.rei.examenbackend.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public QuestionResponse create(QuestionRequest request) {

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Question question = Question.builder()
                .text(request.getText())
                .orderNumber(request.getOrderNumber())
                .difficulty(request.getDifficulty())
                .category(category)
                .build();

        questionRepository.save(question);

        return toResponse(question);
    }


    @Override
    public QuestionResponse update(Long id, QuestionRequest request) {

        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found"));

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        question.setText(request.getText());
        question.setOrderNumber(request.getOrderNumber());
        question.setDifficulty(request.getDifficulty());
        question.setCategory(category);

        questionRepository.save(question);

        return toResponse(question);
    }


    @Override
    public void delete(Long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public QuestionResponse getById(Long id) {
        Question q = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found"));
        return toResponse(q);
    }

    @Override
    public List<QuestionResponse> getAll() {
        return questionRepository
                .findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public List<QuestionResponse> getByCategory(Long categoryId) {
        return questionRepository
                .findByCategoryId(categoryId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private QuestionResponse toResponse(Question q) {
        return QuestionResponse.builder()
                .id(q.getId())
                .text(q.getText())
                .orderNumber(q.getOrderNumber())
                .difficulty(q.getDifficulty())
                .category(
                        CategoryResponse.builder()
                                .id(q.getCategory().getId())
                                .name(q.getCategory().getName())
                                .description(q.getCategory().getDescription())
                                .build()
                )
                .answers(
                        q.getAnswers() == null ? null :
                                q.getAnswers().stream().map(a ->
                                        AnswerResponse.builder()
                                                .id(a.getId())
                                                .answerText(a.getAnswerText())
                                                .correct(a.isCorrect())
                                                .build()
                                ).toList()
                )
                .build();
    }
}
