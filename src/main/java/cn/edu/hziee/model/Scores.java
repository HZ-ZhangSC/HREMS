package cn.edu.hziee.model;

import java.io.Serializable;
import java.util.Date;

/**
 * scores
 * @author 
 */
public class Scores {
    private Integer scId;

    private String scSname;

    private Integer scEid;

    private Integer scTid;

    private String scName;

    private String scCs;

    private String scSc;

    private Integer scSid;

    private Date scDate;


    public Integer getScId() {
        return scId;
    }

    public void setScId(Integer scId) {
        this.scId = scId;
    }

    public String getScSname() {
        return scSname;
    }

    public void setScSname(String scSname) {
        this.scSname = scSname;
    }

    public Integer getScEid() {
        return scEid;
    }

    public void setScEid(Integer scEid) {
        this.scEid = scEid;
    }

    public Integer getScTid() {
        return scTid;
    }

    public void setScTid(Integer scTid) {
        this.scTid = scTid;
    }

    public String getScName() {
        return scName;
    }

    public void setScName(String scName) {
        this.scName = scName;
    }

    public String getScCs() {
        return scCs;
    }

    public void setScCs(String scCs) {
        this.scCs = scCs;
    }

    public String getScSc() {
        return scSc;
    }

    public void setScSc(String scSc) {
        this.scSc = scSc;
    }

    public Integer getScSid() {
        return scSid;
    }

    public void setScSid(Integer scSid) {
        this.scSid = scSid;
    }

    public Date getScDate() {
        return scDate;
    }

    public void setScDate(Date scDate) {
        this.scDate = scDate;
    }
    
    @Override
	public String toString() {
		return "{\"scId\":\"" + scId + "\", \"scSname\":\"" + scSname + "\", \"scEid\":\"" + scEid + "\", \"scTid\":\""
				+ scTid + "\", \"scName\":\"" + scName + "\", \"scCs\":\"" + scCs + "\", \"scSc\":\"" + scSc
				+ "\", \"scSid\":\"" + scSid + "\", \"scDate\":\"" + scDate + "\"}\n";
	}
}