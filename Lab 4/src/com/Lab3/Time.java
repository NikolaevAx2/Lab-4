package com.Lab3;

public class Time {
    MessageOutput output = new Message();
    TimeOfDay timeOfDay;

    public Time(TimeOfDay timeOfDay){
        this.timeOfDay= timeOfDay;
        output.messageOutput(String.format("Время суток создано и установлено на %s",timeOfDay.getTranslation()));
    }

    public void setTimeOfDay(TimeOfDay timeOfDay) {
        this.timeOfDay = timeOfDay;
        output.messageOutput(String.format("Время суток сменилось на %s",timeOfDay.getTranslation()));
    }

    public TimeOfDay getTimeOfDay(){
        return this.timeOfDay;
    }

    @Override
    public String toString(){
        return String.format("Объект типа: Time. Время суток: %s.", this.getTimeOfDay());
    }
    @Override
    public int hashCode(){
        return 100 * this.hashCode() + 8;
    }
    @Override
    public boolean equals(Object obj1) {
        if (!(obj1 instanceof Time)) return false;
        Time obj2 = (Time) obj1;
        return (obj2.getTimeOfDay() == this.getTimeOfDay());
    }
}
