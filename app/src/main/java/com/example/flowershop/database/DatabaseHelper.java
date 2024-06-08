package com.example.flowershop.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper{

    Context context;
    private static final String DATABASE_NAME = "flowershop.db";
    private static final int DATABASE_VERSION = 1;


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Bouquets (Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Name TEXT NOT NULL," +
                "Image TEXT NOT NULL," +
                "Price TEXT NOT NULL," +
                "Color TEXT NOT NULL," +
                "Description TEXT NOT NULL);");
        db.execSQL("CREATE TABLE Categories (Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Title TEXT NOT NULL);");
        db.execSQL("CREATE TABLE Filter (Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "CategoryId INTEGER NOT NULL," +
                "BouquetId INTEGER NOT NULL);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE Bouquets;");
        db.execSQL("DROP TABLE Categories;");
        db.execSQL("DROP TABLE Filter;");
    }

    public SQLiteDatabase openDatabase() {
        return getWritableDatabase();
    }

    public void closeDatabase() {
        getWritableDatabase().close();
    }

    public Cursor selectAllBouquets(SQLiteDatabase db){
        return db.rawQuery("SELECT * FROM Bouquets;",null);
    }
    public Cursor selectAllCategories(SQLiteDatabase db){
        return db.rawQuery("SELECT * FROM Categories;",null);
    }
    public Cursor selectFilter(SQLiteDatabase db, int bouquetId){
        return db.rawQuery("SELECT CategoryId FROM Filter WHERE BouquetId = ?;",new String[]{String.valueOf(bouquetId)});
    }
}

