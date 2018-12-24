package cn.edu.hziee.model;

import java.util.Date;

/**
 * journal
 * @author 
 */
public class Journal {
    private Integer jId;

    private String jUser;

    private String jMsg;

    private Date jDate;
    
    public Integer getjId() {
        return jId;
    }

    public void setjId(Integer jId) {
        this.jId = jId;
    }

    public String getjUser() {
        return jUser;
    }

    public void setjUser(String jUser) {
        this.jUser = jUser;
    }

    public String getjMsg() {
        return jMsg;
    }

    public void setjMsg(String jMsg) {
        this.jMsg = jMsg;
    }

    public Date getjDate() {
        return jDate;
    }

    public void setjDate(Date jDate) {
        this.jDate = jDate;
    }

	@Override
	public String toString() {
		return "{\"jId\":\"" + jId + "\", \"jUser\":\"" + jUser + "\", \"jMsg\":\"" + jMsg + "\", \"jDate\":\"" + jDate
				+ "\"}\n";
	}

   
}