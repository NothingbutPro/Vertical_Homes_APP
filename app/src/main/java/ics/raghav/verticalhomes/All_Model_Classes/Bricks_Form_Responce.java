package ics.raghav.verticalhomes.All_Model_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Bricks_Form_Responce {

    @SerializedName("data")
    @Expose
    private List<Bricks_Form_Responce_data> data = null;
    @SerializedName("responce")
    @Expose
    private Boolean responce;

    public List<Bricks_Form_Responce_data> getData() {
        return data;
    }

    public void setData(List<Bricks_Form_Responce_data> data) {
        this.data = data;
    }

    public Boolean getResponce() {
        return responce;
    }

    public void setResponce(Boolean responce) {
        this.responce = responce;
    }
}
