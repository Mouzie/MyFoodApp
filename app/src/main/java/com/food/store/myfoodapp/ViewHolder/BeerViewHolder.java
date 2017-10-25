package com.food.store.myfoodapp.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.food.store.myfoodapp.Interface.ItemClickListener;
import com.food.store.myfoodapp.R;

/**
 * Created by Moses on 10/23/2017.
 */

public class BeerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView beer_name;
    public ImageView beer_image;
    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public BeerViewHolder(View itemView) {
        super(itemView);

        beer_name = itemView.findViewById(R.id.beer_name);
        beer_image = itemView.findViewById(R.id.beer_image);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);
    }
}
