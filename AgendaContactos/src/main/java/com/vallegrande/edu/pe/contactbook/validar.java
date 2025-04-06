package com.vallegrande.edu.pe.contactbook;

public class validar {
    // Métodos de validación
    public static boolean validarNombre(String name) {
        return name.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$");
    }

    public static boolean validarCorreo(String email) {
        return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

    public static boolean validarTelefono(String phoneNumber) {
        return phoneNumber.matches("^\\d{9,}$");
    }

}
