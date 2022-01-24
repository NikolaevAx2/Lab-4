package com.Lab3;

import com.Lab3.Heroes.*;
import com.Lab3.Items.*;
import com.Lab3.Locations.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Time timeOfDay = new Time(TimeOfDay.DAY);
        Home PonchikHome = new Home("Дом Пончика");
        Fish[] Fishs = new Fish[]{
                new Fish("Пискарик", PonchikHome, 2000),
                new Fish("Лещик", PonchikHome, 1000),
                new Fish("Сомик", PonchikHome, 0),
                new Fish("Судачек", PonchikHome, 50)
        };
        Wallet wallet = new Wallet("Кошелек друзей", 2000, WalletType.BLUE);
        for (int i = 0; i < Fishs.length; i++) {
            Fishs[i].allMoneyToWallet(wallet);
        }
        Basket basket = new Basket("Корзина");

        Random randint = new Random();
        int basketHas = randint.nextInt(4);
        basket.takeBasket(Fishs[basketHas]);

        Market miniMarket = new Market("Магазин 5орочка");
        for (int i = 0; i < Fishs.length; i++) {
            Fishs[i].changeLocation(miniMarket);
        }

        Products[] food = new Products[]{
                new Products("Apple", 50),
                new Products("Cake", 150),
                new Products("Бутерброд с ветчиной и сыром", 200)
        };
        Ticket ticket = new Ticket("Билет на поезд", 200, "город Фантомас");

        int NumberFood = randint.nextInt(food.length);
        try {
            wallet.BuyItem(food[NumberFood], basket);
            wallet.BuyItem(food[2], basket);
            wallet.BuyItem(ticket);
        }catch (BuyItemException exx){
            System.out.println(exx.getMessage());
        }

        Ponchik ponchik = new Ponchik("Пончик", PonchikHome);
        RailwayStation railwayStation = new RailwayStation("Станция <Простаквашино> ");
        ponchik.changeLocation(railwayStation);

        for (int i = 0; i < Fishs.length; i++) {
            Fishs[i].changeLocation(railwayStation);
        }
        basket.takeBasket(ponchik);
        ponchik.bye();
        Van van = new Van("Вагон", VanType.FULL);
        ponchik.changeLocation(van);
        ponchik.findPlace(van);
        ponchik.watchAround();
        ponchik.smile(SmileType.CROOKENDLY);
        van.goToShelf(ponchik);
        ponchik.setInvisible(true);
        timeOfDay.setTimeOfDay(TimeOfDay.EVENING);
        ponchik.goSleep();
        timeOfDay.setTimeOfDay(TimeOfDay.NIGHT);
        ponchik.getUp();
        try {
            basket.takeFromBasket(ponchik, food[2]);
        } catch (NullPointerException ex){
            System.out.println("Неудалось извлечь " +food[2].getName() + "из корзины из-за его отсутствия в ней");
        }
        ponchik.eat(food[2]);

    }
}
