package ics.raghav.verticalhomes.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ics.raghav.verticalhomes.All_Model_Classes.Bricks_List_Model;
import ics.raghav.verticalhomes.All_Model_Classes.Bricks_Model_Data;
import ics.raghav.verticalhomes.R;

public class Material_List_Adapter extends RecyclerView.Adapter<Material_List_Adapter.ViewHolder> {

    private static final String TAG = "Material_List_Adapter";

    private List<Bricks_Model_Data> bricksList;
    public Context context;
    View viewlike;
    String PID="";


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txt1;
        CardView cardeview;
        int pos;

        public ViewHolder(View view) {
            super(view);
            viewlike = view;

            txt1 = (TextView) viewlike.findViewById(R.id.tv_level);
//
//            cardeview = (CardView)viewlike.findViewById(R.id.cardeview);

        }
    }

    public static Context mContext;
    public Material_List_Adapter(Context mContext, List<Bricks_Model_Data> bricks_list) {
        context = mContext;
        bricksList = bricks_list;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.material_item_list, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        final Bricks_Model_Data bricksListModel = bricksList.get(position);

        // Toast.makeText(context, "pos "+position, Toast.LENGTH_SHORT).show();

            viewHolder.txt1.setText(bricksListModel.getChalanNo());


//        viewHolder.cardeview.setTag(viewHolder);
        viewHolder.pos = position;


//        viewHolder.cardeview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                int i = position;
//               // PID =  LevelHashMap.get(i);
//
//
//            }
//        });







    }
    @Override
    public int getItemCount() {
        return bricksList.size();
    }



}
