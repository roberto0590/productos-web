package com.productos.productos.web.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity // (name = "XYZ")
@Table(name = "ofrendasGE")
public class OfrendasGE {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "ofrendas_ge_id_seq")
    @SequenceGenerator(
            name = "ofrendas_ge_id_seq",
            sequenceName = "ofrendas_ge_id_seq",
            initialValue = 1,
            allocationSize = 1
    )
    private Integer id;
    @Column(name = "monto")
    private BigDecimal monto;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "fecha")
    private LocalDate fecha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
