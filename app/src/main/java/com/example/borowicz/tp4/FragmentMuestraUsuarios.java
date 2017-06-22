package com.example.borowicz.tp4;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by 42374778 on 8/6/2017.
 */

public class FragmentMuestraUsuarios extends Fragment
{
    ArrayList<String> listaUsuarios = new ArrayList<String>();
    ArrayAdapter<String> adaptador;
    Spinner spn;

    public View onCreateView (LayoutInflater InfladorDeLayouts, ViewGroup GrupoDeLaVista, Bundle DatosRecibidos)
    {
        ActividadPrincipal actividadPrincipal = (ActividadPrincipal) getActivity();
        Log.d("FragmentMuestraUsuarios", "esta por llamar a obtenerUsuarios");
        listaUsuarios = actividadPrincipal.obtenerUsuarios();
        Log.d("FragmentMuestraUsuarios", "desp de obtener usuarios ");
        adaptador = new ArrayAdapter<String>(GrupoDeLaVista.getContext(), android.R.layout.simple_dropdown_item_1line, listaUsuarios);

        spn = (Spinner) actividadPrincipal.findViewById(R.id.spinner);
        Log.d("FragmentMuestraUsuarios", "esta por llenar el spinner");
        spn.setAdapter(adaptador);


        View VistaADevolver;

        VistaADevolver = InfladorDeLayouts.inflate(R.layout.muestra_lista_usuarios, GrupoDeLaVista, false);

        return VistaADevolver;
    }
}
