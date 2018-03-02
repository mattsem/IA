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
    
    public boolean isFinished(){
        return finished;
    }
    
    
    public void reset(){
        enabled = true;
        finished = false;
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
            disableFinishedBoard();
        } 
        
        
        return boardWin;
    }
    
    public void disableFinishedBoard(){
        finished = true;
        enabled = false;
    }
    
    
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
    
    public boolean validMove(int localBoardSpace){
        
        if (boardState[localBoardSpace] == Tictactoe.EMPTY && enabled == true) {
            return true;
        }
        else{
            return false;
        }
        
    }
    
    
}
