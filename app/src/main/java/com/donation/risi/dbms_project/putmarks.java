package com.donation.risi.dbms_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class putmarks extends AppCompatActivity {

    private EditText e1,e2,e3,e4;
    private Button B1,B2;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_putmarks);
        getui();
        // Creating database and table
        db=openOrCreateDatabase("StudentDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(Sname VARCHAR,rollno VARCHAR primary key,standard VARCHAR,contact_no VARCHAR);");
        db.execSQL("CREATE TABLE IF NOT EXISTS teacher(subid VARCHAR primary key,Tname VARCHAR,standard VARCHAR);");
        db.execSQL("CREATE TABLE IF NOT EXISTS marks(rollno VARCHAR,subject VARCHAR,marks VARCHAR,FOREIGN KEY(rollno) references student(rollno));");
    }

    void getui() {
        e1 = (EditText)findViewById(R.id.editText);
        e2 = (EditText)findViewById(R.id.editText2);
        e3 = (EditText)findViewById(R.id.editText3);
        e4 = (EditText)findViewById(R.id.editText8);
        B1 = (Button)findViewById(R.id.button12);
        B2 = (Button)findViewById(R.id.button13);
    }

    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    String a = "CN",b="DBMS",c="OOPS";
    public void putmark(View view) {

        db.execSQL("INSERT INTO marks VALUES('"+e1.getText()+"','"+a+ "','"+e2.getText()+"');");
        db.execSQL("INSERT INTO marks VALUES('"+e1.getText()+"','"+b+ "','"+e3.getText()+"');");
        db.execSQL("INSERT INTO marks VALUES('"+e1.getText()+"','"+c+ "','"+e4.getText()+"');");
            showMessage("Success", "Record added");
    }

    public void updatemarks(View view) {

    }
}
