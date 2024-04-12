package ru.netology.java14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

class GameTest {

    Game game = new Game();

    Player player1 = new Player(1, "Игрок 1", 100);
    Player player2 = new Player(2, "Игрок 2", 120);
    Player player3 = new Player(3, "Игрок 3", 50);
    Player player4 = new Player(4, "Игрок 4", 70);
    Player player5 = new Player(5, "Игрок 5", 10);
    Player player6 = new Player(6, "Игрок 6", 100);
    Player player7 = new Player(7, "Игрок 7", 15);

    @BeforeEach
    public void setup() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);
        game.register(player7);
    }

    @Test
    public void TestAddPlayer() {
        Player player8 = new Player(8, "Игрок 8", 175);
        game.register(player8);

        Player[] expected = {player1, player2, player3, player4, player5, player6, player7, player8};
        ArrayList<Player> actual = game.findAll();
        Assertions.assertArrayEquals(expected, actual.toArray());
    }

    @ParameterizedTest
    @CsvSource({
            "Player 1,Player 2",
            "Игрок 1,Player 2",
            "Player 1,Игрок 2",
    })
    public void TestFindZeroPlayer(String playerName1, String playerName2) {
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