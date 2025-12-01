package com.rei.examenbackend.repository;

import com.rei.examenbackend.model.ExaminationSession;
import com.rei.examenbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExaminationSessionRepository extends JpaRepository<ExaminationSession, Long> {

    List<ExaminationSession> findAllByUserOrderByCompletedAtDesc(User user);
}
