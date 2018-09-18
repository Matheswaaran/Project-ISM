package com.sih2018.mat.schemefinder.SubActivities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;


import com.sih2018.mat.schemefinder.Adapters.RecyclerViewDecoration;
import com.sih2018.mat.schemefinder.Adapters.RecyclerViewTouchListener;
import com.sih2018.mat.schemefinder.Adapters.ViewSchemeAdapter;
import com.sih2018.mat.schemefinder.Extras.Scheme;
import com.sih2018.mat.schemefinder.R;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class ViewSchemesActivity extends AppCompatActivity {

    private List<Scheme> schemeList, finalList;
    private ViewSchemeAdapter viewSchemeAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager eLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_schemes);

        schemeList = new ArrayList<Scheme>();
        finalList = new ArrayList<Scheme>();
        int curYear = 2018;
        Bundle extras = getIntent().getExtras();
        String yob = extras.getString("yob");
        int age = curYear - Integer.parseInt(yob);
        String income =extras.getString("income");
        String gender =extras.getString("gender");
        String profession = extras.getString("profession");

        recyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        eLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(eLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new RecyclerViewDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL, 16));

        prepareSchemeData();

        for (Scheme scheme : schemeList){
            if (Integer.parseInt(scheme.getMinAge()) <= age && Integer.parseInt(scheme.getMaxAge()) >= age ){
                if(profession.equals(scheme.getProfession())){
                    if(income.equals(scheme.getIncome())){
                        if (gender.equals(scheme.getGender()) || scheme.getGender().equals("all")){
                            finalList.add(scheme);
                        }
                    }
                }
            }
        }

        viewSchemeAdapter = new ViewSchemeAdapter(finalList);
        recyclerView.setAdapter(viewSchemeAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerViewTouchListener(getApplicationContext(), recyclerView, new RecyclerViewTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

            }
            @Override
            public void onLongClick(View view, int position) {
            }
        }));
    }

    public void prepareSchemeData(){

        Scheme scheme = new Scheme("Jan Dhan Yojna","18","50","0","100000","centre","dailywages","male","all");
        schemeList.add(scheme);
        scheme = new Scheme("Dr.B.R.Ambedkar state award","20","40","200000","300000","state","teacher","all","all");
        schemeList.add(scheme);
        scheme = new Scheme("Lal Bahadur Sastri","15","55","300000","400000","centre","others","all","all");
        schemeList.add(scheme);
        scheme = new Scheme("Merit ScholarShip","20","30","200000","300000","state","student","all","all");
        schemeList.add(scheme);
        scheme = new Scheme("Supplementary Nutrition","4","12","0","0","centre","child","all","all");
        schemeList.add(scheme);
        scheme = new Scheme("Mazi Kanya bagya","25","50","200000","500000","state","others","female","all");
        schemeList.add(scheme);
        scheme = new Scheme("ladli Yojna","50","100","Belove","400000","state","others","","all");
        schemeList.add(scheme);
        scheme = new Scheme("Bavika Samriti Yojna","0","18","0","0","centre","child","female","all");
        schemeList.add(scheme);
        scheme = new Scheme("Pension Scheme","45","100","50000","1000000","state","Teacher","all","all");
        schemeList.add(scheme);
        scheme = new Scheme("100 A Day Scheme","25","45","2000","3450","centre","dailywages","male","all");
        schemeList.add(scheme);
        scheme = new Scheme("Immunisation Scheme","3","13","0","0","state","Child","all","all");
        schemeList.add(scheme);
        scheme = new Scheme("Dhara Scheme","40","65","40000","50700","state","others","all","all");
        schemeList.add(scheme);
        scheme = new Scheme("Help Scheme","20","40","5000","200000","centre","others","male","all");
        schemeList.add(scheme);
        scheme = new Scheme("Sukanya Smriti Scheme","23","38","15000","120000","state","teacher","female","all");
        schemeList.add(scheme);
        scheme = new Scheme("Made In India","15","55","20000","34500","centre","Other","all","all");
        schemeList.add(scheme);
        scheme = new Scheme("Bhanya Scheme","35","50","60000","78912","state","Other","male","all");
        schemeList.add(scheme);
        scheme = new Scheme("laasli Yokna","50","35","40000","345678","state","Other","female","all");
        schemeList.add(scheme);
        scheme = new Scheme("Blaika Samriti Yojna","40","40","50000","123457","centre","Other","all","all");
        schemeList.add(scheme);
    }
}
