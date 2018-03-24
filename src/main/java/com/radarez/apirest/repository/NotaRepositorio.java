package com.radarez.apirest.repository;

import com.radarez.apirest.entity.Nota;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



import java.io.Serializable;
import java.util.List;

/**
* In the next line added the class "Nota.java" to JPA
*/
@Repository("repositorio")
/*Inherit  PagingAndSortingRepository<Nota, Serializable> for the pagination*/
public interface NotaRepositorio extends JpaRepository<Nota, Serializable>, PagingAndSortingRepository<Nota, Serializable> {
     public abstract Nota findByNombre(String nombre);

     public abstract List<Nota> findByTitulo(String titulo);

     public abstract Nota findByNombreAndTitulo(String nombre, String titulo);

     public abstract Nota findByNombreAndId(String nombre, long id);

     /*Pagination*/
     public abstract Page<Nota> findAll(Pageable pageable);
}
