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

    private Date tsDate;

    private String tsEp;

    private String tsTid;

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

	public String getTsTid() {
		return tsTid;
	}

	public void setTsTid(String tsTid) {
		this.tsTid = tsTid;
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
				+ tsEp + "\", \"tsTid\":\"" + tsTid + "\", \"tsNum\":\"" + tsNum + "\", \"tsStatus\":\"" + tsStatus
				+ "\"}\n";
	}

    
}