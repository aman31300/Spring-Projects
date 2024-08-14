package com.example.project.service;

import com.example.project.dao.QuestionDao;
import com.example.project.entity.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService
{
    @Autowired
    QuestionDao dao;

    public ResponseEntity<List<Questions>> getAll() {
        return  new ResponseEntity<>(dao.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<List<Questions>> getByCategory(String category) {
        try{
            return new ResponseEntity<>(dao.findByCategory(category),HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Questions> addQuestion(Questions questions) {
        dao.save(questions);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<Questions> updateQuestion(Questions questions) {
        dao.save(questions);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<List<Questions>> getByDifficulty(String difficulty) {
        return new ResponseEntity<>( dao.findByDifficulty(difficulty.toLowerCase()),HttpStatus.OK);
    }
}
