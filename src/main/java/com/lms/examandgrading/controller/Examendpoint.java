package com.lms.examandgrading.controller;

import com.lms.examandgrading.api.ExamApi;
import com.lms.examandgrading.domain.Exam;
import com.lms.examandgrading.dto.ExamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exams")
public class Examendpoint {

    private ExamApi examApi;

    @Autowired
    public Examendpoint(ExamApi examApi){
        this.examApi = examApi;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Exam addExam(@RequestBody ExamDto examDto){
        Exam exam = new Exam();
        exam.setExamName(examDto.getExamName());
        exam.setTeacherID(examDto.getTeacherID());
        exam.setClassID(examDto.getClassID());
        exam.setSubjectID(examDto.getSubjectID());
        return examApi.addExam(exam);

    }

    @GetMapping("/{teacherID}")
    public List<Exam> getAllByTeacherID(@PathVariable String teacherID){
        return examApi.getAllByTeacherID(teacherID);
    }

    @DeleteMapping("/{examID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String examID , @RequestBody ExamDto examDto){
        examApi.delete(examID);

    }
}
