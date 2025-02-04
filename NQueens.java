import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        
    }

    

    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        backtrack(board, n, 0);
        return result;
    }

    private void backtrack(boolean [][] board , int n ,int r ){
        // base 

      if(r==n){
          List<String> li = new ArrayList<>();

          for (int i = 0 ; i < n ; i++){
              StringBuilder str = new StringBuilder();
              for (int j =0 ; j < n ;j++){
                  if (board[i][j]){
                      str.append('Q');
                  }else{
                     str.append('.');
                  }

              }
              li.add(str.toString());
          }
          result.add(li);
          return;
      }


        // logic
        for(int c= 0 ; c < n ; c ++){
             if(isSafe(board, r,c,n)){
        //action
           board[r][c] = true;

        //rcurse
           backtrack(board, n, r+1 );
    
        //backtrack
          board[r][c] = false;

            
             }
            }

    }

    private boolean isSafe(boolean [][] board , int r , int c, int n){

        for (int i =0 ; i < r ; i++){
            if(board[i][c]) return false;
        }
        // upper right
        int i = r;
        int j =c;
       
            while (i>=0 && j>n){
             if(board[i][r]){
                  return false;
             }
            i--;
            j++;
             
            }
        
        //upper left
        i = r;
        j=c;
        while(i>=0 && j>=0){
           if(board[i][j]){
                return false;
           }
            i--;
            j--;
           

        }
        return true;
    }

}