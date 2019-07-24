package ics.raghav.verticalhomes.Receipts;

import android.app.ProgressDialog;
import android.content.Intent;
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

import ics.raghav.verticalhomes.R;

public class Receipts_Activity extends AppCompatActivity {
    EditText rec_o,date_rep,recwith,topart,sumof,cheque,drawnn,dated,amt,block,proj,flano;
    Button btn_submit_rep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipts);
        rec_o = findViewById(R.id.rec_o);
        date_rep = findViewById(R.id.date_rep);
        proj = findViewById(R.id.proj);
        recwith = findViewById(R.id.recwith);
        btn_submit_rep = findViewById(R.id.btn_submit_rep);
        flano = findViewById(R.id.flano);
        topart = findViewById(R.id.topart);
        sumof = findViewById(R.id.sumof);
        cheque = findViewById(R.id.cheque);
        drawnn = findViewById(R.id.drawnn);
        dated = findViewById(R.id.acc_no_ver);
        amt = findViewById(R.id.amt);
        block = findViewById(R.id.block);
        btn_submit_rep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rec_o.getText().toString().length() !=0 && date_rep.getText().toString().length() !=0 && recwith.getText().toString().length() !=0 &&
                        topart.getText().toString().length() !=0 &&
                        sumof.getText().toString().length() !=0 && cheque.getText().toString().length() !=0 &&
                        drawnn.getText().toString().length() !=0 &&  dated.getText().toString().length() !=0 &&
                        amt.getText().toString().length() !=0 &&  block.getText().toString().length() !=0) {
                    new Receipts_Register(rec_o.getText().toString() ,date_rep.getText().toString(),
                            recwith.getText().toString(),topart.getText().toString(),sumof.getText().toString(),
                            cheque.getText().toString(),drawnn.getText().toString(),dated.getText().toString(),
                            amt.getText().toString(),block.getText().toString(),proj.getText().toString() , flano.getText().toString()).execute();
                }
            }
        });

    }

    private class Receipts_Register  extends AsyncTask<String, Void, String> {
        ProgressDialog dialog;
        String mobs , pincode,otp;
        int user_type;
        String rec_o,  date_rep,  recwith,  topart,  sumof,  cheque,  drawnn,  dated,  amt,  block,project,flat_no;
        String toString10;


        public Receipts_Register(String rec_o, String date_rep, String recwith, String topart, String sumof, String cheque, String drawnn, String dated, String amt, String block ,String project,String flat_no) {
            this.rec_o =rec_o;
            this.date_rep = date_rep;
            this.recwith = recwith;
            this.topart = topart;
            this.sumof = sumof;
            this.cheque = cheque;
            this.drawnn = drawnn;
            this.dated = dated;
            this.amt = amt;
            this.block = block;
            this.project = project;
            this.flat_no = flat_no;
        }

        protected void onPreExecute() {
            dialog = new ProgressDialog(Receipts_Activity.this);
            dialog.show();

        }

        protected String doInBackground(String... arg0) {

            try {

                URL url = new URL("http://ihisaab.in/vertical_homes/Api/receipt");
                Log.d("string" , ""+otp);
                JSONObject postDataParams = new JSONObject();
                postDataParams.put("date", date_rep);
                postDataParams.put("party_name", recwith);
                postDataParams.put("project", project);
                postDataParams.put("flat_no", flat_no);
                postDataParams.put("block", block);
                postDataParams.put("amount", amt);
                postDataParams.put("mode", cheque);
                postDataParams.put("details", sumof);
                postDataParams.put("user_type", drawnn);
                postDataParams.put("head", recwith);
                postDataParams.put("acc_no_verification", dated);
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
        protected void onPostExecute(String result) {
            if (result != null) {
                dialog.dismiss();

                JSONObject jsonObject = null;
                Log.e("PostRegistration", result.toString());
                try {

                    jsonObject = new JSONObject(result);
                    Boolean response = jsonObject.getBoolean("responce");
                    if(response.booleanValue() !=false)
                    {
//                        Intent intent = new Intent(OtpActivity.this , Buyer_Main_Navigation.class);
//                        startActivity(intent);
//                        Toast.makeText(OtpActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
////                        String massage =  jsonObject.getString("massage");
////                        String otp = massage.substring(29);
////                        Log.d("otp is" , ""+otp);
////                        txtmobile.setText(otp);
                    }else {
                        //Toast.makeText(OtpActivity.this, "OTP Could not be sent", Toast.LENGTH_SHORT).show();
//                        overridePendingTransition(R.anim.anim_slide_in_left,
//                                R.anim.anim_slide_out_left);
                    }
                }catch (Exception e)
                {
                    e.printStackTrace();
                }

            }
        }

        public String getPostDataString(JSONObject params) throws Exception {

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
