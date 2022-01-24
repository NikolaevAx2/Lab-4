package com.Lab3.Items;

import com.Lab3.BuyItem;
import com.Lab3.BuyItemException;

public class Wallet extends Item implements BuyItem {

    private int cash;
    WalletType type;

    public Wallet(String name, int cash,WalletType type){
        super(name);
        this.setCash(cash);
        this.type= type;
        output.messageOutput(String.format("Создан предмет: %s. Внутри %d монет. Цвет: %s. \n ", name,cash,type));
    }

    public int setCash (int cash){
        return this.cash=cash;
    }

    public int getCash(){
        return this.cash;
    }

    public void BuyItem(Products item, Basket basket) throws BuyItemException{
        if (this.getCash()- item.getPrice()>=0){
            this.setCash(this.getCash()-item.getPrice());
            output.messageOutput(String.format("Друзья купили %s за %d монет. \n ",item.getName(),item.getPrice()));
            basket.addToBasket(item);
        }

        for(int i = 0; i<basket.getItemsIn().length; i++){
            boolean isFull = true;
            if (basket.getItemsIn()[i] == null) {
                break;
            }
            if(isFull & i== basket.getItemsIn().length-1){
                throw new BuyItemException("ОШИБКА! Не удалось убрать в корзину. Корзина переполнена.");
            }
        }

    }

    public void BuyItem(Ticket item)throws BuyItemException {
        if (this.getCash()- item.getPrice()>=0){
            this.setCash(this.getCash()-item.getPrice());
            output.messageOutput(String.format("Друзья купили %s за %d монет. \n ",item.getName(),item.getPrice()));
        }
    }
    @Override
    public String toString(){
        return String.format("Объект типа: Wallet. Название: %s. Содержит: %d монет.", this.getName(),this.getCash());
    }

    @Override
    public int hashCode(){
        return 100 * this.hashCode() + 10;
    }

    @Override
    public boolean equals(Object obj1) {
        if (!(obj1 instanceof Wallet)) return false;
        Wallet obj2 = (Wallet) obj1;
        return (obj2.getName() == this.getName());
    }
}
