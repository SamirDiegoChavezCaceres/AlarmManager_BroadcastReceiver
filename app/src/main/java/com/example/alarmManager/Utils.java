package com.example.alarmManager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import static android.content.Context.ALARM_SERVICE;

public class Utils {

    public static void setAlarm(int i, Long timestamp, Context ctx) {
        // Obtenemos el servicio de alarm manager
        AlarmManager alarmManager = (AlarmManager) ctx.getSystemService(ALARM_SERVICE);
        // creamos un pending intent para levantar el broadcast receiver al momento de la alarma
        Intent alarmIntent = new Intent(ctx, AlarmReceiver.class);
        PendingIntent pendingIntent;
        pendingIntent = PendingIntent.getBroadcast(ctx, i, alarmIntent, PendingIntent.FLAG_ONE_SHOT | PendingIntent.FLAG_IMMUTABLE);
        //A traves de setData podemos enviar informacion adicional al alarm receiver
        //En receiver podemos usar intent.getData para obtener los datos
        alarmIntent.setData((Uri.parse("custom://" + System.currentTimeMillis())));
        //en este caso usamos set para crear una sola alarma.
        // Aqui hay más informacion de las alarmar repetitivas
        // https://developer.android.com/reference/android/app/AlarmManager
        // https://developer.android.com/training/scheduling/alarms?hl=es-419
        alarmManager.set(AlarmManager.RTC_WAKEUP, timestamp, pendingIntent);
    }
}
