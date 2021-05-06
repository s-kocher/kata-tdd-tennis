package fr.arolla.skocher.tennis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TennisGameTest {

    @Test
    public void should_game_start_score_must_be_Love_Love() {
        TennisGame game = new TennisGame(0, 0);

        String score = game.score();

        assertEquals("Love-Love", score);
    }

    @Test
    public void should_first_player_scores_game_score_is_Fifteen_Love() {
        TennisGame game = new TennisGame(1, 0);

        String score = game.score();

        assertEquals("Fifteen-Love", score);
    }

}
