package com.loop.web.bean;

import java.util.Date;

/**
 * Created by Intellij IDEA.
 *
 * @author: 霍运浩
 * @date: 2018-09-01
 * @time: 11:49
 */
public class Log {

    private String logsId;
    private String logRemarks;
    private  String logOperationUrl;
    private Date logTime;
    private String logOperationIp;
    private String logUsername;
    private String logsUrl;
    public String getLogsId() {
        return logsId;
    }

    public void setLogsId(String logsId) {
        this.logsId = logsId;
    }

    public String getLogRemarks() {
        return logRemarks;
    }

    public void setLogRemarks(String logRemarks) {
        this.logRemarks = logRemarks;
    }

    public String getLogOperationUrl() {
        return logOperationUrl;
    }

    public void setLogOperationUrl(String logOperationUrl) {
        this.logOperationUrl = logOperationUrl;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getLogOperationIp() {
        return logOperationIp;
    }

    public void setLogOperationIp(String logOperationIp) {
        this.logOperationIp = logOperationIp;
    }

    public String getLogUsername() {
        return logUsername;
    }

    public void setLogUsername(String logUsername) {
        this.logUsername = logUsername;
    }

    public String getLogsUrl() {
        return logsUrl;
    }

    public void setLogsUrl(String logsUrl) {
        this.logsUrl = logsUrl;
    }


}
