/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;
import java.util.*;
/**
 *
 * @author matts_000
 */
public class Tictactoe {
    Board[] globalBoard;
    int boardIndex;
    char player;
    
    public Tictactoe(){
        globalBoard = new Board[9];
        for (int boardIndex = 0; boardIndex < 9; boardIndex++) {
            
            globalBoard[boardIndex] = new Board();
            
        }
    }
    
    public void start(){
        boolean done = false;
        System.out.println("Welcome to Ultimate Tictactoe!");
        player ='x';
        printTictactoe();
        while(done == false){
            move();
            printTictactoe();
            if(checkWin()==true){
               done = true;
                System.out.println("Congrats!");
            }
            
            switchPlayer();
            
        }
    }
    
    
    public void printTictactoe(){
        for (int  boardIndex = 0; boardIndex < 9; boardIndex++) {
            globalBoard[boardIndex].print();
        }
    }
    
    public void switchPlayer(){
        if(player == 'x'){
            player = 'o';
        }
        if(player =='o'){
            player = 'x';
        }
    }
    
    public void move(){
        System.out.println("Where would you like to move?");
        Scanner sc = new Scanner(System.in);
        int localBoard = sc.nextInt();
        int localBoardSpace = sc.nextInt();
        if(globalBoard[localBoard].boardState[localBoardSpace] == ' '){
            globalBoard[localBoard].boardState[localBoardSpace] = player;  
        }
        else{
            System.out.println("Invalid move");
        }
        
    }
    
    public boolean checkWin(){
        boolean globalWin = false;
        for (int board = 0; board < 9; board++) {
            if(globalBoard[board].checkBoardWin() == true){
               globalWin = true; 
            }
            
        }
        return globalWin;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Tictactoe tictactoe = new Tictactoe();
        tictactoe.start();
        
    }
    
}
