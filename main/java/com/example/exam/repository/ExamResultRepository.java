package com.example.exam.repository;

import com.example.exam.model.Exam;
import com.example.exam.model.ExamResult;
import com.example.exam.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExamResultRepository extends JpaRepository<ExamResult, Long> {

    List<ExamResult> findByStudent(User student);

    Optional<ExamResult> findByStudentAndExam(User student, Exam exam);
}

