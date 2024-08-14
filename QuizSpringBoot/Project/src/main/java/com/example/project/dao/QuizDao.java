package com.example.project.dao;

import com.example.project.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuizDao extends JpaRepository<Quiz,Integer>
{
    @Query(value = "SELECT *" +
            "FROM quiz WHERE id=:id AND category=:category AND difficulty=:difficulty",nativeQuery = true)
    Quiz getQuizByIdCategoryDifficulty(int id, String category, String difficulty);
}
