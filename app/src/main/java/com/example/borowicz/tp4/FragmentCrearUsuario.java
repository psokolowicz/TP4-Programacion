package com.example.borowicz.tp4;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentCrearUsuario extends Fragment implements View.OnClickListener
{
    Button Registrar;
    public View onCreateView (LayoutInflater InfladorDeLayouts, ViewGroup GrupoDeLaVista, Bundle DatosRecibidos)
    {
        Log.d("frgInicio", "entra al onCreateView");
        View VistaADevolver;
        Log.d("frgInicio", "Inflando el layout");
        VistaADevolver = InfladorDeLayouts.inflate(R.layout.crear_usuario, GrupoDeLaVista, false);
        Log.d("frgInicio", "a punto de retornar");

        Registrar = (Button) VistaADevolver.findViewById(R.id.Registrar);
        Registrar.setOnClickListener(this);

        return VistaADevolver;
    }

    @Override
    public void onClick(View v)
    {
        ActividadPrincipal actividadPrincipal = (ActividadPrincipal) getActivity();
        actividadPrincipal.CambiaFragment(v);
    }
}
