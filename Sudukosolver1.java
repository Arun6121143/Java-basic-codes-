public class SudokuSolver1 {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int [] [] board={{7, 0, 2, 0, 5, 0, 6, 0, 0},
                         {0, 0, 0, 0, 0, 3, 0, 0, 0},
                         {1, 0, 0, 0, 0, 9, 5, 0, 0},
                         {8, 0, 0, 0, 0, 0, 0, 9, 0},
                         {0, 4, 3, 0, 0, 0, 7, 5, 0},
                         {0, 9, 0, 0, 0, 0, 0, 0, 8},
                         {0, 0, 9, 7, 0, 0, 0, 0, 5},
                         {0, 0, 0, 2, 0, 0, 0, 0, 0},
                         {0, 0, 7, 0, 4, 0, 2, 0, 3} };
                         printBoard(board);
        if(solveBoard(board)){
            System.out.println("solved");
        }
        else{
              System.out.println("unsolved");
        }
        printBoard(board);
    }
    private static void printBoard(int [][] board){
        for(int row=0;row<9;row++){
            if(row%3==0 && row!=0){
                System.out.println("----------");
            }
            for(int column=0;column<9;column++){
                if(column%3==0 && column!=0){
                    System.out.print("|");
                }
                System.out.print(board[row][column]);
            }
            System.out.println();
        }
    }
    private static boolean isNumberInRow(int [][] board,int number,int row){
        for(int i=0;i<9;i++){
            if(board[row][i]==number){
                return true;
            }
        }
        return false;
    }
     private static boolean isNumberInColumn(int [][] board,int number,int column){
        for(int i=0;i<9;i++){
            if(board[i][column]==number){
                return true;
            }
        }
        return false;
    }
     private static boolean isNumberInBox(int [][] board,int number,int row , int column){
         int localBoxRow=row-row%3;
          int localBoxColumn=column-column%3;
      for(int i=localBoxRow;i< localBoxRow+3;i++ ){
          for(int j= localBoxColumn;j< localBoxColumn+3;j++){
              if(board[i][j]==number){
                  return true;
              }
          }
      }
         return false;
    }
    private static boolean isValidPlacaement(int [][] board,int number,int row , int column){
        return !isNumberInRow(board,number,row) &&
            !isNumberInColumn(board,number,column)&&
            !isNumberInBox(board,number,row,column);
    }
    private static boolean solveBoard(int [][] board){
        for(int row=0;row<9;row++){
            for(int column=0;column<9;column++){
                if(board[row][column]==0){
                    for(int numberToTry=1;numberToTry<=9;numberToTry++){
                        if( isValidPlacaement(board,numberToTry,row ,column)){
                            board[row][column]=numberToTry;
                            if(solveBoard(board)){
                                return true;
                            }
                            else{
                                board[row][column]=0;
                            }
                        }
                    }
                    return false;
                }
               
            }
        }
        return true;
    }
}
