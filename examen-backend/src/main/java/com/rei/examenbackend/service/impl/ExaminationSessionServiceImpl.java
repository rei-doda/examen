package com.rei.examenbackend.service.impl;

import com.rei.examenbackend.dto.answer.AnswerRequest;
import com.rei.examenbackend.dto.answer.AnswerResponse;
import com.rei.examenbackend.dto.session.ExaminationSessionRequest;
import com.rei.examenbackend.dto.session.ExaminationSessionResponse;
import com.rei.examenbackend.model.Answer;
import com.rei.examenbackend.model.ExaminationSession;
import com.rei.examenbackend.model.Question;
import com.rei.examenbackend.model.User;
import com.rei.examenbackend.repository.*;
import com.rei.examenbackend.service.ExaminationSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExaminationSessionServiceImpl implements ExaminationSessionService {

    private final ExaminationSessionRepository sessionRepository;
    private final UserRepository userRepository;
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    @Override
    public ExaminationSessionResponse startSession(ExaminationSessionRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        ExaminationSession session = ExaminationSession.builder()
                .user(user)
                .startedAt(LocalDateTime.now())
                .build();

        sessionRepository.save(session);

        return toResponse(session);
    }

    @Override
    public ExaminationSessionResponse completeSession(Long id, String notes) {

        ExaminationSession session = sessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Session not found"));

        session.setCompletedAt(LocalDateTime.now());
        session.setNotes(notes);

        sessionRepository.save(session);

        return toResponse(session);
    }

    @Override
    public List<AnswerResponse> submitAnswers(Long sessionId, List<AnswerRequest> answers) {

        ExaminationSession session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));

        List<Answer> answerEntities = answers.stream().map(req -> {

            Question q = questionRepository.findById(req.getQuestionId())
                    .orElseThrow(() -> new RuntimeException("Question not found"));

            return Answer.builder()
                    .answerText(req.getAnswerText())
                    .correct(req.isCorrect())
                    .question(q)
                    .examinationSession(session)
                    .build();

        }).toList();

        answerRepository.saveAll(answerEntities);

        return answerEntities.stream()
                .map(a -> AnswerResponse.builder()
                        .id(a.getId())
                        .answerText(a.getAnswerText())
                        .correct(a.isCorrect())
                        .questionId(a.getQuestion().getId())
                        .examinationSessionId(sessionId)
                        .build())
                .toList();
    }

    @Override
    public ExaminationSessionResponse getById(Long id) {
        ExaminationSession session = sessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Session not found"));
        return toResponse(session);
    }

    @Override
    public List<ExaminationSessionResponse> getByUser(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return sessionRepository.findAllByUserOrderByCompletedAtDesc(user)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private ExaminationSessionResponse toResponse(ExaminationSession session) {
        return ExaminationSessionResponse.builder()
                .id(session.getId())
                .userId(session.getUser().getId())
                .startedAt(session.getStartedAt())
                .completedAt(session.getCompletedAt())
                .notes(session.getNotes())
                .answers(
                        session.getAnswers() == null ? null :
                                session.getAnswers().stream()
                                        .map(a -> AnswerResponse.builder()
                                                .id(a.getId())
                                                .answerText(a.getAnswerText())
                                                .correct(a.isCorrect())
                                                .questionId(a.getQuestion().getId())
                                                .examinationSessionId(session.getId())
                                                .build()
                                        )
                                        .toList()
                )
                .build();
    }
}
