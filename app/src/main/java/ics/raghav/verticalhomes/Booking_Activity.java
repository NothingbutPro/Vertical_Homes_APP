package ics.raghav.verticalhomes;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;

public class Booking_Activity extends AppCompatActivity {
    Button btn_submitdyboo;
    EditText date,party_name,project, flat_no, block ,size, rate, amount, other_charges, electric_charges, water_charges ,parking_charges, maintainace_charges, taxes, registry_expiry, total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_);
        date= findViewById(R.id.datebook);
        party_name= findViewById(R.id.party_name);
        btn_submitdyboo= findViewById(R.id.btn_submitdyboo);
        project= findViewById(R.id.project);
        flat_no= findViewById(R.id.flat_no);
        block= findViewById(R.id.block);
        rate= findViewById(R.id.rate);
        size= findViewById(R.id.size);
        amount= findViewById(R.id.amount);
        taxes= findViewById(R.id.taxes);
        total= findViewById(R.id.total);
        other_charges= findViewById(R.id.other_charges);
        electric_charges= findViewById(R.id.electric_charges);
        water_charges= findViewById(R.id.water_charges);
        registry_expiry= findViewById(R.id.registry_expiry);
        parking_charges= findViewById(R.id.parking_charges);
        maintainace_charges= findViewById(R.id.maintainace_charges);


        btn_submitdyboo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(date.getText().toString().length() !=0 && party_name.getText().toString().length() !=0 && project.getText().toString().length() !=0
                        &&flat_no.getText().toString().length() !=0 && block.getText().toString().length() !=0 && rate.getText().toString().length() !=0
                        && size.getText().toString().length() !=0&& amount.getText().toString().length() !=0
                        && taxes.getText().toString().length() !=0&& total.getText().toString().length() !=0
                        && other_charges.getText().toString().length() !=0&& electric_charges.getText().toString().length() !=0
                        && water_charges.getText().toString().length() !=0&& parking_charges.getText().toString().length() !=0
                        && maintainace_charges.getText().toString().length() !=0
                        && registry_expiry.getText().toString().length() !=0
                        && total.getText().toString().length() !=0
                )
                {
                    new BooktheAct(date.getText().toString() , party_name.getText().toString(),  project.getText().toString()
                            ,flat_no.getText().toString() , block.getText().toString(), rate.getText().toString()
                            ,size.getText().toString() , amount.getText().toString(), taxes.getText().toString()
                            ,other_charges.getText().toString() , electric_charges.getText().toString(), water_charges.getText().toString()
                            ,parking_charges.getText().toString() , maintainace_charges.getText().toString()
                            ,registry_expiry.getText().toString() , total.getText().toString()

                    ).execute();
                }else {
                    Toast.makeText(Booking_Activity.this, "please fill every field", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private class BooktheAct  extends AsyncTask<String, Void, String> {
        ProgressDialog dialog;
        String mobs, pincode, otp;
        int user_type;
        String date,party_name,project, flat_no, block ,size, rate, amount, other_charges, electric_charges, water_charges ,parking_charges, maintainace_charges, taxes, registry_expiry, total;
        String toString10;

        public BooktheAct(String date, String party_name, String project, String flat_no, String block, String size, String rate, String amount, String other_charges, String electric_charges, String water_charges, String parking_charges, String maintainace_charges, String taxes, String registry_expiry, String total) {
            this.date =date;
            this.party_name =party_name;
            this.project =project;
            this.flat_no =flat_no;
            this.block =block;
            this.size =size;
            this.rate =rate;
            this.amount =amount;
            this.other_charges =other_charges;
            this.electric_charges =electric_charges;
            this.water_charges =water_charges;
            this.parking_charges =parking_charges;
            this.maintainace_charges =maintainace_charges;
            this.registry_expiry =registry_expiry;
            this.taxes =taxes;
            this.maintainace_charges =maintainace_charges;
            this.total =total;
        }


        protected void onPreExecute () {
            dialog = new ProgressDialog(Booking_Activity.this);
            dialog.show();

        }

        protected String doInBackground (String...arg0){

            try {

                URL url = new URL("http://ihisaab.in/vertical_homes/Api/booking");
                Log.d("string", "" + otp);
                JSONObject postDataParams = new JSONObject();
                postDataParams.put("date", date);
                postDataParams.put("party_name", party_name);
                postDataParams.put("project", project);
                postDataParams.put("flat_no", flat_no);
                postDataParams.put("block", block);
                postDataParams.put("size", size);
                postDataParams.put("rate", rate);
                postDataParams.put("amount", amount);
                postDataParams.put("other_charges", other_charges);
                postDataParams.put("electric_charges", electric_charges);
                postDataParams.put("water_charges", water_charges);
                postDataParams.put("parking_charges", parking_charges);
                postDataParams.put("maintainace_charges", maintainace_charges);
                postDataParams.put("taxes", taxes);
                postDataParams.put("registry_expiry", registry_expiry);
                postDataParams.put("total", total);
//                postDataParams.put("password", );


                Log.e("postDataParams", postDataParams.toString());

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(15000  /*milliseconds*/);
                conn.setConnectTimeout(15000  /*milliseconds*/);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);

                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(getPostDataString(postDataParams));

                writer.flush();
                writer.close();
                os.close();

                int responseCode = conn.getResponseCode();

                if (responseCode == HttpsURLConnection.HTTP_OK) {

                    BufferedReader in = new BufferedReader(new
                            InputStreamReader(
                            conn.getInputStream()));

                    StringBuffer sb = new StringBuffer("");
                    String line = "";

                    while ((line = in.readLine()) != null) {

                        StringBuffer Ss = sb.append(line);
                        Log.e("Ss", Ss.toString());
                        sb.append(line);
                        break;
                    }

                    in.close();
                    return sb.toString();

                } else {
                    return new String("false : " + responseCode);
                }
            } catch (Exception e) {
                return new String("Exception: " + e.getMessage());
            }

        }

        @Override
        protected void onPostExecute (String result){
            if (result != null) {
                dialog.dismiss();

                JSONObject jsonObject = null;
                Log.e("PostRegistration", result.toString());
                try {

                    jsonObject = new JSONObject(result);
                    Boolean response = jsonObject.getBoolean("responce");
                    if (response.booleanValue() != false) {
//                        Intent intent = new Intent(OtpActivity.this , Buyer_Main_Navigation.class);
//                        startActivity(intent);
//                        Toast.makeText(OtpActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
////                        String massage =  jsonObject.getString("massage");
////                        String otp = massage.substring(29);
////                        Log.d("otp is" , ""+otp);
////                        txtmobile.setText(otp);
                    } else {
                        //Toast.makeText(OtpActivity.this, "OTP Could not be sent", Toast.LENGTH_SHORT).show();
//                        overridePendingTransition(R.anim.anim_slide_in_left,
//                                R.anim.anim_slide_out_left);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

        public String getPostDataString (JSONObject params) throws Exception {

            StringBuilder result = new StringBuilder();
            boolean first = true;

            Iterator<String> itr = params.keys();

            while (itr.hasNext()) {

                String key = itr.next();
                Object value = params.get(key);

                if (first)
                    first = false;
                else
                    result.append("&");

                result.append(URLEncoder.encode(key, "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(value.toString(), "UTF-8"));

            }
            return result.toString();
        }
    }
}
