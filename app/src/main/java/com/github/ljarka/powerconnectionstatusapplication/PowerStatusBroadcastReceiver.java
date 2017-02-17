package com.github.ljarka.powerconnectionstatusapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

public class PowerStatusBroadcastReceiver extends BroadcastReceiver {

    private final OnPowerStatusChangedListener listener;

    public PowerStatusBroadcastReceiver(@NonNull OnPowerStatusChangedListener listener) {
        this.listener = listener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_POWER_CONNECTED.equals(intent.getAction())) {
            listener.onPowerStatusChanged(true);
        } else if (Intent.ACTION_POWER_DISCONNECTED.equals(intent.getAction())) {
            listener.onPowerStatusChanged(false);
        }
    }
}
