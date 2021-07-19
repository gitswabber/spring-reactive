package com.gitswabber.spring.reactive.controller.flux;

import com.gitswabber.spring.reactive.controller.flux.dto.Dish;
import com.gitswabber.spring.reactive.service.KitchenService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ServerController {

    private final KitchenService kitchen;

    public ServerController(KitchenService kitchen) {
        this.kitchen = kitchen;
    }

    // It returns response as text/event-stream type and client side can consume stream of server side easily.
    // Flux<Dish> is type which returns several Dishes asynchronously. This is handled by Reactor and Netty which are reactive execution environment.
    // Spring webflux subscribes it as response is reactor type.
    @GetMapping(value = "/server", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Dish> serverDishes() {
        return kitchen.getDishes();
    }

    @GetMapping(value = "/served-dishes", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Dish> deliverDishes() {
        // It returns result after calling Dish.deliver() and making new response with setting 'delivered' variable as true.
        return kitchen.getDishes().map(Dish::deliver);
    }

    @GetMapping(value = "/served-dish", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Mono<Dish> deliverDish() {
        // It returns result after calling Dish.deliver() and making new response with setting 'delivered' variable as true.
        return kitchen.getDish().map(Dish::deliver);
    }
}
