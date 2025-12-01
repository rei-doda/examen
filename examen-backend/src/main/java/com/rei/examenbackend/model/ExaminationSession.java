package com.rei.examenbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "examination_sessions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExaminationSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // The user that this session belongs to
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // All answers provided in this session
    @OneToMany(mappedBy = "examinationSession", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers;

    private LocalDateTime startedAt;

    private LocalDateTime completedAt;

    // Optional: summary or notes after the examination
    @Column(length = 1000)
    private String notes;
}
