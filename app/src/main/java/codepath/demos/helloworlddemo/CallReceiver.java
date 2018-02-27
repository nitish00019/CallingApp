package codepath.demos.helloworlddemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.method.TextKeyListener;
import android.util.Log;

/**
 * Created by Harish on 23-02-2018.
 */


   /* public class ServiceReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(final Context context, final Intent intent) {
            TelephonyManager telephony = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
            telephony.listen(new PhoneStateListener(){
                @Override
                public void onCallStateChanged(int state, String incomingNumber) {
                    super.onCallStateChanged(state, incomingNumber);


                    Intent alarmIntent = new Intent(context, AlarmDialogPopUp.class);
                    alarmIntent.putExtra(intent);
                    alarmIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    // Start the popup activity
                    context.startActivity(alarmIntent);
                    *//*if(state==TelephonyManager.CALL_STATE_RINGING) {
                        System.out.println("incomingNumber : " + incomingNumber);
                        Intent alarmIntent = new Intent(context, AlarmDialogPopUp.class);
                        alarmIntent.putExtra("PhoneNumber ", incomingNumber.toString());
                        alarmIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        // Start the popup activity
                        context.startActivity(alarmIntent);
                    }else if(state == TelephonyManager.CALL_STATE_OFFHOOK){
                        System.out.println("incomingNumber : " + incomingNumber);
                        Intent alarmIntent = new Intent(context, AlarmDialogPopUp.class);
                        alarmIntent.putExtra("PhoneNumber ", "Juhi");
                        alarmIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        // Start the popup activity
                        context.startActivity(alarmIntent);
                    }*//*

                }
            },PhoneStateListener.LISTEN_CALL_STATE);




        }
    }
*/


public class CallReceiver extends BroadcastReceiver {





    @Override
    public void onReceive(Context context, Intent intent) {

       /* Log.d("IncomingBroadcastReceiver: onReceive: ", "flag1");*/

        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        /*Log.d("IncomingBroadcastReceiver: onReceive: ", state);*/
        if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)
                ) {

             Log.d("Ringing", "Phone is ringing");
             if(intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER)!=null) {
                 System.out.println("Incoming number is "+intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER));
                 Intent i = new Intent(context, CallerInfo.class);
                 i.putExtras(intent);
                 i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                 i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                 context.startActivity(i);

             }
             if(state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)){
                 System.out.println("Call is connected");
                // context.sendBroadcast(new Intent("YOUR_TAG"));
             }
           /* Wait.oneSec();*/

        }
    }

}

