package com.loop.web.bean;

import java.util.Date;

/**
 * Created by Intellij IDEA.
 *
 * @author: 霍运浩
 * @date: 2018-09-01
 * @time: 10:58
 */
public class Ann {

    private String announcementId;

    public String getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(String announcementId) {
        this.announcementId = announcementId;
    }

    public String getAnnoncementCreatBy() {
        return annoncementCreatBy;
    }

    public void setAnnoncementCreatBy(String annoncementCreatBy) {
        this.annoncementCreatBy = annoncementCreatBy;
    }

    public String getAnnonucementName() {
        return annonucementName;
    }

    public void setAnnonucementName(String annonucementName) {
        this.annonucementName = annonucementName;
    }

    public String getAnnnonucementContents() {
        return annnonucementContents;
    }

    public void setAnnnonucementContents(String annnonucementContents) {
        this.annnonucementContents = annnonucementContents;
    }



    private String annoncementCreatBy;
    private String annonucementName;
    private String annnonucementContents;

    public Date getAnnouncemnetTime() {
        return announcemnetTime;
    }

    public void setAnnouncemnetTime(Date announcemnetTime) {
        this.announcemnetTime = announcemnetTime;
    }

    private Date announcemnetTime;
}
