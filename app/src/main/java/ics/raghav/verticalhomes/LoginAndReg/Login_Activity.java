package ics.raghav.verticalhomes.LoginAndReg;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import ics.raghav.verticalhomes.Accountant_dashboard;
import ics.raghav.verticalhomes.All_Model_Classes.Login_Responce;
import ics.raghav.verticalhomes.ApiAndParameter.Api_parameter;
import ics.raghav.verticalhomes.ApiAndParameter.BaseUrl;
import ics.raghav.verticalhomes.BankPayment;
import ics.raghav.verticalhomes.Book_Payment_Dashboard;
import ics.raghav.verticalhomes.Booking_Activity;
import ics.raghav.verticalhomes.Booking_Dashbook;
import ics.raghav.verticalhomes.DayBookActivity;
import ics.raghav.verticalhomes.DayBook_Dashboard;
import ics.raghav.verticalhomes.R;
import ics.raghav.verticalhomes.Receipts.Receipts_Activity;
import ics.raghav.verticalhomes.SiteSupervisior_Dashboard.Site_Supervisor_Dashboard;
import ics.raghav.verticalhomes.Super_Admin_Dashboard.Super_Admin_HomePage;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login_Activity extends AppCompatActivity {

    TextView click_here;
    Button btn_login;
    EditText et_mobile,et_password;
    private ProgressDialog progressDialog;
    public static String user_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

        click_here=findViewById(R.id.click_here);
        btn_login=findViewById(R.id.btn_login);
        et_password=findViewById(R.id.et_password);
        et_mobile=findViewById(R.id.et_mobile);

        click_here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Login_Activity.this, Registration_Activity.class);
                startActivity(intent);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Mobile=et_mobile.getText().toString();
                String Password=et_password.getText().toString();
               // Intent intent=new Intent(Login_Activity.this, Site_Supervisor_Dashboard.class);
               // startActivity(intent);

                LoginExcuteTask(Mobile,Password);
            }
        });


    }

    private void LoginExcuteTask(String mobile, String password) {

        progressDialog = new ProgressDialog(this);
        progressDialog.setMax(1000);
        progressDialog.setTitle("Getting Your Data");
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100,TimeUnit.SECONDS).build();
        Retrofit RetroLogin = new Retrofit.Builder()
                .baseUrl(BaseUrl.The_Base).client(client).addConverterFactory(GsonConverterFactory.create())
                .build();
        Api_parameter LoginApi = RetroLogin.create(Api_parameter.class);

        Call<Login_Responce> login_Call = LoginApi.Login_Call_Api(mobile,password);


        login_Call.enqueue(new Callback<Login_Responce>() {
            @Override
            public void onResponse(Call<Login_Responce> call, Response<Login_Responce> response) {
                progressDialog.dismiss();

                Log.e("login" , ""+response.body().getResponce());



                if (response.body().getResponce().equals(true)){

                    Log.e("login_designation" , ""+response.body().getData().getDesignationName());
                    Log.e("login_designation_id" , ""+response.body().getData().getId());
                    Toast.makeText(Login_Activity.this, "Successful", Toast.LENGTH_SHORT).show();

                    user_id=response.body().getData().getId();
                    String s = response.body().getData().getDesignationName();

                    if (response.body().getData().getDesignationName().equals("admin")){
                        Log.e("login_designation" , ""+response.body().getData().getDesignationName());
                        Intent intent=new Intent(Login_Activity.this, Super_Admin_HomePage.class);
                        startActivity(intent);
                        finish();
                    }
                    if (response.body().getData().getDesignationName().equals("Site Supervisor")){
                        Log.e("login_designation" , ""+response.body().getData().getDesignationName());
                        Intent intent=new Intent(Login_Activity.this, Site_Supervisor_Dashboard.class);
                        startActivity(intent);
                        finish();
                    }
                    if (response.body().getData().getDesignationName().equals("Accountant")){
                        Log.e("login_designation" , ""+response.body().getData().getDesignationName());
                        Intent intent=new Intent(Login_Activity.this, Accountant_dashboard.class);
                        startActivity(intent);
                        finish();
                    }
                    if (response.body().getData().getDesignationName().equals("Day Book")){
                        Log.e("login_designation" , ""+response.body().getData().getDesignationName());
                        Intent intent=new Intent(Login_Activity.this, DayBookActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    if (response.body().getData().getDesignationName().equals("Booking")){
                        Log.e("login_designation" , ""+response.body().getData().getDesignationName());
                        Intent intent=new Intent(Login_Activity.this, Booking_Dashbook.class);
                        startActivity(intent);
                        finish();
                    }
                    if (response.body().getData().getDesignationName().equals("Book Payment")){
                        Log.e("login_designation" , ""+response.body().getData().getDesignationName());
                        Intent intent=new Intent(Login_Activity.this, Book_Payment_Dashboard.class);
                        startActivity(intent);
                        finish();
                    } if (response.body().getData().getDesignationName().equals("Receipts")){
                        Log.e("login_designation" , ""+response.body().getData().getDesignationName());
                        Intent intent=new Intent(Login_Activity.this, Receipts_Activity.class);
                        startActivity(intent);
                        finish();
                    }if (response.body().getData().getDesignationName().equals("Receipts")){
                        Log.e("login_designation" , ""+response.body().getData().getDesignationName());
                        Intent intent=new Intent(Login_Activity.this, Receipts_Activity.class);
                        startActivity(intent);
                        finish();
                    }if (response.body().getData().getDesignationName().equals("Bank Payments")){
                        Log.e("login_designation" , ""+response.body().getData().getDesignationName());
                        Intent intent=new Intent(Login_Activity.this, BankPayment.class);
                        startActivity(intent);
                        finish();
                    }if (response.body().getData().getDesignationName().equals("Day Book")){
                        Log.e("login_designation" , ""+response.body().getData().getDesignationName());
                        Intent intent=new Intent(Login_Activity.this, DayBookActivity.class);
                        startActivity(intent);
                        finish();
                    }if (response.body().getData().getDesignationName().equals("Booking")){
                        Log.e("login_designation" , ""+response.body().getData().getDesignationName());
                        Intent intent=new Intent(Login_Activity.this, Booking_Activity.class);
                        startActivity(intent);
                        finish();
                    }
                }else {
                    Toast.makeText(Login_Activity.this, "Login Fail", Toast.LENGTH_SHORT).show();
                }



                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<Login_Responce> call, Throwable t) {

                Log.e("failer",""+t.getMessage());
//                Toast.makeText(Registration_Step_1.this, ""+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(Registration_Step_1.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
