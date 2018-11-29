package com.loop.web.dao;

import com.loop.web.bean.Section;

import java.util.HashMap;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hyh
 * Date: 2018/7/31
 */
public interface SectionDao {
    List<HashMap<String,Object>> getAllSection();

    void addSection(Section section);

    void updaetSection(Section section);

    Section getSectionInfoById(String sectionId);

    List<Section> getAllKonwledPointBysectionId(String sectionId);
}
