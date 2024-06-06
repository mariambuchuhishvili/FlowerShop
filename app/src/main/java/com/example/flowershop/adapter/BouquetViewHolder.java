package com.example.flowershop.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowershop.R;

public final class BouquetViewHolder extends RecyclerView.ViewHolder{

    //определение элементов интерфейса куда будут привязываться данные
    TextView name;
    ImageView img;
    Button price;
    ConstraintLayout backgroundColor;

    public BouquetViewHolder(@NonNull View itemView) {
        super(itemView);
        this.name = itemView.findViewById(R.id.nameTextView);
        this.img = itemView.findViewById(R.id.imageView);
        this.price = itemView.findViewById(R.id.priceButton);
        this.backgroundColor = itemView.findViewById(R.id.backgroundConstraintLayout);
    }
}
