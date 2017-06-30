package com.example.eleazer.desafioglobo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eleazer.desafioglobo.R;
import com.example.eleazer.desafioglobo.modelos.Conteudo;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NoticiasAdapter extends RecyclerView.Adapter<NoticiasAdapter.MyViewHolder> {

    private Context mContext;
    private List<Conteudo> conteudos;
    private Conteudo noticia;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView editora, tituloNoticia;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);

            ButterKnife.bind(view);

            editora = (TextView) view.findViewById(R.id.title);
            tituloNoticia = (TextView) view.findViewById(R.id.tituloNoticia);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }

    public NoticiasAdapter(Context mContext, List<Conteudo> conteudos) {
        this.mContext = mContext;
        this.conteudos = conteudos;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.noticias_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        noticia = this.conteudos.get(position);

        if (noticia.getImagens() != null && noticia.getImagens().size()>0) {
            holder.editora.setText(noticia.getSecao().getNome());
            holder.tituloNoticia.setText(noticia.getTitulo());
            Picasso.with(mContext).load(noticia.getImagens().get(0).getUrl()).into(holder.thumbnail);
        }
    }

   @Override
    public int getItemCount() {
        return conteudos.size();
    }
}
