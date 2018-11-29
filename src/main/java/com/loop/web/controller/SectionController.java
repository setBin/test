package com.loop.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.loop.web.bean.Section;
import com.loop.web.service.SectionService;
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
@RequestMapping("")
@RestController
public class SectionController {



    @Autowired
    SectionService sectionService;

    /**
     * 获取所有章节列表
     * @param curPage
     * @param pageSize
     * @param navigatePages
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/section/{curPage}/{pageSize}/{navigatePages}",method = RequestMethod.GET)
    public Msg getAllSection(@PathVariable("curPage") Integer curPage,
                             @PathVariable("pageSize") Integer pageSize,
                             @PathVariable("navigatePages") Integer navigatePages)throws Exception{
        PageHelper.startPage(curPage,pageSize);
        List<HashMap<String,Object>> sectionList=sectionService.getAllSection();
        PageInfo pageInfo=new PageInfo(sectionList,navigatePages);
        return Msg.success().add("msg",pageInfo);
    }

    /**
     * 添加章节
     * @param section
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "section",method = RequestMethod.POST)
    public Msg addSetion(@Valid @RequestBody Section section, BindingResult bindingResult){
       if(section.getSectionName()!=null && !section.getSectionName().trim().isEmpty() &&
               section.getSectionRemark()!=null){
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
                section.setSectionId(CommonHelper.getId());
                sectionService.addSection(section);
                return Msg.success().add("msg","添加成功");
            }
        }else{
            return Msg.fail().add("msg","参数错误");
        }
    }
    /**
     * 更新章节
     * @param section
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "section/{sectionId}",method = RequestMethod.PUT)
    public Msg updateSetion(@Valid @RequestBody Section section, BindingResult bindingResult,@PathVariable("sectionId") String sectionId){
        if(section.getSectionName()!=null && !section.getSectionName().trim().isEmpty() &&
                section.getSectionRemark()!=null){
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
                section.setSectionId(sectionId);
                section.setSectionName(section.getSectionName());
                section.setSectionRemark(section.getSectionRemark());
                sectionService.updaetSection(section);
                return Msg.success().add("msg","更新成功");
            }
        }else{
            return Msg.fail().add("msg","参数错误");
        }
    }

    /**
     * 根据章节id的信息获取章节信息
     * @param sectionId
     * @return
     */
    @RequestMapping(value = "section/{sectionId}",method = RequestMethod.GET)
    public Msg getSectionInfoById(@PathVariable("sectionId") String sectionId){
        Section  section=sectionService.getSectionInfoById(sectionId);
        return Msg.success().add("msg",section);
    }
    /**
     * 获取所有知识点通过章节id
     * @param curPage
     * @param pageSize
     * @param navigatePages
     * @param sectionId
     * @return
     */
    @RequestMapping(value = "/section/{curPage}/{pageSize}/{navigatePages}/{sectionId}",method = RequestMethod.GET)
    public Msg getKonwledgPointController(@PathVariable(value = "curPage") Integer curPage,
                                          @PathVariable(value = "pageSize") Integer pageSize,
                                          @PathVariable(value = "navigatePages") Integer navigatePages,
                                          @PathVariable(value = "sectionId") String sectionId)throws Exception{
        PageHelper.startPage(curPage,pageSize);
        List<Section> sectionList=sectionService.getAllKonwledPointBysectionId(sectionId);
        PageInfo pageInfo=new PageInfo(sectionList,navigatePages);
        return Msg.success().add("msg",pageInfo);
    }


}
