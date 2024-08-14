package com.example.project.service;

import com.example.project.Wrapper.QuestionWrapper;
import com.example.project.dao.QuestionDao;
import com.example.project.dao.QuizDao;
import com.example.project.entity.Answer;
import com.example.project.entity.Questions;
import com.example.project.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService
{
    @Autowired
    QuestionDao questionDao;
    @Autowired
    QuizDao quizDao;

    public ResponseEntity<Quiz> createQuiz(int id, String category, String Difficulty, int size)
    {
        List<Questions> list = questionDao.findQuizByDifficultyCategorySize(category,Difficulty,size);
        Quiz quiz = new Quiz();
        quiz.setId(id);
        quiz.setCategory(category);
        quiz.setDifficulty(Difficulty);
        quiz.setList(list);
        quizDao.save(quiz);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    public List<QuestionWrapper> getQuizById(int id)
    {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<QuestionWrapper> userList = new ArrayList<>();
        List<Questions> dbQuestion = quiz.get().getList();
        for(int i = 0; i<dbQuestion.size();i++)
        {
            QuestionWrapper q = new QuestionWrapper(dbQuestion.get(i).getId(),dbQuestion.get(i).getQuestion(),dbQuestion.get(i).getOption1(),dbQuestion.get(i).getOption2(),dbQuestion.get(i).getOption3(),dbQuestion.get(i).getOption4());
            userList.add(q);
        }
        return userList;
    }
    public List<Integer> showAllQuizes() {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<=quizDao.findAll().size();i++)
        {
            if(quizDao.findById(i).isPresent()) {
                list.add(quizDao.findById(i).get().getId());
            }
        }
        return list;
    }
    public ResponseEntity<Integer> getResult(int id, List<Answer> answer)
    {
        Optional<Quiz> quiz = quizDao.findById(id);
        int result=0;
        for(int i =0;i<quiz.get().getList().size();i++)
        {
            if(answer.get(i).getAnswer().equalsIgnoreCase(quiz.get().getList().get(i).getRightAns()))
            {
                result++;
            }
        }
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
