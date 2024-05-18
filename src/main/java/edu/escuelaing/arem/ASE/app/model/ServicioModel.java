package edu.escuelaing.arem.ASE.app.model;

import java.util.UUID;

public class ServicioModel {

    private String id = UUID.randomUUID().toString();
    private String nombre;
    
    public ServicioModel() {
    }

    public ServicioModel(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(String id) {
        this.id = id;
    }
    public  void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
