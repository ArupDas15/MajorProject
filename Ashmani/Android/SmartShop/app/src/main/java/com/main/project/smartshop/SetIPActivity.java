package com.main.project.smartshop;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SetIPActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "MyPrefsFile";
    private static final String PREF_IP = "ipaddress";

    EditText editText;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_ip);

        editText = findViewById(R.id.et_set_ip);
        btn = findViewById(R.id.submit_ip);

        SharedPreferences pref = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String ip_addr = pref.getString(PREF_IP, null);

        if (ip_addr == null) {
            getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
                    .edit()
                    .putString(PREF_IP, editText.getText().toString())
                    .apply();
        } else {
            editText.setText(ip_addr);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
                        .edit()
                        .putString(PREF_IP, editText.getText().toString())
                        .apply();
                String ip = editText.getText().toString();
                if(ip.length() >= 12) {
                    new Global(ip);
                    Toast.makeText(SetIPActivity.this, Global.getUrlString(), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(SetIPActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(SetIPActivity.this, "Please check your ip address length", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
