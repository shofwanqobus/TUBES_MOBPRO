package com.mobileprogramming.tubes_mobpro.LogIn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mobileprogramming.tubes_mobpro.Home.HomeActivity;
import com.mobileprogramming.tubes_mobpro.Model.PostLogin;
import com.mobileprogramming.tubes_mobpro.R;
import com.mobileprogramming.tubes_mobpro.Rest.ApiClient;
import com.mobileprogramming.tubes_mobpro.Rest.ApiInterface;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity{

    private EditText username, password;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Deklarasi Object
        username = (EditText) findViewById(R.id.edt_username);
        password = (EditText) findViewById(R.id.edt_password);
        Button btnLogin = (Button) findViewById(R.id.btn_login);

        // API
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        // Login
        btnLogin.setOnClickListener((v) -> login());

        if (savedInstanceState != null){
            Intent ha = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(ha);
        }
    }

    private void login(){
        if (TextUtils.isEmpty(username.getText().toString().trim())){
            username.setError("Field tidak boleh kosong!");
            return;
        }

        if (TextUtils.isEmpty(password.getText().toString().trim())){
            username.setError("Field tidak boleh kosong!");
            return;
        }

        Call<PostLogin> postLoginCall = mApiInterface.postLogin("index_post",
                RequestBody.create(MediaType.parse("text/plain"), username.getText().toString()),
                RequestBody.create(MediaType.parse("text/plain"), password.getText().toString()));

        postLoginCall.enqueue(new Callback<PostLogin>() {
            @Override
            public void onResponse(Call<PostLogin> call, Response<PostLogin> response) {
                HomeActivity.ha.home(); //Ini blom buat nanti sehabis login
                finish();
            }

            @Override
            public void onFailure(Call<PostLogin> call, Throwable t) {
                Log.d("RETRO", "ON FAILURE : " + t.getMessage());
                Log.d("RETRO", "ON FAILURE : " + t.getCause());

                Toast.makeText(getApplicationContext(), "Error, login gagal!", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {// API 5+ Solution
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}