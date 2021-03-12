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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DataDialog2 extends DialogFragment {

    View view1;
    OnDataDialogListener ddl;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        RadioButton sexoM;

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        view1 = inflater.inflate(R.layout.dialog2, null);

        builder.setView(view1);

        sexoM = view1.findViewById(R.id.radioButton);


        builder.setTitle(R.string.title_2);
        builder.setPositiveButton(R.string.guardar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                ddl.goDialog3();
                if (sexoM.isChecked()) {
                    ddl.onDialogoGuardarIntListener((Integer) 0);
                } else {
                    ddl.onDialogoGuardarIntListener((Integer) 1);
                }


                dialog.dismiss();

            }
        });
        builder.setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
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
