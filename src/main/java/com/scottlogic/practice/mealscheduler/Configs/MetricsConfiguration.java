package com.scottlogic.practice.mealscheduler.Configs;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import org.springframework.context.annotation.Bean;

public class MetricsConfiguration {

    @Bean
    public PrometheusConfig getMeterRegistryConfig() {
        return new PrometheusConfig() {
            @Override
            public String get(String s) {
                return null;
            }

            @Override
            public String prefix() {
                return "meal_scheduler";
            }
        };
    }

    @Bean
    public MeterRegistry getMeterRegistry(PrometheusConfig prometheusConfig) {
        final var reg = new PrometheusMeterRegistry(prometheusConfig);
        Metrics.addRegistry(reg);
        return new PrometheusMeterRegistry(prometheusConfig);
    }
}
