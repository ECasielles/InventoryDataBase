package com.example.usuario.inventorydatabase.ui.sector;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.usuario.inventorydatabase.R;

/**
 * Actividad que maneja el alta de secciones
 *
 * @author Enrique Casielles Lapeira
 * @version 2.0
 * @see android.app.Activity
 * @see AppCompatActivity
 */
public class SectorActivity extends AppCompatActivity {

    ListSectorFragment listSectorFragment;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listSectorFragment = (ListSectorFragment) getSupportFragmentManager().findFragmentByTag(ListSectorFragment.TAG);
        if (listSectorFragment == null) {
            listSectorFragment = new ListSectorFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.activity_sector, listSectorFragment, ListSectorFragment.TAG)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_activity_sector, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
