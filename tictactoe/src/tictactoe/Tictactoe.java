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
    
    public Tictactoe(){
        boards = new Board[9];
        for (int boardNum = 0; boardNum < 3; boardNum++) {
            
            boards[boardNum] = new Board();
            
        }
    }
    
    public void start(){
        boolean done = false;
        while(done == false){
            
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
