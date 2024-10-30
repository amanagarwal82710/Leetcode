package leetcodeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RatInAMaze {

    public ArrayList<String> findPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        ArrayList<String> res = new ArrayList<>();
        Func(mat, res,  0, 0, "");
        return  res;
    }

    public void Func(int [][] mat, ArrayList<String> res, int i, int j, String s){
        if((i == mat.length-1) && j == mat[0].length-1){
            if(mat[i][j] == 1){
                res.add(s);
            }
        }

        if(i<0 || j<0 || i>= mat.length || j>= mat[0].length || mat[i][j] == 0){
            return;
        }

        mat[i][j] = 0;
        Func(mat,res,i,j+1,s + "R");
        Func(mat,res,i-1,j,s+"U");
        Func(mat,res,i,j-1,s+"L");
        Func(mat,res,i+1, j, s+"D");

        mat[i][j] = 1;
    }
}
