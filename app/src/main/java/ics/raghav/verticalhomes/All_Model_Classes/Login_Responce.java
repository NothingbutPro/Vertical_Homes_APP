package ics.raghav.verticalhomes.All_Model_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ics.raghav.verticalhomes.Login_Res_Data;

public class Login_Responce {

    @SerializedName("data")
    @Expose
    private Login_Res_Data data;
    @SerializedName("responce")
    @Expose
    private Boolean responce;

    public Login_Res_Data getData() {
        return data;
    }

    public void setData(Login_Res_Data data) {
        this.data = data;
    }

    public Boolean getResponce() {
        return responce;
    }

    public void setResponce(Boolean responce) {
        this.responce = responce;
    }
}
