package cn.edu.hziee.model;

import java.util.Date;

/**
 * examinees
 * @author 
 */
public class Examinees {
    private Integer eEid;

    private String eName;

    private Integer eSid;

    private Integer eTid;

    private String eTnm;

    private String eClass;

    private String ePlace;

    private Date eTime;

    public Integer geteEid() {
        return eEid;
    }

    public void seteEid(Integer eEid) {
        this.eEid = eEid;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public Integer geteSid() {
        return eSid;
    }

    public void seteSid(Integer eSid) {
        this.eSid = eSid;
    }

    public Integer geteTid() {
        return eTid;
    }

    public void seteTid(Integer eTid) {
        this.eTid = eTid;
    }

    public String geteTnm() {
        return eTnm;
    }

    public void seteTnm(String eTnm) {
        this.eTnm = eTnm;
    }

    public String geteClass() {
        return eClass;
    }

    public void seteClass(String eClass) {
        this.eClass = eClass;
    }

    public String getePlace() {
        return ePlace;
    }

    public void setePlace(String ePlace) {
        this.ePlace = ePlace;
    }

    public Date geteTime() {
        return eTime;
    }

    public void seteTime(Date eTime) {
        this.eTime = eTime;
    }

    @Override
	public String toString() {
		return "{\"eEid\":\"" + eEid + "\", \"eName\":\"" + eName + "\", \"eSid\":\"" + eSid + "\", \"eTid\":\"" + eTid
				+ "\", \"eTnm\":\"" + eTnm + "\", \"eClass\":\"" + eClass + "\", \"ePlace\":\"" + ePlace
				+ "\", \"eTime\":\"" + eTime + "\"}\n";
	}
}