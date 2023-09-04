package com.example.makeitrain;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.snackbar.Snackbar;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private TextView moneyValue;
    private ConstraintLayout constraintLayout;
    private int amount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moneyValue = findViewById(R.id.amount_value);
        constraintLayout = findViewById(R.id.constraint_layout);
    }

    public void showMoney(View view) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        amount += 1000;
        moneyValue.setText(numberFormat.format(amount));
        Log.d("MainActivity", "showMoney: $200k");
    }

    public void showInfo(View view){
        Snackbar.make(constraintLayout, R.string.snack_info, Snackbar.LENGTH_LONG).show();
    }
}