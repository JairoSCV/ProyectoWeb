package com.proyecto.proyectoweb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager configureAuthentication(){

        List<UserDetails> listaUsuarios = new ArrayList<>();

        List<GrantedAuthority> rolesClientes = new ArrayList<>();

        List<GrantedAuthority> rolesAdministradores = new ArrayList<>();



        rolesClientes.add(new SimpleGrantedAuthority("USER"));

        rolesAdministradores.add(new SimpleGrantedAuthority("ADMIN"));



        listaUsuarios.add(new User("Administrador","{noop}123456",rolesAdministradores));

        listaUsuarios.add(new User("Jorge","{noop}123456",rolesClientes));

        

        return new InMemoryUserDetailsManager(listaUsuarios);

    }

    @Bean

    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests()
        .antMatchers("/","/shop","/contact","/cart","/delete/cart/{id}","/obtenerCarrito","/checkout","/shop-single/{id}","/thankyou","/saveOrder","/caballeros","/damas","/infantil","/zapato","/zapatilla","/botines").permitAll()
        .anyRequest().authenticated()
        .and().formLogin().loginPage("/autenticacion").defaultSuccessUrl("/dashboard", true).permitAll()
        .and().formLogin().permitAll()
        .and().logout().permitAll();
        return http.build();
        //aqui van las paginas o htmls publicos
    }


    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() throws Exception{
        return (web) -> web.ignoring().antMatchers("/css/**", "/js/**","/fonts/**","/images/**","/img/**","/scss/**","/imagenes/**");
        //aqui van las carpetas que son publicas
    }
}
