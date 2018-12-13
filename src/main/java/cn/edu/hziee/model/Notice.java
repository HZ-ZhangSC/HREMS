package cn.edu.hziee.model;

import java.io.Serializable;
import java.util.Date;

/**
 * notice
 * @author 
 */
public class Notice {
    private Integer noId;

    private String noTitle;

    private String noContent;

    private Date noDate;

    private String tname;

    private static final long serialVersionUID = 1L;

    public Integer getNoId() {
        return noId;
    }

    public void setNoId(Integer noId) {
        this.noId = noId;
    }

    public String getNoTitle() {
        return noTitle;
    }

    public void setNoTitle(String noTitle) {
        this.noTitle = noTitle;
    }

    public String getNoContent() {
        return noContent;
    }

    public void setNoContent(String noContent) {
        this.noContent = noContent;
    }

    public Date getNoDate() {
        return noDate;
    }

    public void setNoDate(Date noDate) {
        this.noDate = noDate;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

	@Override
	public String toString() {
		return "{\"noId\":\"" + noId + "\", \"noTitle\":\"" + noTitle + "\", \"noContent\":\"" + noContent
				+ "\", \"noDate\":\"" + noDate + "\", \"tname\":\"" + tname + "\"}\n";
	}

   
}