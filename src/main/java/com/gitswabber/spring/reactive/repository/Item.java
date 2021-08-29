package com.gitswabber.spring.reactive.repository;

import org.springframework.data.annotation.Id;

public class Item {

    // This id is used as ObjectId which is for _id in mongodb collection.
    private @Id
    String id;
    private String name;
    private double price;

    private Item() {
    }

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
