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

public class TopHotelAdapter extends RecyclerView.Adapter<TopHotelAdapter.TopHotelAdapterViewHolder> {
    // TopHotelAdapter is an adapter class and is used to link the RecyclerView and the information
    // from the database. This class applies the polymorphism concept.
    private Context mContext;
    private ArrayList<HotelModel> mData;

    @Override
    public TopHotelAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.top_place_list, parent, false);
        return new TopHotelAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TopHotelAdapterViewHolder holder, final int position) {
        holder.tv_top_hotel_name.setText(mData.get(position).getNameHotel());
        holder.img_top_hotel_thumbnail.setImageResource(mData.get(position).getHotelThumbnail());
        holder.topHotelCardView.setOnClickListener(new View.OnClickListener() {
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

    public TopHotelAdapter(Context mContext, ArrayList<HotelModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    public class TopHotelAdapterViewHolder extends RecyclerView.ViewHolder{
        TextView tv_top_hotel_name;
        ImageView img_top_hotel_thumbnail;
        CardView topHotelCardView;

        public TopHotelAdapterViewHolder(View itemView){
            super(itemView);
            tv_top_hotel_name = itemView.findViewById(R.id.tvTopPlaceName);
            img_top_hotel_thumbnail = itemView.findViewById(R.id.imgTopPlace);
            topHotelCardView = itemView.findViewById(R.id.topPlaceList);
        }
    }
}
