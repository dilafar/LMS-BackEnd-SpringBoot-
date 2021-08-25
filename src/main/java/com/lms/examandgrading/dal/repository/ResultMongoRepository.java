package com.lms.examandgrading.dal.repository;

import com.lms.examandgrading.dal.model.ResultModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultMongoRepository extends MongoRepository<ResultModel,String> {
    void deleteResultModelById(String id);
    List<ResultModel>findResultModelByStudentID(String studentID);
    List<ResultModel>findResultModelByTeacherID(String teacherID);
}
