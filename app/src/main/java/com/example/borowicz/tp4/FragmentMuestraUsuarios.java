package com.example.borowicz.tp4;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 42374778 on 8/6/2017.
 */

public class FragmentMuestraUsuarios extends Fragment
{
    public View onCreateView (LayoutInflater InfladorDeLayouts, ViewGroup GrupoDeLaVista, Bundle DatosRecibidos)
    {
        Log.d("frgEntrarDatos ", "entra al onCreateView");
        View VistaADevolver;
        Log.d("frgEntrarDatos ", "Inflando el layout");
        VistaADevolver = InfladorDeLayouts.inflate(R.layout.muestra_lista_usuarios, GrupoDeLaVista, false);
        Log.d("frgEntrarDatos", "a punto de retornar");
        return VistaADevolver;
    }
}
