package com.loop.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.loop.web.bean.Problem;
import com.loop.web.bean.ProblemTagsCases;
import com.loop.web.service.ProblemService;
import com.loop.web.service.TagsService;
import com.loop.web.utils.CommonHelper;
import com.loop.web.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: hyh
 * Date: 2018/8/1
 */
@RestController
@RequestMapping("")
public class ProblemController {

    @Autowired
    ProblemService problemService;

    @Autowired
    TagsService tagsService;

    /**
     * 获取所有题目
     * @param curPage
     * @param pageSize
     * @param navigatePages
     * @return
     */
    @RequestMapping(value = "/problem/{curPage}/{pageSize}/{navigatePages}",method = RequestMethod.GET)
    public Msg getQuestion(@PathVariable(value = "curPage") Integer curPage,
                        @PathVariable(value = "pageSize") Integer pageSize,
                        @PathVariable(value = "navigatePages") Integer navigatePages){
        PageHelper.startPage(curPage,pageSize);
        List<Problem> problemList= problemService.selectAllPro();
        PageInfo pageInfo=new PageInfo(problemList,navigatePages);
        return Msg.success().add("msg",pageInfo);
    }

    /**
     * 添加题目
     * @param
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "problem",method = RequestMethod.POST)
    public Msg addQuestion(@Valid @RequestBody ProblemTagsCases ProblemTagsCases,
                           BindingResult bindingResult
                           ) throws IOException {
        if(ProblemTagsCases.getProblem().getDescription()!=null && !ProblemTagsCases.getProblem().getDescription().trim().isEmpty() &&
                ProblemTagsCases.getProblem().getInput()!=null && !ProblemTagsCases.getProblem().getInput().trim().isEmpty() &&
                ProblemTagsCases.getProblem().getOutput()!=null && !ProblemTagsCases.getProblem().getOutput().trim().isEmpty() &&
                ProblemTagsCases.getProblem().getMemoryLimit()!=null && !ProblemTagsCases.getProblem().getMemoryLimit().toString().trim().isEmpty() &&
                ProblemTagsCases.getProblem().getLevel()!=null && !ProblemTagsCases.getProblem().getLevel().trim().isEmpty() &&
                ProblemTagsCases.getProblem().getPointId()!=null && !ProblemTagsCases.getProblem().getPointId().trim().isEmpty() &&
                ProblemTagsCases.getProblem().getTimeLimit()!=null && !ProblemTagsCases.getProblem().getTimeLimit().toString().trim().isEmpty() &&
                ProblemTagsCases.getProblem().getTitle()!=null && !ProblemTagsCases.getProblem().getTitle().trim().isEmpty()&&
                CommonHelper.cheakIsRepeat(ProblemTagsCases.getTags())
                ){
            if(bindingResult.hasErrors()){
                Map<String, Object> map = new HashMap<String, Object>();
                List<FieldError> errors = bindingResult.getFieldErrors();
                for (FieldError fieldError : errors) {
                    System.out.println("错误的字段名：" + fieldError.getField());
                    System.out.println("错误信息：" + fieldError.getDefaultMessage());
                    map.put(fieldError.getField(), fieldError.getDefaultMessage());
                }
                return Msg.fail().add("msg", map);
            }else{
                ProblemTagsCases.getProblem().setStatus('N');
                ProblemTagsCases.getProblem().setCreatDate(new Date());
                ProblemTagsCases.getProblem().setSpj('0');

               problemService.addQuestion(ProblemTagsCases.getProblem());
                //去写文件

                if(CommonHelper.makeFile(ProblemTagsCases.getProblem().getProblemId(),ProblemTagsCases.getStringMap()))
                {
                    //去存标签
                    tagsService.addTags(ProblemTagsCases.getTags(),ProblemTagsCases.getProblem().getProblemId());
                    return Msg.success().add("msg","添加成功"+ProblemTagsCases.getProblem().getProblemId());
                }
                return Msg.fail().add("msg","添加测试用户失败");

            }
        }else{
            return Msg.fail().add("msg","参数错误");
        }
    }

    /**
     * 更新题目
     * @param ProblemTagsCases
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "problem/{problemId}",method = RequestMethod.PUT)
    public Msg updateQuestion(@Valid @RequestBody ProblemTagsCases ProblemTagsCases,
                           BindingResult bindingResult,@PathVariable("problemId") Integer problemId
    ) throws IOException {
        if(ProblemTagsCases.getProblem().getDescription()!=null && !ProblemTagsCases.getProblem().getDescription().trim().isEmpty() &&
                ProblemTagsCases.getProblem().getInput()!=null && !ProblemTagsCases.getProblem().getInput().trim().isEmpty() &&
                ProblemTagsCases.getProblem().getOutput()!=null && !ProblemTagsCases.getProblem().getOutput().trim().isEmpty() &&
                ProblemTagsCases.getProblem().getMemoryLimit()!=null && !ProblemTagsCases.getProblem().getMemoryLimit().toString().trim().isEmpty() &&
                ProblemTagsCases.getProblem().getLevel()!=null && !ProblemTagsCases.getProblem().getLevel().trim().isEmpty() &&
                ProblemTagsCases.getProblem().getPointId()!=null && !ProblemTagsCases.getProblem().getPointId().trim().isEmpty() &&
                ProblemTagsCases.getProblem().getTimeLimit()!=null && !ProblemTagsCases.getProblem().getTimeLimit().toString().trim().isEmpty() &&
                ProblemTagsCases.getProblem().getTitle()!=null && !ProblemTagsCases.getProblem().getTitle().trim().isEmpty()
                ){
            if(bindingResult.hasErrors()){
                Map<String, Object> map = new HashMap<String, Object>();
                List<FieldError> errors = bindingResult.getFieldErrors();
                for (FieldError fieldError : errors) {
                    System.out.println("错误的字段名：" + fieldError.getField());
                    System.out.println("错误信息：" + fieldError.getDefaultMessage());
                    map.put(fieldError.getField(), fieldError.getDefaultMessage());
                }
                return Msg.fail().add("msg", map);
            }else{
                ProblemTagsCases.getProblem().setProblemId(problemId);
                ProblemTagsCases.getProblem().setCreatDate(new Date());
                ProblemTagsCases.getProblem().setStatus('Y');
                problemService.updateQuestion(ProblemTagsCases.getProblem());
                //去写文件
                if(CommonHelper.updateFile(problemId,ProblemTagsCases.getStringMap()))
                {
                    //先删除以前的标签再去存标签
                    tagsService.deleteTags(problemId);
                    tagsService.addTags(ProblemTagsCases.getTags(),problemId);

                    return Msg.success().add("msg","更新成功"+problemId);
                }
                return Msg.fail().add("msg","添加测试用户失败");

            }
        }else{
            return Msg.fail().add("msg","参数错误");
        }
    }
    /**
     * 删除题目
     */
    @RequestMapping(value = "problem/{problemId}",method = RequestMethod.DELETE)
    public Msg deleteProblem(@PathVariable("problemId") Integer problemId) throws IOException {

        problemService.deleteProblemAndTags(problemId);
        CommonHelper.deleteFile(problemId);
        return Msg.success().add("msg","删除成功");
    }

    /**
     * 获取这个问题的所有信息
     * @param problemId
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "problem/{problemId}",method = RequestMethod.GET)
    public Msg getProblemById(@PathVariable("problemId") Integer problemId) throws IOException {

        List< Map<String,String>> stringStringMap=CommonHelper.getFile(problemId);
        Problem problem=problemService.getProblemById(problemId);
        problem.setMapList(stringStringMap);
        return Msg.success().add("msg",problem);
    }

}
