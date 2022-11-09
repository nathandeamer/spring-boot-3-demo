package com.nathandeamer.demo.shared.config;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MetricConfig {

    private final ApplicationContext applicationContext;

    @Bean
    public MeterRegistryCustomizer<MeterRegistry> metricsCommonTags(@Value("${owner}") String owner) {
        return registry -> registry.config().commonTags(
                "application", this.applicationContext.getId(),
                "owner", owner);
    }
}