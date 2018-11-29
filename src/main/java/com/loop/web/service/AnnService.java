package com.loop.web.service;

import com.loop.web.bean.Ann;
import com.loop.web.dao.AnnDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Intellij IDEA.
 *
 * @author: 霍运浩
 * @date: 2018-09-01
 * @time: 10:54
 */
@Service
public class AnnService {

    @Autowired
    AnnDao annDao;
    public List<Ann> getAllKonwledPoint() {

        return annDao.getAllKonwledPoint();
    }

    public void addAnn(Ann ann) {
        annDao.addAnn(ann);
    }

    public void updateAnn(Ann ann) {

        annDao.updateAnn(ann);
    }

    public void deleteAnn(String id) {
        annDao.deleteAnn(id);
    }

    public Ann getAnnById(String id) {

        return annDao.getAnnById(id);
    }
}
