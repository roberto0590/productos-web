package com.productos.productos.web.model;

import javax.persistence.*;

@Entity
@Table(name = "devocionales")
public class Devocionales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_devocional;

    @Column(name = "estado", nullable = false, length = 100)
    private boolean estado;
    @Column(name = "nombre", nullable = false, length = 500)
    private String nombre;
    @Column(name = "fecha_devocional", nullable = false, length = 500)
    private String fechaDevocional;

    @Column(name = "puntos", nullable = false, length = 500)
    private String punto;
    @Column(name = "url", nullable = false, length = 500)
    private String url;

    public Integer getId_devocional() {
        return id_devocional;
    }

    public void setId_devocional(Integer id_devocional) {
        this.id_devocional = id_devocional;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaDevocional() {
        return fechaDevocional;
    }

    public void setFechaDevocional(String fechaDevocional) {
        this.fechaDevocional = fechaDevocional;
    }

    public String getPunto() {
        return punto;
    }

    public void setPunto(String punto) {
        this.punto = punto;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
