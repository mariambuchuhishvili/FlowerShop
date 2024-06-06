package com.example.flowershop;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.flowershop.model.Order;

public class BouquetPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bouquet_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.backgroundConstraintLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Подставление данные под соответсвующие элементы
        ConstraintLayout background = findViewById(R.id.backgroundConstraintLayout);
        ImageView image = findViewById(R.id.bouquetImageView);
        TextView name = findViewById(R.id.nameTextView);
        TextView description = findViewById(R.id.descriprionTextView);
        Button price = findViewById(R.id.priceButton);

        background.setBackgroundColor(getIntent().getIntExtra("bouquetBackground ",0));
        image.setImageResource(getIntent().getIntExtra("bouquetImage",0));
        name.setText(getIntent().getStringExtra("bouquetName"));
        price.setText(getIntent().getStringExtra("bouquetPrice"));
        description.setText(getIntent().getStringExtra("bouquetDescription"));
    }
    //Добавление букета в корзину
    public void AddToOrder(View v){
        Order.orderedBouquest.add(getIntent().getIntExtra("bouquetId",0));
        Toast.makeText(this,"Букет добавлен в корзину",Toast.LENGTH_SHORT).show();
    }
}