package leetcodeProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class nQueens2 {
     static int sol =0;

    public static int totalNQueens(int n) {

        List<List<String>> res = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        Func(res,board,n,0);
        return sol;

    }

    public static void Func(List<List<String>> ans, boolean[][] board, int n, int row){
        if(row == n){
            sol ++;
            return;
        }

        for(int col =0; col<n; col++){
            board[row][col] = true;
            if(isValid(board,n,row, col)){
                Func(ans,board,n,row+1);
            }
            board[row][col] = false;

        }
    }

    public static boolean isValid(boolean[][] board, int n, int row, int col){
        for(int i=0; i<n; i++){
            if(i != col && board[row][i]){
                return false;
            }
            if(i != row && board[i][col]){
                return false;
            }

            int tr = row+1, tc = col+1;
            while (tr<n && tc < n){
                if(board[tr][tc]){
                    return false;
                }
                tr++;
                tc ++;
            }

            tr = row-1;
            tc = col-1;
            while (tr >=0 && tc >= 0){
                if(board[tr][tc]){
                    return false;
                }
                tr--;
                tc --;
            }

            tr = row -1;
            tc = col+1;
            while (tr >=0 && tc < n){
                if(board[tr][tc]){
                    return false;
                }
                tr--;
                tc ++;
            }
            tr = row+1;
            tc = col-1;
            while (tr < n && tc >= 0){
                if(board[tr][tc]){
                    return false;
                }
                tr++;
                tc --;
            }
        }
        return true;
    }

    public static void main(String[] args){
        int k = 4;
        int list = totalNQueens(k);
        System.out.println(list);

    }
}
