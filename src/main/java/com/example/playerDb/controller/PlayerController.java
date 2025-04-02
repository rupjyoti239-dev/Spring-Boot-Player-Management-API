package com.example.playerDb.controller;

import com.example.playerDb.dto.PlayerDto;
import com.example.playerDb.entity.Player;
import com.example.playerDb.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("list")
    public ResponseEntity<List<Player>> findAll() {
        List<Player> data = playerService.findAll();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<Player> store(@Valid @RequestBody PlayerDto playerDto) {
        Player data = playerService.store(playerDto);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    @GetMapping("view/{id}")
    public ResponseEntity<Player> view(@PathVariable Long id) {
        Player data = playerService.view(id);
        if (data != null) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Player> update(@PathVariable Long id,
     @Valid                                    @RequestBody PlayerDto playerDto) {
        Player data = playerService.update(playerDto, id);
        if (data != null) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Player> delete(@PathVariable Long id) {
        Player data = playerService.delete(id);
        if (data != null) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
