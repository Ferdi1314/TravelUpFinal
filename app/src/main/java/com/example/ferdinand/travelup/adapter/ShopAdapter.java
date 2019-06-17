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
import com.example.ferdinand.travelup.model.ShopModel;

import java.util.ArrayList;
import java.util.List;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.MyViewHolder>{

    // ShopAdapter is an adapter class and is used to link the RecyclerView and the information
    // from the database. This class applies the polymorphism concept.
    private Context mContext;
    private List<ShopModel> mData;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.list_shop,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv_shop_name.setText(mData.get(position).getNameShop());
        holder.tv_shop_address.setText(mData.get(position).getShopAddress());
        holder.tv_shop_rating.setText(mData.get(position).getShopReviews());
        holder.img_shop_thumbnail.setImageResource(mData.get(position).getShopThumbnail());
        holder.shopCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PlaceActivity.class);
                intent.putExtra("nama", mData.get(position).getNameShop());
                intent.putExtra("address", mData.get(position).getShopAddress());
                intent.putExtra("reviews", mData.get(position).getShopReviews());
                intent.putExtra("latitude", mData.get(position).getShopLatitude());
                intent.putExtra("longitude", mData.get(position).getShopLongitude());
                intent.putExtra("thumbnail", mData.get(position).getShopThumbnail());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void filterList(ArrayList<ShopModel> filteredList){
        mData = filteredList;
        notifyDataSetChanged();
    }

    public ShopAdapter(Context mContext, List<ShopModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_shop_name, tv_shop_address, tv_shop_rating;
        ImageView img_shop_thumbnail;
        CardView shopCardView;

        public MyViewHolder(View itemView){
            super(itemView);
            tv_shop_name = (TextView) itemView.findViewById(R.id.tvShopName);
            tv_shop_address = (TextView) itemView.findViewById(R.id.tvShopAddress);
            tv_shop_rating = (TextView) itemView.findViewById(R.id.tvShopRating);
            img_shop_thumbnail = (ImageView) itemView.findViewById(R.id.imgShop);
            shopCardView = (CardView) itemView.findViewById(R.id.shopList);
        }
    }
}
