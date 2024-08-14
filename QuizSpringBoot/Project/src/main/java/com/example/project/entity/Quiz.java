package com.example.project.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.util.List;

@Entity
@Table(name = "quiz")
@Transactional
public class Quiz
{
    @Column
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToMany
    private List<Questions> list;
    private String category;
    private String difficulty;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Questions> getList() {
        return list;
    }

    public void setList(List<Questions> list) {
        this.list = list;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
