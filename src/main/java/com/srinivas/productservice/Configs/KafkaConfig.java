package com.srinivas.productservice.Configs;

import com.srinivas.productservice.Models.ProductEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaConfig {
    public ProducerFactory<String, ProductEvent>
}
