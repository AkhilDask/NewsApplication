package com.example.newsapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Technologyfragment extends Fragment {

    String apikey="132707ca4b684ef381864ec1dbe7a645";
    ArrayList<Modelclass> modelclassArrayList;
    MyAdapter adapter;
    String country="in";
    private RecyclerView recyclertechnology;
    private String category="technology";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.technologyfragment,null);


        recyclertechnology=v.findViewById(R.id.recyclertechnology);
        modelclassArrayList = new ArrayList<>();
        recyclertechnology.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new MyAdapter(getContext(),modelclassArrayList);
        recyclertechnology.setAdapter(adapter);


        findnews();





        return v;
    }

    private void findnews() {
        Apiutilities.getApiInterface().getcategoryNews(country,category,100,apikey).enqueue(new Callback<Mainnews>() {
            @Override
            public void onResponse(Call<Mainnews> call, Response<Mainnews> response) {
                if (response.isSuccessful())
                {
                    modelclassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<Mainnews> call, Throwable t) {

            }
        });
    }

}
