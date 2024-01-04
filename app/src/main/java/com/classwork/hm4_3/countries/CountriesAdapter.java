package com.classwork.hm4_3.countries;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.classwork.hm4_3.R;
import com.classwork.hm4_3.databinding.ItemCountriesBinding;

import java.util.ArrayList;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesViewHolder>{

    private ArrayList<CountryModel> countriesList = new ArrayList<>();

    public CountriesAdapter(ArrayList<CountryModel> countriesList) {
        this.countriesList = countriesList;
    }

    @NonNull
    @Override
    public CountriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CountriesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_countries, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CountriesViewHolder holder, int position) {
        holder.onBind(countriesList.get(position));
    }

    @Override
    public int getItemCount() {
        return countriesList.size();
    }
}
class CountriesViewHolder extends RecyclerView.ViewHolder{
    private TextView tvName;
    private ImageView imgCountry;
    private ItemCountriesBinding binding;

    public CountriesViewHolder(@NonNull View itemView) {
        super(itemView);
        this.tvName = tvName;
        this.imgCountry = imgCountry;
        this.binding = binding;
    }

    public void onBind(CountryModel model){
        tvName.setText(model.getName());
        Glide.with(imgCountry).load(model.getImg()).into(imgCountry);
    }
}


