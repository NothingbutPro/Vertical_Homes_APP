package ics.raghav.verticalhomes.SiteSupervisior_Dashboard.Navigation_Menu_option;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import ics.raghav.verticalhomes.R;
import ics.raghav.verticalhomes.SiteSupervisior_Dashboard.Material_Forms.Bricks_Material_Activity;
import ics.raghav.verticalhomes.SiteSupervisior_Dashboard.Material_Forms.Cement_Material_Activity;
import ics.raghav.verticalhomes.SiteSupervisior_Dashboard.Material_Forms.Electric_finish_Activity;
import ics.raghav.verticalhomes.SiteSupervisior_Dashboard.Material_Forms.Electric_raw_Activity;
import ics.raghav.verticalhomes.SiteSupervisior_Dashboard.Material_Forms.Gitty_Activity;
import ics.raghav.verticalhomes.SiteSupervisior_Dashboard.Material_Forms.Mix_sundry_Activity;
import ics.raghav.verticalhomes.SiteSupervisior_Dashboard.Material_Forms.Reti_Activity;
import ics.raghav.verticalhomes.SiteSupervisior_Dashboard.Material_Forms.Sanitary_finished_Activity;
import ics.raghav.verticalhomes.SiteSupervisior_Dashboard.Material_Forms.Sanitary_raw;
import ics.raghav.verticalhomes.SiteSupervisior_Dashboard.Material_Forms.Sariya_Activity;

public class Material_Forms_Activity extends AppCompatActivity {


    TextView tv_bricks,tv_cement,sanitary_raw,Sanitary_finished,Sariya,Reti,Mix_sundry,Gitti,Electric_raw,
            Electric_finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material__forms_);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Material Form");


        //******************content find view id************************************
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

//*****************************intent listener*************************************

        tv_bricks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Material_Forms_Activity.this, "active +bricks", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Material_Forms_Activity.this, Bricks_Material_Activity.class);
                startActivity(intent);
            }
        });
        tv_cement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Material_Forms_Activity.this, Cement_Material_Activity.class);
                startActivity(intent);
            }
        });
        sanitary_raw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Material_Forms_Activity.this, Sanitary_raw.class);
                startActivity(intent);
            }
        });
        Sanitary_finished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Material_Forms_Activity.this, Sanitary_finished_Activity.class);
                startActivity(intent);
            }
        });
        Sariya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Material_Forms_Activity.this, Sariya_Activity.class);
                startActivity(intent);
            }
        });
        Reti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Material_Forms_Activity.this, Reti_Activity.class);
                startActivity(intent);
            }
        });
        Mix_sundry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Material_Forms_Activity.this, Mix_sundry_Activity.class);
                startActivity(intent);
            }
        });
        Gitti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Material_Forms_Activity.this, Gitty_Activity.class);
                startActivity(intent);
            }
        });
        Electric_raw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Material_Forms_Activity.this, Electric_raw_Activity.class);
                startActivity(intent);
            }
        });
        Electric_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Material_Forms_Activity.this, Electric_finish_Activity.class);
                startActivity(intent);
            }
        });

        //********************************************************************
    }
}
