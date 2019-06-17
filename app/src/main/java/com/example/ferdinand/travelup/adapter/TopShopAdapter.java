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

public class TopShopAdapter extends RecyclerView.Adapter<TopShopAdapter.TopShopAdapterViewHolder> {

    // TopShopAdapter is an adapter class and is used to link the RecyclerView and the information
    // from the database. This class applies the polymorphism concept.
    private Context mContext;
    private ArrayList<ShopModel> mData;

    @Override
    public TopShopAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.top_place_list, parent, false);
        return new TopShopAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TopShopAdapterViewHolder holder, final int position) {
        holder.tv_top_shop_name.setText(mData.get(position).getNameShop());
        holder.img_top_shop_thumbnail.setImageResource(mData.get(position).getShopThumbnail());
        holder.topShopCardView.setOnClickListener(new View.OnClickListener() {
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

    public TopShopAdapter(Context mContext, ArrayList<ShopModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    public class TopShopAdapterViewHolder extends RecyclerView.ViewHolder{
        TextView tv_top_shop_name;
        ImageView img_top_shop_thumbnail;
        CardView topShopCardView;

        public TopShopAdapterViewHolder(View itemView){
            super(itemView);
            tv_top_shop_name = itemView.findViewById(R.id.tvTopPlaceName);
            img_top_shop_thumbnail = itemView.findViewById(R.id.imgTopPlace);
            topShopCardView = itemView.findViewById(R.id.topPlaceList);
        }
    }
}
