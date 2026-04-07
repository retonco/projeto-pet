package com.example.ProjetoInterdisciplinar.pet;

public enum Sexo {
    MACHO("Macho"),
    FEMEA("Fêmea");

    private final String valor;

    Sexo(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public static Sexo fromString(String valor) {
        if (valor == null) return null;

        return switch (valor.toLowerCase()) {
            case "macho" -> MACHO;
            case "femea", "fêmea" -> FEMEA;
            default -> throw new IllegalArgumentException("Sexo inválido: " + valor);
        };
    }
}