package ao.co.isptec.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

public class MyPhoneReceiver extends BroadcastReceiver {

    private static final String TAG = "MyPhoneReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        if (TelephonyManager.ACTION_PHONE_STATE_CHANGED.equals(intent.getAction())) {
            String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);

            if (TelephonyManager.EXTRA_STATE_RINGING.equals(state)) {
                if (incomingNumber != null) {
                    Log.i(TAG, "Incoming call from: " + incomingNumber);
                } else {
                    Log.i(TAG, "Incoming call from an unknown number");
                }
            } else if (TelephonyManager.EXTRA_STATE_OFFHOOK.equals(state)) {
                Log.i(TAG, "Call connected");
            } else if (TelephonyManager.EXTRA_STATE_IDLE.equals(state)) {
                Log.i(TAG, "Call disconnected");
            }
        }
    }
}