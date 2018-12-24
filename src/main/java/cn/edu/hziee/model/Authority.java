package cn.edu.hziee.model;

/**
 * authority
 * @author 
 */
public class Authority  {
    private Integer auId;

    private String auName;

    private String auInfo;

    public Integer getAuId() {
        return auId;
    }

    public void setAuId(Integer auId) {
        this.auId = auId;
    }

    public String getAuName() {
        return auName;
    }

    public void setAuName(String auName) {
        this.auName = auName;
    }

    public String getAuInfo() {
        return auInfo;
    }

    public void setAuInfo(String auInfo) {
        this.auInfo = auInfo;
    }
    
	@Override
	public String toString() {
		return "{\"auId\":\"" + auId + "\", \"auName\":\"" + auName + "\", \"auInfo\":\"" + auInfo + "\"}\n";
	}

 
}