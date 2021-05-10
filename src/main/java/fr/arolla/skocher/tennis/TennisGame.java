package fr.arolla.skocher.tennis;

import java.util.Arrays;

public class TennisGame {

    private enum TennisScore {
        
        LOVE(0, "Love"),
        FIFTEEN(1, "Fifteen"),
        THIRTY(2, "Thirty"),
        FORTY(3, "Forty"),
        DEUCE("Deuce"),
        ADVANTAGE("Advantage player %s"),
        VICTORY("Victory player %s");

        int associatedRawScore = -1;
        String message;

        TennisScore(String message) {
            this.message = message;
        }

        TennisScore(int associatedRawScore, String message) {
            this(message);
            this.associatedRawScore = associatedRawScore;
        }

    }

    private static final String DISPLAY_SCORE_SEPARATOR = "-";

    private final int player1Score;
    private final int player2Score;

    public TennisGame(int p1Score, int p2Score) {
        this.player1Score = p1Score;
        this.player2Score = p2Score;
    }

    public String score() {
        int winnerPlayer = getWinnerPlayer();
        int scoreDelta = getScoreDelta();
        int highestScore = getHighestScore();

        if (highestScore >= 4 && scoreDelta >= 2) {
            return getDisplayWinnerPlayerScore(TennisScore.VICTORY, winnerPlayer);
        }

        if (player1Score >= 3 && player2Score >= 3) {

            if (winnerPlayer == 0) {
                return TennisScore.DEUCE.message;
            }
             return getDisplayWinnerPlayerScore(TennisScore.ADVANTAGE, winnerPlayer);
        }

        TennisScore player1TennisScore = getPlayerTennisScore(player1Score);
        TennisScore player2TennisScore = getPlayerTennisScore(player2Score);

        return getDisplayedGameScore(player1TennisScore, player2TennisScore);
    }

    /**
     * Return 0 if players scores are equal
     * @return return player number that win
     */
    private int getWinnerPlayer() {
        if (player1Score > player2Score) {
            return 1;
        }
        if (player2Score > player1Score) {
            return 2;
        }
        return 0;
    }

    private int getScoreDelta() {
        return Math.abs(player1Score-player2Score);
    }

    private int getHighestScore() {
        return Math.max(player1Score, player2Score);
    }

    private TennisScore getPlayerTennisScore(int playerScore) {
        return Arrays.stream(TennisScore.values())
            .filter(e -> e.associatedRawScore == playerScore)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("No matching score for player score " + playerScore));
    }

    private String getDisplayWinnerPlayerScore(TennisScore tennisScore, int winnerPlayer) {
        return String.format(tennisScore.message, winnerPlayer);
    }

    private String getDisplayedGameScore(TennisScore tennisScore1, TennisScore tennisScore2) {
        return tennisScore1.message + DISPLAY_SCORE_SEPARATOR + tennisScore2.message;
    }

}
