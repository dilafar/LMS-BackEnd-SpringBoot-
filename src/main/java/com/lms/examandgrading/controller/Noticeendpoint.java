package com.lms.examandgrading.controller;

import com.lms.examandgrading.api.NoticeApi;
import com.lms.examandgrading.domain.Notice;
import com.lms.examandgrading.dto.NoticeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notices")
public class Noticeendpoint {
    private NoticeApi noticeApi;

    @Autowired
    public Noticeendpoint(NoticeApi noticeApi){
        this.noticeApi = noticeApi;
    }

    @GetMapping
    public List<Notice> getNotices(){
        return noticeApi.getAllNotices();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Notice addNotice(@RequestBody NoticeDto noticeDto){
        Notice notice = new Notice();
        notice.setTitle(noticeDto.getTitle());
        notice.setDescription(noticeDto.getDescription());
        notice.setDate(noticeDto.getDate());
        return noticeApi.addNotice(notice);

    }

    @PutMapping("/{noticeID}")
    @ResponseStatus(HttpStatus.CREATED)
    public Notice updateNotice(@PathVariable String noticeID,@RequestBody NoticeDto noticeDto){
        Notice notice = new Notice();
        notice.setNoticeID(noticeID);
        notice.setDate(noticeDto.getDate());
        notice.setDescription(noticeDto.getDescription());
        notice.setTitle(noticeDto.getTitle());
        return noticeApi.update(notice);

    }
    @DeleteMapping("/{noticeID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String noticeID , @RequestBody NoticeDto noticeDto){
        noticeApi.delete(noticeID);

    }
}
