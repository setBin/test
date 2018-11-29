package com.loop.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.loop.web.bean.Ann;
import com.loop.web.service.AnnService;
import com.loop.web.utils.CommonHelper;
import com.loop.web.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Intellij IDEA.
 *
 * @author: 霍运浩
 * @date: 2018-08-31
 * @time: 23:55
 */
@RestController
@RequestMapping("")
public class AnnController {

    @Autowired
    AnnService annService;

    /**
     * 分页查询所有公告
     * @param curPage
     * @param pageSize
     * @param navigatePages
     * @return
     */
    @RequestMapping(value = "/ann{curPage}/{pageSize}/{navigatePages}",method = RequestMethod.GET)
    public Msg getAllAnn(@PathVariable(value = "curPage") Integer curPage,
                         @PathVariable(value = "pageSize") Integer pageSize,
                         @PathVariable(value = "navigatePages") Integer navigatePages){

        PageHelper.startPage(curPage,pageSize);
        List<Ann> knowledgPointList=annService.getAllKonwledPoint();
        PageInfo pageInfo=new PageInfo(knowledgPointList,navigatePages);
        return Msg.success().add("msg",pageInfo);
    }

    /**
     * 添加公告
     * @param ann
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "ann",method = RequestMethod.POST)
    public Msg addAnn(@RequestBody @Valid Ann ann, BindingResult bindingResult)
    {

        if(ann.getAnnonucementName()!=null&& ann.getAnnnonucementContents()!=null) {
            if (bindingResult.hasErrors()) {
                Map<String, Object> map = new HashMap<String, Object>();
                List<FieldError> errors = bindingResult.getFieldErrors();
                for (FieldError fieldError : errors) {
                    System.out.println("错误的字段名：" + fieldError.getField());
                    System.out.println("错误信息：" + fieldError.getDefaultMessage());
                    map.put(fieldError.getField(), fieldError.getDefaultMessage());
                }
                return Msg.fail().add("msg", map);
            }
            ann.setAnnoncementCreatBy("admin");
            ann.setAnnouncemnetTime(new Date());
            ann.setAnnouncementId(CommonHelper.getId());
            annService.addAnn(ann);
            return Msg.success().add("msg","添加成功");
        }
        return Msg.fail().add("msg","参数错误");

    }

    /**
     * 更新公告通过公告的id
     * @param ann
     * @param bindingResult
     * @param id
     * @return
     */
    @RequestMapping(value = "ann/{id}",method = RequestMethod.PUT)
    public Msg updateAnn(@RequestBody @Valid Ann ann, BindingResult bindingResult,@PathVariable("id") String id)
    {

        if(ann.getAnnonucementName()!=null&& ann.getAnnnonucementContents()!=null) {
            if (bindingResult.hasErrors()) {
                Map<String, Object> map = new HashMap<String, Object>();
                List<FieldError> errors = bindingResult.getFieldErrors();
                for (FieldError fieldError : errors) {
                    System.out.println("错误的字段名：" + fieldError.getField());
                    System.out.println("错误信息：" + fieldError.getDefaultMessage());
                    map.put(fieldError.getField(), fieldError.getDefaultMessage());
                }
                return Msg.fail().add("msg", map);
            }
            ann.setAnnoncementCreatBy("admin");
            ann.setAnnouncemnetTime(new Date());
            ann.setAnnouncementId(id);
            annService.updateAnn(ann);
            return Msg.success().add("msg","更新成功");
        }
        return Msg.fail().add("msg","参数错误");
    }

    /**
     * 通过公告的id删除公告
     * @param id
     * @return
     */
    @RequestMapping(value = "ann/{id}",method = RequestMethod.DELETE)
    public Msg deleteAnn(@PathVariable("id") String id) {
        if(id!=null &&!id.trim().isEmpty()){
            annService.deleteAnn(id);
            return  Msg.success().add("msg","删除成功");
        }
        return Msg.fail().add("msg","参数错误");
    }

    /**
     * 通过id查询用公告详情
     * @param id
     * @return
     */
    @RequestMapping(value = "ann/{id}",method = RequestMethod.GET)
    public Msg getAnnById(@PathVariable("id") String id) {
        if(id!=null &&!id.trim().isEmpty()){
            Ann ann=annService.getAnnById(id);
            return Msg.success().add("msg",ann);
        }
        return Msg.fail().add("msg","参数错误");
    }

}
