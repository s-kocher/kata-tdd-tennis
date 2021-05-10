package fr.arolla.skocher.tennis;

public class TennisGame {

    private static final String DISPLAY_SCORE_LOVE = "Love";
    private static final String DISPLAY_SCORE_FIFTEEN = "Fifteen";
    private static final String DISPLAY_SCORE_THIRTY = "Thirty";
    private static final String DISPLAY_SCORE_FORTY = "Forty";

    private static final String DISPLAY_SCORE_SEPARATOR = "-";

    private final int player1Score;
    private final int player2Score;

    public TennisGame(int p1Score, int p2Score) {
        this.player1Score = p1Score;
        this.player2Score = p2Score;
    }

    public String score() {
        if (player1Score >= 3 && player2Score >= 3) {
            int winnerPlayer = getWinnerPlayer();
            if (winnerPlayer == 0) {
                return "Deuce";
            }
             return "Advantage player " + winnerPlayer;
        }

        String player1DisplayScore = getDisplayPlayerScore(player1Score);
        String player2DisplayScore = getDisplayPlayerScore(player2Score);

        return getDisplayedGameScore(player1DisplayScore, player2DisplayScore);
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
        if (playerScore == 3) {
            return DISPLAY_SCORE_FORTY;
        }

        return null;
    }

    private String getDisplayedGameScore(String displayScore1, String displayScore2) {
        return displayScore1 + DISPLAY_SCORE_SEPARATOR + displayScore2;
    }

}
