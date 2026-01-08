package com.example.exam.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int duration; // minutes

    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    private List<Question> questions;
}
