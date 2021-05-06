package fr.arolla.skocher.tennis;

public class TennisGame {

    private final int player1Score;
    private final int player2Score;

    public TennisGame(int p1Score, int p2Score) {
        this.player1Score = p1Score;
        this.player2Score = p2Score;
    }

    public String score() {
        if (player1Score == 1 && player2Score == 1 ) {
            return "Fifteen-Fifteen";
        }
        if (player1Score == 1) {
            return "Fifteen-Love";
        }
        if (player2Score == 1) {
            return "Love-Fifteen";
        }

        return "Love-Love";
    }

}
