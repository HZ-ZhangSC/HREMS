package cn.edu.hziee.model;

import java.util.Date;

/**
 * notice
 * @author 
 */
public class Notice  {
    private Integer noId;

    private String noTitle;

    private String noContent;
    
    private String noName;

	private Date noDate;


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
    public String getNoName() {
		return noName;
	}
	public void setNoName(String noName) {
		this.noName = noName;
	}

	@Override
	public String toString() {
		return "{\"noId\":\"" + noId + "\", \"noTitle\":\"" + noTitle + "\", \"noContent\":\"" + noContent
				+ "\", \"noDate\":\"" + noDate + "\",\"noName\":\"" + noName + "\"}\n";
	}

    
}