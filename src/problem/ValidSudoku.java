package problem;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {

        char[][] sudoku =
                {
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}

                };

        String[][] notValid = {
                {"8", "3", ".", ".", "7", ".", ".", ".", "."}
                , {"6", ".", ".", "1", "9", "5", ".", ".", "."}
                , {".", "9", "8", ".", ".", ".", ".", "6", "."}
                , {"8", ".", ".", ".", "6", ".", ".", ".", "3"}
                , {"4", ".", ".", "8", ".", "3", ".", ".", "1"}
                , {"7", ".", ".", ".", "2", ".", ".", ".", "6"}
                , {".", "6", ".", ".", ".", ".", "2", "8", "."}
                , {".", ".", ".", "4", "1", "9", ".", ".", "5"}
                , {".", ".", ".", ".", "8", ".", ".", "7", "9"}
        };

        char[][] testcase364 = {
                {'.', '.', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '3', '.', '.', '.', '.', '.', '1'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'1', '.', '.', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '.', '2', '.', '6', '.', '.'},
                {'.', '9', '.', '.', '.', '.', '.', '7', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'8', '.', '.', '8', '.', '.', '.', '.', '.'}
        };

        boolean validSudoku = isValidSudoku(testcase364);
        System.out.println(validSudoku);
    }

    public static boolean isValidSudoku(char[][] board) {

        Set<Character> row = new HashSet<>(10);
        Set<Character> column = new HashSet<>(10);
        Set<String> non_duplicate = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char s = board[i][j];
                char s2 = board[j][i];
                System.out.println(s);
                if (!(s == '.')) {
                    String box = "box + " + ((i / 3) * 3 + (j / 3)) + " + " + s;
                    if (!non_duplicate.add(box)) {
                        return false;
                    }
                    if (!row.add(s)) {
                        return false;
                    }
                }

                if (!(s2 == '.')) {
                    if (!column.add(s2)) {
                        return false;
                    }
                }
            }
            row.clear();
            column.clear();


        }


        return true;
    }

    //optimized
//    public static boolean isValidSudoku2(char[][] board) {
//
//        for(int i = 0; i<9; i++){
//            HashSet<Character> rows = new HashSet<Character>();
//            HashSet<Character> columns = new HashSet<Character>();
//            HashSet<Character> cube = new HashSet<Character>();
//            for (int j = 0; j < 9;j++){
//                if(board[i][j]!='.' && !rows.add(board[i][j]))
//                    return false;
//                if(board[j][i]!='.' && !columns.add(board[j][i]))
//                    return false;
//                int RowIndex = 3*(i/3);
//                int ColIndex = 3*(i%3);
//                if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
//                    return false;
//            }
//        }
//        return true;
//    }
}
