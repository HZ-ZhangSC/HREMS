package cn.edu.hziee.model;

/**
 * manager
 * @author 
 */
public class Manager  {
    private Integer mId;

    private Integer mZid;

    private String mName;

    private String mPwd;


    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public Integer getmZid() {
        return mZid;
    }

    public void setmZid(Integer mZid) {
        this.mZid = mZid;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPwd() {
        return mPwd;
    }

    public void setmPwd(String mPwd) {
        this.mPwd = mPwd;
    }

	@Override
	public String toString() {
		return "{\"mId\":\"" + mId + "\", \"mZid\":\"" + mZid + "\", \"mName\":\"" + mName + "\", \"mPwd\":\"" + mPwd
				+ "\"}\n";
	}

   
}