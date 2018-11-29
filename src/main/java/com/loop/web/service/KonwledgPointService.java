package com.loop.web.service;

import com.loop.web.bean.KnowledgPoint;
import com.loop.web.bean.Problem;
import com.loop.web.dao.KnowledgPointDao;
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
public class KonwledgPointService {
    @Autowired
    KnowledgPointDao knowledgPointDao;
    public List<KnowledgPoint> getAllKonwledPointBysectionId(String sectionId) {
        return knowledgPointDao.getAllKonwledPointBysectionId(sectionId);
    }
    public List<HashMap<String, Object>> getAllKonwledPoint() {
        return knowledgPointDao.getAllKonwledPoint();
    }

    public void addkonwledgPoint(KnowledgPoint knowledgPoint) {
        knowledgPointDao.addkonwledgPoint(knowledgPoint);
    }

    public void updaetKnowledgPoint(KnowledgPoint knowledgPoint) {
        knowledgPointDao.updaetKnowledgPoint(knowledgPoint);
    }

    public List<Problem> getProblemBykonwledgPoint(String konwledgPointId) {
        return knowledgPointDao.getProblemBykonwledgPoint(konwledgPointId);
    }
}
