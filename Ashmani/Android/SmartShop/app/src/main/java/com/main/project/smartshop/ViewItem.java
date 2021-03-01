package com.main.project.smartshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class ViewItem extends AppCompatActivity {

    private TextView tvItemId;
    private TextView tvItemName;
    private TextView tvItemPrice;
    private SeekBar seekBar;
    private Button btnCart;
    private Button btnScan;
    private Button btn_view_cart;
    private static int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item);

        tvItemId = findViewById(R.id.tvItemId);
        tvItemName = findViewById(R.id.tvItemName);
        tvItemPrice = findViewById(R.id.tvItemPrice);
        seekBar = findViewById(R.id.seekBar);
        btnCart = findViewById(R.id.btn_cart);
        btnScan = findViewById(R.id.btn_scan2);
        btn_view_cart = findViewById(R.id.view_cart);


        Bundle extras = getIntent().getExtras();

        final String result[] = extras.getString("result").split("-");
        tvItemId.setText("Item ID : "+result[0]);
        tvItemName.setText("Item Name : "+result[1]);
        tvItemPrice.setText("Item Price : "+result[2]);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                count = progressChangedValue;
                Toast.makeText(ViewItem.this, "Selected item count is :" + count, Toast.LENGTH_SHORT).show();
            }
        });

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ViewItem.count > 0) {
                    CartItem cartItem = new CartItem();
                    cartItem.setItemId(result[0]);
                    cartItem.setItemName(result[1]);
                    cartItem.setItemPrice(Double.parseDouble(result[2]));
                    cartItem.setNoOfItems(ViewItem.count);

                    Cart.addItemToCart(result[0], cartItem);
                    Toast.makeText(ViewItem.this, "Item added successfully...", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ViewItem.this, "Please select the number of items...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewItem.this, ScanActivity.class);
                startActivity(intent);
            }
        });

        btn_view_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewItem.this, ViewCart.class);
                startActivity(intent);
            }
        });
    }
}
