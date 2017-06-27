package com.example.eleazer.desafioglobo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eleazer.desafiomobfiq.R;
import com.example.eleazer.desafiomobfiq.modelos.Bestinstallment;
import com.example.eleazer.desafiomobfiq.modelos.Products;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public abstract class ProductAdapter  extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    private Context mContext;
    private List<Products> products;

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


    public ProductAdapter(Context mContext, List<Products> products) {
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

        Products product = this.products.get(position);


        holder.title.setText(product.getName());
        //TODO: tratar regra por sku para determinar o preço exato
        //TODO: Tratar valores a serem exibidospara evitar null
        Locale ptBr = new Locale("pt", "BR");
        Bestinstallment bestinstallment = product.getSkus().get(0).getSellers().get(0).getBestinstallment();
        holder.brand.setText(product.getBrand() + "\n" + "R$ " + NumberFormat.getCurrencyInstance(ptBr).format(product.getSkus().get(0).getSellers().get(0).getPrice()) + "\n" +
                bestinstallment.getCount() + " x de R$ " + NumberFormat.getCurrencyInstance(ptBr).format(bestinstallment.getValue()) + "\n" + "Preço final: " +
                NumberFormat.getCurrencyInstance(ptBr).format(bestinstallment.getTotal()));

        if (this.products.size() > 6){
            if ((position >= getItemCount() - 1))
                load();
        }

        // loading album cover using Glide library
        Picasso.with(mContext).load(product.getSkus().get(0).getImages().get(0).getImageurl()).into(holder.thumbnail);

    }

    public abstract void load();

   @Override
    public int getItemCount() {
        return products.size();
    }
}
