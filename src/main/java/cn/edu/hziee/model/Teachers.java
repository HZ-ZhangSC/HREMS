package cn.edu.hziee.model;

/**
 * teachers
 * @author 
 */
public class Teachers  {
    private Integer tId;

    private String tPwd;

    private String tName;

    private String tSub;

    private Integer tRt;

    private Integer tPid;

    private String tSch;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String gettPwd() {
        return tPwd;
    }

    public void settPwd(String tPwd) {
        this.tPwd = tPwd;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettSub() {
        return tSub;
    }

    public void settSub(String tSub) {
        this.tSub = tSub;
    }

    public Integer gettRt() {
        return tRt;
    }

    public void settRt(Integer tRt) {
        this.tRt = tRt;
    }

    public Integer gettPid() {
        return tPid;
    }

    public void settPid(Integer tPid) {
        this.tPid = tPid;
    }

    public String gettSch() {
        return tSch;
    }

    public void settSch(String tSch) {
        this.tSch = tSch;
    }

	@Override
	public String toString() {
		return "{\"tId\":\"" + tId + "\", \"tPwd\":\"" + tPwd + "\", \"tName\":\"" + tName + "\", \"tSub\":\"" + tSub
				+ "\", \"tRt\":\"" + tRt + "\", \"tPid\":\"" + tPid + "\", \"tSch\":\"" + tSch + "\"}\n";
	}

    
}