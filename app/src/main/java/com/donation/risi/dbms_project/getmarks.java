package com.donation.risi.dbms_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class getmarks extends AppCompatActivity {
    SQLiteDatabase db;
    private EditText e1,e2;
    private Button B1,B2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getmarks);
        getui();
        db=openOrCreateDatabase("StudentDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(Sname VARCHAR,rollno VARCHAR primary key,standard VARCHAR,contact_no VARCHAR);");
        db.execSQL("CREATE TABLE IF NOT EXISTS teacher(subid VARCHAR primary key,Tname VARCHAR,standard VARCHAR);");
        db.execSQL("CREATE TABLE IF NOT EXISTS marks(rollno VARCHAR,subject VARCHAR,marks VARCHAR,FOREIGN KEY(rollno) references student(rollno));");
    }

    private void getui() {
           e1 = (EditText)findViewById(R.id.editText9);
           e2 = (EditText)findViewById(R.id.editText10);
           B1 = (Button)findViewById(R.id.button14);
    }

    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void showdtl(View view) {
        Cursor c=db.rawQuery("SELECT * FROM marks WHERE rollno="+e1.getText(), null);
            if(c.getCount()==0)
            {
                showMessage("Error", "No records found");
                return;
            }
            StringBuffer buffer=new StringBuffer();
            while(c.moveToNext())
            {
                buffer.append("Rollno: "+c.getString(0)+"\n");
                buffer.append("Name: "+c.getString(1)+"\n");
                buffer.append("Marks: "+c.getString(2)+"\n\n");
            }
            showMessage("Student Details", buffer.toString());
    }

    public void MAxi(View view) {
        Cursor c=db.rawQuery("SELECT max(marks) as maximum_mark from marks WHERE subject="+e2.getText(), null);
        showMessage("Student Details", c.toString());
    }
}
