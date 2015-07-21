package com.example.sgoyal5.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * Created by sgoyal5 on 7/3/15.
 */
public class ShowMessageActivity extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_showmessage);
        String str="";
        StringBuffer buf = new StringBuffer();
        InputStream is = this.getResources().openRawResource(R.drawable.output);
        BufferedReader reader;
        String[] parts = null;
        reader = new BufferedReader(new InputStreamReader(is));
        if (is!=null) {
            try {
                while ((str = reader.readLine()) != null) {
                    buf.append(str + "\n" );
                    parts = str.split(" ");
                }
            } catch (IOException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try {
            is.close();
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        TextView mon = (TextView) findViewById(R.id.monday);
        TextView tue = (TextView) findViewById(R.id.tuesday);
        TextView wed = (TextView) findViewById(R.id.wednesday);
        TextView thu = (TextView) findViewById(R.id.thursday);
        TextView fri = (TextView) findViewById(R.id.friday);
        TextView sat = (TextView) findViewById(R.id.saturday);
        TextView sun = (TextView) findViewById(R.id.sunday);
        mon.setText(parts[0].toString());
        tue.setText(parts[1].toString());
        wed.setText(parts[2].toString());
        thu.setText(parts[3].toString());
        fri.setText(parts[4].toString());
        sat.setText(parts[5].toString());
        sun.setText(parts[6].toString());

    }
}
