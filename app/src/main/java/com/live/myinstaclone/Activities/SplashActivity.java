package com.live.myinstaclone.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import com.live.myinstaclone.R;

public class SplashActivity extends Activity {

    ImageView insta_logo;
    TextView androrealm;
    TextView frm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (isOnline()) {

            load();
        } else {
            try {
                new AlertDialog.Builder(SplashActivity.this)
                        .setTitle("Error")
                        .setMessage("Internet not available, Check your internet connectivity")
                        .setCancelable(false)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                load();
                            }
                        }).show();
            } catch (Exception e) {
              //  Log.d(SyncStateContract.Constants.TAG, "Show Dialog: " + e.getMessage());
            }
        }
    }

    public boolean isOnline() {
        ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if(netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()){
            return false;
        }
        return true;
    }

    public void load(){
        insta_logo = (ImageView)findViewById(R.id.insta_logo);
        androrealm = (TextView)findViewById(R.id.androrealm);
        frm = (TextView)findViewById(R.id.from);

        insta_logo.animate().alpha(0f).setDuration(0);
        androrealm.animate().alpha(0f).setDuration(0);

        insta_logo.animate().alpha(1f).setDuration(1000).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                androrealm.animate().alpha(1f).setDuration(800);

            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        },3000);
    }
}