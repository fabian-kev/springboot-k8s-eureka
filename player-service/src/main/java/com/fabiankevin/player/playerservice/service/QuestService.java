package com.fabiankevin.player.playerservice.service;

import com.fabiankevin.player.playerservice.models.dto.remote.Quest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("quest-service")
public interface QuestService {


    @GetMapping("/quest/{playerId}")
    List<Quest> getAllByPlayerId(@PathVariable("playerId") Long player);
}
