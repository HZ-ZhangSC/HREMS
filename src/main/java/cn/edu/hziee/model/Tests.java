package cn.edu.hziee.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * tests
 * @author 
 */
public class Tests  {
    private Integer tsId;

    private String tsName;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date tsDate;

    private String tsEp;

    private String tsClass;

    private Integer tsNum;

    private Integer tsStatus;

    public Integer getTsId() {
        return tsId;
    }

    public void setTsId(Integer tsId) {
        this.tsId = tsId;
    }

    public String getTsName() {
        return tsName;
    }

    public void setTsName(String tsName) {
        this.tsName = tsName;
    }

    public Date getTsDate() {
        return tsDate;
    }

    public void setTsDate(Date tsDate) {
        this.tsDate = tsDate;
    }

    public String getTsEp() {
        return tsEp;
    }

    public void setTsEp(String tsEp) {
        this.tsEp = tsEp;
    }

    public String getTsClass() {
        return tsClass;
    }

    public void setTsClass(String tsClass) {
        this.tsClass = tsClass;
    }

    public Integer getTsNum() {
        return tsNum;
    }

    public void setTsNum(Integer tsNum) {
        this.tsNum = tsNum;
    }

    public Integer getTsStatus() {
        return tsStatus;
    }

    public void setTsStatus(Integer tsStatus) {
        this.tsStatus = tsStatus;
    }

	@Override
	public String toString() {
		return "{\"tsId\":\"" + tsId + "\", \"tsName\":\"" + tsName + "\", \"tsDate\":\"" + tsDate + "\", \"tsEp\":\""
				+ tsEp + "\", \"tsClass\":\"" + tsClass + "\", \"tsNum\":\"" + tsNum + "\", \"tsStatus\":\"" + tsStatus
				+ "\"}\n";
	}
}