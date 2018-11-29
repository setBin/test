package com.loop.web.dao;

import com.loop.web.bean.RubtimeInfo;
import com.loop.web.bean.Solution;

import java.util.List;

/**
 * Created by Intellij IDEA.
 *
 * @author: 霍运浩
 * @date: 2018-08-29
 * @time: 10:06
 */
public interface SolutionDao {
    List<Solution> getAllSolution();

    Solution getSolution(Integer solutionId);

    void addSolution(Solution solution);

    RubtimeInfo getAnserStatsbyId(Integer id);

    List<Solution> getAnserStatsbyName(String name);
}
