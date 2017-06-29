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

import com.example.eleazer.desafioglobo.modelos.Conteudo;
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
        Conteudo conteudo = (Conteudo) intent.getSerializableExtra("conteudo");

        if (conteudo != null) {

            Picasso.with(this).load(conteudo.getImagens().get(0).getUrl()).into(thumbnail);
            title.setText(conteudo.getTitulo());
            subTitulo.setText(conteudo.getSubTitulo());

            if (conteudo.getAutores() == null) {
                autor.setVisibility(View.GONE);
                por.setVisibility(View.GONE);
            } else {
                autor.setText(conteudo.getAutores().get(0));
            }

            try {
                data.setText(formatDate(conteudo.getPublicadoEm()));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            imageTitle.setText(conteudo.getImagens().get(0).getLegenda());
            texto.setText(conteudo.getTexto());
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(conteudo.getSecao().getNome());
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
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

    public void startFirstActivity() {

        Intent secondActivity = new Intent(this, MainActivity.class);
        this.startActivity(secondActivity);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            startFirstActivity();// close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

    //TODO: Colocar em uma classe auxiliar
    private String formatDate(String date) throws ParseException {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZ");
        Date result;
        result = df.parse(date);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        return sdf.format(result);
    }

}
