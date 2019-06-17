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
import com.example.ferdinand.travelup.model.HotelModel;

import java.util.ArrayList;
import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.MyViewHolder> {
    // HotelAdapter is an adapter class and is used to link the RecyclerView and the information
    // from the database. This class applies the polymorphism concept.
    private Context mContext;
    private List<HotelModel> mData;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.list_hotel,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv_hotel_name.setText(mData.get(position).getNameHotel());
        holder.tv_hotel_address.setText(mData.get(position).getHotelAddress());
        holder.tv_hotel_rating.setText(mData.get(position).getHotelReviews());
        holder.img_hotel_thumbnail.setImageResource(mData.get(position).getHotelThumbnail());
        holder.hotelCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PlaceActivity.class);
                intent.putExtra("nama", mData.get(position).getNameHotel());
                intent.putExtra("address", mData.get(position).getHotelAddress());
                intent.putExtra("reviews", mData.get(position).getHotelReviews());
                intent.putExtra("latitude", mData.get(position).getHotelLatitude());
                intent.putExtra("longitude", mData.get(position).getHotelLongitude());
                intent.putExtra("thumbnail", mData.get(position).getHotelThumbnail());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void filterList(ArrayList<HotelModel> filteredList){
        mData = filteredList;
        notifyDataSetChanged();
    }


    public HotelAdapter(Context mContext, List<HotelModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_hotel_name, tv_hotel_address, tv_hotel_rating;
        ImageView img_hotel_thumbnail;
        CardView hotelCardView;

        public MyViewHolder(View itemView){
            super(itemView);
            tv_hotel_name = (TextView) itemView.findViewById(R.id.tvHotelName);
            tv_hotel_address = (TextView) itemView.findViewById(R.id.tvHotelAddress);
            tv_hotel_rating = (TextView) itemView.findViewById(R.id.tvHotelRating);
            img_hotel_thumbnail = (ImageView) itemView.findViewById(R.id.imgHotel);
            hotelCardView = (CardView) itemView.findViewById(R.id.hotelList);
        }
    }
}
