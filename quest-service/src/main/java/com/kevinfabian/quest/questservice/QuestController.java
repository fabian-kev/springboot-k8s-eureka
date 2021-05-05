package com.kevinfabian.quest.questservice;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quest")
@RequiredArgsConstructor
public class QuestController {

    private final QuestRepository questRepository;
    private final PlayerService playerService;

    @GetMapping("/{playerId}")
    List<Quest> getAll(){
        System.out.println("Konichiwa ");
        return questRepository.findAll();
    }


    @PostMapping
    Quest create(@RequestBody Quest quest) {
        Player player = playerService.getOne(quest.getPlayerId());
        System.out.println("Hello " + player);
        return questRepository.save(quest);
    }


}
