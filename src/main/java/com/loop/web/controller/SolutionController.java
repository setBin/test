package com.loop.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.loop.web.bean.*;
import com.loop.web.service.ProblemService;
import com.loop.web.service.SolutionService;
import com.loop.web.service.SourceCodeService;
import com.loop.web.service.UserService;
import com.loop.web.utils.CommonHelper;
import com.loop.web.utils.Constants;
import com.loop.web.utils.Msg;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Intellij IDEA.
 *
 * @author: 霍运浩
 * @date: 2018-08-29
 * @time: 10:00
 */
@RestController
@RequestMapping("")
public class SolutionController {


    @Autowired
    SolutionService solutionService;
    @Autowired
    SourceCodeService sourceCodeService ;
    @Autowired
    UserService userService;
    @Autowired
    ProblemService problemService;

    /**
     * 获取答题状态
     * @param curPage
     * @param pageSize
     * @param navigatePages
     * @return
     */
    @RequestMapping(value = "solution/{curPage}/{pageSize}/{navigatePages}",method = RequestMethod.GET)
    public Msg getQuestionResult(@PathVariable("curPage") Integer curPage,
                                 @PathVariable("pageSize") Integer pageSize,
                                 @PathVariable("navigatePages") Integer navigatePages){

        List<Solution> solutionList=solutionService.getAllSolution();
        for(Solution solution:solutionList){
            ;
            solution.setResultC(CommonHelper.getcompileResult(solution.getResult()));
        }
        PageHelper.startPage(curPage,pageSize);
        PageInfo pageInfo=new PageInfo(solutionList,navigatePages);
        return Msg.success().add("msg",pageInfo);
    }
    /**
     * 答题
     */
    @RequestMapping(value = "solution",method = RequestMethod.POST)
    public Msg answerQustion(@RequestBody @Valid SolutionSourceCode solutionSourceCode, BindingResult bindingResult){
        if(solutionSourceCode.getSourceCode().getSource()!=null&& !solutionSourceCode.getSourceCode().getSource().trim().isEmpty()&&
                solutionSourceCode.getSolution().getProblemId()!=null&&solutionSourceCode.getSolution().getLanguage()!=null){
            Session session = SecurityUtils.getSubject().getSession();
            User user = (User) session.getAttribute(Constants.SESSION_USER);
            solutionSourceCode.getSolution().setUsername(user.getUsername());
            User user1=userService.selectUserById(user.getUserId());
            Integer user_submit = Integer.parseInt(user1.getUserSubmit());
            user_submit++;
            userService.updateUserById(user1.getUserId(),user_submit.toString());
            Problem problem=problemService.getProblemById(solutionSourceCode.getSolution().getProblemId());
            Integer pro_submit = problem.getSubmit();
            pro_submit++;
            problemService.updateProblemById(problem.getProblemId(),pro_submit);
            solutionSourceCode.getSolution().setCodeLength(solutionSourceCode.getSourceCode().getSource().trim().trim().length());
            solutionService.addSolution(solutionSourceCode.getSolution());
            solutionSourceCode.getSourceCode().setSolutionId(solutionSourceCode.getSolution().getSolutionId());
            sourceCodeService.addSourceCode(solutionSourceCode.getSourceCode());
            Solution solution=null;
            while(true){
                solution=solutionService.getSolution(solutionSourceCode.getSolution().getSolutionId());
                if(solution.getResult().toString().equals("4")){

                    Integer user_solved1 = Integer.parseInt(user1.getUserSolved());
                    user_solved1++;
                    userService.updateUserinfoById(user1.getUserId(),user_solved1.toString());
                    Integer pro_solved1 = problem.getSubmit();
                    pro_solved1++;
                    problemService.updateProblemInfoById(problem.getProblemId(),pro_solved1);
                    solution.setResultC(CommonHelper.getcompileLanguage(solution.getResult()));
                    return Msg.success().add("msg",solution);
                }
                else{
                    solution=solutionService.getSolution(solutionSourceCode.getSolution().getSolutionId());
                }
            }
        }
        return Msg.success().add("msg","参数错误");
    }
    /**
     * 获取问题状态
     * @param id
     * @return
     */
    @RequestMapping(value = "solution/{id}",method = RequestMethod.GET)
    public Msg getAnserStatsbyId(@PathVariable("id") Integer id){
        RubtimeInfo rubtimeInfo=solutionService.getAnserStatsbyId(id);
        if(rubtimeInfo==null)
        {
            SourceCode sourceCode=sourceCodeService.getCodeById(id);
            return Msg.success().add("msg",sourceCode);
        }
        return Msg.success().add("msg",rubtimeInfo);
    }

    /**
     * 根据用户的name找到用户的找过的转态
     * @param name
     * @return
     */
    @RequestMapping(value = "solution/author/{name}",method = RequestMethod.GET)
    public Msg getAnserStatsbyName(@PathVariable("name") String name){
        List<Solution> solutionList=solutionService.getAnserStatsbyName(name);
        for(Solution solution:solutionList){
            solution.setResultC(CommonHelper.getcompileLanguage(solution.getResult()));
        }
        return Msg.success().add("msg",solutionList);
    }

}
