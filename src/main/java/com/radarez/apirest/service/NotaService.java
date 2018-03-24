package com.radarez.apirest.service;

import com.radarez.apirest.entity.Nota;
import com.radarez.apirest.model.MNota;
import com.radarez.apirest.repository.NotaRepositorio;
import com.radarez.apirest.converter.Convertidor;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
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

    private static final Log logger = LogFactory.getLog(NotaService.class);

    public boolean crear(Nota nota){
        logger.info("Creando nota...");
        try{
            repositorio.save(nota);
            logger.info("Se creó una nota =)");
            return true;
        }catch (Exception e){
            logger.error("No se creó la nota :(");
            return false;
        }
    }
    public boolean actualizar(Nota nota){
        logger.info("Actiualizando nota...");
        try{
            //TODO: Validate that record is not null or 0
            repositorio.save(nota);
            logger.info("Se actualizo la nota: " + nota.getId());
            return true;
        }catch (Exception e){
            logger.error("Ocurrio un erro al actualizar la nota");
            return false;
        }
    }
    public boolean borrar(String nombre, long id){
        logger.info("Eliminado nota...");
        try{
            Nota nota = repositorio.findByNombreAndId(nombre, id);
            repositorio.delete(nota);
            logger.info("Se elimino la nota de: " + nombre + " con Id:" + id);
            return true;
        }catch (Exception e){
            logger.error("Ocurrio un error al eliminar la nota :(");
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
