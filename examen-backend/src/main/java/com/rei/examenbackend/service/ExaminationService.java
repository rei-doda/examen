package com.rei.examenbackend.service;

import com.rei.examenbackend.model.Answer;
import com.rei.examenbackend.model.ExaminationSession;
import com.rei.examenbackend.model.User;

import java.util.List;

public interface ExaminationService {

    // Start a new examination for a user
    ExaminationSession startSession(User user);

    // Complete the examination and set the completed timestamp
    ExaminationSession completeSession(Long sessionId, String notes);

    // Save a list of answers in the session
    List<Answer> saveAnswers(Long sessionId, List<Answer> answers);

    // Get all sessions for a user
    List<ExaminationSession> getSessionsByUser(User user);

    // Get a single session by ID
    ExaminationSession getSessionById(Long id);
}