package ics.raghav.verticalhomes.All_Model_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Userdatum {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("designation_name")
    @Expose
    private String designation;
    @SerializedName("status")
    @Expose
    private String status;

    public Userdatum(String des_id, String des_name) {
        this.designation=des_name;
        this.id=des_id;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
