package com.example.sgoyal5.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
      TextView usertv,passtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usertv = (TextView) findViewById(R.id.Ledituname);
        passtv=(TextView) findViewById(R.id.Leditpw);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public void OnLogin(View view)
    {
        if((usertv.getText().toString().equalsIgnoreCase("Sonali_Goyal@intuit.com"))&& (passtv.getText().toString().equalsIgnoreCase("pawansir05")))
        {
            Intent intent = new Intent(this,SecondActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this,"incorrect username or password" , Toast.LENGTH_LONG).show();

        }

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
