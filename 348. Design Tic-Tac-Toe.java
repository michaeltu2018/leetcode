public class TicTacToe {
    int[] rows1;
    int[] cols1;
    int diagonal1;
    int anti_diagonal1;
    int[] rows2;
    int[] cols2;
    int diagonal2;
    int anti_diagonal2;
    int n;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows1 = new int[n];
        cols1 = new int[n];
        rows2 = new int[n];
        cols2 = new int[n];
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if(player == 1){
            rows1[row]++;
            cols1[col]++;
            if(rows1[row] == n || cols1[col] == n){
                return 1;
            }
            if(row == col){
                diagonal1++;
            }
            if((row + col) == (n-1)){
                anti_diagonal1++;
            }
            if(diagonal1 == n || anti_diagonal1 == n){
                return 1;
            }
        }
        else{
            rows2[row]++;
            cols2[col]++;
            if(rows2[row] == n || cols2[col] == n){
                return 2;
            }
            if(row == col){
                diagonal2++;
            }
            if((row + col) ==(n-1)){
                anti_diagonal2++;
            }
            if(diagonal2 == n || anti_diagonal2 == n){
                return 2;
            }
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
