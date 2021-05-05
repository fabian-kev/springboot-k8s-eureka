package com.fabiankevin.player.playerservice.controller;

import com.fabiankevin.player.playerservice.repository.PlayerRepository;
import com.fabiankevin.player.playerservice.models.PlayerResource;
import com.fabiankevin.player.playerservice.service.QuestService;
import com.fabiankevin.player.playerservice.models.Player;
import com.fabiankevin.player.playerservice.models.dto.remote.Quest;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerRepository playerRepository;
    private final QuestService questService;
    @PostMapping
    public Player create(@RequestBody Player player) {
        System.out.println("Creating -> " + player);
        return playerRepository.save(player);
    }
    @GetMapping("/all")
    List<Player> getall(){
        System.out.println("Getting all....");
        return this.playerRepository.findAll();
    }
    @GetMapping("/{id}")
    PlayerResource getOne(@PathVariable Long id) {
        Player player = playerRepository.findById(id).orElseThrow(() -> new RuntimeException("Sorry, We weren't able to find the user with id "+id));
        List<Quest> quest = new ArrayList<>();
        try {
            quest = questService.getAllByPlayerId(player.getId());
        } catch (FeignException e) {
            System.out.println(e.getMessage());
            System.out.println("feign exception");
        }
        return PlayerResource.builder()
                .player(player)
                .quest(quest)
                .build();
    }
}
