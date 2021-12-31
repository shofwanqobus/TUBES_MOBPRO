package com.mobileprogramming.tubes_mobpro.Review;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRatingBar;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mobileprogramming.tubes_mobpro.Config;
import com.mobileprogramming.tubes_mobpro.Model.PostReview;
import com.mobileprogramming.tubes_mobpro.R;
import com.mobileprogramming.tubes_mobpro.Rest.ApiClient;
import com.mobileprogramming.tubes_mobpro.Rest.ApiInterface;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReviewActivity extends AppCompatActivity{


    public static final String EXTRA_NAMA = "extra_nama";
    public static final String EXTRA_POSTER = "extra_poster";

    TextView rateHasil, tvTempat;
    ImageView poster;
    EditText edtReview;
    AppCompatRatingBar ratingBar;

    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        tvTempat = (TextView) findViewById(R.id.tv_nama);
        poster = (ImageView) findViewById(R.id.img_poster);

        edtReview = (EditText) findViewById(R.id.edt_review);
        rateHasil = (TextView) findViewById(R.id.tv_rate_the_place);
        ratingBar = (AppCompatRatingBar) findViewById(R.id.rating_review);

        Button btnSubmit = (Button) findViewById(R.id.btn_review);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        String tempat = getIntent().getStringExtra(EXTRA_NAMA);
        String posterFile = getIntent().getStringExtra(EXTRA_POSTER);

        tvTempat.setText(tempat);
        Glide.with(ReviewActivity.this)
                .load(Config.IMAGE_URL + posterFile)
                .apply(new RequestOptions().placeholder(R.color.design_default_color_on_primary))
                .into(poster);

        btnSubmit.setOnClickListener((v) -> sendReview());
    }

    private void sendReview(){

        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> rateHasil.setText(String.valueOf(rating)));

        if (TextUtils.isEmpty(edtReview.getText().toString().trim())) {
            edtReview.setError("Review tidak boleh kosong!");
        }

        Call<PostReview> postReviewCall = mApiInterface.postReview("submit_post",
                RequestBody.create(MediaType.parse("text/plain"), rateHasil.getText().toString()),
                RequestBody.create(MediaType.parse("text/plain"), edtReview.getText().toString()));

        postReviewCall.enqueue(new Callback<PostReview>() {
            @Override
            public void onResponse(Call<PostReview> call, Response<PostReview> response) {
                ListReviewActivity.lra.showData();
                finish();
            }

            @Override
            public void onFailure(Call<PostReview> call, Throwable t) {
                Log.d("RETRO", "ON FAILURE : " + t.getMessage());
                Log.d("RETRO", "ON FAILURE : " + t.getCause());

                Toast.makeText(getApplicationContext(), "Failed to review the place!", Toast.LENGTH_LONG).show();
            }
        });

    }

}