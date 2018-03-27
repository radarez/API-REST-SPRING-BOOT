package com.radarez.apirest.configuration;

import com.radarez.apirest.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
    @Autowired
    @Qualifier("usuarioServicio")
    private UsuarioService userdetailservice;

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userdetailservice);

    }


    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/login", "/nota/all").permitAll()//Permite el acceso libre a login
                .anyRequest().authenticated()//Cualquier otra petición requiere autenticación
                .and()
                //Las peticiones /login pasaran previamente por este filto
                .addFilterBefore(new LoginFilter("/login", authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class).

                //Las demás peticiones pasarán por este filtro para validar el token
                addFilterBefore(new JwtFilter(),
                        UsernamePasswordAuthenticationFilter.class);

    }
}
