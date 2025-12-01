package com.rei.examenbackend.dto.question;

import lombok.Data;

@Data
public class QuestionRequest {
    private String text;
    private Integer orderNumber;
    private Long categoryId;
    private String difficulty;
}
