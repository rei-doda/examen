package com.rei.examenbackend.dto.session;

import com.rei.examenbackend.dto.answer.AnswerResponse;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ExaminationSessionResponse {
    private Long id;
    private Long userId;
    private LocalDateTime startedAt;
    private LocalDateTime completedAt;
    private List<AnswerResponse> answers;
    private String notes;
}
