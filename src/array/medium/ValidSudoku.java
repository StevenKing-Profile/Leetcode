package array.medium;

import java.util.*;

/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

Note:
    A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    Only the filled cells need to be validated according to the mentioned rules.
 */
public class ValidSudoku {
    public static void main(String[] args) {
    }

    public static boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for (int i=0; i < 9; i++) {
            for (int j=0; j < 9; j++) {
                char number = board[i][j];
                if (number != '.') {
                    if (!set.add(number + "row" + i) || !set.add(number + "col" + j) || !set.add(number + "square" + i/3 + j/3 )) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

//    // Honestly disgusting
//    public static boolean isValidSudoku(char[][] board) {
//        // row validity
//        for (int i=1; i < 10; i++) {
//            int[] count = new int[10];
//            Arrays.fill(count, 0);
//            for (int j=0; j < 9; j++) {
//                if (board[i - 1][j] != '.') {
//                    count[Integer.parseInt(String.valueOf(board[i - 1][j]))]++;
//                }
//            }
//
//            for (int j = 1; j < 10; j++) {
//                if (count[j] > 1)
//                    return false;
//            }
//        }
//
//        // col validity
//        for (int i=1; i < 10; i++) {
//            int[] count = new int[10];
//            Arrays.fill(count, 0);
//            for (int j=0; j < 9; j++) {
//                if (board[j][i-1] != '.') {
//                    count[Integer.parseInt(String.valueOf(board[j][i-1]))]++;
//                }
//            }
//
//            for (int j=1; j < 10; j++) {
//                if (count[j] > 1)
//                    return false;
//            }
//        }
//
//        // table validity
//        int row = 0, col = 0;
//
//        for (int i=0; i < 9; i++) {
//            int[] count = new int[10];
//            Arrays.fill(count, 0);
//            for (int j=row; j < row + 3; j++) {
//                for (int k=col; k < col + 3; k++) {
//                    if (board[j][k] != '.')
//                        count[Integer.parseInt(String.valueOf(board[j][k]))]++;
//                }
//            }
//            col += 3;
//
//            if (i == 2) {
//                row = 3;
//                col = 0;
//            } else if (i == 5) {
//                row = 6;
//                col = 0;
//            }
//
//            for (int j=1; j < 10; j++) {
//                if (count[j] > 1)
//                    return false;
//            }
//        }
//
//        return true;
//    }
}
