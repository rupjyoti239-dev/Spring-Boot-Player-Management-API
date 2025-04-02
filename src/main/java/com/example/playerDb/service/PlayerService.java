package com.example.playerDb.service;

import com.example.playerDb.dto.PlayerDto;
import com.example.playerDb.entity.Player;
import com.example.playerDb.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Player store(PlayerDto playerDto) {
        Player player = new Player();
        player.setName(playerDto.getName());
        player.setTeam(playerDto.getTeam());
        player.setRun(playerDto.getRun());

        return playerRepository.save(player);
    }

    public Player view(Long id) {
        return playerRepository.findById(id).orElse(null); // Simplified with `orElse`
    }

    public Player delete(Long id) {
        Optional<Player> player = playerRepository.findById(id);
        if (player.isPresent()) {
            playerRepository.deleteById(id);
            return player.get();
        } else {
            return null;
        }
    }

    public Player update(PlayerDto playerDto, Long id) {
        Optional<Player> existingPlayer = playerRepository.findById(id);
        if (existingPlayer.isPresent()) {
            Player playerToUpdate = existingPlayer.get();

            if (playerDto.getName() != null && !playerDto.getName().isEmpty()) {
                playerToUpdate.setName(playerDto.getName());
            }
            if (playerDto.getTeam() != null && !playerDto.getTeam().isEmpty()) {
                playerToUpdate.setTeam(playerDto.getTeam());
            }
            if (playerDto.getRun() >= 0) { // Only update if run is non-negative
                playerToUpdate.setRun(playerDto.getRun());
            }

            return playerRepository.save(playerToUpdate);
        } else {
            return null;
        }
    }
}
