import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "AlarmChannel";
    private TimePicker alarmTimePicker;
    private Button setAlarmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the views from the layout
        alarmTimePicker = findViewById(R.id.alarm_time_picker);
        setAlarmButton = findViewById(R.id.set_alarm_button);

        // Set a click listener for the set alarm button
        setAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the alarm time
                int hour = alarmTimePicker.getHour();
                int minute = alarmTimePicker.getMinute();

                // Create a calendar object with the alarm time
                Calendar alarmCalendar = Calendar.getInstance();
                alarmCalendar.set(Calendar.HOUR_OF_DAY, hour);
                alarmCalendar.set(Calendar.MINUTE, minute);

                // Create a handler to show the notification after the alarm time
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Show the notification
                        showNotification();
                    }
                }, alarmCalendar.getTimeInMillis() - Calendar.getInstance().getTimeInMillis());
            }
        });
    }

    private void showNotification() {
        // Create a notification manager
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // Create a notification channel for Android O and higher
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Alarm", NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(channel);
        }

        // Create a notification builder
        Notification.Builder builder = new Notification.Builder(this, CHANNEL_ID)
                .setContentTitle("Alarm")
                .setContentText("Time to wake up!")
                .setSmallIcon(R.drawable.ic_launcher_foreground);

        // Show the notification
        notificationManager.notify(0, builder.build());
    }
}
