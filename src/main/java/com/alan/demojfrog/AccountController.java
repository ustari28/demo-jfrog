package com.alan.demojfrog;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

/**
 * Created by alan-davila on 29/11/17.
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @GetMapping("/{id}")
    public String retrieve(@PathVariable Long id) {
        return "Hello ".concat(String.valueOf(id));
    }
}
