package com.kevinfabian.quest.questservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("player-service")
public interface PlayerService {

    @GetMapping("/players/{id}")
    Player getOne(@PathVariable("id") Long id);
}
