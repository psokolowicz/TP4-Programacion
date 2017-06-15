package com.example.borowicz.tp4;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Date;

public class ActividadPrincipal extends AppCompatActivity {

    FragmentManager AdministradorDeFragments;
    FragmentTransaction TransaccionDeFragment;

    private SQLite DBaccess;
    private SQLiteDatabase database;

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

     public void CambiaFragment(View vista, String usuario, String contraseña, boolean errores)
     {
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
             try
             {
                 if (baseDeDatosAbierta())
                 {
                     if (exiteUsuario(usuario))
                     {
                         FragmentMuestraUsuarios frgMuestraUsuarios;
                         Log.d("ActPrin", "Instanciando el frgMuestraUsuarios");
                         frgMuestraUsuarios = new FragmentMuestraUsuarios();
                         TransaccionDeFragment=AdministradorDeFragments.beginTransaction();
                         TransaccionDeFragment.replace(R.id.holder, frgMuestraUsuarios);
                         Log.d("ActPrin", "ya remplazo el holder");
                         TransaccionDeFragment.commit();

                         Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();
                     }
                     else
                     {
                         FragmentCrearUsuario frgCrearUsuario;
                         Log.d("ActPrin", "Instanciando el frgCrearUsuario");
                         frgCrearUsuario = new FragmentCrearUsuario();
                         TransaccionDeFragment=AdministradorDeFragments.beginTransaction();
                         TransaccionDeFragment.replace(R.id.holder, frgCrearUsuario);
                         Log.d("ActPrin", "ya remplazo el holder");
                         TransaccionDeFragment.commit();

                         Toast.makeText(this, "No estas registrado, acá podes hacerlo.", Toast.LENGTH_SHORT).show();

                     }

                     database.close();
                 }
             }
             catch (Exception e)
             {
                 Toast.makeText(this, "Error, pasese a constru", Toast.LENGTH_SHORT);
             }

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

         else if(vista.getId() == R.id.Registrar)
         {
             if(errores==false)
             {

                 try
                 {
                     if (baseDeDatosAbierta())
                     {
                         if (exiteUsuario(usuario))
                         {
                             FragmentEntrarDatos frgEntrarDatos;
                             Log.d("ActPrin", "Instanciando el frgEntrarDatos");
                             frgEntrarDatos = new FragmentEntrarDatos();
                             TransaccionDeFragment=AdministradorDeFragments.beginTransaction();
                             TransaccionDeFragment.replace(R.id.holder, frgEntrarDatos);
                             Log.d("ActPrin", "ya remplazo el holder");
                             TransaccionDeFragment.commit();

                             Toast.makeText(this, "Ya estás registrado, acá podes loguearte.", Toast.LENGTH_SHORT).show();
                         }
                         else
                         {
                             FragmentMuestraUsuarios frgMuestraUsuarios;
                             Log.d("ActPrin", "Instanciando el frgCrearUsuario");
                             frgMuestraUsuarios = new FragmentMuestraUsuarios();
                             TransaccionDeFragment = AdministradorDeFragments.beginTransaction();
                             TransaccionDeFragment.replace(R.id.holder, frgMuestraUsuarios);
                             Log.d("ActPrin", "ya remplazo el holder");
                             TransaccionDeFragment.commit();

                             guardaUsuario(usuario, contraseña);

                             Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();
                         }

                         database.close();
                     }
                 }
                 catch (Exception e)
                 {
                     FragmentCrearUsuario frgCrearUsuario;
                     Log.d("ActPrin", "Instanciando el frgCrearUsuario");
                     frgCrearUsuario = new FragmentCrearUsuario();
                     TransaccionDeFragment=AdministradorDeFragments.beginTransaction();
                     TransaccionDeFragment.replace(R.id.holder, frgCrearUsuario);
                     Log.d("ActPrin", "ya remplazo el holder");
                     TransaccionDeFragment.commit();

                     Toast.makeText(this, "Error, pasese a constru", Toast.LENGTH_SHORT);
                 }



             }
             else
             {
                 Toast.makeText(this, "Ingresá correctamente tus datos", Toast.LENGTH_LONG).show();
             }
         }

     }


    public Boolean baseDeDatosAbierta()
    {
        Boolean respuesta;
        DBaccess = new SQLite(this, "usuarios", null, 1);
        database = DBaccess.getWritableDatabase();

        if (database != null)
            respuesta = true;
        else
            respuesta = false;

        Date fechaActual = new Date();
        int dia = fechaActual.getDay();

        return respuesta;
    }


    public void guardaUsuario(String nombre, String contraseña)
    {
        ContentValues nuevoRegistro;
        nuevoRegistro = new ContentValues();

        nuevoRegistro.put("usuario", nombre);
        nuevoRegistro.put("password", contraseña);

        database.insert("usuarios", null, nuevoRegistro);
    }


    public boolean exiteUsuario(String usuario)
    {
        Cursor conjuntoDeRegistros;
        conjuntoDeRegistros = database.rawQuery("select usuario from usuarios;", null);
        String usuarioActual = "";
        if (conjuntoDeRegistros.moveToFirst() == true)
        {
            do
            {
                usuarioActual = conjuntoDeRegistros.getString(0);
                if (usuarioActual.equals(usuario))
                    return true;
            }
            while (conjuntoDeRegistros.moveToNext() == true);

        }

        return false;
    }
}
