package com.rei.examenbackend.dto.answer;

import lombok.Data;

@Data
public class AnswerRequest {

    private String answerText;
    private boolean correct;
    private Long questionId;
    private Long examinationSessionId;
}
