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

public class TopRestoAdapter extends RecyclerView.Adapter<TopRestoAdapter.TopRestoAdapterViewHolder> {
    // TopRestoAdapter is an adapter class and is used to link the RecyclerView and the information
    // from the database. This class applies the polymorphism concept.
    private Context mContext;
    private ArrayList<RestoModel> mData;

    @Override
    public TopRestoAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.top_place_list, parent, false);
        return new TopRestoAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TopRestoAdapterViewHolder holder, final int position) {
        holder.tv_top_resto_name.setText(mData.get(position).getNameResto());
        holder.img_top_resto_thumbnail.setImageResource(mData.get(position).getRestoThumbnail());
        holder.topRestoCardView.setOnClickListener(new View.OnClickListener() {
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

    public TopRestoAdapter(Context mContext, ArrayList<RestoModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    public class TopRestoAdapterViewHolder extends RecyclerView.ViewHolder{
        TextView tv_top_resto_name;
        ImageView img_top_resto_thumbnail;
        CardView topRestoCardView;

        public TopRestoAdapterViewHolder(View itemView){
            super(itemView);
            tv_top_resto_name = itemView.findViewById(R.id.tvTopPlaceName);
            img_top_resto_thumbnail = itemView.findViewById(R.id.imgTopPlace);
            topRestoCardView = itemView.findViewById(R.id.topPlaceList);
        }
    }
}
