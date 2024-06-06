package com.example.flowershop;

import android.os.Bundle;
import android.util.AndroidException;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.flowershop.adapter.BouquetAdapter;
import com.example.flowershop.model.Bouquet;
import com.example.flowershop.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Отображение имен букетов в списке корзине
        ListView orderlistView = findViewById(R.id.orderListView);
        List<String> bouquetTitle = new ArrayList<>();
        for (Bouquet b: MainActivity.fullBouquetsList){
            if(Order.orderedBouquest.contains(b.getId())){
                bouquetTitle.add(b.getName());
            }
        }
        orderlistView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bouquetTitle));
    }
}