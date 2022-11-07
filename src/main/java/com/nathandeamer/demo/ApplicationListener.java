package com.nathandeamer.demo;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.Metrics;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.Duration;

@NoArgsConstructor
public class ApplicationListener implements SpringApplicationRunListener {

    @Override
    public void ready(ConfigurableApplicationContext context, Duration timeTaken) {
        long appStartTimeMillis = timeTaken.toMillis();
        Gauge.builder("app_start_time", appStartTimeMillis, value -> appStartTimeMillis)
                .description("Application Start Time in milliseconds")
                .baseUnit("ms")
                .register(Metrics.globalRegistry);
    }

}
