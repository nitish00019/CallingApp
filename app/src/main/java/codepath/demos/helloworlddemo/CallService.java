package codepath.demos.helloworlddemo;

import android.app.IntentService;
import android.content.ComponentName;
import android.content.Intent;
import android.telephony.TelephonyManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class CallService extends IntentService {
    public CallService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(final Intent intent) {

        String phoneNumber =  intent.getStringExtra(
                TelephonyManager.EXTRA_INCOMING_NUMBER);
        System.out.println("Incoming phone numberr is "+ phoneNumber);


    }
}
