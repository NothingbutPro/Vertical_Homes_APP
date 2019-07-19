package ics.raghav.verticalhomes.LoginAndReg;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import ics.raghav.verticalhomes.All_Model_Classes.Otp_only;
import ics.raghav.verticalhomes.All_Model_Classes.Registration_only;
import ics.raghav.verticalhomes.ApiAndParameter.Api_parameter;
import ics.raghav.verticalhomes.ApiAndParameter.BaseUrl;
import ics.raghav.verticalhomes.R;
import ics.raghav.verticalhomes.SiteSupervisior_Dashboard.Site_Supervisor_Dashboard;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Otp_Activity extends AppCompatActivity {

    EditText inputOtp;
    Button btn_verify_otp;
    String Otp,fullname,mobile,email,password,designation;
     ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_);

        inputOtp=findViewById(R.id.inputOtp);
        btn_verify_otp=findViewById(R.id.btn_verify_otp);

        try {
            Otp= getIntent().getStringExtra("otp");
            fullname= getIntent().getStringExtra("fullname");
            email= getIntent().getStringExtra("email");
            mobile= getIntent().getStringExtra("mobile");
            password= getIntent().getStringExtra("password");
            designation= getIntent().getStringExtra("designation");

            Log.e("OTP_intent",Otp);
            Log.e("fullname_intent",fullname);
            inputOtp.setText(Otp);

        }catch (Exception e){
            Log.e("otp_error",""+e.getMessage());
        }

        btn_verify_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                OtpVerify(Otp,fullname,email,mobile,password,designation);
                
            }
        });

    }

    private void OtpVerify(String otp, String fullname, String email, String mobile, String password, String designation) {

        progressDialog = new ProgressDialog(Otp_Activity.this);
        progressDialog.setTitle("processing please wait");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS).build();
        Retrofit RetroLogin = new Retrofit.Builder()
                .baseUrl(BaseUrl.The_Base).client(client).addConverterFactory(GsonConverterFactory.create())
                .build();
        Api_parameter AbloutApi = RetroLogin.create(Api_parameter.class);
        Call<Otp_only> get_aboutCall = AbloutApi.REGISTRATION_OTP_CALL(otp,fullname ,email,mobile,
                password,designation);
        get_aboutCall.enqueue(new Callback<Otp_only>() {
            @Override
            public void onResponse(Call<Otp_only> call, Response<Otp_only> response) {
                progressDialog.dismiss();
                Log.e("responce message is", "" + response.body().getResponce());

                Toast.makeText(Otp_Activity.this, "Successful", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(Otp_Activity.this, Site_Supervisor_Dashboard.class);
                startActivity(intent);

//                if (response.body().getResponce().booleanValue() == true) {
//                   // sessionManager.serverEmailLogin(Integer.valueOf(response.body().getMassage().getId()));
//                   // Shared_Preference.setId(Registration_Step_1.this,response.body().getMassage().getId());
//
////                   Intent intent=new Intent(Registration_Activity.this, Otp_Activity.class);
//                startActivity(intent);
//
//                    finish();
//                    Toast.makeText(Registration_Activity.this, "Successful", Toast.LENGTH_SHORT).show();
//                }

            }

            @Override
            public void onFailure(Call<Otp_only> call, Throwable t) {
                progressDialog.dismiss();
                Log.e("Failer",""+t.getMessage());
                Log.e("Failer",""+t.getLocalizedMessage());
                Log.e("Failer",""+t.getCause());
//                Toast.makeText(getActivity(), "" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(getActivity(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });








    }
}
