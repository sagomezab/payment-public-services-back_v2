package edu.escuelaing.arem.ASE.app.model;

import edu.escuelaing.arem.ASE.app.configuration.InternalConstantValue.EstadoTrx;

import java.time.LocalDate;
import java.util.Date;

public class TxrModel {

    private String id;
    private String idFactura;
    private LocalDate fechaTrx;
    private EstadoTrx estado;

    public TxrModel() {
    }

    public TxrModel(String id, String idFactura, LocalDate fechaTrx, EstadoTrx estado) {
        this.id = id;
        this.idFactura = idFactura;
        this.fechaTrx = fechaTrx;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public LocalDate getFechaTrx() {
        return fechaTrx;
    }

    public void setFechaTrx(LocalDate fechaTrx) {
        this.fechaTrx = fechaTrx;
    }

    public EstadoTrx getEstado() {
        return estado;
    }

    public void setEstado(EstadoTrx estado) {
        this.estado = estado;
    }
}
