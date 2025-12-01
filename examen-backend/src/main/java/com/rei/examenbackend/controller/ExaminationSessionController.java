package com.rei.examenbackend.controller;

import com.rei.examenbackend.dto.answer.AnswerRequest;
import com.rei.examenbackend.dto.answer.AnswerResponse;
import com.rei.examenbackend.dto.session.ExaminationSessionRequest;
import com.rei.examenbackend.dto.session.ExaminationSessionResponse;
import com.rei.examenbackend.service.ExaminationSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
@RequiredArgsConstructor
public class ExaminationSessionController {

    private final ExaminationSessionService sessionService;

    @PostMapping("/start")
    public ResponseEntity<ExaminationSessionResponse> start(@RequestBody ExaminationSessionRequest request) {
        return ResponseEntity.ok(sessionService.startSession(request));
    }

    @PostMapping("/{id}/complete")
    public ResponseEntity<ExaminationSessionResponse> complete(
            @PathVariable Long id,
            @RequestParam(required = false) String notes
    ) {
        return ResponseEntity.ok(sessionService.completeSession(id, notes));
    }

    @PostMapping("/{id}/submit-answers")
    public ResponseEntity<List<AnswerResponse>> submitAnswers(
            @PathVariable Long id,
            @RequestBody List<AnswerRequest> answers
    ) {
        return ResponseEntity.ok(sessionService.submitAnswers(id, answers));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExaminationSessionResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(sessionService.getById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ExaminationSessionResponse>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(sessionService.getByUser(userId));
    }
}
