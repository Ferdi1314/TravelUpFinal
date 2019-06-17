package com.example.ferdinand.travelup.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ferdinand.travelup.PlaceActivity;
import com.example.ferdinand.travelup.R;
import com.example.ferdinand.travelup.model.RestoModel;

import java.util.ArrayList;
import java.util.List;

public class RestoAdapter extends RecyclerView.Adapter<RestoAdapter.MyViewHolder>{
    // RestoAdapter is an adapter class and is used to link the RecyclerView and the information
    // from the database. This class applies the polymorphism concept.
    private Context mContext;
    private List<RestoModel> mData;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.list_restaurant,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv_resto_name.setText(mData.get(position).getNameResto());
        holder.tv_resto_address.setText(mData.get(position).getRestoAddress());
        holder.tv_resto_rating.setText(mData.get(position).getRestoReviews());
        holder.img_resto_thumbnail.setImageResource(mData.get(position).getRestoThumbnail());
        holder.restoCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PlaceActivity.class);
                intent.putExtra("nama", mData.get(position).getNameResto());
                intent.putExtra("address", mData.get(position).getRestoAddress());
                intent.putExtra("reviews", mData.get(position).getRestoReviews());
                intent.putExtra("latitude", mData.get(position).getRestoLatitude());
                intent.putExtra("longitude", mData.get(position).getRestoLongitude());
                intent.putExtra("thumbnail", mData.get(position).getRestoThumbnail());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void filterList(ArrayList<RestoModel> filteredList){
        mData = filteredList;
        notifyDataSetChanged();
    }

    public RestoAdapter(Context mContext, List<RestoModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_resto_name, tv_resto_address, tv_resto_rating;
        ImageView img_resto_thumbnail;
        CardView restoCardView;

        public MyViewHolder(View itemView){
            super(itemView);
            tv_resto_name = (TextView) itemView.findViewById(R.id.tvRestoName);
            tv_resto_address = (TextView) itemView.findViewById(R.id.tvRestoAddress);
            tv_resto_rating = (TextView) itemView.findViewById(R.id.tvRestoRating);
            img_resto_thumbnail = (ImageView) itemView.findViewById(R.id.imgResto);
            restoCardView = (CardView) itemView.findViewById(R.id.restoList);
        }
    }
}
