package ics.raghav.verticalhomes.LoginAndReg;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import ics.raghav.verticalhomes.All_Model_Classes.Destination_Model;
import ics.raghav.verticalhomes.All_Model_Classes.Registration_only;
import ics.raghav.verticalhomes.All_Model_Classes.Userdatum;
import ics.raghav.verticalhomes.ApiAndParameter.Api_parameter;
import ics.raghav.verticalhomes.ApiAndParameter.BaseUrl;
import ics.raghav.verticalhomes.R;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Registration_Activity extends AppCompatActivity {

    TextView back_login_here;
    Button btn_signup;
    EditText et_fullname,et_mobile,et_email,et_password;
    Spinner spin_designation;
     ProgressDialog progressDialog;
    ArrayList<String> raghav=new ArrayList<>();
    private ArrayAdapter<String> DestinationAdapter;

    HashMap<Integer,Userdatum>destination_id=new HashMap<>();
     String Desti_ID,Et_fullname,Et_mobile,Et_email,Et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_);


        back_login_here=findViewById(R.id.back_login_here);
        btn_signup=findViewById(R.id.btn_signup);

        et_fullname=findViewById(R.id.et_fullname);
        et_mobile=findViewById(R.id.et_mobile);
        et_email=findViewById(R.id.et_email);
        et_password=findViewById(R.id.et_password);
        spin_designation=findViewById(R.id.spin_designation);

        spin_designation_item();

        back_login_here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Registration_Activity.this, Login_Activity.class);
                startActivity(intent);
            }
        });

        //******************spinner***designation********************
        spin_designation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Log.e("desti_size",""+destination_id.size());
                Desti_ID= String.valueOf(spin_designation.getItemIdAtPosition(position));
                for (int i = 0; i < destination_id.size(); i++)
                {
                    if (destination_id.get(i).getDesignation().equals
                            (spin_designation.getItemAtPosition(position))){

                       // Desti_ID=destination_id.get(i);
//                        Desti_ID= spin_designation.getItemIdAtPosition(position);
                        Log.e("des_id",""+Desti_ID);
                        // Toast.makeText(AttendenceActivity.this, "sec_Id"+Section_ID, Toast.LENGTH_SHORT).show();
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //*********************************************************1

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Et_fullname=et_fullname.getText().toString();
                Et_email=et_email.getText().toString();
                Et_mobile=et_mobile.getText().toString();
                Et_password=et_password.getText().toString();

                RegisterExcuteTask(Et_fullname,Et_email,Et_mobile,Et_password,Desti_ID);
            }
        });
    }

    private void spin_designation_item() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("processing");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100,TimeUnit.SECONDS).build();
        Retrofit RetroLogin = new Retrofit.Builder()
                .baseUrl(BaseUrl.The_Base).client(client).addConverterFactory(GsonConverterFactory.create())
                .build();
        Api_parameter AbloutApi = RetroLogin.create(Api_parameter.class);

        Call<Destination_Model> Get_destination = AbloutApi.Get_Destination_Call();
        Get_destination.enqueue(new Callback<Destination_Model>() {
            @Override
            public void onResponse(Call<Destination_Model> call, Response<Destination_Model> response) {
                 Log.e("get_destination" , ""+response.toString());
                if (response!=null){
                   Log.e("Get_destination",""+response.body().getResponse());
                   Log.e("Get_destination",""+response.body().getUserdata());


                   for (int i=0;i<response.body().getUserdata().size();i++)
                   {
                       Log.e("element" , ""+response.body().getUserdata().get(i).getDesignation());
                       Log.e("element_size" , ""+response.body().getUserdata().size());

                       raghav.add(response.body().getUserdata().get(i).getDesignation());

                       String des_id=response.body().getUserdata().get(i).getId();
                       String des_name=response.body().getUserdata().get(i).getDesignation();

                       destination_id.put(i, new Userdatum(des_id,des_name));

                       Log.e("hashmap_des",""+destination_id);

                   }
                    DestinationAdapter = new ArrayAdapter<String>(Registration_Activity.this, android.R.layout.simple_spinner_dropdown_item, raghav);
                    DestinationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin_designation.setAdapter(DestinationAdapter);

                }

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<Destination_Model> call, Throwable t) {
                progressDialog.dismiss();
                Log.e("error_country",t.getMessage());
                //Toast.makeText(AllCountries.this, ""+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
               // Toast.makeText(AllCountries.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void RegisterExcuteTask(String et_fullname, String et_email, String et_mobile, String et_password, String desti_ID) {

        progressDialog = new ProgressDialog(Registration_Activity.this);
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
        Call<Registration_only> get_aboutCall = AbloutApi.REGISTRATION_ONLY_CALL(et_fullname,et_email ,et_mobile,et_password,
                desti_ID);
        get_aboutCall.enqueue(new Callback<Registration_only>() {
            @Override
            public void onResponse(Call<Registration_only> call, Response<Registration_only> response) {
                progressDialog.dismiss();
                Log.e("responce is ", "" + response.body());
                Toast.makeText(Registration_Activity.this, "Successful", Toast.LENGTH_SHORT).show();
                Log.e("responce message is", "" + response.body().getMassage());
                Log.e("responce_otp", "" + response.body().getResponce());

                String otp= String.valueOf(response.body().getResponce());
                Intent intent=new Intent(Registration_Activity.this, Otp_Activity.class);
                intent.putExtra("otp",otp);
                intent.putExtra("fullname",Et_fullname);
                intent.putExtra("email",Et_email);
                intent.putExtra("mobile",Et_mobile);
                intent.putExtra("password",Et_password);
                intent.putExtra("designation",Desti_ID);

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
            public void onFailure(Call<Registration_only> call, Throwable t) {
                progressDialog.dismiss();
                Log.e("Failer",""+t.getMessage());
//                Toast.makeText(getActivity(), "" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(getActivity(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });




    }
}
