package com.alan.demojfrog;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.influx.InfluxMeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alan-davila on 29/11/17.
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private InfluxMeterRegistry metrics;

    @GetMapping("/{id}")
    public String retrieve(@PathVariable Long id) {
        metrics.counter("test1").increment();
        return "Hello ".concat(String.valueOf(id));
    }
}
