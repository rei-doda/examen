package com.rei.examenbackend.service.impl;

import com.rei.examenbackend.model.Answer;
import com.rei.examenbackend.model.ExaminationSession;
import com.rei.examenbackend.model.User;
import com.rei.examenbackend.repository.ExaminationSessionRepository;
import com.rei.examenbackend.repository.AnswerRepository;
import com.rei.examenbackend.service.ExaminationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExaminationServiceImpl implements ExaminationService {

    private final ExaminationSessionRepository sessionRepository;
    private final AnswerRepository answerRepository;

    public ExaminationServiceImpl(ExaminationSessionRepository sessionRepository,
                                  AnswerRepository answerRepository) {
        this.sessionRepository = sessionRepository;
        this.answerRepository = answerRepository;
    }

    @Override
    public ExaminationSession startSession(User user) {
        ExaminationSession session = ExaminationSession.builder()
                .user(user)
                .startedAt(LocalDateTime.now())
                .build();

        return sessionRepository.save(session);
    }

    @Override
    public ExaminationSession completeSession(Long sessionId, String notes) {
        ExaminationSession session = sessionRepository.findById(sessionId).orElse(null);

        if (session == null) {
            return null;
        }

        session.setCompletedAt(LocalDateTime.now());
        session.setNotes(notes);

        return sessionRepository.save(session);
    }

    @Override
    public List<Answer> saveAnswers(Long sessionId, List<Answer> answers) {
        ExaminationSession session = sessionRepository.findById(sessionId).orElse(null);

        if (session == null) {
            return null;
        }

        // Attach each answer to the session
        for (Answer answer : answers) {
            answer.setExaminationSession(session);
        }

        return answerRepository.saveAll(answers);
    }

    @Override
    public List<ExaminationSession> getSessionsByUser(User user) {
        return sessionRepository.findAllByUserOrderByCompletedAtDesc(user);
    }

    @Override
    public ExaminationSession getSessionById(Long id) {
        return sessionRepository.findById(id).orElse(null);
    }
}