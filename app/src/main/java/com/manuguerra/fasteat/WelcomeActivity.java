package com.manuguerra.fasteat;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    protected String email;
    protected String password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //disegno gli oggeti xml
        TextView welcome_email_tv=findViewById(R.id.welcome_email_tv);
        TextView welcome_password_tv=findViewById(R.id.welcome_password_tv);

        //listener
        welcome_email_tv.setOnClickListener(this);

        Intent intent=getIntent();
        //mail to
        if(intent.getData()!=null){
            Uri data=intent.getData();
            email=data.toString();
            email=email.replace("mailto:","");
        }else {
            email = intent.getStringExtra(MainActivity.EMAIL_KEY);
            password = intent.getStringExtra(MainActivity.PASSWORD_KEY);
        }

        welcome_email_tv.setText(email);
        welcome_password_tv.setText(password);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.welcome_email_tv){

            Intent intent=new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"+email));
            startActivity(intent);
        }
    }
}

