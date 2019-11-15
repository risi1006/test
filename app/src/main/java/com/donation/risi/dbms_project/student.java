package com.donation.risi.dbms_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class student extends AppCompatActivity {

    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        db=openOrCreateDatabase("StudentDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(Sname VARCHAR,rollno VARCHAR primary key,standard VARCHAR,contact_no VARCHAR);");
        db.execSQL("CREATE TABLE IF NOT EXISTS teacher(subid VARCHAR primary key,Tname VARCHAR,standard VARCHAR);");
        db.execSQL("CREATE TABLE IF NOT EXISTS marks(rollno VARCHAR,subject VARCHAR,marks VARCHAR,FOREIGN KEY(rollno) references student(rollno));");
    }

    public void putsutd1(View view) {
        Intent intent = new Intent(getApplicationContext(),getstud.class);
        startActivity(intent);
    }

    public void getstud1(View view) {
        Intent intent = new Intent(getApplicationContext(),putstud.class);
        startActivity(intent);
    }


}
