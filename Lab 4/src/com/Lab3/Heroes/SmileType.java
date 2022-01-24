package com.Lab3.Heroes;

public enum SmileType {
    RYDELY("Грубая"),
    CROOKENDLY("Кривая"),
    MALISIOUSLY("Ехидная");

    private final String translation;

    SmileType(String translation) {
        this.translation = translation;
    }

    public String getTranslation() { return translation; }
}
