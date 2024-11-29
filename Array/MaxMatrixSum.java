package leetcodeProblems.Array;

public class MaxMatrixSum {
    public long maxMatrixSum(int[][] matrix) {

        int negativeElements =0;
        int min = Integer.MAX_VALUE;

        int sum =0;
        int n= matrix.length;
        int m = matrix[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] < 0){
                    negativeElements++;
                }

                int ab = Math.abs(matrix[i][j]);
                min = Math.min(min,ab);
                sum += ab;
            }
        }

        if(negativeElements % 2 == 0){
            return sum;
        }


        return sum - 2L *min;
    }
}
