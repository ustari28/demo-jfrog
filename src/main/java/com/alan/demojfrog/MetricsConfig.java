package com.alan.demojfrog;

import io.micrometer.core.instrument.Clock;
import io.micrometer.influx.InfluxConfig;
import io.micrometer.influx.InfluxMeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by alan-davila on 1/12/17.
 */
@Configuration
public class MetricsConfig {

    @Bean
    public InfluxMeterRegistry meterRegistry(@Autowired InfluxConfig influxConfig) {
        InfluxMeterRegistry influxMeterRegistry = new InfluxMeterRegistry(influxConfig, Clock.SYSTEM);
        influxMeterRegistry.start();
        return influxMeterRegistry;
    }
}
