package com.mobileprogramming.tubes_mobpro.Rest;

import com.mobileprogramming.tubes_mobpro.Model.GetReview;
import com.mobileprogramming.tubes_mobpro.Model.GetUser;
import com.mobileprogramming.tubes_mobpro.Model.PostLogin;
import com.mobileprogramming.tubes_mobpro.Model.PostReview;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("Login.php")
    Call<GetUser> getUser(@Query("function") String function);

    @Multipart
    @POST("Login.php")
    Call<PostLogin> postLogin(@Query("function") String function,
                             @Part ("username") RequestBody username,
                             @Part ("password") RequestBody password);

    @GET("Review.php")
    Call<GetReview> getReview(@Query("function") String function);

    @Multipart
    @POST("Review.php")
    Call<PostReview> postReview(@Query("function") String function,
                                @Part ("rating") RequestBody rating,
                                @Part ("comment") RequestBody comment);
}
