// SudokuBoard Creed Jones CSC512 CBU December 27, 2017
//  this class represents a single Sudoku Board

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {
    private static final int SZ = 9;        // there are spots in the code that won't work if SZ != 9
    private Integer cells[][];

    public SudokuBoard() {
        cells = new Integer[SZ][SZ];
    }       // initializes to all zeros

    public String toString() {
        String res = "";
        for (int yinc = 0; yinc < SZ; yinc++) {
            if ( (yinc == 3) || (yinc == 6) ) {
                res = res + "------------------------\n\r";
            }
            for (int xinc = 0; xinc < SZ; xinc++) {
                if ( (xinc == 3) || (xinc == 6) ) {
                    res = res + " | ";
                }
                res = res + cells[yinc][xinc] + " ";
            }
            res += "\n\r";
        }
        return res;
    }

    public void fill(Integer[] data) {
        int inc = 0;
        for (int yinc = 0; yinc < SZ; yinc++) {
            for (int xinc = 0; xinc < SZ; xinc++) {
                cells[yinc][xinc] = data[inc++];
            }
        }
    }

    private int numPresent(List<Integer> arr, int size) {
        int result = 0;
        for (int incr = 1; incr <= size; incr++) {
            if (arr.contains(incr)) {
                result++;
            }
        }
        return result;
    }

    public int getFitness() {
        int fitness = 0, inc;

        List<Integer> checkArray = new ArrayList<Integer>(SZ);
        // first check the rows for each value from 1 to 9
        inc = 0;
        for (int xinc = 0; xinc < SZ; xinc++) {
            checkArray.clear();
            for (int yinc = 0; yinc < SZ; yinc++) {
                checkArray.add(cells[yinc][xinc]);
            }
            fitness += numPresent(checkArray, SZ);
        }

        // now check the columns for each value from 1 to 9
        inc = 0;
        for (int yinc = 0; yinc < SZ; yinc++) {
            checkArray.clear();
            for (int xinc = 0; xinc < SZ; xinc++) {
                checkArray.add(cells[yinc][xinc]);
            }
            fitness += numPresent(checkArray, SZ);
        }

        // finally check each 3x3 cell...
        for (int youter = 0; youter < 3; youter++) {
            for (int xouter = 0; xouter < 3; xouter++) {
                checkArray.clear();
                for (int yinner = 0; yinner < 3; yinner++) {
                    for (int xinner = 0; xinner < 3; xinner++) {
                        checkArray.add(cells[youter*3 + yinner][xouter*3+xinner]);
                    }
                }
                fitness += numPresent(checkArray, SZ);
            }
        }

        return fitness;
    }

    public static void main(String[] args) {    // to test the fitness function
        SudokuBoard sb = new SudokuBoard();
        Integer sampData[] = {  2, 9, 5, 7, 4, 3, 8, 6, 1,
                4, 3, 1, 8, 6, 5, 9, 2, 7,
                8, 7, 6, 1, 9, 2, 5, 4, 3,
                3, 8, 7, 4, 5, 9, 2, 1, 6,
                6, 1, 2, 3, 8, 7, 4, 9, 5,
                5, 4, 9, 2, 1, 6, 7, 3, 8,
                7, 6, 3, 5, 2, 4, 1, 8, 9,
                9, 2, 8, 6, 7, 1, 3, 5, 4,
                1, 5, 4, 9, 3, 8, 6, 7, 2};

        Integer sampData2[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9,
                1, 2, 3, 4, 5, 6, 7, 8, 9,
                1, 2, 3, 4, 5, 6, 7, 8, 9,
                1, 2, 3, 4, 5, 6, 7, 8, 9,
                1, 2, 3, 4, 5, 6, 7, 8, 9,
                1, 2, 3, 4, 5, 6, 7, 8, 9,
                1, 2, 3, 4, 5, 6, 7, 8, 9,
                1, 2, 3, 4, 5, 6, 7, 8, 9,
                1, 2, 3, 4, 5, 6, 7, 8, 9};

        sb.fill(sampData);
        System.out.println("Fitness is: " + sb.getFitness());
        sb.fill(sampData2);
        System.out.println("Fitness is: " + sb.getFitness());
    }
}