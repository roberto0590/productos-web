package com.productos.productos.web.dto;


import java.time.LocalDate;

public class DetallePuntosGEDTO {

    private Integer id;
    private String usuario;
    private Integer puntosGE;
    private String decripcion;
    private LocalDate fecha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Integer getPuntosGE() {
        return puntosGE;
    }

    public void setPuntosGE(Integer puntosGE) {
        this.puntosGE = puntosGE;
    }

    public String getDecripcion() {
        return decripcion;
    }

    public void setDecripcion(String decripcion) {
        this.decripcion = decripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
