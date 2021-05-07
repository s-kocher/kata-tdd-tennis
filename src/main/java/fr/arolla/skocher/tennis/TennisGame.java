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
        if (player1Score == 1 && player2Score == 1 ) {
            return getDisplayedScore(DISPLAY_SCORE_FIFTEEN, DISPLAY_SCORE_FIFTEEN);
        }
        if (player1Score == 1) {
            return getDisplayedScore(DISPLAY_SCORE_FIFTEEN, DISPLAY_SCORE_LOVE);
        }
        if (player1Score == 2) {
            return getDisplayedScore(DISPLAY_SCORE_THIRTY, DISPLAY_SCORE_LOVE);
        }
        if (player2Score == 1) {
            return getDisplayedScore(DISPLAY_SCORE_LOVE, DISPLAY_SCORE_FIFTEEN);
        }

        return getDisplayedScore(DISPLAY_SCORE_LOVE, DISPLAY_SCORE_LOVE);
    }

    private String getDisplayedScore(String displayScore1, String displayScore2) {
        return displayScore1 + DISPLAY_SCORE_SEPARATOR + displayScore2;
    }

}
