package ics.raghav.verticalhomes.All_Model_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bricks_Form_Responce {

    @SerializedName("response")
    @Expose
    private Boolean response;
    @SerializedName("msg")
    @Expose
    private String msg;

    public Boolean getResponse() {
        return response;
    }

    public void setResponse(Boolean response) {
        this.response = response;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
