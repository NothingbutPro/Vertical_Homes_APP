package ics.raghav.verticalhomes.LoginAndReg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ics.raghav.verticalhomes.R;

public class Registration_Pending_Activity extends AppCompatActivity {

    Button btn_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration__pending_);

        btn_ok=findViewById(R.id.btn_ok);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Registration_Pending_Activity.this,Login_Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
