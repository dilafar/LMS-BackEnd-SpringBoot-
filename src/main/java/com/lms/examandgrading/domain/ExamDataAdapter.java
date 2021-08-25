package com.lms.examandgrading.domain;

import java.util.List;

public interface ExamDataAdapter {

    Exam Save(Exam exam);
    void delete(String examID);
    List<Exam> getAllByTeacherID(String teacherID);
    List<String> getAll();
}
