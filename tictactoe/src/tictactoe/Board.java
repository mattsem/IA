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
    boolean finished;
    
    public Board(){
        boardState = new char[9];
        reset();
    }
    
    public void reset(){
        enabled = true;
        finished = false;
        for (int boardPlace = 0; boardPlace < 9; boardPlace++) {
            
                boardState[boardPlace] = ' ';
            
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
        char boardWin = ' ';
        if(checkHorizontal() == 'x'){
            boardWin = 'x';
        }
        if(checkHorizontal() == 'o'){
            boardWin = 'o';
        }
        if(checkVertical() == 'x'){
            boardWin = 'x';
        }
        if(checkVertical() == 'o'){
            boardWin = 'o';
        }
        if(checkDiagonal() == 'x'){
            boardWin = 'x';
        }
        if(checkDiagonal() == 'o'){
            boardWin = 'o';
        }
        
        if(boardWin != ' '){
            disableFinishedBoard();
        } 
        
        
        return boardWin;
    }
    
    public void disableFinishedBoard(){
        finished = true;
        enabled = false;
    }
    
    
    public char checkHorizontal(){
        char rowWin = ' ';
        for (int row = 0; row < 3; row++) {
            if(boardState[3*row]=='x' && boardState[3*row+1]=='x' && boardState[3*row+2]=='x'){
                rowWin='x';   
            }
        }
        for (int row = 0; row < 3; row++) {
            if(boardState[3*row]=='o' && boardState[3*row+1]=='o' && boardState[3*row+2]=='o'){
                rowWin='o';   
            }
        }
        
        return rowWin;
    }
    public char checkVertical(){
        char columnWin = ' ';
        for (int col = 0; col < 3; col++) {
            if(boardState[col]=='x' && boardState[col+3]=='x' && boardState[col+6]=='x'){
                columnWin = 'x';
            }
        }
        for (int col = 0; col < 3; col++) {
            if(boardState[col]=='o' && boardState[col+3]=='o' && boardState[col+6]=='o'){
                columnWin = 'o';
            }
        }
        return columnWin;
    }
    public char checkDiagonal(){
        char diagWin =' ';
        if(boardState[0] =='x' && boardState[4] =='x'&& boardState[8] =='x'){
            diagWin = 'x';
        }
        if(boardState[0] =='o' && boardState[4] =='o'&& boardState[8] =='o'){
            diagWin = 'o';
        }
        if(boardState[2] =='x' && boardState[4] =='x'&& boardState[6] =='x'){
            diagWin = 'x';
        }
        if(boardState[2] =='o' && boardState[4] =='o'&& boardState[6] =='o'){
            diagWin = 'o';
        }
        return diagWin;
    }
    
    public boolean validMove(int localBoardSpace){
        
        if (boardState[localBoardSpace] == ' ' && enabled == true) {
            return true;
        }
        else{
            return false;
        }
        
    }
    
    
}
