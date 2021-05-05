package com.fabiankevin.item.itemservice;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "bean")
@Data
public class ClientConfig {

    private String message = "Message from backend is: %s <br/> Services : %s";



}
