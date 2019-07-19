package ics.raghav.verticalhomes.SiteSupervisior_Dashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ics.raghav.verticalhomes.R;

public class Successful_form_Activity extends AppCompatActivity {

Button button_homepage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful_form_);


        button_homepage=findViewById(R.id.button_homepage);

        button_homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Successful_form_Activity.this,Site_Supervisor_Dashboard.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
