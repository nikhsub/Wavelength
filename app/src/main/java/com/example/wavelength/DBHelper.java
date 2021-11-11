package com.example.wavelength;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBHelper {
    SQLiteDatabase sqLiteDatabase;

    public DBHelper(SQLiteDatabase sqLiteDatabase) {
        this.sqLiteDatabase = sqLiteDatabase;
    }
// Fuction to create the users table
    public void createTable() {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS users" +
                "(id INTEGER PRIMARY KEY,username TEXT, password TEXT)");
    }

    public void onSignup(String username, String password){
        createTable();
        sqLiteDatabase.execSQL((String.format("INSERT INTO users (username,password) VALUES ('%s','%s')",
                username,password)));
    }
}
