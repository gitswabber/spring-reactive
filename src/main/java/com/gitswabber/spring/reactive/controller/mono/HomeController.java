package com.gitswabber.spring.reactive.controller.mono;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

// Since this controller will return a web page with template(not JSON or XML), it uses @Controller annotation.
@Controller
public class HomeController {

    // It returns template name with Mono type which is reactive container.
    // Mono is reactive publisher which is provided by Project Reactor and can include one or zero element.
    @GetMapping
    Mono<String> home() {
        // It will return template 'home.html' in 'classpath:/templates/' using thymeleaf view resolver.
        // It can render html file at browser reactively.
        return Mono.just("home");
    }
}
