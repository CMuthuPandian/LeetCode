/*

Determine if a 9 x 9 Sudoku board is valid.
Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.

Input: board =
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true

Example 2:

Input: board =
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8.
Since there are two 8's in the top left 3x3 sub-box, it is invalid.

 */

public class ValidSuduko_24 {

    public static void main(String[] args){
        char[][] arr = {
                {'5','3','.','.','7','.','6','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSuduko(arr));
    }

    public static boolean isValidSuduko(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j =0;j<board.length-1;j++){
                int temp=j+1;
                if(board[i][j]!='.'){
                    while(temp<board.length){
                        if((board[i][j]==board[i][temp])){
                            return false;
                        }
                        else
                            temp++;
                    }
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j =0;j<board.length-1;j++){
                int temp1=j+1;
                if(board[j][i]!='.'){
                    while(temp1<board.length){
                        if((board[j][i]==board[temp1][i])){
                            return false;
                        }
                        else
                            temp1++;
                    }
                }
            }
        }
        for (int block = 0; block < 9; block++) {
            boolean[] m = new boolean[9];
            for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
                for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
                    if (board[i][j] != '.') {
                        if (m[(int) (board[i][j] - '1')]) {
                            return false;
                        }
                        m[(int) (board[i][j] - '1')] = true;
                    }
                }
            }
        }
        return true;
    }
}

/*

//checking subbox program for understanding.Other two parts are best and take less time.

private boolean checkCol(char[][] matrix, int col) {
        boolean[] filled = new boolean[9]; /
        for (int i = 0; i < 9; i++) {
            char cell = matrix[i][col];
            if (cell == '.') continue;
            int index = cell - '1';
            if (filled[index]) return false;
            filled[index] = true;
        }
        return true;
    }


 */
