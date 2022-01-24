package com.Lab3.Items;

import com.Lab3.Heroes.Hero;

public class Basket extends Item{
    private Products[] ItemsIn = new Products[3];


    public Basket (String name){
        super(name);
        output.messageOutput(String.format("Создан предмет: %s. \n ", name));
    }

    public Products[] getItemsIn(){
        return ItemsIn;
    }
    public void InBasket(){
        for(int i = 0; i<ItemsIn.length; i++){
            boolean isEmpty = true;
            if (this.ItemsIn[i] != null) {
                output.messageOutput("В корзине лежит: " + this.ItemsIn[i]);
                isEmpty=false;
            }
            if(isEmpty){
                output.messageOutput("Корзина пуста");
            }
        }
    }

    public void addToBasket(Products item){
        for(int i = 0; i<ItemsIn.length; i++){
            boolean isFull = true;
            if (this.ItemsIn[i] == null) {
                this.ItemsIn[i] = item;
                output.messageOutput(String.format("Друзья положили в корзину %s ." ,item.getName()));
                break;
            }
            if(isFull & i== ItemsIn.length-1){
                output.messageOutput("Корзина переполнена.");
            }
        }
    }

    public void takeFromBasket(Hero hero, Products item){
        for(int i = 0; i<ItemsIn.length; i++){
            if (this.ItemsIn[i].getName().equals(item.getName())){
                this.ItemsIn[i] = null;
                output.messageOutput(String.format("%s достал из корзины %s .", hero.getName(),item.getName()));
                break;
            }
        }
    };

    public void takeBasket(Hero hero){
        output.messageOutput(String.format("%s взял %s",hero.getName(),this.getName()));
    };

    @Override
    public String toString(){
        return String.format("Объект типа: Basket. Название: %s. Размер: 5.", this.getName());
    }

    @Override
    public int hashCode(){
        return 100 * this.hashCode() + 3;
    }

    @Override
    public boolean equals(Object obj1) {
        if (!(obj1 instanceof Basket)) return false;

        Basket obj2 = (Basket) obj1;
        return (obj2.getName() == this.getName());
    }
}
