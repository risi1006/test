package com.donation.risi.dbms_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class getstud extends AppCompatActivity {

    private EditText e1,e2,e3,e4;
    private Button B1;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getstud);
        //Loading UI
        getui();
        // Creating database and table
        db=openOrCreateDatabase("StudentDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(Sname VARCHAR,rollno VARCHAR primary key,standard VARCHAR,contact_no VARCHAR);");
    }



    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }





    void getui()
    {
        e1 = (EditText)findViewById(R.id.editText4);
        e2 = (EditText)findViewById(R.id.editText5);
        e3 = (EditText)findViewById(R.id.editText6);
        e4 = (EditText)findViewById(R.id.editText7);
        B1 = (Button)findViewById(R.id.button5);
    }

    public void insert(View view) {
        db.execSQL("INSERT INTO student VALUES('"+e1.getText()+"','"+e2.getText()+ "','"+e3.getText()+"','"+e4.getText()+"');");
        showMessage("Success", "Record added");
    }
}
