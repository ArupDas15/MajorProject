package com.main.project.smartshop;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class LoginActivity extends AppCompatActivity {
    public static final String PREFS_NAME = "MyPrefsFile";
    private static final String PREF_USERNAME = "username";
    private static final String PREF_PASSWORD = "password";
    EditText usr;
    EditText pwd;
    Button lbtn, btnsetip;
    Intent intent = null;
    String usn, pass, res, mob;

    SQLiteDemo demo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usr = findViewById(R.id.usn);
        pwd = findViewById(R.id.pw);
        lbtn = findViewById(R.id.loginbtn);
//        btnsetip = findViewById(R.id.btn_setip);
        /*to store username and password*/
        SharedPreferences pref = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String username = pref.getString(PREF_USERNAME, null);
        String password = pref.getString(PREF_PASSWORD, null);
        if (username == null || password == null) {
            getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
                    .edit()
                    .putString(PREF_USERNAME, usr.getText().toString())
                    .putString(PREF_PASSWORD, pwd.getText().toString())
                    .apply();
        } else {
            usr.setText(username);
            pwd.setText(password);
        }

        //add the function to connect to database
        lbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
                        .edit()
                        .putString(PREF_USERNAME, usr.getText().toString())
                        .putString(PREF_PASSWORD, pwd.getText().toString())
                        .apply();
                usn = usr.getText().toString().trim();
                pass = pwd.getText().toString().trim();
                demo = new SQLiteDemo(getApplicationContext());
                ArrayList<String[]> arrayList = demo.getData();

                if (!arrayList.isEmpty()) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        String[] st = arrayList.get(i);
                        if (st[1].equals(usn) && st[2].equals(pass)) {
                            Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            mob = demo.getMobileNo(usn);
                            Toast.makeText(LoginActivity.this, "-----"+ mob, Toast.LENGTH_SHORT).show();
                            try {
                                new LoadWallet().execute(new URL(Global.getUrlString() + "LoadUserWallet"));
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                            intent = new Intent(LoginActivity.this, BarcodeActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
                else{
                    Toast.makeText(LoginActivity.this, "You have not registered yet...", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        btnsetip.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(LoginActivity.this, SetIPActivity.class);
//                startActivity(intent);
//            }
//        });

    }

    private class LoadWallet extends AsyncTask<URL, Void, String> {

        @Override
        protected String doInBackground(URL... urls) {

            try {
                URL url = urls[0];
                JSONObject jsn = new JSONObject();
                jsn.put("mob", mob);
                String response = HttpClientConnection.executeClient(url, jsn);
                res = response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return res;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
        }
    }

}
