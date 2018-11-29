package com.loop.web.dao;

import com.loop.web.bean.Problem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Intellij IDEA.
 *
 * @author: 霍运浩
 * @date: 2018-08-12
 * @time: 19:35
 */
public interface ProblemDao {
    List<Problem> selectAllPro();

    void addQuestion(Problem problem);

    void detelePrpblem(Integer problemId);

    Problem selectProById(Integer problemId);

    void updateQuestion(Problem problem);

    Problem getProblemById(Integer problemId);

    void updateProblemById(@Param("problemId") Integer problemId, @Param("pro_submit") Integer pro_submit);

    void updateProblemInfoById(@Param("problemId") Integer problemId, @Param("pro_solved") Integer pro_solved);
}
