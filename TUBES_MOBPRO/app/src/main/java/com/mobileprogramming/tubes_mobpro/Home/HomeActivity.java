package com.mobileprogramming.tubes_mobpro.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mobileprogramming.tubes_mobpro.R;

public class HomeActivity extends AppCompatActivity {

    public static HomeActivity ha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ha = this;
        home();
    }

    public void home(){
        
    }
}