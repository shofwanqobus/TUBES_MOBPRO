package com.mobileprogramming.tubes_mobpro.Review;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.mobileprogramming.tubes_mobpro.Adapter.ReviewAdapter;
import com.mobileprogramming.tubes_mobpro.Model.GetReview;
import com.mobileprogramming.tubes_mobpro.Model.Review;
import com.mobileprogramming.tubes_mobpro.R;
import com.mobileprogramming.tubes_mobpro.Rest.ApiClient;
import com.mobileprogramming.tubes_mobpro.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListReviewActivity extends AppCompatActivity {

    private RecyclerView rvListReview;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    ApiInterface mApiInterface;

    public static ListReviewActivity lra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_review);

        rvListReview = (RecyclerView) findViewById(R.id.rv_list_review);
        mLayoutManager = new LinearLayoutManager(this);

        rvListReview.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        lra = this;
        showData();
    }

    public void showData(){
        Call<GetReview> getReviewCall = mApiInterface.getReview("index_get");
        getReviewCall.enqueue(new Callback<GetReview>() {
            @Override
            public void onResponse(Call<GetReview> call, Response<GetReview> response) {
                List<Review> reviewList = response.body().getReviewList();
                Log.d("Retrofit Get", "Jumlah data review : " + reviewList.size());

                rvAdapter = new ReviewAdapter(reviewList);
                rvListReview.setAdapter(rvAdapter);
            }

            @Override
            public void onFailure(Call<GetReview> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}