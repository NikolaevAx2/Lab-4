package com.Lab3;

import com.Lab3.Items.Basket;
import com.Lab3.Items.Item;
import com.Lab3.Items.Products;
import com.Lab3.Items.Ticket;

public interface BuyItem {
    void BuyItem(Products item, Basket basket) throws BuyItemException;
    void BuyItem (Ticket item) throws BuyItemException;
}
