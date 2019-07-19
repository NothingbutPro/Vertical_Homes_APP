package ics.raghav.verticalhomes.All_Model_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Bricks_List_Model {


    @SerializedName("data")
    @Expose
    private List<Bricks_Model_Data> data = null;
    @SerializedName("response")
    @Expose
    private Boolean response;

    public List<Bricks_Model_Data> getData() {
        return data;
    }

    public void setData(List<Bricks_Model_Data> data) {
        this.data = data;
    }

    public Boolean getResponse() {
        return response;
    }

    public void setResponse(Boolean response) {
        this.response = response;
    }
}
