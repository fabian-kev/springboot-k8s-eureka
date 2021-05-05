package com.fabiankevin.player.playerservice.models;

import com.fabiankevin.player.playerservice.models.Player;
import com.fabiankevin.player.playerservice.models.dto.remote.Quest;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PlayerResource {
    private Player player;
    private List<Quest> quest;
}
