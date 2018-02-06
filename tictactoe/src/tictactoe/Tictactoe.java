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
public class Tictactoe {
    Board[] boards;
    int boardIndex;
    int player;
    
    public Tictactoe(){
        boards = new Board[9];
        for (int boardIndex = 0; boardIndex < 9; boardIndex++) {
            
            boards[boardIndex] = new Board();
            
        }
    }
    
    public void start(){
        boolean done = false;
        while(done == false){
            printTictactoe();
            done = true;
        }
    }
    
    
    public void printTictactoe(){
        for (int  boardIndex = 0; boardIndex < 9; boardIndex++) {
            boards[boardIndex].print();
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Tictactoe tictactoe = new Tictactoe();
        tictactoe.start();
        
    }
    
}
