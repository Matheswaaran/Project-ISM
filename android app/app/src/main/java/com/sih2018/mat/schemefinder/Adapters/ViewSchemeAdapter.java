package com.sih2018.mat.schemefinder.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sih2018.mat.schemefinder.Extras.Scheme;
import com.sih2018.mat.schemefinder.R;

import java.util.List;

/**
 * Created by mat on 31/03/18.
 */

public class ViewSchemeAdapter extends RecyclerView.Adapter<ViewSchemeAdapter.MyViewHolder> {
    private List<Scheme> schemeList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title, division, gender, profession;

        public MyViewHolder(View view){
            super(view);

            title = (TextView) view.findViewById(R.id.slot_title);
            division = (TextView) view.findViewById(R.id.slot_division);
            gender = (TextView) view.findViewById(R.id.slot_gender);
            profession = (TextView) view.findViewById(R.id.slot_profession);
        }
    }

    public ViewSchemeAdapter(List<Scheme> schemeList){
        this.schemeList = schemeList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_scheme, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Scheme scheme = schemeList.get(position);
        holder.title.setText(scheme.getName());
        holder.division.setText(scheme.getDivision());
        holder.gender.setText(scheme.getGender());
        holder.profession.setText(scheme.getProfession());
    }

    @Override
    public int getItemCount(){
        return schemeList.size();
    }
}
