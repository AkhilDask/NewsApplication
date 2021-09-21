package com.example.newsapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    Context context;
    ArrayList<Modelclass> modelclassArrayList;

    public MyAdapter(Context context,ArrayList<Modelclass>modelclassArrayList){
        this.context = context;
        this.modelclassArrayList= modelclassArrayList;
    }




    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.layout_item,null,false);

        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {

    holder.cardView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context,webview.class);
            intent.putExtra("url",modelclassArrayList.get(position).getUrl());
            context.startActivity(intent);
        }
    });

    holder.atime.setText("published at: "+modelclassArrayList.get(position).getPublishedAt());
    holder.aauthor.setText(modelclassArrayList.get(position).getAuthor());
    holder.aheading.setText(modelclassArrayList.get(position).getTitle());
        holder.acontent.setText(modelclassArrayList.get(position).getDescription());
        Glide.with(context).load(modelclassArrayList.get(position).getUrlToImage()).into(holder.imageView);






    }

    @Override
    public int getItemCount() {
        return modelclassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView aheading,acontent,aauthor,atime;
        CardView cardView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            aheading=itemView.findViewById(R.id.mainheading);
            acontent=itemView.findViewById(R.id.content);
            aauthor=itemView.findViewById(R.id.author);
            atime=itemView.findViewById(R.id.time);
            imageView=itemView.findViewById(R.id.imageview);
            cardView=itemView.findViewById(R.id.cardview);

        }
    }


}
