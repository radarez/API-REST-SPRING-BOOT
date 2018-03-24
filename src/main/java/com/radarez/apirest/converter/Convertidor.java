package com.radarez.apirest.converter;

import org.springframework.stereotype.Component;

import com.radarez.apirest.entity.Nota;
import com.radarez.apirest.model.MNota;


import java.util.List;
import java.util.ArrayList;

@Component("convertidor")
public class Convertidor {
    public List<MNota> convertirLista(List<Nota> notas){
        List<MNota> mnotas = new ArrayList<>();

        for (Nota nota : notas){
            mnotas.add(new MNota(nota));
        }
        return mnotas;
    }

}

