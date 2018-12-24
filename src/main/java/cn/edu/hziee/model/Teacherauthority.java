package cn.edu.hziee.model;

/**
 * teacherauthority
 * @author 
 */
public class Teacherauthority {
    private Integer taLevel;

    private String taContent;

    public Integer getTaLevel() {
        return taLevel;
    }

    public void setTaLevel(Integer taLevel) {
        this.taLevel = taLevel;
    }

    public String getTaContent() {
        return taContent;
    }

    public void setTaContent(String taContent) {
        this.taContent = taContent;
    }

	@Override
	public String toString() {
		return "{\"taLevel\":\"" + taLevel + "\", \"taContent\":\"" + taContent + "\"}\n";
	}

}