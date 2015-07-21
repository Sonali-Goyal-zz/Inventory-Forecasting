package com.example.sgoyal5.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

/**
 * Created by sgoyal5 on 7/3/15.
 */
public class SecondActivity extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_second);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Your stock for Testing has reached below expected limit of 85. Would you like to notify the vendor");

        alertDialogBuilder.setPositiveButton("I Agree", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage("9663429400", null, "Order from Company Intuit. Place an order for Testing. Quantity Required= 85 units for this week.", null, null);
                    Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
                }

                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "SMS faild, please try again.", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               dialog.dismiss();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
   public void OnShowStatus(View view)
   {
       Intent intent = new Intent(this,GraphActivity.class);
       startActivity(intent);
   }

    public void OnSalesReceipt(View view)
    {
        Intent intent = new Intent(this,ItemList.class);
        startActivity(intent);
    }
    public void OnShowMessage(View view)
    {
        Intent intent = new Intent(this,ShowMessageActivity.class);
        startActivity(intent);
    }

}
