package com.productos.productos.web.model;

import javax.persistence.*;

@Entity // (name = "XYZ")
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "usuario_id_seq")
    @SequenceGenerator(
            name = "usuario_id_seq",
            sequenceName = "usuario_id_seq",
            initialValue = 1,
            allocationSize=1
    )
    private Integer id_usuario;


    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false, foreignKey = @ForeignKey(name = "fk_cliente"))
    private Cliente cliente;

    @Column(name = "estado", nullable = false, length = 255)
    private boolean estado;
    @Column(name = "user_name", nullable = false, length = 255)
    private String user_name;
    @Column(name = "clave", nullable = false, length = 255)
    private String clave;
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    @Column(name = "apellido", nullable = false, length = 255)
    private String apellido;
    @Column(name = "mail", nullable = false, length = 255)
    private String mail;
    @Column(name = "genero", nullable = false, length = 10)
    private String genero;
    @Column(name = "fecha_nacimiento", nullable = false, length = 255)
    private String fecha_nacimiento;
    @Column(name = "telefono", nullable = false, length = 255)
    private String telefono;
    @Column(name = "puntosGE", nullable = true)
    private Integer puntosGE;
    @Column(columnDefinition = "TEXT")
    private String foto;

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getPuntosGE() {
        return puntosGE;
    }

    public void setPuntosGE(Integer puntosGE) {
        this.puntosGE = puntosGE;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
