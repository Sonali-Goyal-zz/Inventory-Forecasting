package com.example.sgoyal5.myapplication;
import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sgoyal5 on 7/3/15.
 */
public class ItemList extends Activity {

    private ListView listview1;
    List<String> list = new ArrayList<String>();
    String str = "";
    StringBuffer buf = new StringBuffer();

    BufferedReader reader;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_list_layout);
        List<String> list = new ArrayList<String>();
        List<String> itemName = new ArrayList<String>();
        List<Integer> itemCount = new ArrayList<Integer>();
        final InputStream is = this.getResources().openRawResource(R.drawable.qty);

        reader = new BufferedReader(new InputStreamReader(is));
        if (is!=null) {
            try {
                while ((str = reader.readLine()) != null) {
                    buf.append(str + "\n");
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

        Buffer.itemCount = itemCount;
        Buffer.itemName=itemName;
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1,itemName.toArray(new String[list.size()]));

        ListView listView = (ListView) findViewById(R.id.lv);
        if(adapter==null)
        {
            Toast.makeText(this, "null", Toast.LENGTH_LONG).show();
        }
        else
        {
            listView.setAdapter(adapter);
        }


// Close it.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {


            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3) {
                Toast.makeText(getApplicationContext(), Integer.valueOf(position).toString(), Toast.LENGTH_LONG).show();



            }
            });

            try {
                is.close();
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }


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
