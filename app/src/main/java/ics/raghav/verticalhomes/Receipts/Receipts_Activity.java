package ics.raghav.verticalhomes.Receipts;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    EditText rec_o,date_rep,recwith,topart,sumof,cheque,drawnn,dated,amt,block;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipts);
        rec_o = findViewById(R.id.rec_o);
        date_rep = findViewById(R.id.date_rep);
        recwith = findViewById(R.id.recwith);
        topart = findViewById(R.id.topart);
        sumof = findViewById(R.id.sumof);
        cheque = findViewById(R.id.cheque);
        drawnn = findViewById(R.id.drawnn);
        dated = findViewById(R.id.dated);
        amt = findViewById(R.id.amt);
        block = findViewById(R.id.block);
        if(rec_o.getText().toString().length() !=0 && date_rep.getText().toString().length() !=0 && recwith.getText().toString().length() !=0 &&
                topart.getText().toString().length() !=0 &&
                sumof.getText().toString().length() !=0 && cheque.getText().toString().length() !=0 &&
                drawnn.getText().toString().length() !=0 &&  dated.getText().toString().length() !=0 &&
                amt.getText().toString().length() !=0 &&  block.getText().toString().length() !=0) {
            new Receipts_Register(rec_o.getText().toString() ,date_rep.getText().toString(),
                    recwith.getText().toString(),topart.getText().toString(),sumof.getText().toString(),
                    cheque.getText().toString(),drawnn.getText().toString(),dated.getText().toString(),
            amt.getText().toString(),block.getText().toString()).execute();
        }
    }

    private class Receipts_Register  extends AsyncTask<String, Void, String> {
        ProgressDialog dialog;
        String mobs , pincode,otp;
        int user_type;
        String rec_o,  date_rep,  recwith,  topart,  sumof,  cheque,  drawnn,  dated,  amt,  block;
        String toString10;


        public Receipts_Register(String rec_o, String date_rep, String recwith, String topart, String sumof, String cheque, String drawnn, String dated, String amt, String block) {
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
        }

        protected void onPreExecute() {
            dialog = new ProgressDialog(Receipts_Activity.this);
            dialog.show();

        }

        protected String doInBackground(String... arg0) {

            try {

                URL url = new URL("https://sdltechserv.in/dgfeb/api/api/buyerragistration");
                Log.d("string" , ""+otp);
                JSONObject postDataParams = new JSONObject();
                postDataParams.put("mobile", mobs);
                postDataParams.put("pincode", pincode);
                postDataParams.put("user_type", 1);
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
