package com.rei.examenbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "answers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // The actual answer text (fixes AnswerBuilder errors)
    @Column(nullable = false)
    private String answerText;

    // Whether this answer is the correct one
    private boolean correct;

    // RELATION WITH QUESTION
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    // RELATION WITH EXAM SESSION
    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false)
    private ExaminationSession examinationSession;
}
