package com.example.sgoyal5.myapplication;
import android.widget.Toast;

import java.io.*;
/**
 * Created by sgoyal5 on 7/3/15.
 */
public class Learning {
    public static void main(String[] args) throws IOException {
// set up the command and parameter
        String pythonScriptPath = "holtwinters.py";
        String[] cmd = new String[2];
        cmd[0] = "python2.6";
        cmd[1] = pythonScriptPath;

// create runtime to execute external command
        Runtime rt = Runtime.getRuntime();
        Process pr = rt.exec(cmd);

// retrieve output from python script
        BufferedReader bfr = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line = "";
        while((line = bfr.readLine()) != null) {
// display each output line form python script
            System.out.println(line);

        }
    }
}
