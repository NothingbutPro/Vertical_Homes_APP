package ics.raghav.verticalhomes.SiteSupervisior_Dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;

import ics.raghav.verticalhomes.R;

public class Site_Supervisor_Dashboard extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView tv_bricks,tv_cement,sanitary_raw,Sanitary_finished,Sariya,Reti,Mix_sundry,Gitti,Electric_raw,Electric_finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site__supervisor__dashboard);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Vertical Homes");
        setSupportActionBar(toolbar);
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
                Intent intent=new Intent(Site_Supervisor_Dashboard.this,Bricks_Material_Activity.class);
                startActivity(intent);
            }
        });
        tv_cement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Site_Supervisor_Dashboard.this,Cement_Material_Activity.class);
                startActivity(intent);
            }
        });
        sanitary_raw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Site_Supervisor_Dashboard.this,Sanitary_raw.class);
                startActivity(intent);
            }
        });
        Sanitary_finished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Site_Supervisor_Dashboard.this,Sanitary_finished_Activity.class);
                startActivity(intent);
            }
        });
        Sariya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Site_Supervisor_Dashboard.this,Sariya_Activity.class);
                startActivity(intent);
            }
        });
        Reti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Site_Supervisor_Dashboard.this,Reti_Activity.class);
                startActivity(intent);
            }
        });
        Mix_sundry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Site_Supervisor_Dashboard.this,Mix_sundry_Activity.class);
                startActivity(intent);
            }
        });
        Gitti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Site_Supervisor_Dashboard.this,Gitty_Activity.class);
                startActivity(intent);
            }
        });
        Electric_raw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Site_Supervisor_Dashboard.this,Electric_raw_Activity.class);
                startActivity(intent);
            }
        });
        Electric_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Site_Supervisor_Dashboard.this,Electric_finish_Activity.class);
                startActivity(intent);
            }
        });

        //********************************************************************
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.site__supervisor__dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
