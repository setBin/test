package com.loop.web.dao;

import com.loop.web.bean.KnowledgPoint;
import com.loop.web.bean.Problem;

import java.util.HashMap;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hyh
 * Date: 2018/7/31
 */
public interface KnowledgPointDao {
    List<HashMap<String,Object>> getAllKonwledPoint();
    List<KnowledgPoint> getAllKonwledPointBysectionId(String sectionId);

    void addkonwledgPoint(KnowledgPoint knowledgPoint);


    void updaetKnowledgPoint(KnowledgPoint knowledgPoint);

    List<Problem> getProblemBykonwledgPoint(String konwledgPointId);
}
