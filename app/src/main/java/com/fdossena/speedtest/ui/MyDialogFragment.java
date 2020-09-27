package com.fdossena.speedtest.ui;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
public class MyDialogFragment extends  DialogFragment {
    public boolean wifi_room;
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String title = "Ваше местоположение";
        String message = "Вы находитесь в комнате с WIFI роутером?";
        String button1String = "Да";
        String button2String = "Нет";
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title);  // заголовок
        builder.setMessage(message); // сообщение
        builder.setPositiveButton(button1String, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                wifi_room = true;
                FragmentManager manager = getFragmentManager();
                Dialog2 dialog2 = new Dialog2();
                dialog2.show(manager, "myDialog");
            }
        });
        builder.setNegativeButton(button2String, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                wifi_room = false;
                FragmentManager manager = getFragmentManager();
                Dialog2 dialog2 = new Dialog2();
                dialog2.show(manager, "myDialog");
            }
        });
        builder.setCancelable(false);

        return builder.create();
    }
}
