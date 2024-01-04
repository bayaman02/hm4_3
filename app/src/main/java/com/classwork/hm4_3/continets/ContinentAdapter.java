package com.classwork.hm4_3.continets;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.classwork.hm4_3.OnClick;
import com.classwork.hm4_3.R;
import com.classwork.hm4_3.databinding.ItemContinetsBinding;

import java.util.ArrayList;

public class ContinentAdapter extends RecyclerView.Adapter<ContinentViewHolder>{
    private ArrayList<ContinentModel> continentsList = new ArrayList<>();
    private OnClick onClick;

    public ContinentAdapter(ArrayList<ContinentModel> continentsList, OnClick onClick) {
        this.continentsList = continentsList;
        this.onClick = onClick;
    }


    @NonNull
    @Override
    public ContinentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContinentViewHolder
                (LayoutInflater.from(parent.getContext()).inflate(R.layout.item_continets, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContinentViewHolder holder, int position) {
        holder.onBind(continentsList.get(position));
        holder.itemView.setOnClickListener(view -> {
            onClick.onClick(position);
        });
    }

    @Override
    public int getItemCount() {
        return continentsList.size();
    }
}
class ContinentViewHolder extends RecyclerView.ViewHolder{
    private TextView tvName;
    private ImageView imgContinent;
    private ItemContinetsBinding binding;

    public ContinentViewHolder(@NonNull View itemView) {
        super(itemView);
        this.tvName = tvName;
        this.imgContinent = imgContinent;
        this.binding = binding;
    }

    public void onBind(ContinentModel model){
        tvName.setText(model.getName());
        Glide.with(imgContinent).load(model.getImg()).into(imgContinent);
    }
}
