package com.fabiankevin.item.itemservice;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class ClientController {
    private final DiscoveryClient discoveryClient;
    private final ClientConfig config;


    @Scheduled(fixedDelay = 3000)
    public String load() {
        System.out.println(config.getMessage());
        return String.format(config.getMessage(), "", "");
    }
}