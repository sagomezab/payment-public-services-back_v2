package edu.escuelaing.arem.ASE.app.configuration;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class PasswordValidator implements Formatter<String> {

    private static final int MIN_LENGTH = 8;
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).*$";


    @Override
    public String print(String object, Locale locale) {
        return object;
    }

    @Override
    public String parse(String text, Locale locale) throws ParseException {
        if (text.length() < MIN_LENGTH || !text.matches(PASSWORD_PATTERN)) {
            throw new IllegalArgumentException("La contraseña no cumple con la política de contraseñas.");
        }
        return text;
    }
}

