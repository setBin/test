package com.loop.web.service;

import com.loop.web.bean.Section;
import com.loop.web.dao.SectionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hyh
 * Date: 2018/7/31
 */
@Service
public class SectionService {

    @Autowired
    SectionDao sectionDao;
    public List<HashMap<String,Object>> getAllSection() {
        return sectionDao.getAllSection();
    }

    public void addSection(Section section) {
        sectionDao.addSection(section);
    }

    public void updaetSection(Section section) {
        sectionDao.updaetSection(section);
    }

    public Section getSectionInfoById(String sectionId) {

          return sectionDao.getSectionInfoById(sectionId);
    }

    public List<Section> getAllKonwledPointBysectionId(String sectionId) {
        return  sectionDao.getAllKonwledPointBysectionId(sectionId);
    }
}
