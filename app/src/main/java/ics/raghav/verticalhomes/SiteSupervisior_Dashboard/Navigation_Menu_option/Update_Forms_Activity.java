package ics.raghav.verticalhomes.SiteSupervisior_Dashboard.Navigation_Menu_option;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import ics.raghav.verticalhomes.R;
import ics.raghav.verticalhomes.SiteSupervisior_Dashboard.Material_Update_List.Material_List_Activity;

public class Update_Forms_Activity extends AppCompatActivity {

    TextView tv_bricks,tv_cement,sanitary_raw,Sanitary_finished,Sariya,Reti,Mix_sundry,Gitti,Electric_raw,
            Electric_finish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material__forms_);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Update Form");


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
                Intent intent=new Intent(Update_Forms_Activity.this, Material_List_Activity.class);
                intent.putExtra("form_no","1");
                intent.putExtra("form_name","Bricks List");
                startActivity(intent);
            }
        });
        tv_cement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Update_Forms_Activity.this,Material_List_Activity.class);
                intent.putExtra("form_no","2");
                intent.putExtra("form_name","Cement List");
                startActivity(intent);
            }
        });
        sanitary_raw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Update_Forms_Activity.this,Material_List_Activity.class);
                intent.putExtra("form_no","3");
                intent.putExtra("form_name","Sanitary raw List");
                startActivity(intent);
            }
        });
        Sanitary_finished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Update_Forms_Activity.this,Material_List_Activity.class);
                intent.putExtra("form_no","4");
                intent.putExtra("form_name","Sanitary finished List");
                startActivity(intent);
            }
        });
        Sariya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Update_Forms_Activity.this,Material_List_Activity.class);
                intent.putExtra("form_no","5");
                intent.putExtra("form_name","Sariya List");
                startActivity(intent);
            }
        });
        Reti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Update_Forms_Activity.this,Material_List_Activity.class);
                intent.putExtra("form_no","6");
                intent.putExtra("form_name","Reti List");
                startActivity(intent);
            }
        });
        Mix_sundry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Update_Forms_Activity.this,Material_List_Activity.class);
                intent.putExtra("form_no","7");
                intent.putExtra("form_name","Mix sundry List");
                startActivity(intent);
            }
        });
        Gitti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Update_Forms_Activity.this,Material_List_Activity.class);
                intent.putExtra("form_no","8");
                intent.putExtra("form_name","Gitty List");
                startActivity(intent);
            }
        });
        Electric_raw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Update_Forms_Activity.this,Material_List_Activity.class);
                intent.putExtra("form_no","9");
                intent.putExtra("form_name","Electric raw List");
                startActivity(intent);
            }
        });
        Electric_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Update_Forms_Activity.this,Material_List_Activity.class);
                intent.putExtra("form_no","10");
                intent.putExtra("form_name","Electric finish List");
                startActivity(intent);
            }
        });
    }
}
