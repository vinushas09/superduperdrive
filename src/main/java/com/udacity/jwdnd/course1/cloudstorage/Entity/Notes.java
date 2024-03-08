package com.udacity.jwdnd.course1.cloudstorage.Entity;

public class Notes {

    private Integer noteid; //PK
    private String notetitle;
    private String notedescription;
    private Integer userid; //FK

    public Notes(Integer noteid, String notetitle, String notedescription){
        this.noteid = noteid;
        this.notetitle = notetitle;
        this.notedescription = notedescription;
    }
    public Notes(Integer noteid, String notetitle, String notedescription, Integer userid) {
        this.noteid = noteid;
        this.notetitle = notetitle;
        this.notedescription = notedescription;
        this.userid = userid;
    }

    public Integer getNoteid() {
        return noteid;
    }

    public void setNoteid(int noteid) {
        this.noteid = noteid;
    }

    public String getNotetitle() {
        return notetitle;
    }

    public void setNotetitle(String notetitle) {
        this.notetitle = notetitle;
    }

    public String getNotedescription() {
        return notedescription;
    }

    public void setNotedescription(String notedescription) {
        this.notedescription = notedescription;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
