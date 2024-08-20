package com.productos.productos.web.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity // (name = "XYZ")
@Table(name = "DetallePuntosGE")
public class DetallePuntosGE {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "detalle_puntos_ge_id_seq")
    @SequenceGenerator(
            name = "detalle_puntos_ge_id_seq",
            sequenceName = "detalle_puntos_ge_id_seq",
            initialValue = 1,
            allocationSize=1
    )
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "usuario", nullable = false, foreignKey = @ForeignKey(name = "puntosGEUsuario"))
    private Usuario usuario;
    @Column(name = "puntosGE", nullable = true)
    private Integer puntosGE;
    @Column(name = "decripcion")
    private String decripcion;
    @Column(name = "fecha")
    private LocalDate fecha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
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
