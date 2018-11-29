package com.loop.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.loop.web.bean.KnowledgPoint;
import com.loop.web.bean.Problem;
import com.loop.web.service.KonwledgPointService;
import com.loop.web.utils.CommonHelper;
import com.loop.web.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: hyh
 * Date: 2018/7/31
 */
@RestController
@RequestMapping("")
public class KonwledgPointController {

    @Autowired
    KonwledgPointService konwledgPointService;

    /**
     * 获取所有知识点
     * @param curPage
     * @param pageSize
     * @param navigatePages
     * @return
     */
    @RequestMapping(value = "/konwledgPoint/{curPage}/{pageSize}/{navigatePages}",method = RequestMethod.GET)
    public Msg getKonwledgPoint(@PathVariable(value = "curPage") Integer curPage,
                                          @PathVariable(value = "pageSize") Integer pageSize,
                                          @PathVariable(value = "navigatePages") Integer navigatePages){
        PageHelper.startPage(curPage,pageSize);
        List<HashMap<String, Object>> knowledgPointList=konwledgPointService.getAllKonwledPoint();
        PageInfo pageInfo=new PageInfo(knowledgPointList,navigatePages);
        return Msg.success().add("msg",pageInfo);
    }

    /**
     * 添加知识点
     * @param knowledgPoint
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "konwledgPoint",method = RequestMethod.POST)
    public Msg getKonwledgPoint(@RequestBody @Valid KnowledgPoint knowledgPoint,
                                BindingResult bindingResult
                                 ){
        if(knowledgPoint.getSectionId()!=null && !knowledgPoint.getSectionId().trim().isEmpty() &&
                knowledgPoint.getPointName()!=null){
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
                knowledgPoint.setPointId(CommonHelper.getId());

                konwledgPointService.addkonwledgPoint(knowledgPoint);
                return Msg.success().add("msg","添加成功");
            }
        }else{
            return Msg.fail().add("msg","参数错误");
        }
    }

    /**
     * 修改知识点
     * @param knowledgPoint
     * @param bindingResult
     * @param konwledgPointId
     * @return
     */
    @RequestMapping(value = "konwledgPoint/{konwledgPointId}",method = RequestMethod.PUT)
    public Msg updateSetion(@Valid @RequestBody KnowledgPoint knowledgPoint, BindingResult bindingResult, @PathVariable("konwledgPointId") String konwledgPointId){
        if(knowledgPoint.getPointName()!=null && !knowledgPoint.getPointName().trim().isEmpty() &&
                knowledgPoint.getSectionId()!=null){
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
                knowledgPoint.setPointId(konwledgPointId);
                konwledgPointService.updaetKnowledgPoint(knowledgPoint);
                return Msg.success().add("msg","更新成功");
            }
        }else{
            return Msg.fail().add("msg","参数错误");
        }
    }
    /**
     * 根据知识点id获得题目
     */
    @RequestMapping(value ="konwledgPoint/{konwledgPointId}/{curPage}",method = RequestMethod.GET)
    public Msg getProblemBykonwledgPoint(@PathVariable("konwledgPointId") String konwledgPointId,
                                         @PathVariable("curPage") Integer curPage){
        PageHelper.startPage(curPage,10);
        List<Problem> problemList=konwledgPointService.getProblemBykonwledgPoint(konwledgPointId);
        PageInfo pageInfo=new PageInfo(problemList,5);
        return Msg.success().add("list",pageInfo);
    }

}
