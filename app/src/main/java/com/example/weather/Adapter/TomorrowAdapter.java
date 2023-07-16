package com.example.weather.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.weather.Domains.Tomorrow;
import com.example.weather.R;

import java.util.ArrayList;


public class TomorrowAdapter extends RecyclerView.Adapter<TomorrowAdapter.ViewHolder> {
    ArrayList<Tomorrow> items;
    Context context;

    public TomorrowAdapter(ArrayList<Tomorrow> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public TomorrowAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_tomorrow,parent,false);
        context =parent.getContext();

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull TomorrowAdapter.ViewHolder holder, int position) {
        holder.dayTxt.setText(items.get(position).getDay());
        holder.statusTxt.setText(items.get(position).getStatus());
        holder.highTemp.setText(items.get(position).getHighTemp()+"º");
        holder.lowTemp.setText(items.get(position).getHighTemp()+"º");

        int drawableResourceId= holder.itemView.getResources()
                        .getIdentifier(items.get(position).getPicPath(),"drawable",
                        holder.itemView.getContext().getPackageName());


        Glide.with(context)
                .load(drawableResourceId)
                .into(holder.picTmw);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView dayTxt, statusTxt, lowTemp,highTemp;
        ImageView picTmw;
         public ViewHolder(@NonNull View itemView) {
            super(itemView);
             dayTxt = itemView.findViewById(R.id.dayTxt);
             statusTxt = itemView.findViewById(R.id.statusTxt);
             lowTemp = itemView.findViewById(R.id.lowTemp);
             highTemp = itemView.findViewById(R.id.highTemp);
             picTmw = itemView.findViewById(R.id.picTmw);

        }
    }
}
