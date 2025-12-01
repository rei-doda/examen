package com.rei.examenbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "questions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // The actual question text
    @Column(nullable = false)
    private String text;

    private Integer orderNumber;

    // RELATION WITH CATEGORY (correct way)
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    // RELATION WITH ANSWERS
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers;

    // Optional difficulty
    private String difficulty;
}
