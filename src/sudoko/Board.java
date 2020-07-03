
package sudoko;

public class Board {
    int[][] sud = new int[9][9];
    
    public Board(){
        for (int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                this.sud[i][j] = 0;
            }
        }        
    } // end public board

    public int getSpaceNum(int a, int b) {
        return this.sud[a][b];
    }

    public void setSpaceNum(int a, int b, int c) {
        this.sud[a][b] = c;
    }
    
    public String printRow(int b){
        String printThis = "";
        for(int a = 0; a<9; a++){
            if(a % 3 == 0 && a != 0){
                printThis = printThis + " |";
            }
            printThis = String.format("%s ( %02d )", printThis, this.sud[b][a]);
        }
        return printThis;
    }
    
    public void printBoard(){
       for(int b = 0; b<9; b++){
           if(b % 3 == 0 && b!=0){
               System.out.println("----------------------|----------------------|----------------------");
           }
           System.out.println(printRow(b));
       }
        System.out.println("");
    }
  
}
