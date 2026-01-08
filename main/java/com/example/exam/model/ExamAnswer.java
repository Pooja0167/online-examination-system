package com.example.exam.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "exam_answers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExamAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String selectedAnswer;

    @ManyToOne
    private User student;

    @ManyToOne
    private Question question;
}
