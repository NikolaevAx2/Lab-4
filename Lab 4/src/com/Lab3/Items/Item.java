package com.Lab3.Items;

import com.Lab3.Message;
import com.Lab3.MessageOutput;

public class Item {
    MessageOutput output = new Message();

    private final String name;


    public Item (String name){
        this.name=name;
    };
    public String getName(){
        return this.name;
    }

}
