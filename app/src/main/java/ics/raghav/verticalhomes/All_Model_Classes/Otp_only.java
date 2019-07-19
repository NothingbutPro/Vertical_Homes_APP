package ics.raghav.verticalhomes.All_Model_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Otp_only {
    @SerializedName("data")
    @Expose
    private Object data;
    @SerializedName("responce")
    @Expose
    private Boolean responce;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Boolean getResponce() {
        return responce;
    }

    public void setResponce(Boolean responce) {
        this.responce = responce;
    }
}
