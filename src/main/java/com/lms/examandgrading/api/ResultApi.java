package com.lms.examandgrading.api;

import com.lms.examandgrading.domain.Quiz;
import com.lms.examandgrading.domain.Result;
import com.lms.examandgrading.domain.ResultDataAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultApi {

    private final ResultDataAdapter resultDataAdapter;

    @Autowired
    public ResultApi(ResultDataAdapter resultDataAdapter){
        this.resultDataAdapter = resultDataAdapter;

    }

    public List<Result> getAllResult(){
        return resultDataAdapter.getAll();
    }

    public Result addResult(Result result){
        String id1 = result.getStudentID();
        String id2 = result.getTerm();
        String id3 = id1 + " " + id2;
        result.setId(id3);
        result = resultDataAdapter.Save(result);
        return result;
    }

    public Result update (Result result){
        return resultDataAdapter.update(result);
    }
    public void delete(String id){
        resultDataAdapter.delete(id);
    }

    public List<Result> getAllByStudentID(String studentID){
        return resultDataAdapter.getAllByStudentID(studentID);
    }

    public List<Result> getAllByTeacherID(String teacherID){
        return resultDataAdapter.getAllByTeacherID(teacherID);
    }


}
