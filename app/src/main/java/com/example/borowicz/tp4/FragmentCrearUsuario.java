package com.example.borowicz.tp4;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FragmentCrearUsuario extends Fragment implements View.OnClickListener
{
    String user;
    String password;
    String confPassword;

    Button Registrar;
    EditText usuario;
    EditText contraseña;
    EditText confContraseña;

    boolean errores;

    public View onCreateView (LayoutInflater InfladorDeLayouts, ViewGroup GrupoDeLaVista, Bundle DatosRecibidos)
    {
        Log.d("frgInicio", "entra al onCreateView");
        View VistaADevolver;
        Log.d("frgInicio", "Inflando el layout");
        VistaADevolver = InfladorDeLayouts.inflate(R.layout.crear_usuario, GrupoDeLaVista, false);
        Log.d("frgInicio", "a punto de retornar");

        usuario = (EditText) VistaADevolver.findViewById(R.id.usuario);
        contraseña = (EditText) VistaADevolver.findViewById(R.id.contraseña);
        confContraseña = (EditText) VistaADevolver.findViewById(R.id.confContraseña);

        Registrar = (Button) VistaADevolver.findViewById(R.id.Registrar);
        Registrar.setOnClickListener(this);

        return VistaADevolver;
    }

    @Override
    public void onClick(View v)
    {
        user = usuario.getText().toString().trim();
        password = contraseña.getText().toString().trim();
        confPassword = confContraseña.getText().toString().trim();

        //#RegEx
        String PASSWORD_PATTERN = "^[a-zA-Z0-9._-]{8,12}$";
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);

        if(password.equals(confPassword) && matcher.matches())
        {
            errores=false;
        }
        else
        {
            errores=true;
        }

        ActividadPrincipal actividadPrincipal = (ActividadPrincipal) getActivity();
        actividadPrincipal.CambiaFragment(v, user, password, errores);
    }
}
