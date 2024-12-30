package com.productos.productos.web.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity // (name = "XYZ")
@Table(name = "detalleCampaQR")
public class DetalleCampaQR {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "detalle_campa_qr_id_seq")
    @SequenceGenerator(
            name = "detalle_campa_qr_id_seq",
            sequenceName = "detalle_campa_qr_id_seq",
            initialValue = 1,
            allocationSize=1
    )
    private Integer id;
    @Column(name = "decripcion")
    private String decripcion;
    @Column(columnDefinition = "TEXT")
    private String foto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDecripcion() {
        return decripcion;
    }

    public void setDecripcion(String decripcion) {
        this.decripcion = decripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
