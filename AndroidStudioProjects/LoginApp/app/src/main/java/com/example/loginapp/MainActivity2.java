package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btn_clean_prefs = findViewById(R.id.button2);

        SharedPreferences myPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        btn_clean_prefs.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = myPrefs.edit();

                editor.remove("user");
                editor.remove("passw");
                editor.apply();

                Toast.makeText(MainActivity2.this, "Datos borrados", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}