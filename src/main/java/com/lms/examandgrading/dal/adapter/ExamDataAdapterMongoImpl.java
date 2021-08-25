package com.lms.examandgrading.dal.adapter;

import com.lms.examandgrading.dal.model.ExamModel;
import com.lms.examandgrading.dal.repository.ExamMongoRepository;
import com.lms.examandgrading.domain.Exam;
import com.lms.examandgrading.domain.ExamDataAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExamDataAdapterMongoImpl implements ExamDataAdapter {

    private final ExamMongoRepository repository;

    @Autowired
    public ExamDataAdapterMongoImpl(ExamMongoRepository repository){
        this.repository = repository;
    }

    @Override
    public Exam Save(Exam exam) {
        ExamModel examModel = new ExamModel();
        examModel.setExamName(exam.getExamName());
        examModel.setTeacherID(exam.getTeacherID());
        examModel.setClassID(exam.getClassID());
        examModel.setSubjectID(exam.getSubjectID());
        examModel.setExamID(exam.getExamID());
        examModel = repository.save(examModel);

        exam.setKey(examModel.getKey());
        return exam;
    }

    @Override
    public void delete(String examID) {
        repository.deleteExamModelByExamID(examID);
    }

    @Override
    public List<Exam> getAllByTeacherID(String teacherID) {
        List<ExamModel> examModels = repository.findExamModelByTeacherID(teacherID);
        List<Exam> exams = new ArrayList<>();

        for(ExamModel examModel: examModels){
            Exam exam = new Exam();
            exam.setExamID(examModel.getExamID());
            exam.setExamName(examModel.getExamName());
            exam.setTeacherID(examModel.getTeacherID());
            exam.setSubjectID(examModel.getSubjectID());
            exam.setClassID(examModel.getClassID());
            exam.setKey(examModel.getKey());
            exams.add(exam);
        }
        return exams;
    }

    @Override
    public List<String> getAll() {
        List<ExamModel> examModels = repository.findAll();
        List<String> Ids = new ArrayList<>();
        for(ExamModel examModel: examModels){


            Ids.add(examModel.getExamID());

        }
        return Ids;
    }


}
