package com.android.material.androidmaterial;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class NewContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);

        Button button = (Button) findViewById(R.id.buttonAddContact);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goToContactList();
            }
        });
    }

    public void goToContactList(){
        finish();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

}
