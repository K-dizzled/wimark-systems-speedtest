package com.fdossena.speedtest.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.DialogFragment;
import android.content.SharedPreferences;
import android.util.Log;

public class Dialog2 extends DialogFragment {
    Context context = getActivity();
    public int room_count = -1;
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final String[] num_of_rooms = {"1", "2", "3", "4", "5", "6"};
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        SharedPreferences pref = getActivity().getSharedPreferences("number_of_rooms", 0); // 0 - for private mode
        builder.setTitle("Укажите количество комнат у вас в квартире");
                // добавляем переключатели
        builder.setSingleChoiceItems(num_of_rooms, pref.getInt("number_of_rooms", -1),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int item) {
                              room_count = item;
                              //Log.d("item", Integer.toString(item));
                              //Log.d("room_count", Integer.toString(room_count));
                                SharedPreferences pref1 = getActivity().getSharedPreferences("number_of_rooms", 0); // 0 - for private mode
                                SharedPreferences.Editor editor1 = pref1.edit();  //open settings editor
                                editor1.putInt("number_of_rooms", room_count); //save changes
                                editor1.apply();
                            }
                        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                   @Override
                    public void onClick(DialogInterface dialog, int id) {
                      // Log.d("room_count_after", Integer.toString(room_count));
                      // SharedPreferences pref1 = getActivity().getSharedPreferences("number_of_rooms", 0);
                      // Log.d("settings_after_writing", Integer.toString(pref1.getInt("number_of_rooms", -1)));
                    }
                });
        builder.setCancelable(false);
        return builder.create();
    }
}

