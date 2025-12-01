package com.rei.examenbackend.controller;

import com.rei.examenbackend.model.Answer;
import com.rei.examenbackend.model.ExaminationSession;
import com.rei.examenbackend.model.User;
import com.rei.examenbackend.repository.UserRepository;
import com.rei.examenbackend.service.ExaminationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/examination")
public class ExaminationController {

    private final ExaminationService examinationService;
    private final UserRepository userRepository;

    public ExaminationController(ExaminationService examinationService, UserRepository userRepository) {
        this.examinationService = examinationService;
        this.userRepository = userRepository;
    }

    // START A NEW SESSION
    @PostMapping("/start/{userId}")
    public ExaminationSession startSession(@PathVariable Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        return examinationService.startSession(user);
    }

    // SAVE ANSWERS FOR A SESSION
    @PostMapping("/{sessionId}/answers")
    public List<Answer> saveAnswers(@PathVariable Long sessionId,
                                    @RequestBody List<Answer> answers) {
        return examinationService.saveAnswers(sessionId, answers);
    }

    // COMPLETE THE SESSION
    @PostMapping("/{sessionId}/complete")
    public ExaminationSession completeSession(@PathVariable Long sessionId,
                                              @RequestBody(required = false) String notes) {
        return examinationService.completeSession(sessionId, notes);
    }

    // GET ALL SESSIONS FOR A USER
    @GetMapping("/user/{userId}")
    public List<ExaminationSession> getSessionsByUser(@PathVariable Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        return examinationService.getSessionsByUser(user);
    }

    // GET SINGLE SESSION BY ID
    @GetMapping("/{sessionId}")
    public ExaminationSession getSessionById(@PathVariable Long sessionId) {
        return examinationService.getSessionById(sessionId);
    }
}