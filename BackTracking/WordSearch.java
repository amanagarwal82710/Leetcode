package leetcodeProblems.BackTracking;

public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if((board[i][j] == word.charAt(0)) && find(board,i,j,word,0)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean find(char[][] board, int i, int j, String word, int indx){
        if(indx == word.length()){
            return true;
        }
        if(i<0 || j<0 || i>=board.length || j>= board[0].length || board[i][j] == '$'){
            return false;
        }
        if(board[i][j] != word.charAt(indx)){
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '$';
        if(find(board,i+1,j,word,indx+1) ||
        find(board,i-1,j,word,indx+1)||
        find(board,i,j+1,word,indx+1)||
        find(board,i,j-1,word,indx+1)){
            return true;
        }
        board[i][j] = temp;


        return false;
    }

    public static void main(String[] args){
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";
        exist(board,word);
    }
}
