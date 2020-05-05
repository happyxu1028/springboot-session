package com.xubin.learn.controller;

import com.xubin.learn.dao.ResumeDao;
import com.xubin.learn.pojo.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private ResumeDao resumeDao;

    /**
     * 简历列表
     * @param map
     * @return
     */
    @RequestMapping("/list")
    public String list(Map<String,Object> map){
        map.put("resumes",resumeDao.findAll());
        return "resume/list";
    }

    /**
     * 创建简历页
     * @return
     */
    @RequestMapping("/create")
    public String create(){
        return "resume/edit";
    }

    /**
     * 修改简历页
     * @param id
     * @param map
     * @return
     */
    @RequestMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Map<String,Object> map){
        map.put("resume",resumeDao.findById(id).get());
        return "resume/edit";
    }

    /**
     * 删除简历
     * @param id
     * @return
     */
    @RequestMapping("/{id}/delete")
    public String delete(@PathVariable Long id){
        resumeDao.deleteById(id);
        return "redirect:/resume/list";
    }

    /**
     * 修改简历
     * @param resume
     * @return
     */
    @RequestMapping("/update")
    public String add(Resume resume){
        resumeDao.save(resume);
        return "redirect:/resume/list";
    }
}
