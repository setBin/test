package com.loop.web.dao;


import com.loop.web.bean.Log;

import java.util.List;

/**
 * Created by Intellij IDEA.
 *
 * @author: 霍运浩
 * @date: 2018-09-01
 * @time: 11:42
 */
public interface LogDao {
    List<Log> getAllLog();

    void addLog(com.loop.web.bean.Log log);
}
