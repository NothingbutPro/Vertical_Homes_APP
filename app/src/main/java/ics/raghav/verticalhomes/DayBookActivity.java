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

import ics.raghav.verticalhomes.Receipts.Receipts_Activity;

public class DayBookActivity extends AppCompatActivity {
    EditText jamamt, jama, jamhead, khtamt, khtate, khatehea;
    Button btn_submitbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_book);

        btn_submitbook = findViewById(R.id.btn_submitbook);
        jamamt = findViewById(R.id.jamamt);
        jama = findViewById(R.id.jama);
        jamhead = findViewById(R.id.jamhead);
        khtamt = findViewById(R.id.khtamt);
        khtate = findViewById(R.id.khtate);
        khatehea = findViewById(R.id.khatehea);
        btn_submitbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (jamamt.getText().toString().length() != 0 && jama.getText().toString().length() != 0 && jamhead.getText().toString().length() != 0
                        && khtamt.getText().toString().length() != 0 && khtate.getText().toString().length() != 0 && khatehea.getText().toString().length() != 0) {
                    new Daybooklogin(jamamt.getText().toString(), jama.getText().toString(), jamhead.getText().toString()
                            , khtamt.getText().toString(), khtate.getText().toString(), khatehea.getText().toString()).execute();
                } else {
                    Toast.makeText(DayBookActivity.this, "please fill every field", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    public class Daybooklogin extends AsyncTask<String, Void, String> {
        ProgressDialog dialog;
        String mobs, pincode, otp;
        int user_type;
        String jamamt, jama, jamhead, khtamt, khtate, khatehea, drawnn, dated, amt, block, project, flat_no;
        String toString10;

        public Daybooklogin(String jamamt, String jama, String jamhead, String khtamt, String khtate, String khatehea) {

            this.jamamt = jamamt;
            this.jama = jama;
            this.jama = jama;
            this.jamhead = jamhead;
            this.khtamt = khtamt;
            this.khtate = khtate;
            this.khatehea = khatehea;


        }


        protected void onPreExecute() {
            dialog = new ProgressDialog(DayBookActivity.this);
            dialog.show();

        }

        protected String doInBackground(String... arg0) {

            try {

                URL url = new URL("http://ihisaab.in/vertical_homes/Api/daybook");
                Log.d("string", "" + otp);
                JSONObject postDataParams = new JSONObject();
                postDataParams.put("jama_amount", jamamt);
                postDataParams.put("jama", jama);
                postDataParams.put("jama_head", jamhead);
                postDataParams.put("khate_amount", khtamt);
                postDataParams.put("khate", khtate);
                postDataParams.put("khate_head", khatehea);
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
