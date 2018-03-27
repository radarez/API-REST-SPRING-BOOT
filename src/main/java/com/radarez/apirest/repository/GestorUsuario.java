package com.radarez.apirest.repository;

import com.radarez.apirest.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("gestorUsuario")
public interface GestorUsuario extends JpaRepository<Usuario, Serializable> {
    public abstract Usuario findByUsuario(String usuario);
}
