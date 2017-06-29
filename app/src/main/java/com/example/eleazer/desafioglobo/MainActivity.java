package com.example.eleazer.desafioglobo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chootdev.recycleclick.RecycleClick;
import com.example.eleazer.desafioglobo.adapter.NoticiasAdapter;
import com.example.eleazer.desafioglobo.app.AppApplication;
import com.example.eleazer.desafioglobo.callback.OuvirNoticiasCallback;
import com.example.eleazer.desafioglobo.component.AppComponent;
import com.example.eleazer.desafioglobo.event.CarregaNoticiasEvent;
import com.example.eleazer.desafioglobo.manager.NoticiasManager;
import com.example.eleazer.desafioglobo.modelos.Conteudo;
import com.example.eleazer.desafioglobo.modelos.Noticias;
import com.example.eleazer.desafioglobo.service.AppService;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Inject
    public AppService appService;

    private AppComponent component;

    @BindView(R.id.recycler_view)
    public RecyclerView recyclerView;

    @BindView(R.id.imageDestaque)
    ImageView imageDestaque;

    @BindView(R.id.titleDestaque)
    TextView titleDestaque;

    @BindView(R.id.imageTitle)
    TextView imageTitle;

    @Inject
    EventBus eventBus;

    private NoticiasManager noticiasManager;
    private List<Noticias> noticias;
    private NoticiasAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        injectAll();

        eventBus.register(this);
        ouvirNoticias();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void ouvirNoticias() {
        Call<List<Noticias>> call = appService.ouvirNoticias();
        call.enqueue(new OuvirNoticiasCallback(eventBus, this));
    }

    @Subscribe
    public void carregaNoticias(CarregaNoticiasEvent carregaNoticiasEvent) {

        if (noticias == null) {
            if (carregaNoticiasEvent != null && carregaNoticiasEvent.noticias != null){
                noticias = carregaNoticiasEvent.noticias;

                noticiasManager = new NoticiasManager(noticias);

                Picasso.with(this).load(noticiasManager.getDestaque().getImagens().get(0).getUrl()).into(imageDestaque);
                titleDestaque.setText(noticiasManager.getDestaque().getTitulo());
                imageTitle.setText(noticiasManager.getDestaque().getSecao().getNome());

                adapter = new NoticiasAdapter(this, noticiasManager.getConteudos()){
                    @Override
                    public void load() {
                        //implement your load more here
                    /*offset = size+ 1;
                    size = size + 11;
                    pesquisaProdutos();*/
                    }
                };

                RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(adapter);

                RecycleClick.addTo(recyclerView).setOnItemClickListener(new RecycleClick.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        Conteudo conteudo = noticiasManager.getConteudos().get(position);
                        startSecondActivity(conteudo);
                    }
                });
            }
        }
    }

    public void startSecondActivity(Conteudo conteudo) {

        Intent secondActivity = new Intent(this, DetalheActivity.class);
        secondActivity.putExtra("conteudo", conteudo);
        this.startActivity(secondActivity);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        eventBus.unregister(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            this.finish();
            System.exit(0);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void injectAll() {
        AppApplication app = (AppApplication) getApplication();
        component = app.getComponent();
        component.inject(this);
    }
}
