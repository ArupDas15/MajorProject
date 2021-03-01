package com.main.project.smartshop;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewCart extends AppCompatActivity {

    ListView listView;
    Button btn_buy, btn_logout;
    ArrayAdapter<String> adapter;


    String res = "";
    double totalcost = 0.0;

    String uemail = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cart);

        btn_buy = findViewById(R.id.btn_trnxn);
        btn_logout = findViewById(R.id.btn_logout);
        listView = findViewById(R.id.list_item);

        SharedPreferences pref = getSharedPreferences("MyPrefsFile", MODE_PRIVATE);
        uemail = pref.getString("username", null);

        String arr[] = new String[Cart.getMyCart().size()];
        int count = 0;
        for (Map.Entry entry : Cart.getMyCart().entrySet()) {
            CartItem citem = (CartItem) entry.getValue();
            arr[count] = "Id : " + citem.getItemId() + "\nName : " + citem.getItemName() + "\nPrice : " + citem.getItemPrice() + "\nItem Count : " + citem.getNoOfItems();
            totalcost += citem.getItemPrice() * citem.getNoOfItems();
            count++;
        }
        adapter = new ArrayAdapter<>(this, R.layout.activity_list_view_item, R.id.textView, arr);

        listView.setAdapter(adapter);


        btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Cart.getMyCart().size() > 0) {
                    Toast.makeText(ViewCart.this, "The total cost of all items : " + totalcost, Toast.LENGTH_SHORT).show();
                    try {
                        new BuyCartItem().execute(new URL(Global.getUrlString() + "BuyItems"));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    Cart.refreshCart();
                    Intent intent = getIntent();
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    finish();
                    startActivity(intent);
                } else {
                    Toast.makeText(ViewCart.this, "Your Cart is empty...", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewCart.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                Toast.makeText(ViewCart.this, "! You have successfully logged out. Hope to see u again !", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class BuyCartItem extends AsyncTask<URL, Void, String> {

        @Override
        protected String doInBackground(URL... urls) {

            try {
                URL url = urls[0];
                JSONObject jsn = new JSONObject();
                jsn.put("mob", new SQLiteDemo(getApplicationContext()).getMobileNo(uemail));
                jsn.put("total", totalcost);

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
