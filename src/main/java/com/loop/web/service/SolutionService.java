package com.loop.web.service;

import com.loop.web.bean.RubtimeInfo;
import com.loop.web.bean.Solution;
import com.loop.web.dao.SolutionDao;
import com.loop.web.dao.SourceCodeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Intellij IDEA.
 *
 * @author: 霍运浩
 * @date: 2018-08-29
 * @time: 10:05
 */
@Service
public class SolutionService {
    @Autowired
    SolutionDao solutionDao;
    @Autowired
    SourceCodeDao sourceCodeDao;

    public List<Solution> getAllSolution() {
        return solutionDao.getAllSolution();
    }

    public void addSolution(Solution solution) {

        solutionDao.addSolution(solution);
    }

    public Solution getSolution(Integer solutionId) {

        return solutionDao.getSolution(solutionId);
    }

    public RubtimeInfo getAnserStatsbyId(Integer id) {
        return solutionDao.getAnserStatsbyId(id);
    }

    public List<Solution> getAnserStatsbyName(String name) {
        return solutionDao.getAnserStatsbyName(name);
    }


}
