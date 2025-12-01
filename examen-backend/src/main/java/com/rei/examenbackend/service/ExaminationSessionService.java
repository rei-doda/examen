package com.rei.examenbackend.service;

import com.rei.examenbackend.dto.session.ExaminationSessionRequest;
import com.rei.examenbackend.dto.session.ExaminationSessionResponse;
import com.rei.examenbackend.dto.answer.AnswerRequest;
import com.rei.examenbackend.dto.answer.AnswerResponse;

import java.util.List;

public interface ExaminationSessionService {

    ExaminationSessionResponse startSession(ExaminationSessionRequest request);

    ExaminationSessionResponse completeSession(Long id, String notes);

    List<AnswerResponse> submitAnswers(Long sessionId, List<AnswerRequest> answers);

    ExaminationSessionResponse getById(Long id);

    List<ExaminationSessionResponse> getByUser(Long userId);
}
