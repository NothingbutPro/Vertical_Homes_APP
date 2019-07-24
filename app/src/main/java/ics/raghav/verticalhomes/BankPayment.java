package ics.raghav.verticalhomes;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

public class BankPayment extends AppCompatActivity {
  EditText date_on_cheque,cheque_no,particulars, amount ,remark,account_no,cheque_given_date;
  Button btn_submitbnk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_payment);
        date_on_cheque = findViewById(R.id.date_on_cheque);
        cheque_no = findViewById(R.id.cheque_no);
        particulars = findViewById(R.id.particulars);
        amount = findViewById(R.id.amount);
        remark = findViewById(R.id.remark);
        account_no = findViewById(R.id.account_no);
        btn_submitbnk = findViewById(R.id.btn_submitbnk);
        cheque_given_date = findViewById(R.id.cheque_given_date);
        btn_submitbnk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(date_on_cheque.getText().toString().length() !=0 && cheque_no.getText().toString().length() !=0 && particulars.getText().toString().length() !=0 &&
                        amount.getText().toString().length() !=0 &&
                        remark.getText().toString().length() !=0 && account_no.getText().toString().length() !=0 &&
                        cheque_given_date.getText().toString().length() !=0 ) {
                    new Bankpayregister(date_on_cheque.getText().toString() ,cheque_no.getText().toString(),
                            particulars.getText().toString(),amount.getText().toString(),remark.getText().toString(),
                            account_no.getText().toString(),cheque_given_date.getText().toString()).execute();
                }
            }
        });

    }


    public class Bankpayregister  extends AsyncTask<String, Void, String>

    {
        ProgressDialog dialog;
        String mobs , pincode,otp;
        int user_type;
        String date_on_cheque,cheque_no,particulars,amount,remark,account_no,cheque_given_date;
        String toString10;

        public Bankpayregister(String date_on_cheque, String cheque_no, String particulars, String amount, String remark, String account_no, String cheque_given_date) {

            this.date_on_cheque = date_on_cheque;
            this.cheque_no = cheque_no;
            this.particulars = particulars;
            this.amount = amount;
            this.remark = remark;
            this.account_no = account_no;
            this.cheque_given_date = cheque_given_date;
        }


        protected void onPreExecute() {
            dialog = new ProgressDialog(BankPayment.this);
            dialog.show();

        }

        protected String doInBackground(String... arg0) {

            try {

                URL url = new URL("http://ihisaab.in/vertical_homes/Api/bankpayment");
                Log.d("string" , ""+otp);
                JSONObject postDataParams = new JSONObject();
                postDataParams.put("date_on_cheque", date_on_cheque);
                postDataParams.put("cheque_no", cheque_no);
                postDataParams.put("particulars", particulars);
                postDataParams.put("amount", amount);
                postDataParams.put("remark", remark);
                postDataParams.put("account_no", account_no);
                postDataParams.put("cheque_given_date", cheque_given_date);

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
