package edu.escuelaing.arem.ASE.app.service;

import edu.escuelaing.arem.ASE.app.model.usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService us;

    public UserDetailsServiceImpl(UserService us) {
        this.us = us;
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        usuario userData = us.getUsuario(userId);
        if (Objects.equals(userData.getId(), userId)) {
            return new org.springframework.security.core.userdetails.User(userData.getCorreo(), userData.getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }
}

