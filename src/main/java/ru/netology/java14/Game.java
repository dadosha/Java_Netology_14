package ru.netology.java14;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    HashMap<String, Player> registerPlayers = new HashMap<>();

    private HashMap<String, Player> addToArray(String name,Player player) {
        registerPlayers.put(name, player);
        return registerPlayers;
    }

    public void register(String name,Player player) {
        registerPlayers = addToArray(name, player);
    }

    public int round(String playerName1, String playerName2) {
        if (registerPlayers.get(playerName1) == null) {
            throw new NotRegisteredException(
                    "Игрок с именем -" + playerName1 + " не зарегестрирован"
            );
        }
        if (registerPlayers.get(playerName2) == null) {
            throw new NotRegisteredException(
                    "Игрок с именем -" + playerName2 + " не зарегестрирован"
            );
        }
        int strength1 = registerPlayers.get(playerName1).getStrength();
        int strength2 = registerPlayers.get(playerName2).getStrength();
        if (strength1 > strength2) {
            return 1;
        } else if (strength1 == strength2) {
            return 0;
        } else {
            return 2;
        }
    }

    public HashMap<String, Player> findAll() {
        return registerPlayers;
    }
}
