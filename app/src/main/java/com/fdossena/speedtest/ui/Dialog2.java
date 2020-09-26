package com.fdossena.speedtest.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.DialogFragment;

public class Dialog2 extends DialogFragment {
    public int room_count = 0;
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final String[] num_of_rooms = {"1", "2", "3", "4", "5", "6"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Выберите любимое имя кота")
                // добавляем переключатели
                .setSingleChoiceItems(num_of_rooms, -1,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int item) {
                             room_count = item;
                            }
                        })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                   @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        return builder.create();
    }
}

