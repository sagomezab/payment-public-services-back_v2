package edu.escuelaing.arem.ASE.app.model;

import java.util.UUID;

public class usuario {
    private String id = UUID.randomUUID().toString();
    private String nombre;
    private String apellido;
    private String password;
    private String correo;
    private String telefono;
    private String direccion;
    private String idRol;

    public usuario() {

    }

    public usuario(String nombre, String apellido, String password, String correo, String telefono, String direccion, String id_rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.idRol = id_rol;
    }


    // Getters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getPassword() {
        return password;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getIdRol() {
        return idRol;
    }

    // Setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
