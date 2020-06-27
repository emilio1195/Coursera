package edu.uda.pets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import edu.uda.pets.Adapter.ViewPageAdapter;
import edu.uda.pets.Fragmentos.FragmentPerfil;
import edu.uda.pets.Fragmentos.FragmentRecyclerView;

//En esta clase se instancian los Valores o datos de cada mascota
public class WindowPets extends AppCompatActivity {

    //Toolbar myBar;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_window_pets);
       // myBar = (Toolbar) findViewById(R.id.userActionBar);
        //setActionBar(myBar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.vPager);
        SetUpViewPager();
        if (toolbar != null ){
            setSupportActionBar(toolbar);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.btnfavoritos, menu);
        inflater.inflate(R.menu.menu_opcion, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Favoritos:
                Intent favoritosVentana = new Intent(WindowPets.this,FavoritosPets.class);
                startActivity(favoritosVentana);
                return true;
            case R.id.mContacto:
                Intent irContacto = new Intent(WindowPets.this, Contacto.class);
                startActivity(irContacto);
                return true;
            case R.id.mAbout:
                Intent irAbout = new Intent(WindowPets.this, AcercaDe.class);
                startActivity(irAbout);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private ArrayList<Fragment> AddFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new FragmentRecyclerView());
        fragments.add(new FragmentPerfil());
        return fragments;
    }

    private void SetUpViewPager(){
        viewPager.setAdapter(new ViewPageAdapter(getSupportFragmentManager(), AddFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_action_inicio);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_perfil);
    }
}
