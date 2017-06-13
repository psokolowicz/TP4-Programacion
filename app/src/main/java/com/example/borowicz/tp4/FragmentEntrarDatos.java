package com.example.borowicz.tp4;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by 42374778 on 8/6/2017.
 */

public class FragmentEntrarDatos extends Fragment implements View.OnClickListener
{

    String user;
    String password;
    EditText usuario;
    EditText contraseña;
    Button CrearNuevoUser;
    Button IngresarUser;
    public View onCreateView (LayoutInflater InfladorDeLayouts, ViewGroup GrupoDeLaVista, Bundle DatosRecibidos)
    {
        Log.d("FragmentEntrarDatos", "entra al onCreateView");
        View VistaADevolver;
        Log.d("FragmentEntrarDatos", "Inflando el layout");
        VistaADevolver = InfladorDeLayouts.inflate(R.layout.entrar_datos_user, GrupoDeLaVista, false);
        Log.d("FragmentEntrarDatos", "a punto de retornar");

        usuario = (EditText) VistaADevolver.findViewById(R.id.usuario);
        user = usuario.getText().toString().trim();
        contraseña = (EditText) VistaADevolver.findViewById(R.id.contraseña);
        password = usuario.getText().toString().trim();


        Log.d("FragmentEntrarDatos", "-1");
        CrearNuevoUser = (Button) VistaADevolver.findViewById(R.id.CrearNuevoUser);
        Log.d("FragmentEntrarDatos", "0");
        IngresarUser = (Button) VistaADevolver.findViewById(R.id.Ingresar);
        Log.d("FragmentEntrarDatos", "1");
        IngresarUser.setOnClickListener(this);
        Log.d("FragmentEntrarDatos", "2");
        CrearNuevoUser.setOnClickListener(this);
        Log.d("FragmentEntrarDatos", "3");

        return VistaADevolver;
    }

    @Override
    public void onClick(View v)
    {
        ActividadPrincipal actividadPrincipal = (ActividadPrincipal) getActivity();
        actividadPrincipal.CambiaFragment(v, user, password, null);
    }
}
