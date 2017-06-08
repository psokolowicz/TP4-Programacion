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

public class FragmentInicio extends Fragment
{
    public View onCreateView (LayoutInflater InfladorDeLayouts, ViewGroup GrupoDeLaVista, Bundle DatosRecibidos)
    {
        Log.d("frgInicio", "entra al onCreateView");
        View VistaADevolver;
        Log.d("frgInicio", "Inflando el layout");
        VistaADevolver = InfladorDeLayouts.inflate(R.layout.inicio, GrupoDeLaVista, false);
        Log.d("frgInicio", "a punto de retornar");
        return VistaADevolver;
    }
}
