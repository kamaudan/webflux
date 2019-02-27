package com.example.Requisitions.services;


import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

    private final UserRepository users;

    public UserController(UserRepository users) {
        this.users = users;
    }


    @PostMapping("/save")
    public Mono<User> save(@RequestBody User user){
        return Mono.just(user)
                .flatMap(users::save);
    }

    @GetMapping("/{id}")
    public Mono<User> all(@PathVariable final int id){
        return users.findById(id);

    }

    @GetMapping("/all")
    public Flux<User> all (){
        return users.findAll();

    }

}
