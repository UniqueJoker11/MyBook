package colin.profile.opensource.system.bean;

/**
 * Created by DELL on 2015/11/12.
 * 共通的返回Bean
 */
public class ResultCommonBean {
    private boolean isSuccess;
    private String infoMsg;
    private Object data;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getInfoMsg() {
        return infoMsg;
    }

    public void setInfoMsg(String infoMsg) {
        this.infoMsg = infoMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
