package com.lms.examandgrading.domain;

public class Result {
    private  String id;
    private String studentID;
    private String teacherID;
    private String Term;
    private int AssignmentMarks;
    private int QuizMarks;
    private String status;

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getTerm() {
        return Term;
    }

    public void setTerm(String term) {
        Term = term;
    }

    public int getAssignmentMarks() {
        return AssignmentMarks;
    }

    public void setAssignmentMarks(int assignmentMarks) {
        AssignmentMarks = assignmentMarks;
    }

    public int getQuizMarks() {
        return QuizMarks;
    }

    public void setQuizMarks(int quizMarks) {
        QuizMarks = quizMarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }
}
