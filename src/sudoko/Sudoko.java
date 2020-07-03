
package sudoko;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sudoko {

    public static void main(String[] args) throws Exception{
        Board[] board = new Board[50];
        board = createBoard();
        int solvedNumAdd = 0;
        int temp = 0;
        
        for(int i = 0; i < 50; i++){
            System.out.println("Problem " + i + ":");
            board[i].printBoard();
            
            System.out.println("Solved:");
            solve(board[i], 0, 0);
            
            temp = ((board[i].sud[0][0]*100)+(board[i].sud[0][1]*10)+(board[i].sud[0][2]));
            System.out.println("Solved Numbers of Top Row of Puzzle: " + temp);
            
            solvedNumAdd = solvedNumAdd + temp;
            System.out.println("Solved Number of All Puzzles: " + solvedNumAdd);
            
            System.out.println("");
            
        }
    }
    
    public static boolean solve(Board board, int a, int b){
        if(a==9){
            board.printBoard();
            return true;
        }
        
        if(board.sud[a][b] == 0){
            
            int i = 1;

            board.sud[a][b] = i;
            
            if(checkIfBoardWorks(board, a, b)){
                try{
                    if(solve(board, a, b+1) == true){
                        return true;
                    }

                } catch(IndexOutOfBoundsException e){
                    if(solve(board, a+1, 0) == true){
                        return true;
                    }
                }
            }
            i++;

            board.sud[a][b] = i;
            
            if(checkIfBoardWorks(board, a, b)){
                try{
                    if(solve(board, a, b+1) == true){
                        return true;
                    }

                } catch(IndexOutOfBoundsException e){
                    if(solve(board, a+1, 0) == true){
                        return true;
                    }
                }
            }
            i++;
            
            board.sud[a][b] = i;
            
            if(checkIfBoardWorks(board, a, b)){
                try{
                    if(solve(board, a, b+1) == true){
                        return true;
                    }

                } catch(IndexOutOfBoundsException e){
                    if(solve(board, a+1, 0) == true){
                        return true;
                    }
                }
            }
            i++;

            board.sud[a][b] = i;
            
            if(checkIfBoardWorks(board, a, b)){
                try{
                    if(solve(board, a, b+1) == true){
                        return true;
                    }

                } catch(IndexOutOfBoundsException e){
                    if(solve(board, a+1, 0) == true){
                        return true;
                    }
                }
            }
            i++;

            board.sud[a][b] = i;
            
            if(checkIfBoardWorks(board, a, b)){
                try{
                    if(solve(board, a, b+1) == true){
                        return true;
                    }

                } catch(IndexOutOfBoundsException e){
                    if(solve(board, a+1, 0) == true){
                        return true;
                    }
                }
            }
            i++;

            board.sud[a][b] = i;
            
            if(checkIfBoardWorks(board, a, b)){
                try{
                    if(solve(board, a, b+1) == true){
                        return true;
                    }

                } catch(IndexOutOfBoundsException e){
                    if(solve(board, a+1, 0) == true){
                        return true;
                    }
                }
            }
            i++;

            board.sud[a][b] = i;
            
            if(checkIfBoardWorks(board, a, b)){
                try{
                    if(solve(board, a, b+1) == true){
                        return true;
                    }

                } catch(IndexOutOfBoundsException e){
                    if(solve(board, a+1, 0) == true){
                        return true;
                    }
                }
            }
            i++;

            board.sud[a][b] = i;
            
            if(checkIfBoardWorks(board, a, b)){
                try{
                    if(solve(board, a, b+1) == true){
                        return true;
                    }

                } catch(IndexOutOfBoundsException e){
                    if(solve(board, a+1, 0) == true){
                        return true;
                    }
                }
            }
            i++;

            board.sud[a][b] = i;
            
            if(checkIfBoardWorks(board, a, b)){
                try{
                    if(solve(board, a, b+1) == true){
                        return true;
                    }

                } catch(IndexOutOfBoundsException e){
                    if(solve(board, a+1, 0) == true){
                        return true;
                    }
                }
            }
            
            board.sud[a][b] = 0;
            return false;
        } else {
                
            if(checkIfBoardWorks(board, a, b)){
                try{
                    if(solve(board, a, b+1) == true){
                        return true;
                    }

                } catch(IndexOutOfBoundsException e){
                    if(solve(board, a+1, 0) == true){
                        return true;
                    }
                }
            }
            return false;
        }
    }
    
    public static boolean checkIfSpacesFilled(Board board){
        // return true if all spaces are filled up if not return false
        
        int spacesSolved = 0;
        
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                if(board.sud[i][j] != 0){
                    spacesSolved++;
                }
            }
        }
        
        if(spacesSolved == 81){
            return true;
        }
        return false;
    }
    
    public static boolean rowCheck(Board board, int a, int b){
        for(int i = 0; i < 9; i++){
            for(int j = i+1; j < 9; j++){
                if(board.sud[a][i] != 0 && board.sud[a][i] == board.sud[a][j]){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean colCheck(Board board, int a, int b){
        for(int i = 0; i < 9; i++){
            for(int j = i+1; j < 9; j++){
                if(board.sud[i][b] != 0 && board.sud[i][b] == board.sud[j][b]){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean sqrCheck(Board board, int a, int b){
        List<Integer> boxNums = new ArrayList();
        
        if(a < 3){
            if(b < 3){
                
                for(int i = 0; i < 3; i++){
                    for (int j = 0;j <3; j++){
                        boxNums.add(board.sud[i][j]);
                    
                    }
                }
                
                if(!checkArray(boxNums)){
                    return false;
                }
                
            } else if(b < 6){
                for(int i = 0; i < 3; i++){
                    for (int j = 3;j <6; j++){
                        boxNums.add(board.sud[i][j]);
                    
                    }
                }
                
                if(!checkArray(boxNums)){
                    return false;
                }
                
            } else {
                for(int i = 0; i < 3; i++){
                    for (int j = 6;j <9; j++){
                        boxNums.add(board.sud[i][j]);
                    
                    }
                }
                
                if(!checkArray(boxNums)){
                    return false;
                }
                
            }
            
        }else if(a < 6){
            if(b < 3){
                
                for(int i = 3; i < 6; i++){
                    for (int j = 0;j <3; j++){
                        boxNums.add(board.sud[i][j]);
                    
                    }
                }
                
                if(!checkArray(boxNums)){
                    return false;
                }
                
            } else if(b < 6){
                
                for(int i = 3; i < 6; i++){
                    for (int j = 3;j < 6; j++){
                        boxNums.add(board.sud[i][j]);
                    
                    }
                }
                
                if(!checkArray(boxNums)){
                    return false;
                }
                
            } else {
                
                for(int i = 3; i < 6; i++){
                    for (int j = 6;j <9; j++){
                        boxNums.add(board.sud[i][j]);
                    
                    }
                }
                
                if(!checkArray(boxNums)){
                    return false;
                }
                
            }
            
        } else {
            if(b < 3){
                
                for(int i = 6; i < 9; i++){
                    for (int j = 0;j <3; j++){
                        boxNums.add(board.sud[i][j]);
                    
                    }
                }
                
                if(!checkArray(boxNums)){
                    return false;
                }
                
            } else if(b < 6){
                
                for(int i = 6; i < 9; i++){
                    for (int j = 3;j <6; j++){
                        boxNums.add(board.sud[i][j]);
                    
                    }
                }
                
                if(!checkArray(boxNums)){
                    return false;
                }
                
            } else {
                
                for(int i = 6; i < 9; i++){
                    for (int j = 6;j <9; j++){
                        boxNums.add(board.sud[i][j]);
                    
                    }
                }
                
                if(!checkArray(boxNums)){
                    return false;
                }
                
            }
            
        }
        return true;
    }
    
    public static boolean checkArray(List<Integer> boxNums){
        for(int i = 0; i < boxNums.size(); i++){
                    for(int j = i+1; j < boxNums.size(); j++){
                        if(boxNums.get(i) != 0 && (boxNums.get(i) == boxNums.get(j))){
                            return false;
                        }
                    }
                }
        return true;
    }
    
    public static boolean checkIfBoardWorks(Board board, int a, int b){
        if(!colCheck(board, a, b)){
            return false;
        }
        
        if(!rowCheck(board, a, b)){
            return false;
        }
        
        if(!sqrCheck(board, a, b)){
            return false;
        }
        return true;
    }
    
    public static Board[] createBoard() throws Exception{
        Board[] sudBoard = new Board[50];
        
        for(int i = 0; i < 50; i++){
            sudBoard[i] = new Board();
        }
        
        File file = new File("sudoko\\sudoku_probs.txt");
        Scanner sc = new Scanner(file);
        int i = 0;
        String next;
        int set;
        String setChar;
        
        while (sc.hasNextLine()){
            next = sc.nextLine();
            System.out.println("break");
            for(int a = 0; a<9; a++){
                next = sc.nextLine();
                System.out.println(next);
                for(int b = 0; b<9; b++){
                        set = Character.getNumericValue(next.charAt(b));
                        sudBoard[i].sud[a][b] = set;
                        
                    }
                }
            
        
                
            sudBoard[i].printBoard();
            i++;
        }
        
        return sudBoard;
    }
    
}
