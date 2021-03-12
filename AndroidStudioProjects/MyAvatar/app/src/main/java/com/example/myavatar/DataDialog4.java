package com.example.myavatar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DataDialog4 extends DialogFragment {

    View view1;
    OnDataDialogListener ddl;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        RadioButton arq;
        RadioButton gue;
        RadioButton mag;
        RadioButton her;

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        view1 = inflater.inflate(R.layout.dialog4, null);

        builder.setView(view1);

        arq = view1.findViewById(R.id.radioButton7);
        gue = view1.findViewById(R.id.radioButton8);
        mag = view1.findViewById(R.id.radioButton9);
        her = view1.findViewById(R.id.radioButton10);


        builder.setTitle(R.string.title_3).setPositiveButton(R.string.guardar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
                if(arq.isChecked()){
                    ddl.onDialogoGuardarIntListener((Integer)0);
                }
                else if (gue.isChecked()){
                    ddl.onDialogoGuardarIntListener((Integer)1);
                }
                else if (mag.isChecked()){
                    ddl.onDialogoGuardarIntListener((Integer)2);
                }
                else if (her.isChecked()){
                    ddl.onDialogoGuardarIntListener((Integer)3);
                }

                ddl.goEnd();

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
