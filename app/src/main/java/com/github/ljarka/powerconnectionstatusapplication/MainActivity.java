package com.github.ljarka.powerconnectionstatusapplication;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity implements OnPowerStatusChangedListener {

    private PowerStatusBroadcastReceiver receiver;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receiver = new PowerStatusBroadcastReceiver(this);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);

        registerReceiver(receiver, intentFilter);

        imageView = (ImageView) findViewById(R.id.image_view);

        Glide.with(this).load("https://dl.dropboxusercontent.com/u/19835851/first.png").into(imageView);
    }

    @Override
    public void onPowerStatusChanged(boolean isConnected) {
        if (!isConnected) {
            Glide.with(this).load("https://dl.dropboxusercontent.com/u/19835851/first.png").into(imageView);
        } else {
            Glide.with(this).load("https://dl.dropboxusercontent.com/u/19835851/second.png").into(imageView);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
