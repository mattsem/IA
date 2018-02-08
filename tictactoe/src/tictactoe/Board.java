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
    
    public Board(){
        boardState = new char[9];
        reset();
    }
    
    public void reset(){
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
    public boolean checkBoardWin(){
        boolean boardWin = false;
        if(checkHorizontal() == true)
            boardWin = true;
        if(checkVertical() == true)
            boardWin = true;
        if(checkDiagonal() == true)
            boardWin = true;
        return boardWin;
    }
    
    public boolean checkHorizontal(){
        boolean rowWin = false;
        for (int row = 0; row < 3; row++) {
            if(boardState[3*row]=='x' && boardState[3*row+1]=='x' && boardState[3*row+2]=='x'){
                rowWin=true;   
            }
        }
        for (int row = 0; row < 3; row++) {
            if(boardState[3*row]=='o' && boardState[3*row+1]=='o' && boardState[3*row+2]=='o'){
                rowWin=true;   
            }
        }
        
        return rowWin;
    }
    public boolean checkVertical(){
        boolean columnWin = false;
        for (int col = 0; col < 3; col++) {
            if(boardState[col]=='x' && boardState[col+3]=='x' && boardState[col+6]=='x'){
                columnWin = true;
            }
        }
        for (int col = 0; col < 3; col++) {
            if(boardState[col]=='o' && boardState[col+3]=='o' && boardState[col+6]=='o'){
                columnWin = true;
            }
        }
        return columnWin;
    }
    public boolean checkDiagonal(){
        boolean diagWin =false;
        if(boardState[0] =='x' && boardState[4] =='x'&& boardState[8] =='x'){
            diagWin = true;
        }
        if(boardState[0] =='o' && boardState[4] =='o'&& boardState[8] =='o'){
            diagWin = true;
        }
        if(boardState[2] =='x' && boardState[4] =='x'&& boardState[6] =='x'){
            diagWin = true;
        }
        if(boardState[2] =='o' && boardState[4] =='o'&& boardState[6] =='o'){
            diagWin = true;
        }
        return diagWin;
    }
}
