package com.example.borowicz.tp4;

/**
 * Created by 42103343 on 6/7/2017.
 */

public class usuario
{
    public int id;
    public String nomUsuario;
    public String password;
    public int numeroPreferido;
    public boolean tieneSpinner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumeroPreferido() {
        return numeroPreferido;
    }

    public void setNumeroPreferido(int numeroPreferido) {
        this.numeroPreferido = numeroPreferido;
    }

    public boolean isTieneSpinner() {
        return tieneSpinner;
    }

    public void setTieneSpinner(boolean tieneSpinner) {
        this.tieneSpinner = tieneSpinner;
    }
}
