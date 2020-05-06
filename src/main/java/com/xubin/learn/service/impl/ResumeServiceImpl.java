package com.xubin.learn.service.impl;
import com.xubin.learn.dao.ResumeDao;
import com.xubin.learn.pojo.Resume;
import com.xubin.learn.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ResumeServiceImpl implements ResumeService {
    @Autowired
    private ResumeDao resumeDao;

    @Override
    public List<Resume> findAll(){
        return resumeDao.findAll();
    }
}
