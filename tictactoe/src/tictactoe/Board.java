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
    char[][] boardState;
    
    public Board(){
        boardState = new char[3][3];
        reset();
    }
    
    public void reset(){
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                boardState[col][row] = ' ';
            }
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
        System.out.print(boardState[0][row]);
        System.out.print("|");
        System.out.print(boardState[1][row]);
        System.out.print("|");
        System.out.println(boardState[2][row]);
        
    }
    public void printLine(){
        System.out.println("-+-+-");
    }
}
