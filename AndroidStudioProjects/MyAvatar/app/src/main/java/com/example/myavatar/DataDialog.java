package com.example.myavatar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;


public class DataDialog extends DialogFragment {

    View view1;
    OnDataDialogListener ddl;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        EditText nombre;

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        view1 = inflater.inflate(R.layout.dialog1, null);

        builder.setView(view1);

        nombre = view1.findViewById(R.id.editTextTextPersonName);

        builder.setTitle(R.string.title_1).setPositiveButton(R.string.guardar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
                ddl.onDialogoGuardarNombreListener(nombre.getText().toString());
                ddl.goDialog2();


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
