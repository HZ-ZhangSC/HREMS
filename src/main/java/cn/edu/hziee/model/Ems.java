package cn.edu.hziee.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * ems
 * @author 
 */
public class Ems  {
    private Integer erId;

    private Integer erTsid;

    private Integer erCp;

    private Integer erNum;
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date erTime;

    private String erName;


    public Integer getErId() {
        return erId;
    }

    public void setErId(Integer erId) {
        this.erId = erId;
    }

    public Integer getErTsid() {
        return erTsid;
    }

    public void setErTsid(Integer erTsid) {
        this.erTsid = erTsid;
    }

    public Integer getErCp() {
        return erCp;
    }

    public void setErCp(Integer erCp) {
        this.erCp = erCp;
    }

    public Integer getErNum() {
        return erNum;
    }

    public void setErNum(Integer erNum) {
        this.erNum = erNum;
    }

    public Date getErTime() {
        return erTime;
    }

    public void setErTime(Date erTime) {
        this.erTime = erTime;
    }

    public String getErName() {
        return erName;
    }

    public void setErName(String erName) {
        this.erName = erName;
    }

	@Override
	public String toString() {
		return "{\"erId\":\"" + erId + "\", \"erTsid\":\"" + erTsid + "\", \"erCp\":\"" + erCp + "\", \"erNum\":\""
				+ erNum + "\", \"erTime\":\"" + erTime + "\", \"erName\":\"" + erName + "\"}\n";
	}


}