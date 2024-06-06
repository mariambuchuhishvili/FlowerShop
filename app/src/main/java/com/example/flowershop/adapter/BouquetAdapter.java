package com.example.flowershop.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Placeholder;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowershop.BouquetPage;
import com.example.flowershop.R;
import com.example.flowershop.model.Bouquet;

import java.util.List;

public class BouquetAdapter extends RecyclerView.Adapter<BouquetViewHolder> {

    Context context;
    List<Bouquet> bouquetList;

    public BouquetAdapter(Context context, List<Bouquet> bouquetList){
        this.context = context;
        this.bouquetList = bouquetList;
    }

    @NonNull
    @Override
    public BouquetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View bouquetItem  = LayoutInflater.from(parent.getContext()).inflate(R.layout.bouquet_element, parent,false); //интерфейс отображения информации о букете

        return new BouquetViewHolder(bouquetItem);
    }

    @Override
    public void onBindViewHolder(@NonNull BouquetViewHolder holder, int position) {
        //связывание данных о букете с адаптером
        holder.name.setText(bouquetList.get(position).getName());
        int img_id = context.getResources().getIdentifier(bouquetList.get(position).getImg(),"drawable", context.getPackageName());
        holder.img.setImageResource(img_id);
        String price_text = bouquetList.get(position).getPrice()+" ₽";
        holder.price.setText(price_text);
        holder.backgroundColor.setBackgroundColor(Color.parseColor(bouquetList.get(position).getColor()));

        //отправка данных о букете на новую страницу
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), BouquetPage.class);

                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) v.getContext(), new Pair<View,String>(holder.img,"bouquetPhoto")); //анимация перехода страницы через фото

                intent.putExtra("bouquetId",bouquetList.get(holder.getAdapterPosition()).getId());
                intent.putExtra("bouquetImage",img_id);
                intent.putExtra("bouquetPrice",price_text);
                intent.putExtra("bouquetName",bouquetList.get(holder.getAdapterPosition()).getName());
                intent.putExtra("bouquetBackground ", Color.parseColor(bouquetList.get(holder.getAdapterPosition()).getColor()));
                intent.putExtra("bouquetDescription", bouquetList.get(holder.getAdapterPosition()).getDescription());
                
                context.startActivity(intent,activityOptions.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return bouquetList.size();
    }
}
