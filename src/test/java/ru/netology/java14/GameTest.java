package ru.netology.java14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

class GameTest {

    Game game = new Game();

    Player player1 = new Player(1, 100);
    Player player2 = new Player(2,  120);
    Player player3 = new Player(3,  50);
    Player player4 = new Player(4,  70);
    Player player5 = new Player(5,  10);
    Player player6 = new Player(6,  100);
    Player player7 = new Player(7,  15);

    @BeforeEach
    public void setup() {
        game.register("Игрок 1", player1);
        game.register("Игрок 2",player2);
        game.register("Игрок 3",player3);
        game.register("Игрок 4",player4);
        game.register("Игрок 5",player5);
        game.register("Игрок 6",player6);
        game.register("Игрок 7",player7);
    }

    @Test
    public void TestAddPlayer() {
        Player player8 = new Player(8,  175);
        game.register("Игрок 8",player8);

        HashMap<String, Player> expected = new HashMap<>();
        expected.put("Игрок 1", player1);
        expected.put("Игрок 2",player2);
        expected.put("Игрок 3",player3);
        expected.put("Игрок 4",player4);
        expected.put("Игрок 5",player5);
        expected.put("Игрок 6",player6);
        expected.put("Игрок 7",player7);
        expected.put("Игрок 8",player8);

        HashMap<String, Player> actual = game.findAll();
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "Player 1,Player 2",
            "Игрок 1,Player 2",
            "Player 1,Игрок 2",
    })
    public void TestFindPlayers(String playerName1, String playerName2) {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(playerName1, playerName2);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "Игрок 1,Игрок 6,0",
            "Игрок 1,Игрок 3,1",
            "Игрок 1,Игрок 2,2",
    })
    public void TestRound(String playerName1, String playerName2, int expected) {
        Assertions.assertEquals(expected, game.round(playerName1, playerName2));
    }
}