package com.radarez.apirest.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Usuario implements Serializable {
    @GeneratedValue
    @Id
    @Column(name = "ID", unique = true)
    private long id;

    @Column(name = "USUARIO", unique = true)
    private String usuario;

    @Column(name = "CONTRASEÑA")
    private String contraseña;

    @Column(name = "rol")
    private byte rol;

    @Column(name = "ACTIVO")
    private boolean activo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public byte getRol() {
        return rol;
    }

    public void setRol(byte rol) {
        this.rol = rol;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
