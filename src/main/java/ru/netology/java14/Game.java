package ru.netology.java14;

import java.util.ArrayList;

public class Game {
    ArrayList<Player> registerPlayers = new ArrayList<>();

    private ArrayList<Player> addToArray(Player player) {
        registerPlayers.add(player);
        return registerPlayers;
    }

    public void register(Player player) {
        registerPlayers = addToArray(player);
    }

    public Player findByName(String name) {
        for (Player player : registerPlayers) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException(
                    "Игрок с именем -" + playerName1 + " не зарегестрирован"
            );
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException(
                    "Игрок с именем -" + playerName2 + " не зарегестрирован"
            );
        }
        int strength1 = findByName(playerName1).getStrength();
        int strength2 = findByName(playerName2).getStrength();
        if (strength1 > strength2) {
            return 1;
        } else if (strength1 == strength2) {
            return 0;
        } else {
            return 2;
        }
    }

    public ArrayList<Player> findAll() {
        return registerPlayers;
    }
}
