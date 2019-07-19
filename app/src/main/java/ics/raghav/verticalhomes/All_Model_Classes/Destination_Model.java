package ics.raghav.verticalhomes.All_Model_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Destination_Model {

    @SerializedName("response")
    @Expose
    private Boolean response;
    @SerializedName("userdata")
    @Expose
    private List<Userdatum> userdata = null;

    public Boolean getResponse() {
        return response;
    }

    public void setResponse(Boolean response) {
        this.response = response;
    }

    public List<Userdatum> getUserdata() {
        return userdata;
    }

    public void setUserdata(List<Userdatum> userdata) {
        this.userdata = userdata;
    }

}
