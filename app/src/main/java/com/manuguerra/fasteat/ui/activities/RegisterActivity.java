package com.manuguerra.fasteat.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.manuguerra.fasteat.R;
import com.manuguerra.fasteat.Utilities;

public class RegisterActivity extends AppCompatActivity {

    //declaration of activity's component
    EditText email_register_et;
    EditText password_register_et;
    EditText confirm_password_register_et;
    EditText register_number;
    Button confirm_register_btn;
    private final static String TAG= RegisterActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //quando i dati sono corretti, il bottone si attiva
        email_register_et = findViewById(R.id.email_register_et);
        password_register_et = findViewById(R.id.password_register_et);
        confirm_password_register_et = findViewById(R.id.confirm_password_register_et);
        register_number = findViewById(R.id.register_number);
        confirm_register_btn = findViewById(R.id.confirm_register_btn);

        //component with TextWatcher
        email_register_et.addTextChangedListener(textWatcher);
        password_register_et.addTextChangedListener(textWatcher);
        confirm_password_register_et.addTextChangedListener(textWatcher);

    }

    //Classe per ascoltare costantemente i cambiamenti dei componenti
    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            Log.i("RegisterBefore", s.toString());
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String email = email_register_et.getText().toString().trim();
            String password = password_register_et.getText().toString().trim();
            String confirm_password = confirm_password_register_et.getText().toString().trim();
            String number= register_number.getText().toString();
            Log.i("RegisteronChange", s.toString());
            confirm_register_btn.setEnabled(Utilities.emailControll(email) && Utilities.passwordControll(password,confirm_password) && Utilities.numberControll(number));

        }
        @Override
        public void afterTextChanged(Editable s) {
            Log.i("RegisterAfter",s.toString());
        }
    };

}

