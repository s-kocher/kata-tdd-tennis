package fr.arolla.skocher.tennis;

public class TennisGame {

    private static final String DISPLAY_SCORE_LOVE = "Love";
    private static final String DISPLAY_SCORE_FIFTEEN = "Fifteen";
    private static final String DISPLAY_SCORE_THIRTY = "Thirty";

    private static final String DISPLAY_SCORE_SEPARATOR = "-";

    private final int player1Score;
    private final int player2Score;

    public TennisGame(int p1Score, int p2Score) {
        this.player1Score = p1Score;
        this.player2Score = p2Score;
    }

    public String score() {
        String player1DisplayScore = getDisplayPlayerScore(player1Score);
        String player2DisplayScore = getDisplayPlayerScore(player2Score);

        return getDisplayedGameScore(player1DisplayScore, player2DisplayScore);
    }

    private String getDisplayPlayerScore(int playerScore) {
        if (playerScore == 0) {
            return DISPLAY_SCORE_LOVE;
        }
        if (playerScore == 1) {
            return DISPLAY_SCORE_FIFTEEN;
        }
        if (playerScore == 2) {
            return DISPLAY_SCORE_THIRTY;
        }

        return null;
    }

    private String getDisplayedGameScore(String displayScore1, String displayScore2) {
        return displayScore1 + DISPLAY_SCORE_SEPARATOR + displayScore2;
    }

}
