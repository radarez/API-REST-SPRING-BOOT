package com.radarez.apirest.service;

import com.radarez.apirest.entity.Usuario;
import com.radarez.apirest.repository.GestorUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("usuarioServicio")
public class UsuarioService implements UserDetailsService{
    @Autowired
    @Qualifier("gestorUsuario")
    private GestorUsuario repo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = repo.findByUsuario((username));
        return new User(user.getUsuario(), user.getContraseña(),
                user.isActivo(), user.isActivo(), user.isActivo(), user.isActivo(), buildGrante(user.getRol()));

    }

    public List<GrantedAuthority> buildGrante(byte rol){
        String[] roles = { "LECTOR", "USUARIO", "ADMINISTRADOR" };
        List<GrantedAuthority> auths=new ArrayList<>();

        for (int i=0; i<=rol; i++){
            auths.add(new SimpleGrantedAuthority(roles[i]));
        }
        return auths;
    }
}
