package com.horngmail.invisible.authentication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoggedIn extends AppCompatActivity implements View.OnClickListener {

    private TextView viewTextEmail;
    private Button logoutButton, registerButton;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }

        viewTextEmail = (TextView) findViewById(R.id.viewTextEmail);
        logoutButton = (Button) findViewById(R.id.logoutButton);
        registerButton = (Button) findViewById(R.id.registerButton);

        FirebaseUser user = firebaseAuth.getCurrentUser();
        viewTextEmail.setText(user.getEmail());

        logoutButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        if(v == logoutButton){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
        else{
            finish();
            startActivity(new Intent(this, Register.class));
        }
    }
}
