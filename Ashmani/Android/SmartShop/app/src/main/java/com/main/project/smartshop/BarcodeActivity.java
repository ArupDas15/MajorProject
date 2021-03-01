package com.main.project.smartshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

public class BarcodeActivity extends AppCompatActivity {

    public static TextView tvresult;
    private Button btn;
    private Button btnlogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode);

    }

    public void scanItemClick(View view) {
        Intent intent = new Intent(BarcodeActivity.this, ScanActivity.class);
        startActivity(intent);
    }

    public void viewCartClick(View view) {
        Intent intent = new Intent(BarcodeActivity.this, ViewCart.class);
        startActivity(intent);
    }

    public void logoutClick(View view) {
        Intent intent = new Intent(BarcodeActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        Toast.makeText(BarcodeActivity.this, "! You have successfully logged out. Hope to see u again !", Toast.LENGTH_SHORT).show();

    }
}
