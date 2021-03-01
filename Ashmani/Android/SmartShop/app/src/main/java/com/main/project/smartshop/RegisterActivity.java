package com.main.project.smartshop;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {
    EditText etfname;
    EditText etlname;
    EditText etemail;
    EditText etpass;
    EditText etcpass;
    EditText etphone;
    TextView tvdob;
    Button btnReg;
    RadioButton rbtn;
    RadioGroup rdgrp;
    String sfname, slname, semail, spass;
    String scpass, sphone, sdob, sgender;
    Button btnDisplay;

    TextView textView;
    Calendar mCurrentDate;
    int d, m, y;
    String res;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        rdgrp = findViewById(R.id.rgrp);
        etfname = findViewById(R.id.fnametxt);
        etlname = findViewById(R.id.lnametxt);
        etemail = findViewById(R.id.emailtxt);
        etpass = findViewById(R.id.stdpwd);
        etcpass = findViewById(R.id.stdcpwd);
        etphone = findViewById(R.id.phonetxt);
        tvdob = findViewById(R.id.datetxt);
        btnReg = findViewById(R.id.button);
        int rdBtnID = rdgrp.getCheckedRadioButtonId();
        rbtn = findViewById(rdBtnID);


        etpass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasfocus) {
                if (etpass.getText().length() < 6) {
                    etpass.setError("Password must be minimum 6 char");
                }
            }
        });
        etphone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasfocus) {
                if (etphone.getText().length() > 10) {
                    etphone.setError("Invalid Number");
                }
            }
        });


        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sfname = etfname.getText().toString().trim();
                slname = etlname.getText().toString().trim();
                semail = etemail.getText().toString().trim();
                spass = etpass.getText().toString().trim();
                scpass = etcpass.getText().toString().trim();
                sphone = etphone.getText().toString().trim();
                sdob = tvdob.getText().toString().trim();
                sgender = rbtn.getText().toString().trim();
//                Toast.makeText(RegisterActivity.this, sfname + "\n" + sgender + "\n" + semail + "\n" +
//                        "" + spass + "\n" + scpass + "\n" + sphone + "\n" + sdob, Toast.LENGTH_LONG).show();

                if (sfname.isEmpty() || slname.isEmpty() || semail.isEmpty() || spass.isEmpty() || scpass.isEmpty()
                        || sphone.isEmpty() || sdob.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Fill in all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (!spass.equals(scpass)) {
                        etpass.setError("Password Mismatch");
                        etcpass.setError("Password Mismatch");
                    } else {
                        String name = sfname + " " + slname;
                        SQLiteDemo demo = new SQLiteDemo(getApplicationContext());
                        long val = demo.regData(name, semail, spass, sphone, sdob, sgender);
                        Toast.makeText(RegisterActivity.this, val + " User registered successfully", Toast.LENGTH_SHORT);

                        try {
                            new SendData().execute(new URL(Global.getUrlString() + "CreateWallet"));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }


                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }


            }
        });


        textView = findViewById(R.id.datetxt);
        mCurrentDate = Calendar.getInstance();
        d = mCurrentDate.get(Calendar.DAY_OF_MONTH);
        m = mCurrentDate.get(Calendar.MONTH);
        y = mCurrentDate.get(Calendar.YEAR);

        m = m + 1;
        textView.setText(d + "/" + m + "/" + y);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(RegisterActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        monthOfYear = monthOfYear + 1;
                        textView.setText(dayOfMonth + "/" + monthOfYear + "/" + year);
                    }
                }, y, m, d);

                datePickerDialog.show();
            }
        });
    }


    public void rbclick(View v) {
        int radiobtnid = rdgrp.getCheckedRadioButtonId();
        rbtn = findViewById(radiobtnid);
    }

    private class SendData extends AsyncTask<URL, Void, String> {

        @Override
        protected String doInBackground(URL... urls) {

            try {
                URL url = urls[0];
                JSONObject jsn = new JSONObject();
                jsn.put("uid", semail);
                jsn.put("mob", sphone);
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

