package com.Lab3.Locations;

import com.Lab3.Heroes.Hero;

public class Van extends Location{
    private VanType type;

    public  Van (String name,VanType type){
        super(name);
        this.type=type;
        output.messageOutput(String.format("Создана локация: %s. Тип: %s\n ",name, type));
    }
    public String getType(){
        return this.type.getTranslation();
    }


    public void goToShelf(Hero hero){
        Shelf shelf = new Shelf("Верхняя полка");
        output.messageOutput(String.format("%s залез на %s. ",hero.getName(),shelf.getName()));
        hero.changeLocation(shelf);
    }

    public void leaveShelf(Hero hero){
        output.messageOutput(String.format("%s слез с верхней полки. ",hero.getName()));
        hero.changeLocation(this);
    }

    @Override
    public String toString(){
        return String.format("Объект типа: Van. Имя: %s.", this.getName());
    }
    @Override
    public int hashCode(){
        return 100 * this.hashCode() + 8;
    }
    @Override
    public boolean equals(Object obj1) {
        if (!(obj1 instanceof Van)) return false;
        Van obj2 = (Van) obj1;
        return (obj2.getName() == this.getName());
    }
    @Override
    public void description() {
        output.messageOutput(String.format("Уступите бабушке место - доносилось из %s", this.getName()));
    }

    public class Shelf extends Location{
        public Shelf(String name){
            super(name);
        }
        @Override
        public void description() {
            output.messageOutput(String.format("Ох уж эта %s, так и хочется леч.", this.getName()));
        }
    }
}
