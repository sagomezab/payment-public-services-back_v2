package edu.escuelaing.arem.ASE.app.model;

import edu.escuelaing.arem.ASE.app.configuration.InternalConstantValue.EstadoFactura;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class Factura {

    private String id = UUID.randomUUID().toString();
    private String idUsuario;
    private String idServicio;
    private BigDecimal valor;
    private EstadoFactura estado;
    private Date fechaFactura;
    private int idTrx;

    public int getIdTrx() {
        return idTrx;
    }

    // Constructor por defecto
    public Factura() {
    }

    // Constructor con parámetros
    public Factura(String id,String idUsuario, String idServicio, BigDecimal valor, EstadoFactura estado, Date fechaFactura) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idServicio = idServicio;
        this.valor = valor;
        this.estado = estado;
        this.fechaFactura = fechaFactura;
    }

    // Getters y setters

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public EstadoFactura getEstado() {
        return estado;
    }

    public void setEstado(EstadoFactura estado) {
        this.estado = estado;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    // Puedes agregar otros métodos o validaciones según tus necesidades

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Factura{" +
                ", idUsuario=" + idUsuario +
                ", idServicio=" + idServicio +
                ", valor=" + valor +
                ", estado='" + estado + '\'' +
                ", fechaFactura=" + fechaFactura +
                ", idTrx=" + idTrx +
                '}';
    }
}
