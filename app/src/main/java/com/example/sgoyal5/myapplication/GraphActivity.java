package com.example.sgoyal5.myapplication;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by sgoyal5 on 7/3/15.
 */
public class GraphActivity extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_graph_activity);
        List<String> list = new ArrayList<String>();
        List<String> itemName = new ArrayList<String>();
        List<Integer> itemCount = new ArrayList<Integer>();

        String str="";
        StringBuffer buf = new StringBuffer();
        InputStream is = this.getResources().openRawResource(R.drawable.qty);
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(is));
        if (is!=null) {
            try {
                while ((str = reader.readLine()) != null) {
                    buf.append(str + "\n" );
                    String[] parts = str.split(",");
                    String name = parts[0];
                    Integer count = Integer.parseInt(parts[1]);
                    itemName.add(name);
                    itemCount.add(count);
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
        Buffer.itemCount = itemCount;
        Buffer.itemName=itemName;
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1,itemCount.toArray(new Integer[list.size()]));


        BarGraph bar = new BarGraph();
        Intent barIntent = bar.getIntent(this);
        startActivity(barIntent);

// Close it.


        Toast.makeText(this, "HH", Toast.LENGTH_LONG).show();
        //Log.e(TAG, ""+list.size());





    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
// Handle action bar item clicks here. The action bar will
// automatically handle clicks on the Home/Up button, so long
// as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    }

