package com.example.flowershop;

import android.os.Bundle;
import android.util.AndroidException;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowershop.adapter.BouquetAdapter;
import com.example.flowershop.model.Bouquet;
import com.example.flowershop.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderPage extends AppCompatActivity {

    RecyclerView orderView;
    BouquetAdapter bouquetAdapter;
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

        TextView aboutTextView = findViewById(R.id.about);
        aboutTextView.setOnClickListener(new MyOnClickListener(getCurrentFocus(),this, AboutActivity.class));
        TextView contactsTextView = findViewById(R.id.contacts);
        contactsTextView.setOnClickListener(new MyOnClickListener(getCurrentFocus(),this, ContactsActivity.class));
        TextView mainTextView = findViewById(R.id.main_menu);
        mainTextView.setOnClickListener(new MyOnClickListener(getCurrentFocus(),this,MainActivity.class));

        //Добавление заказанных букетов в  корзине
        //если в списке id заказанных букетов есть id определенного букета то он добавляется в список
        List<Bouquet> orderedBouquetsList = new ArrayList<>();
        for (Bouquet b: MainActivity.fullBouquetsList){
            if(Order.orderedBouquest.contains(b.getId())){
                orderedBouquetsList.add(b);
            }
        }
        SetBouquetsTitles(orderedBouquetsList);

    }
    //Отображение заказанных букетов
    private void SetBouquetsTitles(List<Bouquet> orderedBouquetsList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL, false);
        orderView = findViewById(R.id.orderRecyclerView);
        orderView.setLayoutManager(layoutManager);

        bouquetAdapter = new BouquetAdapter(this, orderedBouquetsList);
        orderView.setAdapter(bouquetAdapter);
    }

}