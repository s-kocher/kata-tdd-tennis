package fr.arolla.skocher.tennis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TennisGameTest {

    static Stream<Arguments> inputPlayerScoresExpectedDisplayedScore () {
        return Stream.of(
            Arguments.of(0, 0, "Love-Love"),
            Arguments.of(1, 0, "Fifteen-Love"),
            Arguments.of(0, 1, "Love-Fifteen"),
            Arguments.of(1, 1, "Fifteen-Fifteen"),
            Arguments.of(2, 0, "Thirty-Love"),
            Arguments.of(0, 2, "Love-Thirty"),
            Arguments.of(2, 2, "Thirty-Thirty"),
            Arguments.of(3, 0, "Forty-Love"),
            Arguments.of(2, 3, "Thirty-Forty"),
            Arguments.of(3, 3, "Deuce"),
            Arguments.of(4, 4, "Deuce"),
            Arguments.of(5, 5, "Deuce"),
            Arguments.of(4, 3, "Advantage player 1"),
            Arguments.of(3, 4, "Advantage player 2"),
            Arguments.of(5, 4, "Advantage player 1"),
            Arguments.of(4, 5, "Advantage player 2")
        );
    }

    @ParameterizedTest(name = "Raw player scores {0} - {1} => Display score game : {2} ")
    @MethodSource("inputPlayerScoresExpectedDisplayedScore")
    public void should_for_given_raw_player_scores_display_the_expected_game_score(
        int player1Score, int player2Score, String expectedGameScore) {
        TennisGame game = new TennisGame(player1Score, player2Score);

        String score = game.score();

        assertEquals(expectedGameScore, score);
    }

}
