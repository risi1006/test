package com.donation.risi.dbms_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class putstud extends AppCompatActivity {

    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_putstud);
        db=openOrCreateDatabase("StudentDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(Sname VARCHAR,rollno VARCHAR primary key,standard VARCHAR,contact_no VARCHAR);");
        db.execSQL("CREATE TABLE IF NOT EXISTS teacher(subid VARCHAR primary key,Tname VARCHAR,standard VARCHAR);");
        db.execSQL("CREATE TABLE IF NOT EXISTS marks(rollno VARCHAR,subject VARCHAR,mark int,FOREIGN KEY(rollno) references student(rollno));");
    }

    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }


    public void putstud1(View view) {
//            Cursor c=db.rawQuery("SELECT * FROM student", null);
//            StringBuffer buffer=new StringBuffer();
//            while(c.moveToNext())
//            {
//                buffer.append("Rollno: "+c.getString(0)+"\n");
//                buffer.append("Name: "+c.getString(1)+"\n");
//                buffer.append("Marks: "+c.getString(2)+"\n\n");
//            }
//            showMessage("Student Details", buffer.toString());
    }


    public void studdetail(View view) {
        Cursor c=db.rawQuery("SELECT * FROM student", null);
        StringBuffer buffer=new StringBuffer();
        while(c.moveToNext())
        {
            buffer.append("Name: "+c.getString(0)+"\n");
            buffer.append("Roll NO: "+c.getString(1)+"\n");
            buffer.append("Standard: "+c.getString(2)+"\n");
            buffer.append("Contact no: "+c.getString(3)+"\n\n");
        }
        showMessage("Student Details", buffer.toString());
    }

    public void count(View view) {
      int numRows = (int) DatabaseUtils.longForQuery(db, "SELECT COUNT(*) FROM "+"student", null);
//        int numRows = (int) DatabaseUtils.queryNumEntries(db, "student");
        showMessage("Student Details", String.valueOf(numRows));

    }

    public void totalmarks(View view) {
        Cursor cur = db.rawQuery("SELECT SUM(mark) FROM marks", null);
        showMessage("Total", String.valueOf(cur.getInt(0)));
    }

    public void maxmarks(View view) {
        //max marks
    }
}
