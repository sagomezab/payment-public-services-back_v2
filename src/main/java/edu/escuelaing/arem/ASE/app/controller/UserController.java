package edu.escuelaing.arem.ASE.app.controller;

import java.util.List;
import edu.escuelaing.arem.ASE.app.configuration.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.escuelaing.arem.ASE.app.model.usuario;
import edu.escuelaing.arem.ASE.app.service.UserService;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService us;

    @Autowired
    public UserController(UserService usuarioDAO) {
        this.us = usuarioDAO;
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody usuario user) {
        us.create(user);
        return new ResponseEntity<>("Usuario Creado", HttpStatus.CREATED);
    }

    @GetMapping("/{correo}/rol")
    public ResponseEntity<String> obtenerRolUsuario(@PathVariable String correo) {
        String rol = us.obtenerRolUsuario(correo);

        if (rol != null) {
            return new ResponseEntity<>(rol, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Usuario no encontrado o rol no asignado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{correo}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable String correo) {
        boolean eliminado = us.eliminarUsuarioPorCorreo(correo);

        if (eliminado) {
            return new ResponseEntity<>("Usuario eliminado correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        List<Object> usuarios = us.obtenerTodosUsuarios();

        if (usuarios != null) {
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update_rol")
    public ResponseEntity<String> updateRol(@RequestBody usuario user) {
        us.updateRolUsuario(user.getId(), user.getIdRol());
        return new ResponseEntity<>("Rol actualizado correctamente", HttpStatus.OK);
    }
}
