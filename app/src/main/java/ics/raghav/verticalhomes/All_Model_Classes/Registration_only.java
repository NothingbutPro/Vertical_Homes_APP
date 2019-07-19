package ics.raghav.verticalhomes.All_Model_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Registration_only {

    @SerializedName("responce")
    @Expose
    private Integer responce;
    @SerializedName("massage")
    @Expose
    private String massage;

    public Integer getResponce() {
        return responce;
    }

    public void setResponce(Integer responce) {
        this.responce = responce;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }


}
