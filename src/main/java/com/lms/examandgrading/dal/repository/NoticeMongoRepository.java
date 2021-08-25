package com.lms.examandgrading.dal.repository;

import com.lms.examandgrading.dal.model.NoticeModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeMongoRepository extends MongoRepository<NoticeModel,String> {
    void deleteNoticeModelByNoticeID(String noticeID);
}
