package com.example.eleazer.desafioglobo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eleazer.desafioglobo.enumerator.ActivityEnum;
import com.example.eleazer.desafioglobo.modelos.Conteudo;
import com.example.eleazer.desafioglobo.util.DateUtils;
import com.squareup.picasso.Picasso;

import org.eclipse.jdt.internal.compiler.batch.Main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetalheActivity extends AppCompatActivity {

    @BindView(R.id.thumbnail)
    ImageView thumbnail;

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.por)
    TextView por;

    @BindView(R.id.subTitulo)
    TextView subTitulo;

    @BindView(R.id.autor)
    TextView autor;

    @BindView(R.id.data)
    TextView data;

    @BindView(R.id.imageTitle)
    TextView imageTitle;

    @BindView(R.id.texto)
    TextView texto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        ButterKnife.bind(this);

        Intent intent = this.getIntent();
        Conteudo conteudo = (Conteudo) intent.getSerializableExtra(ActivityEnum.CONTEUDO.name());

        if (conteudo != null) {

            Picasso.with(this).load(conteudo.getImagens().get(0).getUrl()).into(thumbnail);

            title.setText(conteudo.getTitulo());
            subTitulo.setText(conteudo.getSubTitulo());

            setAutorInView(conteudo);

            formatDataInView(conteudo);

            imageTitle.setText(conteudo.getImagens().get(0).getLegenda());
            texto.setText(conteudo.getTexto());
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(conteudo.getSecao().getNome());
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void formatDataInView(Conteudo conteudo) {
        try {
            data.setText(DateUtils.formatDate(conteudo.getPublicadoEm()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void setAutorInView(Conteudo conteudo) {
        if (conteudo.getAutores()== null || conteudo.getAutores() != null && conteudo.getAutores().size() == 0) {
            autor.setVisibility(View.GONE);
            por.setVisibility(View.GONE);
        } else {
            autor.setText(conteudo.getAutores().get(0));
        }
    }

    public void startFirstActivity() {

        Intent secondActivity = new Intent(this, MainActivity.class);
        this.startActivity(secondActivity);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            startFirstActivity();
        }
        return super.onOptionsItemSelected(item);
    }

}
