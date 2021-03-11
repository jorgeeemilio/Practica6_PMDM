package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public static final String user = "fran";
    public static final String passw = "10101998fB";
    /*public static final String MyPREFERENCES = "LoginCredentials";
    public static final String Usuario  = "nombreKey";
    public static final String Clave = "claveKey";
    public static final String Pulsador = "switchKey";*/




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //binding id
        EditText et1 = findViewById((int)R.id.editTextTextPersonName);;
        EditText et2 = findViewById((int)R.id.editTextTextPassword);;
        Switch sw1 = findViewById((int)R.id.switch1);;
        Button btn1 = findViewById((int)R.id.button);;

        SharedPreferences sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        String isShared = sharedPref.getString("user", "");

        if(!isShared.equals("")){
            et1.setText(sharedPref.getString("user", ""));
            et2.setText(sharedPref.getString("passw", ""));
            btn1.post(new Runnable(){
                @Override
                public void run() {
                    btn1.performClick();
                }
            });
        }


        //btn listeners
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((!et1.getText().toString().equals(""))&&(!et2.getText().toString().equals(""))) {

                    if((et1.getText().toString().equals(user))&&(et2.getText().toString().equals(passw))) {
                        if(sw1.isChecked()) {

                            SharedPreferences.Editor editor = sharedPref.edit();

                            editor.putString("user", et1.getText().toString());
                            editor.putString("passw", et2.getText().toString());
                            editor.commit();

                            Toast.makeText(MainActivity.this, "Datos guardados", Toast.LENGTH_LONG).show();

                        }

                        Intent main_act_2 = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(main_act_2);

                    }

                    else {

                        Toast.makeText(MainActivity.this, "Las credenciales no son correctas", Toast.LENGTH_LONG).show();

                    }

                }
                else {
                    Toast.makeText(MainActivity.this, "Los campos 'Usuario' o 'Contraseña' están vacías", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}