package ics.raghav.verticalhomes.ApiAndParameter;

import ics.raghav.verticalhomes.All_Model_Classes.Bricks_Form_Responce;
import ics.raghav.verticalhomes.All_Model_Classes.Bricks_List_Model;
import ics.raghav.verticalhomes.All_Model_Classes.Destination_Model;
import ics.raghav.verticalhomes.All_Model_Classes.Login_Responce;
import ics.raghav.verticalhomes.All_Model_Classes.Otp_only;
import ics.raghav.verticalhomes.All_Model_Classes.Registration_only;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api_parameter {

    @FormUrlEncoded
    @POST(BaseUrl.Login)
    Call<Login_Responce> Login_Call_Api(
            @Field("contact") String type_of_user,
            @Field("password") String service

    );

    @GET(BaseUrl.Get_designation)
    Call<Destination_Model> Get_Destination_Call();


    @FormUrlEncoded
    @POST(BaseUrl.Registration)
    Call<Registration_only> REGISTRATION_ONLY_CALL(
                     @Field("fullname") String et_fullname,
                     @Field("email") String et_email,
                     @Field("contact") String et_mobile,
                     @Field("password") String et_password,
                     @Field("designation") String desti_id

    );

    @FormUrlEncoded
    @POST(BaseUrl.OtpMatch)
    Call<Otp_only> REGISTRATION_OTP_CALL(
            @Field("otp") String otp,
            @Field("fullname") String fullname,
            @Field("email") String email,
            @Field("contact") String mobile,
            @Field("password") String password,
            @Field("designation") String designation
    );

    @FormUrlEncoded
    @POST(BaseUrl.sit_supervisor_bricks)
    Call<Bricks_Form_Responce> Bricks_form_Call_Api(

                                                    @Field("admin_id") String user_id,
                                                    @Field("date") String date,
                                                    @Field("inward_time") String inward_time,
                                                    @Field("outward_time") String outward_time,
                                                    @Field("lorry_no") String lorry_no,
                                                    @Field("chalan_no") String chalan_no,
                                                     @Field("party_name") String party_name,
                                                    @Field("quantity") String quantity,
                                                    @Field("amount") String amount,
                                                    @Field("rate") String rate,
                                                    @Field("gst") String gst,
                                                    @Field("gross_amount") String gross_amount,
                                                    @Field("remark") String reamark,
                                                    @Field("attachment") String attachment

    );

    @FormUrlEncoded
    @POST(BaseUrl.sit_supervisor_cement)
    Call<Bricks_Form_Responce> Cement_form_Call_Api(

            @Field("admin_id") String user_id,
            @Field("date") String date,
            @Field("inward_time") String inward_time,
            @Field("outward_time") String outward_time,
            @Field("lorry_no") String lorry_no,
            @Field("chalan_no") String chalan_no,
            @Field("party_name") String party_name,
            @Field("quantity") String quantity,
            @Field("amount") String amount,
            @Field("rate") String rate,
            @Field("gst") String gst,
            @Field("gross_amount") String gross_amount,
            @Field("remark") String reamark,
            @Field("attachment") String attachment

    );

    //Call<Bricks_Form_Responce> Sanetory_form_Call_Api(String user_id, String date, String inward_time, String outward_time, String lorry_no, String chalan_no, String party_name, String quantity, String amount, String rate, String gst, String gross_amount, String reamark, String attachment, String item);

    @FormUrlEncoded
    @POST(BaseUrl.sit_supervisor_sanitary_raw)
    Call<Bricks_Form_Responce> Sanetory_form_Call_Api(

            @Field("admin_id") String user_id,
            @Field("date") String date,
            @Field("inward_time") String inward_time,
            @Field("outward_time") String outward_time,
            @Field("lorry_no") String lorry_no,
            @Field("chalan_no") String chalan_no,
            @Field("party_name") String party_name,
            @Field("quantity") String quantity,
            @Field("amount") String amount,
            @Field("rate") String rate,
            @Field("gst") String gst,
            @Field("gross_amount") String gross_amount,
            @Field("remark") String reamark,
            @Field("attachment") String attachment,
            @Field("item") String item

    );

    @FormUrlEncoded
    @POST(BaseUrl.sit_supervisor_sanitory_finished)
    Call<Bricks_Form_Responce> Sanetory_Finished_form_Call_Api(
            @Field("admin_id") String user_id,
            @Field("date") String date,
            @Field("inward_time") String inward_time,
            @Field("outward_time") String outward_time,
            @Field("lorry_no") String lorry_no,
            @Field("chalan_no") String chalan_no,
            @Field("party_name") String party_name,
            @Field("quantity") String quantity,
            @Field("amount") String amount,
            @Field("rate") String rate,
            @Field("gst") String gst,
            @Field("gross_amount") String gross_amount,
            @Field("remark") String reamark,
            @Field("attachment") String attachment,
            @Field("item") String item

    );
    @FormUrlEncoded
    @POST(BaseUrl.sit_supervisor_saria)
    Call<Bricks_Form_Responce> Sariya_form_Call_Api(
            @Field("admin_id") String user_id,
            @Field("date") String date,
            @Field("inward_time") String inward_time,
            @Field("outward_time") String outward_time,
            @Field("lorry_no") String lorry_no,
            @Field("chalan_no") String chalan_no,
            @Field("party_name") String party_name,
            @Field("quantity") String quantity,
            @Field("amount") String amount,
            @Field("rate") String rate,
            @Field("gst") String gst,
            @Field("gross_amount") String gross_amount,
            @Field("remark") String reamark,
            @Field("attachment") String attachment,
            @Field("item") String item
    );

    @FormUrlEncoded
    @POST(BaseUrl.sit_supervisor_reti)
    Call<Bricks_Form_Responce> Reti_form_Call_Api(

             @Field("admin_id") String user_id,
            @Field("date") String date,
            @Field("inward_time") String inward_time,
            @Field("outward_time") String outward_time,
            @Field("lorry_no") String lorry_no,
            @Field("chalan_no") String chalan_no,
            @Field("party_name") String party_name,
            @Field("quantity") String quantity,
            @Field("amount") String amount,
            @Field("rate") String rate,
            @Field("gst") String gst,
            @Field("gross_amount") String gross_amount,
            @Field("remark") String reamark,
            @Field("attachment") String attachment,
            @Field("height") String height,
            @Field("breadth") String bridth,
            @Field("length") String length
    );

    @FormUrlEncoded
    @POST(BaseUrl.sit_supervisor_mix_sundry)
    Call<Bricks_Form_Responce> Mix_Sundry_form_Call_Api(
            @Field("admin_id") String user_id,
            @Field("date") String date,
            @Field("inward_time") String inward_time,
            @Field("outward_time") String outward_time,
            @Field("lorry_no") String lorry_no,
            @Field("chalan_no") String chalan_no,
            @Field("party_name") String party_name,
            @Field("quantity") String quantity,
            @Field("amount") String amount,
            @Field("rate") String rate,
            @Field("gst") String gst,
            @Field("gross_amount") String gross_amount,
            @Field("remark") String reamark,
            @Field("attachment") String attachment,
            @Field("item") String item

    );

    @FormUrlEncoded
    @POST(BaseUrl.sit_supervisor_gitti)
    Call<Bricks_Form_Responce> Gitty_form_Call_Api(
            @Field("admin_id") String user_id,
            @Field("date") String date,
            @Field("inward_time") String inward_time,
            @Field("outward_time") String outward_time,
            @Field("lorry_no") String lorry_no,
            @Field("chalan_no") String chalan_no,
            @Field("party_name") String party_name,
            @Field("quantity") String quantity,
            @Field("amount") String amount,
            @Field("rate") String rate,
            @Field("gst") String gst,
            @Field("gross_amount") String gross_amount,
            @Field("remark") String reamark,
            @Field("attachment") String attachment,
            @Field("height") String height,
            @Field("breadth") String bridth,
            @Field("length") String length

    );

    @FormUrlEncoded
    @POST(BaseUrl.sit_supervisor_electricfinish)
    Call<Bricks_Form_Responce> Electric_Finish_form_Call_Api(
            @Field("admin_id") String user_id,
            @Field("date") String date,
            @Field("inward_time") String inward_time,
            @Field("outward_time") String outward_time,
            @Field("lorry_no") String lorry_no,
            @Field("chalan_no") String chalan_no,
            @Field("party_name") String party_name,
            @Field("quantity") String quantity,
            @Field("amount") String amount,
            @Field("rate") String rate,
            @Field("gst") String gst,
            @Field("gross_amount") String gross_amount,
            @Field("remark") String reamark,
            @Field("attachment") String attachment,
            @Field("item") String item


    );
    @FormUrlEncoded
    @POST(BaseUrl.sit_supervisor_electric_raw)
    Call<Bricks_Form_Responce> Electric_Raw_form_Call_Api(
            @Field("admin_id") String user_id,
            @Field("date") String date,
            @Field("inward_time") String inward_time,
            @Field("outward_time") String outward_time,
            @Field("lorry_no") String lorry_no,
            @Field("chalan_no") String chalan_no,
            @Field("party_name") String party_name,
            @Field("quantity") String quantity,
            @Field("amount") String amount,
            @Field("rate") String rate,
            @Field("gst") String gst,
            @Field("gross_amount") String gross_amount,
            @Field("remark") String reamark,
            @Field("attachment") String attachment,
            @Field("item") String item

    );



    @GET(BaseUrl.sit_supervisor_bricks_list)
    Call<Bricks_List_Model> Get_Bricks_List_Call();
}
