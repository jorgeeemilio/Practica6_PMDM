package com.example.myavatar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DataDialog3 extends DialogFragment {

    View view1;
    OnDataDialogListener ddl;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        RadioButton elf;
        RadioButton ena;
        RadioButton hob;
        RadioButton hum;

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        view1 = inflater.inflate(R.layout.dialog3, null);

        builder.setView(view1);

        elf = view1.findViewById(R.id.radioButton3);
        ena = view1.findViewById(R.id.radioButton4);
        hob = view1.findViewById(R.id.radioButton5);
        hum = view1.findViewById(R.id.radioButton6);


        builder.setTitle(R.string.title_3).setPositiveButton(R.string.guardar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
                if(elf.isChecked()){
                    ddl.onDialogoGuardarIntListener((Integer)0);
                }
                else if (ena.isChecked()){
                    ddl.onDialogoGuardarIntListener((Integer)1);
                }
                else if (hob.isChecked()){
                    ddl.onDialogoGuardarIntListener((Integer)2);
                }
                else if (hum.isChecked()){
                    ddl.onDialogoGuardarIntListener((Integer)3);
                }

                ddl.goDialog4();

            }
        }).setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
                ddl.onDialogoCancelarListener();

            }
        });





        return builder.create();
    }

    public void onAttach(Context context)
    {
        super.onAttach(context);
        try{
            ddl = (OnDataDialogListener) context;
        }
        catch(ClassCastException e)
        {
            throw new ClassCastException(context.toString());
        }
    }

}