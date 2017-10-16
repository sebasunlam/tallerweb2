package ar.edu.unlam.tallerweb2tp.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import ar.edu.unlam.tallerweb2tp.MainActivity;
import ar.edu.unlam.tallerweb2tp.R;

/**
 * Created by spardo on 16/10/17.
 */

public class Dialogs {
    public static AlertDialog alertDialog(Context context,String title,String message){
        AlertDialog alert = new AlertDialog.Builder(context, R.style.AlertDialogOpenMl).create();
        alert.setTitle(title);
        alert.setMessage(message);
        alert.setButton(AlertDialog.BUTTON_NEUTRAL,"ACEPTAR",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        return alert;
    }
}
