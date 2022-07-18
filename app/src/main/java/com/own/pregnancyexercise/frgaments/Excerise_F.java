package com.own.pregnancyexercise.frgaments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.own.pregnancyexercise.Perform_excrise_activity;
import com.own.pregnancyexercise.R;
import com.own.pregnancyexercise.adapters.Excerise_list_adapter;
import com.own.pregnancyexercise.adapters.ViewItemclicklistener;
import com.own.pregnancyexercise.helper.Youga_helper;

import java.util.ArrayList;

/*
Source Code Downloaded From: https://nulledsourcecode.com/
If you need reskin and custom app hire us.
*/

public class Excerise_F extends Fragment {
    Excerise_list_adapter adapter;
    
    RecyclerView listview;

    public ArrayList<Youga_helper> yougahelpers = new ArrayList<>();

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override
    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
        this.yougahelpers = (ArrayList) bundle.getSerializable("yoga_helper");
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_excerise_, viewGroup, false);
        this.listview = (RecyclerView) inflate.findViewById(R.id.list_view);
        this.listview.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.listview.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(getActivity(), R.anim.layout_animation_fall_down));
        this.adapter = new Excerise_list_adapter(getActivity(), this.yougahelpers);
        this.listview.setAdapter(this.adapter);
        this.adapter.setItemclickListener(new ViewItemclicklistener() {


            @Override
            public void currentprogress(int i, int i2) {
                Log.d("","ssd");
            }

            public void delete(String str, int i) {
                Log.d("", "dsd");
            }

            public void save(String str, String str2, String str3) {
                Log.d("", "dsd");
            }

            public void update(String str, int i, boolean z, String str2) {
                Log.d("", "dsd");
            }

            @Override
            public void viewaction(int i) {
                Log.d("","ssd");
            }


            public void onClick(View view, int i) {
                Intent intent = new Intent(Excerise_F.this.getActivity(), Perform_excrise_activity.class);
                intent.putExtra("excerise_name", ((Youga_helper) Excerise_F.this.yougahelpers.get(i)).getYouganame());
                intent.putExtra("excerise_image", ((Youga_helper) Excerise_F.this.yougahelpers.get(i)).getYougaimage());
                intent.putExtra("youga_helpers", Excerise_F.this.yougahelpers);
                intent.putExtra("current_position", i);
                Excerise_F.this.startActivity(intent);
            }
        });
        return inflate;
    }
}
