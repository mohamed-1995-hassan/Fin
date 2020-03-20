package com.example.fin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void go_fill(View view) {
        Intent i=new Intent(this,Add_note.class);
        startActivity(i);
    }

    public void code_log(View view) {
        Intent i=new Intent(this,Code_login.class);
        startActivity(i);
    }
}
