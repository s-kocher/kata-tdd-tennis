package fr.arolla.skocher.tennis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TennisGameTest {

    @Test
    public void should_for_raw_score_0_0_displayed_score_must_be_Love_Love() {
        TennisGame game = new TennisGame(0, 0);

        String score = game.score();

        assertEquals("Love-Love", score);
    }

    @Test
    public void should_for_raw_score_1_0_displayed_score_must_be_Fifteen_Love() {
        TennisGame game = new TennisGame(1, 0);

        String score = game.score();

        assertEquals("Fifteen-Love", score);
    }

    @Test
    public void should_for_raw_score_0_1_displayed_score_must_be_Love_Fifteen() {
        TennisGame game = new TennisGame(0, 1);

        String score = game.score();

        assertEquals("Love-Fifteen", score);
    }

    @Test
    public void should_for_raw_score_1_1_displayed_score_must_bes_Fifteen_Fifteen() {
        TennisGame game = new TennisGame(1, 1);

        String score = game.score();

        assertEquals("Fifteen-Fifteen", score);
    }

}
