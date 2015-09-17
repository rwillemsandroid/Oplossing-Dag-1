package be.vdab.simplelayout.activities;

import android.app.NotificationManager;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import be.vdab.simplelayout.R;

public class NavDrawerActivity extends AppCompatActivity {

    Button mNotifBtn;
    Button mSoundBtn;
    Button mAnimationBtn;
    Button mCountDownBtn;

    TextView mCouterTV;

    Animation mRotateAnimation;

    private static final String FORMAT = "%02d:%02d:%02d";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);

        //Set notification functionality
        mNotifBtn = (Button) findViewById(R.id.activity_nav_drawer_btn_notif);
        mNotifBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(NavDrawerActivity.this)
                                .setSmallIcon(R.drawable.ic_camera_white_24dp)
                                .setContentTitle("My notification")
                                .setContentText("Hello World!");

                // Sets an ID for the notification
                int mNotificationId = 001;
                // Gets an instance of the NotificationManager service
                NotificationManager mNotifyMgr =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                // Builds the notification and issues it.
                mNotifyMgr.notify(mNotificationId, mBuilder.build());

            }
        });

        //Set Sound functionality
        mSoundBtn = (Button) findViewById(R.id.activity_nav_drawer_btn_sound);
        mSoundBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mp;
                mp = MediaPlayer.create(NavDrawerActivity.this, R.raw.kzaluisietszeggense);
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        // TODO Auto-generated method stub
                        mp.reset();
                        mp.release();
                        mp=null;
                    }

                });
                mp.start();
            }
        });


        //Animation
        mRotateAnimation = AnimationUtils.loadAnimation(NavDrawerActivity.this, R.anim.rotate);
        mRotateAnimation.setRepeatCount(1);

        mAnimationBtn = (Button) findViewById(R.id.activity_nav_drawer_btn_anim);
        mAnimationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mRotateAnimation);
            }
        });

        mCouterTV = (TextView) findViewById(R.id.activity_nav_drawer_et_counter);
        mCountDownBtn = (Button) findViewById(R.id.activity_nav_drawer_btn_counter);
        mCountDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new CountDownTimer(10000, 1000) { // adjust the milli seconds here

                    public void onTick(long millisUntilFinished) {

                        mCouterTV.setText(""+String.format(FORMAT,
                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                                TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
                    }

                    public void onFinish() {
                        mCouterTV.setText("done!");
                    }
                }.start();


            }
        });



    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_nav_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
