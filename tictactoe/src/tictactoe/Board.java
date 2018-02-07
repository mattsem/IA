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
    public void checkBoardWin(){
        checkHorizontal();
        checkVertical();
        checkDiagonal();
    }
    
    public void checkHorizontal(){
        
    }
    public void checkVertical(){
        
    }
    public void checkDiagonal(){
        
    }
}
