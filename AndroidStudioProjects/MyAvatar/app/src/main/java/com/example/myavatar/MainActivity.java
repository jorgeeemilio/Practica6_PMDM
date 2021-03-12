package com.example.myavatar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnDataDialogListener {



    ArrayList <Integer> dataset = new ArrayList<>();
    TextView nombre;
    TextView vida;
    TextView magia;
    TextView fuerza;
    TextView velocidad;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.imageView);
        nombre = findViewById(R.id.textView5);
        vida = findViewById(R.id.textView);
        magia = findViewById(R.id.textView2);
        fuerza = findViewById(R.id.textView3);
        velocidad = findViewById(R.id.textView4);
        Button btn_nuevo = findViewById(R.id.button);



        btn_nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataDialog dialog_nombre;

                dialog_nombre = new DataDialog();
                dialog_nombre.setCancelable(false);
                dialog_nombre.show(getSupportFragmentManager(), "Nombre");

                dataset.clear();
                vida.setText(R.string.texto_1);
                magia.setText(R.string.texto_2);
                fuerza.setText(R.string.texto_3);
                velocidad.setText(R.string.texto_4);

            }
        });


    }

    @Override
    public void onDialogoGuardarNombreListener(String nombre) {
        this.nombre.setText(nombre);
    }

    @Override
    public void onDialogoGuardarIntListener(Integer numero) {
        dataset.add(numero);
    }



    @Override
    public void onDialogoCancelarListener() {

    }

    @Override
    public void goDialog2() {
        DataDialog2 dd2 = new DataDialog2();
        dd2.setCancelable(false);
        dd2.show(getSupportFragmentManager(), "Sexo");
    }

    @Override
    public void goDialog3() {
        DataDialog3 dd3 = new DataDialog3();
        dd3.setCancelable(false);
        dd3.show(getSupportFragmentManager(), "Raza");
    }

    @Override
    public void goDialog4() {

        DataDialog4 dd4 = new DataDialog4();
        dd4.setCancelable(false);
        dd4.show(getSupportFragmentManager(), "Clase");

    }

    @Override
    public void goEnd() {

        setImage(dataset);

        vida.append(Long.toString(Math.round(Math.random()*100)));
        magia.append(Long.toString(Math.round(Math.random()*10)));
        fuerza.append(Long.toString(Math.round(Math.random()*20)));
        velocidad.append(Long.toString(Math.round(Math.random()*5)));


    }

    private void setImage(ArrayList dataset) {

        if (dataset.get(0).equals(0)) {
            if (dataset.get(1).equals(0)) {
                if (dataset.get(2).equals(0)) {
                    img.setImageResource(R.drawable.elfo_arquero);

                }
                else if (dataset.get(2).equals(1)) {
                    img.setImageResource(R.drawable.elfo_guerrero);

                }
                else if (dataset.get(2).equals(2)) {
                    img.setImageResource(R.drawable.elfo_mago);

                }
                else if (dataset.get(2).equals(3)) {
                    img.setImageResource(R.drawable.elfo_herrero);

                }
            }

            else if (dataset.get(1).equals(1)) {
                if (dataset.get(2).equals(0)) {
                    img.setImageResource(R.drawable.enano_arquero);

                }
                else if (dataset.get(2).equals(1)) {
                    img.setImageResource(R.drawable.enano_guerrero);

                }
                else if (dataset.get(2).equals(2)){
                    img.setImageResource(R.drawable.enano_mago);

                }
                else if (dataset.get(2).equals(3)){
                    img.setImageResource(R.drawable.enano_herrero);

                }

            }

            else if (dataset.get(1).equals(2)) {
                if (dataset.get(2).equals(0)) {
                    img.setImageResource(R.drawable.hobbit_arquero);

                }
                else if (dataset.get(2).equals(1)) {
                    img.setImageResource(R.drawable.hobbit_guerrero);

                }
                else if (dataset.get(2).equals(2)) {
                    img.setImageResource(R.drawable.hobbit_mago);

                }
                else if (dataset.get(2).equals(3)) {
                    img.setImageResource(R.drawable.hobbit_herrero);

                }
            }

            else if (dataset.get(1).equals(3)) {
                if (dataset.get(2).equals(0)) {
                    img.setImageResource(R.drawable.humano_arquero);

                }
                else if (dataset.get(2).equals(1)) {
                    img.setImageResource(R.drawable.humano_guerrero);

                }
                else if (dataset.get(2).equals(2)) {
                    img.setImageResource(R.drawable.humano_mago);

                }
                else if (dataset.get(2).equals(3)) {
                    img.setImageResource(R.drawable.humano_herrero);

                }
            }

        }
        else if (dataset.get(0).equals(1)) {
            if (dataset.get(1).equals(0)) {
                if (dataset.get(2).equals(0)) {
                    img.setImageResource(R.drawable.elfa_arquera);

                }
                else if (dataset.get(2).equals(1)) {
                    img.setImageResource(R.drawable.elfa_guerrera);

                }
                else if (dataset.get(2).equals(2)) {
                    img.setImageResource(R.drawable.elfa_maga);

                }
                else if (dataset.get(2).equals(3)) {
                    img.setImageResource(R.drawable.elfa_herrera);

                }
            }

            else if (dataset.get(1).equals(1)) {
                if (dataset.get(2).equals(0)) {
                    img.setImageResource(R.drawable.enana_arquera);

                }
                else if (dataset.get(2).equals(1)) {
                    img.setImageResource(R.drawable.enana_guerrera);

                }
                else if (dataset.get(2).equals(2)){
                    img.setImageResource(R.drawable.enana_maga);

                }
                else if (dataset.get(2).equals(3)){
                    img.setImageResource(R.drawable.enana_herrera);

                }

            }

            else if (dataset.get(1).equals(2)) {
                if (dataset.get(2).equals(0)) {
                    img.setImageResource(R.drawable.hobbit_arquera);

                }
                else if (dataset.get(2).equals(1)) {
                    img.setImageResource(R.drawable.hobbit_guerrera);

                }
                else if (dataset.get(2).equals(2)) {
                    img.setImageResource(R.drawable.hobbit_maga);

                }
                else if (dataset.get(2).equals(3)) {
                    img.setImageResource(R.drawable.hobbit_herrera);

                }
            }

            else if (dataset.get(1).equals(3)) {
                if (dataset.get(2).equals(0)) {
                    img.setImageResource(R.drawable.humana_arquera);

                }
                else if (dataset.get(2).equals(1)) {
                    img.setImageResource(R.drawable.humana_guerrera);

                }
                else if (dataset.get(2).equals(2)) {
                    img.setImageResource(R.drawable.humana_maga);

                }
                else if (dataset.get(2).equals(3)) {
                    img.setImageResource(R.drawable.humana_herrera);

                }
            }

        }

    }
}