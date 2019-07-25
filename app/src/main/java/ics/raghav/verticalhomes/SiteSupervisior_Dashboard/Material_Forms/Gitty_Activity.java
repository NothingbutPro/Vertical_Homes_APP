package ics.raghav.verticalhomes.SiteSupervisior_Dashboard.Material_Forms;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
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

public class Gitty_Activity extends AppCompatActivity {

    EditText date, inward_time, outward_time, lorry_no, chalan_no, party_name, quantity, amount, rate, gst, gross_amount,
            reamark, attachment, height, bridth, length;
    Button btn_submit;
    String Date, Inward_time, Outward_time, Lorry_no, Chalan_no, Party_name, Quantity, Amount, Rate, Gst, Gross_amount,
            Reamark, Attachment, Height, Bridth, Length;
    ProgressDialog progressDialog;
    ImageView calender, watch, watch1;
    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gitty_);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Gitty Form");

        date = findViewById(R.id.date);
        inward_time = findViewById(R.id.inward_time);
        outward_time = findViewById(R.id.outward_time);
        lorry_no = findViewById(R.id.lorry_no);
        chalan_no = findViewById(R.id.chalan_no);
        party_name = findViewById(R.id.party_name);
        quantity = findViewById(R.id.quantity);
        amount = findViewById(R.id.amount);
        gst = findViewById(R.id.gst);
        rate = findViewById(R.id.rate);
        gross_amount = findViewById(R.id.gross_amt);
        reamark = findViewById(R.id.reamark);
        attachment = findViewById(R.id.attachment);
        height = findViewById(R.id.height);
        bridth = findViewById(R.id.bridth);
        length = findViewById(R.id.length);
        btn_submit = findViewById(R.id.btn_submit);
        calender = findViewById(R.id.calender);
        watch = findViewById(R.id.watch);
        watch1 = findViewById(R.id.watch1);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Date = date.getText().toString();
                Inward_time = inward_time.getText().toString();
                Outward_time = outward_time.getText().toString();
                Lorry_no = lorry_no.getText().toString();
                Chalan_no = chalan_no.getText().toString();
                Party_name = party_name.getText().toString();
                Quantity = quantity.getText().toString();
                Amount = amount.getText().toString();
                Rate = rate.getText().toString();
                Gst = gst.getText().toString();
                Gross_amount = gross_amount.getText().toString();
                Reamark = reamark.getText().toString();
                Attachment = attachment.getText().toString();
                Height = height.getText().toString();
                Bridth = bridth.getText().toString();
                Length = length.getText().toString();

                Gitty_Form_Submit(user_id, Date, Inward_time, Outward_time, Lorry_no, Chalan_no, Party_name, Quantity, Amount, Rate,
                        Gst, Gross_amount, Reamark, Attachment, Height, Bridth, Length);


            }
        });

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        calender.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(Gitty_Activity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        watch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(Gitty_Activity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        inward_time.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });

        watch1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(Gitty_Activity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        outward_time.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, false);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });
    }

    //------------------------------

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        date.setText(sdf.format(myCalendar.getTime()));
    }

    //--------------------------------

    private void Gitty_Form_Submit(String user_id, String date, String inward_time, String outward_time,
                                   String lorry_no, String chalan_no, String party_name, String quantity,
                                   String amount, String rate, String gst, String gross_amount, String reamark,
                                   String attachment, String height, String bridth, String length) {

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Getting Your Data");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS).build();
        Retrofit RetroLogin = new Retrofit.Builder()
                .baseUrl(BaseUrl.The_Base).client(client).addConverterFactory(GsonConverterFactory.create())
                .build();
        Api_parameter LoginApi = RetroLogin.create(Api_parameter.class);

        Call<Bricks_Form_Responce> login_Call = LoginApi.Gitty_form_Call_Api(user_id, date, inward_time, outward_time, lorry_no, chalan_no, party_name
                , quantity, amount, rate, gst, gross_amount, reamark, attachment, height, bridth, length);


        login_Call.enqueue(new Callback<Bricks_Form_Responce>() {
            @Override
            public void onResponse(Call<Bricks_Form_Responce> call, Response<Bricks_Form_Responce> response) {
                progressDialog.dismiss();

                Log.e("Add_new_service", "" + response.body().getResponce());
                Log.e("Add_new_service", "" + response.body().getData());
                Toast.makeText(Gitty_Activity.this, "Successful", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Gitty_Activity.this, Successful_form_Activity.class);
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
//
//                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<Bricks_Form_Responce> call, Throwable t) {
                progressDialog.dismiss();
                Log.e("failer", "" + t.getMessage());
//                Toast.makeText(Registration_Step_1.this, ""+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(Registration_Step_1.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
