package com.telekom.eureka_client_service_admin.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Random;

public class Utils {

    private static final Integer MAX_NUMBER = 1000000;
    private static final Integer MIN_NUMBER = 100;

    private Utils() {
        throw new IllegalStateException("Utility class");
    }

    public static String generatePassword(String password) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    public static Integer generateNumber() {
        return new Random().nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
    }
}
