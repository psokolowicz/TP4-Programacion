package com.example.borowicz.tp4;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ActividadPrincipal extends AppCompatActivity {

    FragmentManager AdministradorDeFragments;
    FragmentTransaction TransaccionDeFragment;

    private SQLite DBaccess;
    private SQLiteDatabase database;

    public static boolean traerTodosLosUsuarios = false;
    public static boolean ingresar = false;
    public static boolean registrar = false;

    public static String usuario = "";
    public static String password = "";
    public static int numeroPreferido;
    public static boolean tieneSpinner = false;


    public ArrayList<String> listaDevolver = new ArrayList<String>();
    public ArrayList<usuario> listaUsuarios = new ArrayList<usuario>();

    public static usuario oUsuario = new usuario();

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

     public void CambiaFragment(View vista, String usuario, String contraseña, int numeroPreferido, boolean tieneSpinner, boolean errores)
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
            // try
            // {
               //  if (baseDeDatosAbierta())
                 //{
                     //if (exiteUsuario(usuario))
                    // {
                         FragmentMuestraUsuarios frgMuestraUsuarios;
                         Log.d("ActPrin", "Instanciando el frgMuestraUsuarios");
                         frgMuestraUsuarios = new FragmentMuestraUsuarios();
                         TransaccionDeFragment=AdministradorDeFragments.beginTransaction();
                         TransaccionDeFragment.replace(R.id.holder, frgMuestraUsuarios);
                         Log.d("ActPrin", "ya remplazo el holder");

                         traerTodosLosUsuarios=true;
                         ingresar=true;

                         hiloMySQL.start();

                         ingresar=false;
                         traerTodosLosUsuarios=false;

                         TransaccionDeFragment.commit();

                         //listaDevolver = obtenerUsuarios();

                         Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();
                     //}
                   //  else
                    /* {
                         FragmentCrearUsuario frgCrearUsuario;
                         Log.d("ActPrin", "Instanciando el frgCrearUsuario");
                         frgCrearUsuario = new FragmentCrearUsuario();
                         TransaccionDeFragment=AdministradorDeFragments.beginTransaction();
                         TransaccionDeFragment.replace(R.id.holder, frgCrearUsuario);
                         Log.d("ActPrin", "ya remplazo el holder");
                         TransaccionDeFragment.commit();

                         Toast.makeText(this, "No estas registrado, acá podes hacerlo.", Toast.LENGTH_SHORT).show();

                     }*/

                     //database.close();
                // }
             //}
            // catch (Exception e)
          //   {
           //     Toast.makeText(this, "Error, pasese a constru", Toast.LENGTH_SHORT);
           //  }

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

                // try
                 //{
                   //  if (baseDeDatosAbierta())
                     //{
                    //     if (exiteUsuario(usuario))
                        // {
                             FragmentEntrarDatos frgEntrarDatos;
                             Log.d("ActPrin", "Instanciando el frgEntrarDatos");
                             frgEntrarDatos = new FragmentEntrarDatos();
                             TransaccionDeFragment=AdministradorDeFragments.beginTransaction();
                             TransaccionDeFragment.replace(R.id.holder, frgEntrarDatos);
                             Log.d("ActPrin", "ya remplazo el holder");


                             registrar=true;
                             hiloMySQL.start();
                             registrar=false;

                             TransaccionDeFragment.commit();

                      //   }
                         //else
                         //{
                             //guardaUsuario(usuario, contraseña);

                             /*FragmentMuestraUsuarios frgMuestraUsuarios;
                             Log.d("ActPrin", "Instanciando el frgCrearUsuario");
                             frgMuestraUsuarios = new FragmentMuestraUsuarios();
                             TransaccionDeFragment = AdministradorDeFragments.beginTransaction();
                             TransaccionDeFragment.replace(R.id.holder, frgMuestraUsuarios);
                             Log.d("ActPrin", "ya remplazo el holder");
                             TransaccionDeFragment.commit();

                             Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();*/
                        // }

                        // database.close();
                     //}
                 //}
                /* catch (Exception e)
                 {
                     FragmentCrearUsuario frgCrearUsuario;
                     Log.d("ActPrin", "Instanciando el frgCrearUsuario");
                     frgCrearUsuario = new FragmentCrearUsuario();
                     TransaccionDeFragment=AdministradorDeFragments.beginTransaction();
                     TransaccionDeFragment.replace(R.id.holder, frgCrearUsuario);
                     Log.d("ActPrin", "ya remplazo el holder");
                     TransaccionDeFragment.commit();

                     Toast.makeText(this, "Error, pasese a constru", Toast.LENGTH_SHORT);
                 }*/



             }
             else
             {
                 Toast.makeText(this, "Ingresá correctamente tus datos", Toast.LENGTH_LONG).show();
             }
         }

     }


   /* public Boolean baseDeDatosAbierta()
    {
        Boolean respuesta;
        DBaccess = new SQLite(this, "usuarios", null, 1);
        database = DBaccess.getWritableDatabase();

        if (database != null)
            respuesta = true;
        else
            respuesta = false;

        return respuesta;
    }


    public void guardaUsuario(String nombre, String contraseña)
    {
        ContentValues nuevoRegistro;
        nuevoRegistro = new ContentValues();

        nuevoRegistro.put("usuario", nombre);
        nuevoRegistro.put("pass", contraseña);

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

    public ArrayList<String> obtenerUsuarios()
    {
        try
        {
            if(baseDeDatosAbierta())
            {
                Cursor conjuntoDeRegistros;
                conjuntoDeRegistros = database.rawQuery("select usuario from usuarios;", null);
                String usuarioActual = "";
                ArrayList<String> listaDevolver = new ArrayList<String>();
                if (conjuntoDeRegistros.moveToFirst() == true) {
                    do {
                        Log.d("obtenerUsuarios", "esta por cargar un usuario al array");
                        usuarioActual = conjuntoDeRegistros.getString(0);
                        listaDevolver.add(usuarioActual);

                    }
                    while (conjuntoDeRegistros.moveToNext() == true);

                }
                Log.d("obtenerUsuarios", "esta por retornar la lista");
            }
        }
        catch (Exception e)
        {
            Toast.makeText(this, "Error, pasese a constru", Toast.LENGTH_SHORT);
        }

        database.close();
        return listaDevolver;
    }*/

    Thread hiloMySQL = new Thread()
    {
        @Override
        public  void run()
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");

                String rutaServidorMySQL, nombreBaseDatos, nombreUsuario, passwordUsuario, cadenaCompletaConexion;
                int puertoServidor;

                rutaServidorMySQL="192.168.56.1";
                puertoServidor=3306;
                nombreBaseDatos="database";
                nombreUsuario="root";
                passwordUsuario="root";

                cadenaCompletaConexion="jdbc:mysql://"+rutaServidorMySQL+":"+puertoServidor+"/"+nombreBaseDatos;

                Connection conexion = DriverManager.getConnection(cadenaCompletaConexion, nombreUsuario, passwordUsuario);

                Statement instruccion = conexion.createStatement();

                if(registrar)
                {

                    String SQLEscritura = "insert into usuarios (usuario, pass, numeroPreferido, tieneSpinner) values (" + usuario + ", " + password + ", " + numeroPreferido + ", " + tieneSpinner + ");";

                    boolean resultado = instruccion.execute(SQLEscritura);

                    if (!resultado) {
                        Log.d("ThreadLOG", "no se guardo, resultado es false");
                    } else {
                        Log.d("ThreadLOG", "se guardo, resultado es true");
                    }

                }
                else if(traerTodosLosUsuarios)
                {
                    String SQLLectura = "select * from usuarios;";

                    ResultSet resultados = instruccion.executeQuery(SQLLectura);

                    if(resultados.first())
                    {
                        oUsuario.setId(resultados.getInt("id"));
                        oUsuario.setNomUsuario(resultados.getString("usuario"));
                        oUsuario.setPassword(resultados.getString("pass"));
                        oUsuario.setNumeroPreferido(resultados.getInt("numeroPreferido"));
                        oUsuario.setTieneSpinner(resultados.getBoolean("numeroPreferido"));

                        listaUsuarios.add(oUsuario);

                        while(resultados.next())
                        {
                            oUsuario = new usuario();
                            oUsuario.setId(resultados.getInt("id"));
                            oUsuario.setNomUsuario(resultados.getString("usuario"));
                            oUsuario.setPassword(resultados.getString("pass"));
                            oUsuario.setNumeroPreferido(resultados.getInt("numeroPreferido"));
                            oUsuario.setTieneSpinner(resultados.getBoolean("numeroPreferido"));

                            listaUsuarios.add(oUsuario);
                        }
                    }
                }
                else if(ingresar)
                {
                    String SQLLectura = "select * from usuarios where usuario="+usuario+" and pass="+password+";";

                    ResultSet resultados = instruccion.executeQuery(SQLLectura);

                    if(resultados.first())
                    {
                        oUsuario.setId(resultados.getInt("id"));
                        oUsuario.setNomUsuario(resultados.getString("usuario"));
                        oUsuario.setPassword(resultados.getString("pass"));
                        oUsuario.setNumeroPreferido(resultados.getInt("numeroPreferido"));
                        oUsuario.setTieneSpinner(resultados.getBoolean("numeroPreferido"));

                    }
                }

            }
            catch (ClassNotFoundException error)
            {
                Log.d("THREADLOGCATCH", error.toString());
            } catch (SQLException error) {
                error.printStackTrace();
                Log.d("THREADLOGCATCH", error.toString());

            }
            catch (Exception error)
            {
                Log.d("THREADLOGCATCH", error.toString());
            }

        }
    };

}
