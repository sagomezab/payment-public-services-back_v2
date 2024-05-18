package edu.escuelaing.arem.ASE.app.controller;

import edu.escuelaing.arem.ASE.app.configuration.JwtUtil;
import edu.escuelaing.arem.ASE.app.configuration.PasswordValidator;
import edu.escuelaing.arem.ASE.app.model.LoginUser;
import edu.escuelaing.arem.ASE.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping(value = "/login")
@CrossOrigin(origins = "*")
public class LoginController {

    private final UserService us;
    private final JwtUtil jwtUtil;

    @Autowired
    public LoginController(UserService usuarioDAO, JwtUtil jwtUtil) {
        this.us = usuarioDAO;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping()
    public ResponseEntity<String> login(@RequestBody LoginUser loginForm) {
        String correo = loginForm.getCorreo();
        String password = loginForm.getPassword();

        String id = us.login(correo, password);

        if (!id.isEmpty()) {
            String token = jwtUtil.generateToken(id);
            String response = "token: " + token;
            return new ResponseEntity<>(response, HttpStatus.OK);

        } else {
            return new ResponseEntity<>("Correo, contraseña o rol incorrectos", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/validate/password")
    public ResponseEntity<String> validatePassword(@RequestBody LoginUser loginForm) {
        String password = loginForm.getPassword();

        PasswordValidator validator = new PasswordValidator();

        try {
            validator.parse(password, null);
            return new ResponseEntity<>("Contraseña válida", HttpStatus.OK);
        } catch (IllegalArgumentException | ParseException e) {
            return new ResponseEntity<>("Contraseña inválida", HttpStatus.BAD_REQUEST);
        }

    }
}
