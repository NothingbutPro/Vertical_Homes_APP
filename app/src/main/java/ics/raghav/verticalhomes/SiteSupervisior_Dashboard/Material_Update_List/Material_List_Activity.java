package ics.raghav.verticalhomes.SiteSupervisior_Dashboard.Material_Update_List;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.concurrent.TimeUnit;

import ics.raghav.verticalhomes.Adapter.Material_List_Adapter;
import ics.raghav.verticalhomes.All_Model_Classes.Bricks_List_Model;
import ics.raghav.verticalhomes.All_Model_Classes.Destination_Model;
import ics.raghav.verticalhomes.All_Model_Classes.Userdatum;
import ics.raghav.verticalhomes.ApiAndParameter.Api_parameter;
import ics.raghav.verticalhomes.ApiAndParameter.BaseUrl;
import ics.raghav.verticalhomes.LoginAndReg.Registration_Activity;
import ics.raghav.verticalhomes.R;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Material_List_Activity extends AppCompatActivity {

    RecyclerView recycler_material_list;
     String Form_no;
     String Form_name;
     ProgressDialog progressDialog;
     Material_List_Adapter material_list_adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material__list_);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //getSupportActionBar().setTitle("Bricks Form");

        recycler_material_list=findViewById(R.id.recycler_material_list);

        Form_no=getIntent().getStringExtra("form_no");
        Form_name=getIntent().getStringExtra("form_name");

        getSupportActionBar().setTitle(Form_name);

        if (Form_no.equals("1")){
            Brick_List_execute();
        }
        if (Form_no.equals("2")){
           // Cement_List_execute();
        }
        if (Form_no.equals("3")){
            //Sanitary_raw_List_execute();
        }
        if (Form_no.equals("4")){
            //Sanitary_finish_List_execute();
        }
        if (Form_no.equals("5")){
            //Sariya_List_execute();
        }
        if (Form_no.equals("6")){
           // Reti_List_execute();
        }
        if (Form_no.equals("7")){
           // MixSundry_List_execute();
        }
        if (Form_no.equals("8")){
           // Gitty_List_execute();
        }
        if (Form_no.equals("9")){
            //Electric_Raw_List_execute();
        }
        if (Form_no.equals("10")){
            //Electric_finish_List_execute();
        }

    }
//*************************************************************************************
    private void Brick_List_execute() {

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

        Call<Bricks_List_Model> Get_destination = AbloutApi.Get_Bricks_List_Call();
        Get_destination.enqueue(new Callback<Bricks_List_Model>() {
            @Override
            public void onResponse(Call<Bricks_List_Model> call, Response<Bricks_List_Model> response) {
                Log.e("get_bricks" , ""+response.toString());
                if (response!=null){
                    Log.e("Get_brics",""+response.body().getResponse());
                   // Log.e("Get_destination",""+response.body().getData());


                    for (int i=0;i<response.body().getData().size();i++)
                    {
                        Log.e("element" , ""+response.body().getData().get(i).getDate());
                        Log.e("element_size" , ""+response.body().getData().size());

//                        String des_id=response.body().getUserdata().get(i).getId();
//                        String des_name=response.body().getUserdata().get(i).getDesignation();
                        //bricks_hashmap.put(i, new Userdatum(des_id,des_name));

                    }
                    material_list_adapter = new Material_List_Adapter(Material_List_Activity.this, response.body().getData());
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(Material_List_Activity.this);
                    recycler_material_list.setLayoutManager(mLayoutManager);
                    recycler_material_list.setItemAnimator(new DefaultItemAnimator());
                    recycler_material_list.setAdapter(material_list_adapter);

                }

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<Bricks_List_Model> call, Throwable t) {
                progressDialog.dismiss();
                Log.e("error_country",t.getMessage());
                //Toast.makeText(AllCountries.this, ""+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
