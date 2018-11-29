package com.loop.web.service;

import com.loop.web.bean.Problem;
import com.loop.web.dao.ProblemDao;
import com.loop.web.dao.TagsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hyh
 * Date: 2018/8/1
 */
@Service
public class ProblemService {

    @Autowired
    ProblemDao problemDao;
    @Autowired
    TagsDao tagsDao;

    public  void updateProblemById(Integer problemId, Integer pro_submit) {
        problemDao.updateProblemById(problemId,pro_submit);
    }

    public List<Problem> selectAllPro() {

        return problemDao.selectAllPro();
    }

    public void addQuestion(Problem problem) {
        problemDao.addQuestion(problem);
    }

    public void deleteProblemAndTags(Integer problemId) {
        tagsDao.deleteTagByProblemId(problemId);
        problemDao.detelePrpblem(problemId);
    }

    public void updateQuestion(Problem problem) {
        problemDao.updateQuestion(problem);
    }

    public Problem getProblemById(Integer problemId) {

        return problemDao.getProblemById(problemId);
    }

    public void updateProblemInfoById(Integer problemId, Integer pro_solved) {
        problemDao.updateProblemInfoById(problemId,pro_solved);
    }
}
