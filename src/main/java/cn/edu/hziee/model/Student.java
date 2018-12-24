package cn.edu.hziee.model;

/**
 * student
 * @author 
 */
public class Student {
    private Integer sId;

    private String sSch;

    private String sName;

    private String sMajor;

    private String sPid;

    private String sPwd;

    private String sClass;



    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsSch() {
        return sSch;
    }

    public void setsSch(String sSch) {
        this.sSch = sSch;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsMajor() {
        return sMajor;
    }

    public void setsMajor(String sMajor) {
        this.sMajor = sMajor;
    }

    public String getsPid() {
        return sPid;
    }

    public void setsPid(String sPid) {
        this.sPid = sPid;
    }

    public String getsPwd() {
        return sPwd;
    }

    public void setsPwd(String sPwd) {
        this.sPwd = sPwd;
    }

    public String getsClass() {
        return sClass;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass;
    }


	@Override
	public String toString() {
		return "{\"sId\":\"" + sId + "\", \"sSch\":\"" + sSch + "\", \"sName\":\"" + sName + "\", \"sMajor\":\""
				+ sMajor + "\", \"sPid\":\"" + sPid + "\", \"sPwd\":\"" + sPwd + "\", \"sClass\":\"" + sClass + "\"}\n";
	} 
}