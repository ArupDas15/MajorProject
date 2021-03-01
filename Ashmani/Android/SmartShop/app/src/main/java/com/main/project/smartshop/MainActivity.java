package com.main.project.smartshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void loginClick(View view) {
        Toast.makeText(this, " Login ", Toast.LENGTH_SHORT).show();
        Intent intent= new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    public void regClick(View view) {
        Intent intent= new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
}
