package com.example.eleazer.desafioglobo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eleazer.desafioglobo.R;
import com.example.eleazer.desafioglobo.modelos.Noticias;

import java.util.List;

public abstract class NoticiasAdapter extends RecyclerView.Adapter<NoticiasAdapter.MyViewHolder> {

    private Context mContext;
    private List<Noticias> products;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView title, brand;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.title);
            brand = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }


    public NoticiasAdapter(Context mContext, List<Noticias> products) {
        this.mContext = mContext;
        this.products = products;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        Noticias noticia = this.products.get(position);


        holder.title.setText(noticia.getProduto());

        if (this.products.size() > 6){
            if ((position >= getItemCount() - 1))
                load();
        }

        // loading album cover using Glide library
        //Picasso.with(mContext).load(noticia.getSkus().get(0).getImages().get(0).getImageurl()).into(holder.thumbnail);

    }

    public abstract void load();

   @Override
    public int getItemCount() {
        return products.size();
    }
}
