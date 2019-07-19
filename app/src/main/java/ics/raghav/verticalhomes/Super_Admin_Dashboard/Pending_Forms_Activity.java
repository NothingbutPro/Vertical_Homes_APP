package ics.raghav.verticalhomes.Super_Admin_Dashboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import ics.raghav.verticalhomes.R;

public class Pending_Forms_Activity extends AppCompatActivity {

    TextView tv_bricks,tv_cement,sanitary_raw,Sanitary_finished,Sariya,Reti,Mix_sundry,Gitti,Electric_raw,
            Electric_finish;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material__forms_);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Pending Forms");

        tv_bricks=findViewById(R.id.tv_bricks);
        tv_cement=findViewById(R.id.tv_cement);
        sanitary_raw=findViewById(R.id.sanitary_raw);
        Sanitary_finished=findViewById(R.id.Sanitary_finished);
        Sariya=findViewById(R.id.sariya);
        Reti=findViewById(R.id.reti);
        Mix_sundry=findViewById(R.id.mix_sundry);
        Gitti=findViewById(R.id.gitti);
        Electric_raw=findViewById(R.id.electric_raw);
        Electric_finish=findViewById(R.id.electricfinish);




    }
}
