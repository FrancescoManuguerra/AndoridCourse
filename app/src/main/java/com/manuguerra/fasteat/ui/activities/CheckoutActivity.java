package com.manuguerra.fasteat.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.manuguerra.fasteat.R;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        getSupportActionBar().setTitle(R.string.checkout);


    }
}
