package com.radarez.apirest.service;

import com.radarez.apirest.entity.Nota;
import com.radarez.apirest.model.MNota;
import com.radarez.apirest.repository.NotaRepositorio;
import com.radarez.apirest.converter.Convertidor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("servicio")
public class NotaService {

    @Autowired
    @Qualifier("repositorio") /*@Repository("repositorio") of */
    private NotaRepositorio repositorio;

    @Autowired
    @Qualifier("convertidor") /*@Component("convertidor")*/
    public Convertidor convertidor;

    public boolean crear(Nota nota){
        try{
            repositorio.save(nota);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean actualizar(Nota nota){
        try{
            //Validate that record is not null or 0
            repositorio.save(nota);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean borrar(String nombre, long id){
        try{
            Nota nota = repositorio.findByNombreAndId(nombre, id);
            repositorio.delete(nota);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<MNota> obtener(){
        return convertidor.convertirLista(repositorio.findAll());
    }

    public MNota buscarPorNombreYTitulo(String nombre, String titulo){
        return new MNota(repositorio.findByNombreAndTitulo(nombre, titulo));
    }

    public List<MNota> buscarPorTitulo(String titulo){
        return convertidor.convertirLista(repositorio.findByTitulo(titulo));
    }
}
