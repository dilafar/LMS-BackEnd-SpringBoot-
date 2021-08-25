package com.lms.examandgrading.dal.repository;

import com.lms.examandgrading.dal.model.QuizModel;
import com.lms.examandgrading.domain.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizMongoRepository extends MongoRepository<QuizModel,String> {
    void deleteQuizModelByQid(String qid);
    List<QuizModel>findQuizModelByExamID(String examID);
    List<QuizModel>findQuizModelByTeacherID(String teacherID);

}
