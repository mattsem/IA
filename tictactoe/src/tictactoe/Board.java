/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author matts_000
 */
public class Board {
    char[] boardState;
    boolean enabled;
    private boolean finished;
    
    public Board(){
        boardState = new char[9];
        reset();
    }
    
//    public boolean isFinished(){
//        return finished;
//    }
    
    
    public void reset(){
        enabled = true;
//        finished = false;
        for (int boardPlace = 0; boardPlace < 9; boardPlace++) {
            
                boardState[boardPlace] = Tictactoe.EMPTY;
            
        }
    }
    
    public void print(){
        for (int i = 0; i < 3; i++) {
            printRow(i);
            
            if(i != 2){
                printLine();
            }
        }
    }
    
    public void printRow(int row){
        System.out.print(boardState[row*3]);
        System.out.print("|");
        System.out.print(boardState[1+(row*3)]);
        System.out.print("|");
        System.out.println(boardState[2+(row*3)]);
        
    }
    public void printLine(){
        System.out.println("-+-+-");
    }
    public char checkBoardWin(){
        char boardWin = Tictactoe.EMPTY;
        if(checkHorizontal() == Tictactoe.PLAYERX){
            boardWin = Tictactoe.PLAYERX;
        }
        if(checkHorizontal() == Tictactoe.PLAYERO){
            boardWin = Tictactoe.PLAYERO;
        }
        if(checkVertical() == Tictactoe.PLAYERX){
            boardWin = Tictactoe.PLAYERX;
        }
        if(checkVertical() == Tictactoe.PLAYERO){
            boardWin = Tictactoe.PLAYERO;
        }
        if(checkDiagonal() == Tictactoe.PLAYERX){
            boardWin = Tictactoe.PLAYERX;
        }
        if(checkDiagonal() == Tictactoe.PLAYERO){
            boardWin = Tictactoe.PLAYERO;
        }
        
        if(boardWin != Tictactoe.EMPTY){
//            disableFinishedBoard();
        } 
        
        
        return boardWin;
    }
    
    
    public boolean checkPossibleX(){
        if(checkPossibleHorizontal(Tictactoe.PLAYERX) != 3){
            
        }
        
        if(checkPossibleVertical(Tictactoe.PLAYERX) != 3){
            
        }
        if(checkPossibleDiagonal(Tictactoe.PLAYERX) == true){
            
        }
        if(checkPossibleOtherDiagonal(Tictactoe.PLAYERX) == true){
            
        }
        return true;
    }
    
    public boolean checkPosibleO(){
        if(checkPossibleHorizontal(Tictactoe.PLAYERO) != 3){
            
        }
        
        if(checkPossibleVertical(Tictactoe.PLAYERO) != 3){
            
        }
        if(checkPossibleDiagonal(Tictactoe.PLAYERO) == true){
            
        }
        if(checkPossibleOtherDiagonal(Tictactoe.PLAYERO) == true){
            
        }
        return true;
    }
    
    
//    public void disableFinishedBoard(){
////        finished = true;
//        enabled = false;
//    }
    
    
    public char checkHorizontal(){
        char rowWin = Tictactoe.EMPTY;
        for (int row = 0; row < 3; row++) {
            if(boardState[3*row]==Tictactoe.PLAYERX && boardState[3*row+1]==Tictactoe.PLAYERX && boardState[3*row+2]==Tictactoe.PLAYERX){
                rowWin=Tictactoe.PLAYERX;   
            }
        }
        for (int row = 0; row < 3; row++) {
            if(boardState[3*row]==Tictactoe.PLAYERO && boardState[3*row+1]==Tictactoe.PLAYERO && boardState[3*row+2]==Tictactoe.PLAYERO){
                rowWin=Tictactoe.PLAYERO;   
            }
        }
        
        return rowWin;
    }
    
    public int checkPossibleHorizontal(char symbol){
        int possible = 3;
        
        for (int row = 0; row < 3; row++) {
            int count = 0;
            
            for (int i = 0; i < 3; i++) {
                if(boardState[row + i] == symbol){
                    count++;
                }
            }
            if(count == 2){
                possible = row;
            }
            
        }
        return possible;
    }
            
            
            
    public char checkVertical(){
        char columnWin = Tictactoe.EMPTY;
        for (int col = 0; col < 3; col++) {
            if(boardState[col]==Tictactoe.PLAYERX && boardState[col+3]==Tictactoe.PLAYERX && boardState[col+6]==Tictactoe.PLAYERX){
                columnWin = Tictactoe.PLAYERX;
            }
        }
        for (int col = 0; col < 3; col++) {
            if(boardState[col]==Tictactoe.PLAYERO && boardState[col+3]==Tictactoe.PLAYERO && boardState[col+6]==Tictactoe.PLAYERO){
                columnWin = Tictactoe.PLAYERO;
            }
        }
        return columnWin;
    }
    
    public int checkPossibleVertical(char symbol){
        int possible = 3;
        
        for (int col = 0; col < 3; col++) {
            int count = 0;
            
            for (int i = 0; i < 3; i++) {
                if(boardState[col + 3 * i] == Tictactoe.PLAYERX){
                    count++;
                }
        
            }
            if(count == 2){
                possible = col;
            }
            
        }
        return possible;
    }
    
    public char checkDiagonal(){
        char diagWin =Tictactoe.EMPTY;
        if(boardState[0] ==Tictactoe.PLAYERX && boardState[4] ==Tictactoe.PLAYERX&& boardState[8] ==Tictactoe.PLAYERX){
            diagWin = Tictactoe.PLAYERX;
        }
        if(boardState[0] ==Tictactoe.PLAYERO && boardState[4] ==Tictactoe.PLAYERO&& boardState[8] ==Tictactoe.PLAYERO){
            diagWin = Tictactoe.PLAYERO;
        }
        if(boardState[2] ==Tictactoe.PLAYERX && boardState[4] ==Tictactoe.PLAYERX&& boardState[6] ==Tictactoe.PLAYERX){
            diagWin = Tictactoe.PLAYERX;
        }
        if(boardState[2] ==Tictactoe.PLAYERO && boardState[4] ==Tictactoe.PLAYERO&& boardState[6] ==Tictactoe.PLAYERO){
            diagWin = Tictactoe.PLAYERO;
        }
        return diagWin;
    }
    
    public boolean checkPossibleDiagonal(char symbol){
        
        
        int count = 0;
        
        
        for (int i = 0; i < 3; i++) {
            if(boardState[4 * i] == symbol){
                count++;
            }
            
        }
        
        if(count == 2){
            return true;
        }
        else{
            return false;
        }
        
        
    }
    
    public boolean checkPossibleOtherDiagonal(char symbol){
        
        int count = 0;
        
        for (int i = 0; i < 3; i++) {
            if(boardState[2 * i + 2] == Tictactoe.PLAYERX){
                count++;
            }
        }
        if(count == 2){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean validMove(int localBoardSpace){
        
        if (boardState[localBoardSpace] == Tictactoe.EMPTY && enabled == true) {
            return true;
        }
        else{
            return false;
        }
        
    }
    
    
}
