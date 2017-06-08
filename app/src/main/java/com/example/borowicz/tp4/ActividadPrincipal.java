package com.example.borowicz.tp4;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ActividadPrincipal extends AppCompatActivity {

    FragmentManager AdministradorDeFragments;
    FragmentTransaction TransaccionDeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_principal);

        Log.d("ActPrin", "Instanciando por 1era vez el admfrg");
        AdministradorDeFragments = getSupportFragmentManager();
        FragmentInicio frgInicio;
        Log.d("ActPrin", "Instanciando el frgInicio");
        frgInicio = new FragmentInicio();

        Log.d("ActPrin", "Por cargar el fragment");
        TransaccionDeFragment=AdministradorDeFragments.beginTransaction();
        Log.d("ActPrin", "Por cargar el fragment");
        TransaccionDeFragment.replace(R.id.holder, frgInicio);
        Log.d("ActPrin", "ya remplazo el holder");
        TransaccionDeFragment.commit();
        Log.d("ActPrin", "ya hizo commit");

    }
}
