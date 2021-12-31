package com.mobileprogramming.tubes_mobpro.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobileprogramming.tubes_mobpro.Model.Review;
import com.mobileprogramming.tubes_mobpro.R;
import com.mobileprogramming.tubes_mobpro.Review.ReviewActivity;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.MyViewHolder>{

    List<Review> reviewList;

    public ReviewAdapter(List<Review> list){
        reviewList = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_review, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.namaTempat.setText(reviewList.get(position).getNamaTempat());

        holder.itemView.setOnClickListener((view) -> {
            Intent intent = new Intent(view.getContext(), ReviewActivity.class);

            intent.putExtra("id", reviewList.get(position).getId());
            intent.putExtra("user_id", reviewList.get(position).getUserId());
            intent.putExtra("nama_tempat", reviewList.get(position).getNamaTempat());
            intent.putExtra("rating", reviewList.get(position).getRating());
            intent.putExtra("comment", reviewList.get(position).getComment());
            intent.putExtra("trip_id", reviewList.get(position).getTrip_id());
        });
    }

    @Override
    public int getItemCount() {
        return reviewList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView namaTempat;

        public MyViewHolder(View itemView){
            super(itemView);

            namaTempat = (TextView) itemView.findViewById(R.id.tv_nama);
        }
    }
}
