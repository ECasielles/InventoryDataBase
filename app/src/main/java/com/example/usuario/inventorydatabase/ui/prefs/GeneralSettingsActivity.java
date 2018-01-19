package com.example.usuario.inventorydatabase.ui.prefs;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.example.usuario.inventorydatabase.R;


/**
 * Clase que guarda las preferencias generales de la aplicación
 *
 * @author Enrique Casielles Lapeira
 * @version 1.0
 * @see PreferenceActivity
 */
public class GeneralSettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.general_settings);
    }

}
