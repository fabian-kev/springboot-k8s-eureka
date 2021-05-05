package com.fabiankevin.player.playerservice.repository;

import com.fabiankevin.player.playerservice.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
