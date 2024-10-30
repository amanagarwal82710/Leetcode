package leetcodeProblems;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;

        for(int i=0; i<col; i++){
            list.add(matrix[0][i]);
        }

        for(int i=1; i< row; i++){
            list.add(matrix[i][col-1]);
        }

        for(int i= col-2; i>=0; i--){
            list.add(matrix[row-1][i]);
        }

        for(int i= row-2; i>=1; i--){
            list.add(matrix[i][0]);
        }

        for(int i=1; i<col-1; i++){
            list.add(matrix[row/2][i]);
        }

        return list;
    }
}
