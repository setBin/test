package com.loop.web.service;

import com.loop.web.bean.Log;
import com.loop.web.dao.LogDao;
import com.loop.web.utils.CommonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


/**
 * Created by Intellij IDEA.
 *
 * @author: 霍运浩
 * @date: 2018-09-01
 * @time: 11:41
 */
@Service
public class LogService {

    @Autowired
    LogDao logDao;

    public List<Log> getAllLog() {

        return logDao.getAllLog();
    }

    public void addLog(HttpServletRequest httpServletRequest) {
        Log log=new Log();
        log.setLogsId(CommonHelper.getId());
        log.setLogTime(new Date());
        log.setLogOperationIp(CommonHelper.getIpAddr1(httpServletRequest)+"|"+CommonHelper.getIpAddr1(httpServletRequest));
        log.setLogOperationUrl(httpServletRequest.getMethod()+" "+httpServletRequest.getRequestURI());
        logDao.addLog(log);

    }
}
