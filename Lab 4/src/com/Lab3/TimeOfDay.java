package com.Lab3;

public enum TimeOfDay {
    MORNING("Утро"),
    DAY("День"),
    EVENING("Вечер"),
    NIGHT("Ночь");

    private final String translation;

    TimeOfDay(String translation) {
        this.translation = translation;
    }

    public String getTranslation() { return translation; }

}
