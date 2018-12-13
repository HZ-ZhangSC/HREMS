package cn.edu.hziee.utils;

public class ResultData<T> {
    /**
     * 结果状态
     */
    private boolean status;
    /**
     * 结果数据信息
     */
    private T data;
    /**
     * 结果提示信息
     */
    private String msg;


    public ResultData() {
        super();
    }
    public ResultData(boolean status, T data, String msg) {
        super();
        this.status = status;
        this.data = data;
        this.msg = msg;
    }
    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
    /**
     * @return the data
     */
    public T getData() {
        return data;
    }
    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }
    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }
    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

   
    @Override
    public String toString() {
        return "{"+"\""+"status"+"\""+":" + status + ", "+"\""+"data"+"\""+":" + data + ","+"\""+ "msg"+"\"" +":" +"\""+ msg +"\"" + "}";
    }
}
