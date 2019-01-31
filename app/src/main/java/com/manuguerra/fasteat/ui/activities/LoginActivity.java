package com.manuguerra.fasteat.ui.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.manuguerra.fasteat.R;
import com.manuguerra.fasteat.Utilities;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    public final static String EMAIL_KEY= "email";
    public final static String PASSWORD_KEY="password";
    private TextView login;
    private EditText email_et;
    private EditText password_et;
    private Button login_btn;
    private Button register_btn;
    private Switch login_switch;
    private LinearLayout activity_main;

    Intent pageLogin=new Intent();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //attach to this Activity the activity_layout.xml file
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle(R.string.Login);

        //dichiarazione componenti xml
        email_et=findViewById(R.id.email_et);
        password_et=findViewById(R.id.password_et);
        login_btn=findViewById(R.id.login_btn);
        register_btn=findViewById(R.id.register_btn);
        login_switch=findViewById(R.id.login_switch);
        login=findViewById(R.id.login);
        activity_main=findViewById(R.id.activity_main_layout);

        //settaggio listener
        login_btn.setOnClickListener(this);
        register_btn.setOnClickListener(this);

        login_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    activity_main.setBackgroundColor(ContextCompat.getColor(LoginActivity.this, R.color.colorTotalBlack));
                    email_et.setHintTextColor(ContextCompat.getColor(LoginActivity.this, R.color.colorWhite));
                    password_et.setHintTextColor(ContextCompat.getColor(LoginActivity.this, R.color.colorWhite));

                    login.setTextColor(ContextCompat.getColor(LoginActivity.this, R.color.colorWhite));
                    email_et.setTextColor(ContextCompat.getColor(LoginActivity.this, R.color.colorWhite));
                    password_et.setTextColor(ContextCompat.getColor(LoginActivity.this, R.color.colorWhite));
                    login_btn.setTextColor(ContextCompat.getColor(LoginActivity.this, R.color.colorWhite));
                    register_btn.setTextColor(ContextCompat.getColor(LoginActivity.this, R.color.colorWhite));
                }
                else {
                    activity_main.setBackgroundColor(ContextCompat.getColor(LoginActivity.this, R.color.colorWhite));
                    email_et.setTextColor(ContextCompat.getColor(LoginActivity.this, R.color.colorTotalBlack));
                    password_et.setTextColor(ContextCompat.getColor(LoginActivity.this, R.color.colorTotalBlack));
                    login.setTextColor(ContextCompat.getColor(LoginActivity.this, R.color.colorTotalBlack));

                    email_et.setHintTextColor(ContextCompat.getColor(LoginActivity.this, R.color.colorTotalBlack));
                    password_et.setHintTextColor(ContextCompat.getColor(LoginActivity.this, R.color.colorTotalBlack));

                    login_btn.setTextColor(ContextCompat.getColor(LoginActivity.this, R.color.colorTotalBlack));
                    register_btn.setTextColor(ContextCompat.getColor(LoginActivity.this, R.color.colorTotalBlack ));
                }
            }
        });
    }



    @Override
    public void onClick(View v) {
        //TODO DO SOMETHING

        if(v.getId()==R.id.login_btn){
            //go to id page
            doLogin();
        }
        if(v.getId()==R.id.register_btn){
            //go to register page
            Intent intent_register=new Intent(this,RegisterActivity.class);
            startActivity(intent_register);
        }
    }

    private void doLogin(){

        String email=email_et.getText().toString();
        String password=password_et.getText().toString();

        if(Utilities.emailControll(email)&& Utilities.passwordControll(password)){
            Toast.makeText(this, getString(R.string.login_done), Toast.LENGTH_SHORT).show();

            Intent intent=new Intent(this, WelcomeActivity.class);
            intent.putExtra(LoginActivity.EMAIL_KEY,email);
            intent.putExtra(LoginActivity.PASSWORD_KEY,password);
            startActivity(intent);
        }else{
            Toast.makeText(this,getString(R.string.error_email),Toast.LENGTH_LONG).show();
        }
    }

}
