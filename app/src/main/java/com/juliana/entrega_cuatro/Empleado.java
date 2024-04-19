package com.juliana.entrega_cuatro;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Empleado {
    private String Nombre;
    private String Cargo;
    private String Correo;


    public Empleado(){

    }

    public Empleado(String nombre, String cargo, String correo) {
        Nombre = nombre;
        Cargo = cargo;
        Correo = correo;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getCargo() {
        return Cargo;
    }

    public String getCorreo() {
        return Correo;
    }
}
