package com.loop.web.dao;

import com.loop.web.bean.Ann;

import java.util.List;

/**
 * Created by Intellij IDEA.
 *
 * @author: 霍运浩
 * @date: 2018-09-01
 * @time: 11:01
 */
public interface AnnDao {

    List<Ann> getAllKonwledPoint();

    void addAnn(Ann ann);

    void updateAnn(Ann ann);

    void deleteAnn(String id);

    Ann getAnnById(String id);
}
