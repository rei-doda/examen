package com.rei.examenbackend.dto.question;

import com.rei.examenbackend.dto.answer.AnswerResponse;
import com.rei.examenbackend.dto.category.CategoryResponse;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class QuestionResponse {
    private Long id;
    private String text;
    private Integer orderNumber;
    private String difficulty;
    private CategoryResponse category;
    private List<AnswerResponse> answers;
}
