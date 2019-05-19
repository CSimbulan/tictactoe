package tictactoe.tictactoe;

/**
 * Created by user on 8/15/18.
 */
public class Game
{
    char[][] board;
    char currentPlayer;
    boolean error;
    boolean gameDone;
    String playerXName;
    String playerOName;
    String errorMsg;
    boolean winner;
    int moveCounter;

    public Game (char P, String pX, String pO) {
        this.board = new char[3][3];
        this.currentPlayer = P;
        this.error = false;
        this.gameDone = false;
        this.errorMsg = "";
        this.playerOName = pO;
        this.playerXName = pX;
        this.moveCounter = 0;
        this.winner = false;
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                this.board[i][j] = '.';
            }
        }
    }

    void setPlayer() {
        if (this.currentPlayer == 'X') {
            this.currentPlayer = 'O';
        }
        else {
            this.currentPlayer = 'X';
        }
    }

    boolean checkRowsForWin () {
        for (int i=0; i<3; i++) {
            if (this.board[i][0] == this.board[i][1] && this.board[i][0] == this.board[i][2] && this.board[i][0] != '.') {
                return true;
            }
        }
        return false;
    }

    boolean checkColsForWin () {
        for (int i=0; i<3; i++) {
            if (this.board[0][i] == this.board[1][i] && this.board[2][i] == this.board[0][i] && this.board[0][i] != '.') {
                return true;
            }
        }
        return false;
    }

    boolean checkDiagForWin () {
        if (this.board[0][0] == this.board[1][1] && this.board[2][2] == this.board[0][0] && this.board[0][0] != '.') {
            return true;
        }
        else if (this.board[0][2] == this.board[1][1] && this.board[2][0] == this.board[0][2] && this.board[1][1] != '.') {
            return true;
        }
        return false;
    }

    void setError (String errormsg) {
        this.error = true;
        this.errorMsg = errormsg;
    }

    void resetError () {
        this.error = false;
        this.errorMsg = "";
    }

    void setBoard (int row, int col) {
        if (!this.gameDone) {
            if (this.board[row-1][col-1]=='.') {
                this.board[row-1][col-1] = this.currentPlayer;
                this.moveCounter ++;
                this.resetError();
                this.winner = (this.checkColsForWin() || this.checkDiagForWin() || this.checkRowsForWin());
                this.gameDone = (this.winner || moveCounter==9);
                if (!this.gameDone) {this.setPlayer();}
            }
            else {
                this.setError("Error: slot @ (" + row + ", " + col + ") already occupied.");
            }

        }
        else {
            this.setError("Error: game is already over.");
        }
    }

    public String toString () {
        String s = "";
        String s2 = "";
        if (this.error){
            s += errorMsg + "\n" + "\n";
        }
        if (this.gameDone) {
            s2 += "Game is over with ";
            if (moveCounter<9 || this.winner)
            {
                if (this.currentPlayer == 'X')
                {
                    s2 += this.playerXName;
                } else
                {
                    s2 += this.playerOName;
                }
                s2 += " being the winner.";
            }
            else {
                s2 += "a tie between " + this.playerXName + " and " + this.playerOName;
            }
        }
        else
        {
            s2 += "Next player to play: ";
            if (this.currentPlayer == 'X')
            {
                s2 += this.playerXName;
            } else
            {
                s2 += this.playerOName;
            }
        }
        s += "Current Game Status:" + "\n" + "\n";
        for (int i=0; i<3; i++) {
            for (int j = 0; j<3; j++) {
                s += this.board[i][j];
                s += "\t";
            }
            s += "\n";
        }
        s += "\n" + s2;

        return s;
    }
}
