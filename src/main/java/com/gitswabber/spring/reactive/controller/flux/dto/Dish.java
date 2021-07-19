package com.gitswabber.spring.reactive.controller.flux.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Dish {
    private String description;
    private boolean delivered;

    public static Dish deliver(Dish dish) {
        return Dish.builder()
                .description(dish.getDescription())
                .delivered(true)
                .build();
    }

    public Dish(String description, boolean delivered) {
        this.description = description;
        this.delivered = delivered;
    }

    public Dish(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("Dish { description = %s, delivered = %s }", description, delivered);
    }
}
