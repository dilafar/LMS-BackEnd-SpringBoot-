package com.lms.examandgrading.controller;


import com.lms.examandgrading.api.QuizApi;
import com.lms.examandgrading.domain.Quiz;
import com.lms.examandgrading.dto.QuizDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizzes")
public class Quizendpoint {

    private QuizApi quizApi;

    @Autowired
    public Quizendpoint(QuizApi quizApi){
        this.quizApi= quizApi;
    }

    @GetMapping
    public List<Quiz> getQuizes(){
        return quizApi.getAllQuizes();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Quiz addQuiz(@RequestBody QuizDto quizDto){
        Quiz quiz = new Quiz();
        quiz.setQuestion(quizDto.getQuestion());
        quiz.setOpt1(quizDto.getOpt1());
        quiz.setOpt2(quizDto.getOpt2());
        quiz.setOpt3(quizDto.getOpt3());
        quiz.setOpt4(quizDto.getOpt4());
        quiz.setAnswer(quizDto.getAnswer());
        quiz.setExamID(quizDto.getExamID());
        quiz.setTeacherID(quizDto.getTeacherID());
        return quizApi.addQuiz(quiz);

    }

    @PutMapping("/{qid}")
    @ResponseStatus(HttpStatus.CREATED)
    public Quiz updateQuiz(@PathVariable String qid , @RequestBody QuizDto quizDto){
        Quiz quiz = new Quiz();
        quiz.setQid(qid);
        quiz.setQuestion(quizDto.getQuestion());
        quiz.setOpt1(quizDto.getOpt1());
        quiz.setOpt2(quizDto.getOpt2());
        quiz.setOpt3(quizDto.getOpt3());
        quiz.setOpt4(quizDto.getOpt4());
        quiz.setAnswer(quizDto.getAnswer());
        quiz.setExamID(quizDto.getExamID());
        quiz.setTeacherID(quizDto.getTeacherID());
        return quizApi.update(quiz);

    }

    @DeleteMapping("/{qid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String qid , @RequestBody QuizDto quizDto){
        quizApi.delete(qid);

     }

    @GetMapping("/exam/{examID}")
    public List<Quiz> getAllByExamID(@PathVariable String examID){
        return quizApi.getAllByExamID(examID);
    }


    @GetMapping("/teacher/{teacherID}")
    public List<Quiz> getAllByTeacherID(@PathVariable String teacherID){
        return quizApi.getAllByTeacherID(teacherID);
    }


}
