package com.classwork.hm4_3.continets;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.classwork.hm4_3.OnClick;
import com.classwork.hm4_3.R;
import com.classwork.hm4_3.databinding.FragmentContinetsBinding;

import java.util.ArrayList;

public class ContinetsFragment extends Fragment implements OnClick {

    private RecyclerView rvContinent;
    private FragmentContinetsBinding binding;
    private ArrayList<ContinentModel> continentList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentContinetsBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvContinent = requireActivity().findViewById(R.id.rv_continets);
        loadData();
        ContinentAdapter adapter = new ContinentAdapter(continentList, this);
        binding.rvContinets.setAdapter(adapter);
    }

    private void loadData() {
        continentList.add(new ContinentModel("Europe", "https://t0.gstatic.com/licensed-image?q=tbn:ANd9GcQEYMOVfn_FuPnR6e6UcEXxLmtUb3h7mGCfPilJr54jkYkzfcuy8jQ24v47r9N69Vso"));
        continentList.add(new ContinentModel("Asia", "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAARMAAAC3CAMAAAAGjUrGAAAAh1BMVEXOESYAKGj////RECSnFjYAKWsAJGYAJmcAIWUAGWEAEl8AHmMAGGH09/rN1OAAAFsUM24AD18PMG1CVoN5iamttMbb4enm6/Hu8vYlPXTGy9decJZzgqMAFGFufZ81TX+Kl7JOYYyTn7gACl+Bj6wAAF5HXoyaori0vs/T2+YqP3UyRXgVPHfSmt7wAAACx0lEQVR4nO3d6W7aQABFYTqtN8AQE8IODiRka97/+VoSRZG4QWWx7kTV+aT8Hx3F44XxuNUCAAAAAAAAAAAAAAAAAAAAAADiJ/a1fmFfK8G+1g/so4miiaKJoomiifoeTbI0S9O/f1nsgbyJ3iTNi6qdXE1ffr9Mr5J2VeRp7CHFbZIW1eB6eNMbjSdlKCfjUe9meD2oirhZIjbJOtV0OBuHfePZcFp1Ih5G0ZpkRT6flRLkXTmb50W0KrGaFNlidCDIu9EiKyKNLU6TfLnSY0aOodUyjzK6KE3ade+fRXZ6dTvG8CI0Savbo4rs3FYRTkH+Jp3B7OgkIcwGHfsI7U269eSEJCFM6q57iO4m7fWh8+8h5do9qZibtOcnFtmZm6N4m3TXZyQJYe09fKxNOvVZSUKorROts0manDqXfCgT5ynZ2CTbHnel9pXe1nj3Y2xSbc5OEsKm8g3U1yQ/dzJ5V/vufWxNsv7zRU1GfdvRY2tSLC5KEsLC9ujA1uTu3HPOh/LONVRXk+79hUlCuHddubma9E+78/vKpG8aq6lJsbo4SQgr04xiatI//3LtU8/0j+JpkiUNJAkh8ZyOPU26m0aabDyzrKdJI4eO7eDxNNk2kiSErWW0lib5Q0NNHiw3PZYmy8eGmjwuHcO1NKmeGmryZHliYGly4S3xp2fLJOtp0lCSEGjyPzdZNtbEctHmaNLQlf2O5ere0SR9bazJq+M3Df5PFPOJ4ryjaKK4jlXc7yjuixXPTxTP2RTPYxXP7RW/7yh+B1T8XqxYV6BYf6JYp6RYz6ZY96hYH6tYR61Yb694L0Px/o7iPS/F+4CK90YV7xcr3kNX7Feg2NdCsf+JYp8cxX5Kin23FPuzKfbxU9GbvGG/x++OJoomiiaKJoomiu8gKL6Xofiuior9qRsAAAAAAAAAAAAAAAAAAAAAAL6jP8+oqDPR+qDBAAAAAElFTkSuQmCC"));
        continentList.add(new ContinentModel("", ""));
        continentList.add(new ContinentModel("", ""));
        continentList.add(new ContinentModel("", ""));
    }

    @Override
    public void onClick(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("key", position);


    }
}