package com.donation.risi.dbms_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class marks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marks);
    }

    public void putMarks(View view) {
        Intent intent = new Intent(getApplicationContext(),putmarks.class);
        startActivity(intent);
    }

    public void getMarks(View view) {
        Intent intent = new Intent(getApplicationContext(),getmarks.class);
        startActivity(intent);
    }
}
