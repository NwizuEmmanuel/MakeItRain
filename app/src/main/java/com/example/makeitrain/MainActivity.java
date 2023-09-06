package com.example.makeitrain;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

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
        if (amount == 20000) {
            moneyValue.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.purple));
            Snackbar.make(constraintLayout, R.string.threshold_message, Snackbar.LENGTH_LONG).show();
        }else {
            moneyValue.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.black));
        }

        Log.d("MainActivity", "increased amount to " + amount);
    }

    public void showInfo(View view) {
        if (amount == 0) {
            Snackbar.make(constraintLayout, R.string.zero_amount_message, Snackbar.LENGTH_LONG).show();
        } else {
            Snackbar.make(constraintLayout, R.string.snack_info, Snackbar.LENGTH_LONG).show();
        }
    }
}