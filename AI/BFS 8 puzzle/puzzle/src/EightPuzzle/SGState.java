package EightPuzzle;
//  SGState class    Creed Jones    CBU    CSC512 SP18    Jan 28, 2018
//   this class supports solving the 8-puzzle problem

import java.util.Random;

public class SGState {
    int[][] board = new int[3][3];      // 0 stands for blank

    public SGState() { this(0); }

    public SGState(int testData) {  // pass in non-zero values to get defined test boards
        Random r = new Random();

        switch (testData) {     // either canned data or random pattern
            default:
                for (int inc = 0; inc < 9; inc++) {     // for each tile
                    boolean notDone = true;
                    while (notDone) {
                        int xc = r.nextInt(3);
                        int yc = r.nextInt(3);
                        if (board[yc][xc] == 0) {
                            board[yc][xc] = inc;        // put each # in first unfilled random spot
                            notDone = false;
                        }
                    }
                }                   // NOTE: 0 stands for the empty spot, and prints out as a blank
                break;
            case 1:
                board[0][0] = 1;    board[0][1] = 2;    board[0][2] = 3;
                board[1][0] = 4;    board[1][1] = 5;    board[1][2] = 6;
                board[2][0] = 7;    board[2][1] = 0;    board[2][2] = 8;
                break;
            case 2:
                board[0][0] = 1;    board[0][1] = 2;    board[0][2] = 3;
                board[1][0] = 4;    board[1][1] = 0;    board[1][2] = 6;
                board[2][0] = 7;    board[2][1] = 5;    board[2][2] = 8;
                break;
            case 3:
                board[0][0] = 1;    board[0][1] = 2;    board[0][2] = 3;
                board[1][0] = 0;    board[1][1] = 4;    board[1][2] = 5;
                board[2][0] = 7;    board[2][1] = 8;    board[2][2] = 6;
                break;
            case 4:
                board[0][0] = 0;    board[0][1] = 1;    board[0][2] = 3;
                board[1][0] = 4;    board[1][1] = 2;    board[1][2] = 6;
                board[2][0] = 7;    board[2][1] = 5;    board[2][2] = 8;
                break;
        }
    }

    public SGState(SGState s) {     // copy constructor
        for (int yc = 0; yc < 3; yc++) {     // for each tile
            for (int xc = 0; xc < 3; xc++) {
                this.board[yc][xc] = s.board[yc][xc];
            }
        }
    }

    public SGState move(String mv) {        // respond to command by swapping blank with another tile
        SGState newState = new SGState(this);
        int xc = findXofBlank();
        int yc = findYofBlank();
        char cmd = mv.toUpperCase().charAt(0);      // get the first char as an uppercase
        switch (cmd) {
            case 'U':
                if (yc > 0) {
                    newState.board[yc][xc] = board[yc-1][xc];
                    newState.board[yc-1][xc] = 0;
                }
                break;
            case 'D':
                if (yc < 2) {
                    newState.board[yc][xc] = board[yc+1][xc];
                    newState.board[yc+1][xc] = 0;
                }
                break;
            case 'L':
                if (xc > 0) {
                    newState.board[yc][xc] = board[yc][xc-1];
                    newState.board[yc][xc-1] = 0;
                }
                break;
            case 'R':
                if (xc < 2) {
                    newState.board[yc][xc] = board[yc][xc+1];
                    newState.board[yc][xc+1] = 0;
                }
                break;
            default:
                break;
        }
        return newState;
    }

    private int findXofBlank() {        // klugey, but find where the blank is (could keep track, I guess)
        for (int yinc = 0; yinc < 3; yinc++) {
            for (int xinc = 0; xinc < 3; xinc++) {
                if (board[yinc][xinc] == 0)
                    return xinc;
            }
        }
        return -1;
    }

    private int findYofBlank() {        // klugey, but find where the blank is (could keep track, I guess)
        for (int yinc = 0; yinc < 3; yinc++) {
            for (int xinc = 0; xinc < 3; xinc++) {
                if (board[yinc][xinc] == 0)
                    return yinc;
            }
        }
        return -1;

    }

    public boolean checkDone() {    // compare to final desired pattern
        int[][] goal = { {1, 2, 3}, {4, 5, 6}, {7, 8, 0} };
        for (int yinc = 0; yinc < 3; yinc++) {
            for (int xinc = 0; xinc < 3; xinc++) {
                if (board[yinc][xinc] != goal[yinc][xinc])
                    return false;
            }
        }
        return true;
    }

    public String toString() {
        String s = "";
        for (int yinc = 0; yinc < 3; yinc++) {
            for (int xinc = 0; xinc < 3; xinc++) {
                s = s + "[" + ((board[yinc][xinc] == 0) ? " " : board[yinc][xinc]) + "] ";
            }
            s += "\n";
        }
        return s;
    }

    public boolean isAllowed(String s) {    // see if placement of blank will allow the desired move
        if (s.toUpperCase().equals("U"))
            return (findYofBlank() > 0);
        if (s.toUpperCase().equals("D"))
            return (findYofBlank() < 2);
        if (s.toUpperCase().equals("L"))
            return (findXofBlank() > 0);
        if (s.toUpperCase().equals("R"))
            return (findXofBlank() < 2);
        return false;
    }

    public boolean equals(Object other) {       // a well-tempered equals method
        if (this == other) return true;
        if (other == null) return false;
        if (this.getClass() != other.getClass()) return false;
        SGState that = (SGState) other;
        for (int yc = 0; yc < 3; yc++) {     // for each tile
            for (int xc = 0; xc < 3; xc++) {
                if (this.board[yc][xc] != that.board[yc][xc])
                    return false;
            }
        }
        return true;

    }

}