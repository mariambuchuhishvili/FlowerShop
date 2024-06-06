package com.example.flowershop;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowershop.adapter.CategoryAdapter;
import com.example.flowershop.adapter.BouquetAdapter;
import com.example.flowershop.adapter.SelectListener;
import com.example.flowershop.model.Category;
import com.example.flowershop.model.Bouquet;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectListener {

    RecyclerView categoryRecyclerView;
    RecyclerView bouquetRecyclerView;
    CategoryAdapter categoryAdapter;
    static BouquetAdapter bouquetAdapter;
    static List<Bouquet> bouquets = new ArrayList<>(); //Список использующийся в адаптере
    static List<Bouquet> fullBouquetsList = new ArrayList<>(); //Полный список букетов

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //список категорий
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1,"Розы"));
        categories.add(new Category(2,"Лилии"));
        categories.add(new Category(3,"Хризантемы"));
        categories.add(new Category(4,"Гвоздики"));
        categories.add(new Category(5,"Тюльпаны"));
        categories.add(new Category(6,"Другие"));


        //список букетов
        fullBouquetsList.add(new Bouquet(1,"51 красная роза", "bouquet1", "7900.00", "#B0001B","Состав:\n" +
                "Роза - 51 шт.\n" +
                "Лента атласная - 1 шт.\n" +
                "\n" +
                "Размер:\n" +
                "Ширина - 15 см\n" +
                "Высота - 40 см",new int[]{1}));
        fullBouquetsList.add(new Bouquet(2,"Букет из роз и лилий", "bouquet2", "15000.00", "#FFF2CC", "Состав:\n" +
                "Лента атласная - 2 шт.\n" +
                "Лилия белая - 8 шт.\n" +
                "Упаковка дизайнерская - 3 шт.\n" +
                "Роза белая 70 см - 19 шт.\n" +
                "эустома белая - 11 шт."+
                "\n"+
                "Размер:\n" +
                "Ширина - 50 см\n" +
                "Высота - 65 см", new int[]{1,2}));
        fullBouquetsList.add(new Bouquet(3,"Нежная коробка с кустовой хризантемой", "bouquet3", "2800.00", "#F9CB9C", "Состав:\n" +
                "Кустовая хризантема - 5 шт.\n" +
                "Лента атласная - 1 шт.\n" +
                "Коробка шляпная - 1 шт.\n" +
                "Оазис - 1 шт.\n" +
                "\n" +
                "Размер:\n" +
                "Ширина - 25 см\n" +
                "Высота - 30 см",new int[]{3}));
        fullBouquetsList.add(new Bouquet(4,"Красная гвоздика 15 шт", "bouquet4", "1000.00", "#E06666", "Состав:\n" +
                "Гвоздика красная - 15 шт.\n" +
                "Крафт упаковка - 1 шт.\n" +
                "\n" +
                "Размер:\n" +
                "Ширина - 28 см\n" +
                "Высота - 45 см",new int[]{4}));
        fullBouquetsList.add(new Bouquet(5,"Красочная весна💛💜", "bouquet5", "4600.00", "#939D62","Состав:\n" +
                "Ирис - 10 шт.\n" +
                "Тюльпан - 15 шт.\n" +
                "Лента атласная - 2 шт.\n" +
                "Крафт - 3 шт.",new int[]{5,6}));
        fullBouquetsList.add(new Bouquet(6,"Цветы из шаров 9 шт", "bouquet6", "1500.00", "#D9EAD3","Состав:\n"+
                "Шары для моделирования - 20 шт.",new int[]{6}));

        //fullBouquetsList.addAll(bouquets);
        bouquets.addAll(fullBouquetsList);
        SetCategoryTitles(categories);
        SetBouquetsTitles(bouquets);
    }


    //Отображение списка категорий
    private void SetCategoryTitles(List<Category> categories) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL, false);
        categoryRecyclerView = findViewById(R.id.categoriesRecyclerView);
        categoryRecyclerView.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(categories, this);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

    //Отображение списка букетов
    private void SetBouquetsTitles(List<Bouquet> goods) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL, false);
        bouquetRecyclerView = findViewById(R.id.bouquetsRecyclerView);
        bouquetRecyclerView.setLayoutManager(layoutManager);

        bouquetAdapter = new BouquetAdapter(this, goods);
        bouquetRecyclerView.setAdapter(bouquetAdapter);
    }


    //Фильтрация списка букетов по категории
    // принимается идентификатор категории
    // для каждого букета в списке проверяется есть ли id категории в списке категорий текущего букета
    @Override
    public void onCategoryClick(int categoryId) {
        bouquets.clear();
        bouquets.addAll(fullBouquetsList);

        List<Bouquet> filteredBouquets = new ArrayList<Bouquet>();
        for (Bouquet b : bouquets){
            for (int i = 0; i<b.getCategoryId().length;i++){
                if(b.getCategoryId()[i] == categoryId){
                    filteredBouquets.add(b);
                }
            }
        }

        bouquets.clear();
        bouquets.addAll(filteredBouquets);

        bouquetAdapter.notifyDataSetChanged();
    }

    //отображение всего списка букета по нажатию кнопки
    public void OnAllButtonClick(View v){
        bouquets.clear();
        bouquets.addAll(fullBouquetsList);
        bouquetAdapter.notifyDataSetChanged();
    }
    //открытие страницы корзины
    public void OpenOrderActivity(View v){
        Intent intent = new Intent(this, OrderPage.class);
        this.startActivity(intent);
    }
}