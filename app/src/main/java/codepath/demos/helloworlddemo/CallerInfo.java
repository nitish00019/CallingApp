package codepath.demos.helloworlddemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Harish on 23-02-2018.
 */

public class CallerInfo extends Activity {
    AlertDialog.Builder mAlertDlgBuilder;
    AlertDialog mAlertDialog;
    View mDialogView = null;
    Button mOKBtn, mCancelBtn;
    String text = null;
    TextView callerTextView;
    String phoneNumber = "prerana";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_main);


        if (getIntent().getStringExtra("PhoneNumber") != null) {
            phoneNumber = getIntent().getStringExtra("PhoneNumber");
        }
        phoneNumber = getIntent().getStringExtra(
                TelephonyManager.EXTRA_INCOMING_NUMBER);
        System.out.println("Phone number o activity " + phoneNumber);

        MyApiInterface myApiInterface = RetrofitClass.getInstance();

        Call<ResponseClass> call = myApiInterface.getPhoneNumber(phoneNumber);
        if (call != null) {
            call.enqueue(new Callback<ResponseClass>() {
                @Override
                public void onResponse(Call<ResponseClass> call, Response<ResponseClass> response) {
                    ResponseClass responseClass = response.body();
                    if (responseClass.getStatus().equalsIgnoreCase("success")) {
                        System.out.println("Status  " + responseClass.getStatus());
                        System.out.println("Name  " + responseClass.getName());
                        System.out.println("Email " + responseClass.getEmail());
                        text = responseClass.getName() + "\n" + responseClass.getEmail();
                    } else {
                        text = "Unknown";
                    }
                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            showdialogue();
                        }
                    }, 2000);


                }

                @Override
                public void onFailure(Call<ResponseClass> call, Throwable t) {
                    System.out.println("Failed");

                    //  showdialogue();
                }
            });

        } else {

            //showdialogue();
        }


    }





        // Build the dialog

    public  void dismissDialogue(){
        if(mAlertDialog.isShowing()){
            mAlertDialog.dismiss();
        }
    }



    public void showdialogue(){

        mAlertDlgBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        mDialogView = inflater.inflate(R.layout.dialog_layout, null);
        mOKBtn = (Button)mDialogView.findViewById(R.id.ID_Ok);
        callerTextView = (TextView)mDialogView.findViewById(R.id.caller_textview);
        mOKBtn.setOnClickListener(mDialogbuttonClickListener);
        callerTextView.setText(text);
        mAlertDlgBuilder.setCancelable(false);
        mAlertDlgBuilder.setInverseBackgroundForced(true);
        mAlertDlgBuilder.setView(mDialogView);
        mAlertDialog = mAlertDlgBuilder.create();
        mAlertDialog.show();

    }
    View.OnClickListener mDialogbuttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.ID_Ok)
            {
                mAlertDialog.dismiss();
                finish();
            }

        }
    };

}


