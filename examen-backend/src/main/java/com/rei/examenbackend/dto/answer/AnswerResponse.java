package com.rei.examenbackend.dto.answer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnswerResponse {
    private Long id;
    private String answerText;
    private boolean correct;
    private Long questionId;
    private Long examinationSessionId;
}
