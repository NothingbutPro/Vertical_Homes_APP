package ics.raghav.verticalhomes.SiteSupervisior_Dashboard.Material_Forms;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import ics.raghav.verticalhomes.All_Model_Classes.Bricks_Form_Responce;
import ics.raghav.verticalhomes.ApiAndParameter.Api_parameter;
import ics.raghav.verticalhomes.ApiAndParameter.BaseUrl;
import ics.raghav.verticalhomes.R;
import ics.raghav.verticalhomes.SiteSupervisior_Dashboard.Successful_form_Activity;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static ics.raghav.verticalhomes.LoginAndReg.Login_Activity.user_id;

public class Electric_raw_Activity extends AppCompatActivity {

    EditText date,inward_time,outward_time,lorry_no,chalan_no,party_name,quantity,amount,rate,gst,gross_amount,
            reamark,attachment,item;
    Button btn_submit;

    String Date,Inward_time,Outward_time,Lorry_no,Chalan_no,Party_name,Quantity,Amount,Rate,Gst,Gross_amount,
            Reamark,Attachment,Item;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanitary_raw);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Electric Raw");

        date=findViewById(R.id.date);
        inward_time=findViewById(R.id.inward_time);
        outward_time=findViewById(R.id.outward_time);
        lorry_no=findViewById(R.id.lorry_no);
        chalan_no=findViewById(R.id.chalan_no);
        party_name=findViewById(R.id.party_name);
        quantity=findViewById(R.id.quantity);
        amount=findViewById(R.id.amount);
        gst=findViewById(R.id.gst);
        rate=findViewById(R.id.rate);
        gross_amount=findViewById(R.id.gross_amount);
        reamark=findViewById(R.id.reamark);
        attachment=findViewById(R.id.attachment);
        item=findViewById(R.id.item);
        btn_submit=findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Date=date.getText().toString();
                Inward_time=inward_time.getText().toString();
                Outward_time=outward_time.getText().toString();
                Lorry_no=lorry_no.getText().toString();
                Chalan_no=chalan_no.getText().toString();
                Party_name=party_name.getText().toString();
                Quantity=quantity.getText().toString();
                Amount =amount.getText().toString();
                Rate=rate.getText().toString();
                Gst=gst.getText().toString();
                Gross_amount=gross_amount.getText().toString();
                Reamark=reamark.getText().toString();
                Attachment=attachment.getText().toString();
                Item=item.getText().toString();


                Electric_Raw_Form_Submit(user_id,Date,Inward_time,Outward_time,Lorry_no,Chalan_no,Party_name,Quantity,Amount,Rate,
                        Gst,Gross_amount,Reamark,Attachment,Item);


            }
        });
    }

    private void Electric_Raw_Form_Submit(String user_id, String date, String inward_time, String outward_time,
                                          String lorry_no, String chalan_no, String party_name, String quantity,
                                          String amount, String rate, String gst, String gross_amount,
                                          String reamark, String attachment, String item) {



        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Getting Your Data");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100,TimeUnit.SECONDS).build();
        Retrofit RetroLogin = new Retrofit.Builder()
                .baseUrl(BaseUrl.The_Base).client(client).addConverterFactory(GsonConverterFactory.create())
                .build();
        Api_parameter LoginApi = RetroLogin.create(Api_parameter.class);

        Call<Bricks_Form_Responce> login_Call = LoginApi.Electric_Raw_form_Call_Api(user_id,date,inward_time,outward_time,lorry_no,chalan_no,party_name
                ,quantity,amount,rate,gst,gross_amount,reamark,attachment,item);


        login_Call.enqueue(new Callback<Bricks_Form_Responce>() {
            @Override
            public void onResponse(Call<Bricks_Form_Responce> call, Response<Bricks_Form_Responce> response) {
                progressDialog.dismiss();

                Log.e("Add_new_service" , ""+response.body().getResponse());
                Log.e("Add_new_service" , ""+response.body().getMsg());
                Toast.makeText(Electric_raw_Activity.this, "Successful", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(Electric_raw_Activity.this, Successful_form_Activity.class);
                startActivity(intent);
                finish();

//                Log.e("Add_service_res_msg" , ""+response.body().getResponce());
//                Log.e("Add_service_res_suc" , ""+response.isSuccessful());
//
//                if (response.isSuccessful()){
//
//                    get_services_data.clear();
//                    service_adapter.notifyDataSetChanged();
//
//                    GETAllServiceS();
//
//                }

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<Bricks_Form_Responce> call, Throwable t) {

                Log.e("failer",""+t.getMessage());
//                Toast.makeText(Registration_Step_1.this, ""+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(Registration_Step_1.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
