package com.example.borowicz.tp4;

import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ActividadPrincipal extends AppCompatActivity {

    FragmentManager AdministradorDeFragments;
    FragmentTransaction TransaccionDeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
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

     public void CambiaFragment(View vista, String usuario, String contraseña, String confContraseña)
     {
         Button btnTocado = (Button) vista;

         if (vista.getId() == R.id.EntrarAplicacion)
         {
             FragmentEntrarDatos frgEntrarDatos;
             Log.d("ActPrin", "Instanciando el frgEntrarDatos");
             frgEntrarDatos = new FragmentEntrarDatos();
             TransaccionDeFragment=AdministradorDeFragments.beginTransaction();
             TransaccionDeFragment.replace(R.id.holder, frgEntrarDatos);
             Log.d("ActPrin", "ya remplazo el holder");
             TransaccionDeFragment.commit();
         }
         else if(vista.getId() == R.id.Ingresar)
         {
             FragmentMuestraUsuarios frgMuestraUsuarios;
             Log.d("ActPrin", "Instanciando el frgMuestraUsuarios");
             frgMuestraUsuarios = new FragmentMuestraUsuarios();
             TransaccionDeFragment=AdministradorDeFragments.beginTransaction();
             TransaccionDeFragment.replace(R.id.holder, frgMuestraUsuarios);
             Log.d("ActPrin", "ya remplazo el holder");
             TransaccionDeFragment.commit();
         }
         else if(vista.getId() == R.id.CrearNuevoUser)
         {
             FragmentCrearUsuario frgCrearUsuario;
             Log.d("ActPrin", "Instanciando el frgCrearUsuario");
             frgCrearUsuario = new FragmentCrearUsuario();
             TransaccionDeFragment=AdministradorDeFragments.beginTransaction();
             TransaccionDeFragment.replace(R.id.holder, frgCrearUsuario);
             Log.d("ActPrin", "ya remplazo el holder");
             TransaccionDeFragment.commit();
         }
         /*
         else if(vista.getId() == R.id.)
         {

         }
         else(vista.getId() == R.id.)
         {

         }
         */
     }
}
