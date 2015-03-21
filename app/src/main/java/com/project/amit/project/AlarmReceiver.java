package com.project.amit.project; /**
 * Created by Amit on 07-03-2015.
 */
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {
    private NotificationManager mNotificationManager;
    private int SIMPLE_NOTFICATION_ID;

    @Override
    public void onReceive(Context context, Intent arg1) {
        // For our recurring task, we'll just display a message

        mNotificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notifyDetails = new Notification(R.drawable.q,"Question Of The Day!",System.currentTimeMillis());
        PendingIntent myIntent = PendingIntent.getActivity(context, 0, new Intent(context, Notifications.class), 0);
        notifyDetails.setLatestEventInfo(context,"Question Of The Day!","Click to view the question", myIntent);
        notifyDetails.flags |= Notification.FLAG_AUTO_CANCEL;
        mNotificationManager.notify(SIMPLE_NOTFICATION_ID, notifyDetails);



    }

}
