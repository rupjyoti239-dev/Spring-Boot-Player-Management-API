package com.example.playerDb.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PlayerDto {

    @NotBlank(message = "Name is required")
    @Size(min = 4, message = "Name must be at least 4 characters")
    private String name;

    @NotBlank(message = "Team name is required")
    private String team;

    @Min(value = 0, message = "Runs must be a non-negative number")
    private int run;

    // Constructors
    public PlayerDto() {
    }

    public PlayerDto(String name, String team, int run) {
        this.name = name;
        this.team = team;
        this.run = run;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }
}
