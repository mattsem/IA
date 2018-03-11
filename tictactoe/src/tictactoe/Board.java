/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;
import java.util.Random;
/**
 *
 * @author matts_000
 */
public class Board {
    
    private Tictactoe parent;
    char[] boardState;
    boolean enabled;
    private boolean finished;
    private static final int INVALID = 3;
    private static final int INVALID_SPACE = -1;
    

    public Board(Tictactoe parent) {
        boardState = new char[9];
        reset();
        this.parent = parent;
    }

//    public boolean isFinished(){
//        return finished;
//    }
    public void reset() {
        enabled = true;
//        finished = false;
        for (int boardPlace = 0; boardPlace < 9; boardPlace++) {

            boardState[boardPlace] = Tictactoe.EMPTY;

        }
    }

    public void print() {
        for (int i = 0; i < 3; i++) {
            printRow(i);

            if (i != 2) {
                printLine();
            }
        }
    }

    public void printRow(int row) {
        System.out.print(boardState[row * 3]);
        System.out.print("|");
        System.out.print(boardState[1 + (row * 3)]);
        System.out.print("|");
        System.out.println(boardState[2 + (row * 3)]);

    }

    public void printLine() {
        System.out.println("-+-+-");
    }

    public char checkBoardWin() {
        char boardWin = Tictactoe.EMPTY;
        if (checkHorizontal() == Tictactoe.PLAYERX) {
            boardWin = Tictactoe.PLAYERX;
        }
        if (checkHorizontal() == Tictactoe.PLAYERO) {
            boardWin = Tictactoe.PLAYERO;
        }
        if (checkVertical() == Tictactoe.PLAYERX) {
            boardWin = Tictactoe.PLAYERX;
        }
        if (checkVertical() == Tictactoe.PLAYERO) {
            boardWin = Tictactoe.PLAYERO;
        }
        if (checkDiagonal() == Tictactoe.PLAYERX) {
            boardWin = Tictactoe.PLAYERX;
        }
        if (checkDiagonal() == Tictactoe.PLAYERO) {
            boardWin = Tictactoe.PLAYERO;
        }

        if (boardWin != Tictactoe.EMPTY) {
//            disableFinishedBoard();
        }

        return boardWin;
    }
    
    public int findSpaceInRow(int row){
        
        for (int i = 0; i < 3; i++) {
            if(boardState[3*row + i] == Tictactoe.EMPTY){
                return 3 * row + i;
            }
        }
        return INVALID_SPACE;
    }
    
    public int findSpaceInCol(int col){
        for (int i = 0; i < 3; i++) {
            if(boardState[col + 3 * i] == Tictactoe.EMPTY){
                return col + 3 * i;
            }
        }
        return INVALID_SPACE;
    }
    
    public int findRightDiag(){
        for (int i = 0; i < 3; i++) {
            if (boardState[4 * i] == Tictactoe.EMPTY) {
                return 4 * i;
            }
        }
        return INVALID_SPACE;
    }
    
    public int findLeftDiag(){
        for (int i = 0; i < 3; i++) {
            if (boardState[2 * i + 2] == Tictactoe.EMPTY) {
                return 2 * i + 2;
            }
        }
        return INVALID_SPACE;
    }
    
    public int findRandomSpace(){
        Random rand = new Random();
        
        while(true){
            int space = Math.abs(rand.nextInt() % 9);
            if(validMove(space) == true){
                return space;
            }
        }
    }

    //check to see if computer can block a win
    public boolean blockX() {
        int result = checkPossibleHorizontal(Tictactoe.PLAYERX);
        if (result != INVALID) {
            //block win on given row
            int space = findSpaceInRow(result);
            if(space != INVALID_SPACE){
                parent.makeMove(parent.getCurrentBoard(), space);
                return true;
            }
        }
           
        result = checkPossibleVertical(Tictactoe.PLAYERX);
        if (result != INVALID) {
            //block win on ginven column
            
            int space = findSpaceInCol(result);
            if(space != INVALID_SPACE){
                parent.makeMove(parent.getCurrentBoard(), space);
                return true;
            }
        }
        if (checkPossibleRightDiagonal(Tictactoe.PLAYERX) == true) {
            int space = findRightDiag();
            if(space != INVALID_SPACE){
                parent.makeMove(parent.getCurrentBoard(), space);
                return true;
            }
        }
        if (checkPossibleLeftDiagonal(Tictactoe.PLAYERX) == true) {
            int space = findLeftDiag();
            if(space != INVALID_SPACE){
                parent.makeMove(parent.getCurrentBoard(), space);
                return true;
            }
        }
        return false;
    }
    
    
    //check to see if computer can win
    public boolean completeOToWin() {
        int result = checkPossibleHorizontal(Tictactoe.PLAYERO);
        if (result != INVALID) {
            //block win on given row
            System.out.println("win horizantal");
            int space = findSpaceInRow(result);
            if(space != INVALID_SPACE){
                parent.makeMove(parent.getCurrentBoard(), space);
                return true;
            }
        }
           
        result = checkPossibleVertical(Tictactoe.PLAYERO);
        if (result != INVALID) {
            //block win on ginven column
            System.out.println("win vertical");
            int space = findSpaceInCol(result);
            if(space != INVALID_SPACE){
                parent.makeMove(parent.getCurrentBoard(), space);
                return true;
            }
        }
        
        if (checkPossibleRightDiagonal(Tictactoe.PLAYERO) == true) {
            System.out.println("win right diag");
            int space = findRightDiag();
            if(space != INVALID_SPACE){
                parent.makeMove(parent.getCurrentBoard(), space);
                return true;
            }
        }
        
        if (checkPossibleLeftDiagonal(Tictactoe.PLAYERO) == true) {
            System.out.println("win right diag");
            int space = findLeftDiag();
            if(space != INVALID_SPACE){
            parent.makeMove(parent.getCurrentBoard(), space);
            return true;
            }
        }
        
        return false;
    }

//    public void disableFinishedBoard(){
////        finished = true;
//        enabled = false;
//    }
    public char checkHorizontal() {
        char rowWin = Tictactoe.EMPTY;
        for (int row = 0; row < 3; row++) {
            if (boardState[3 * row] == Tictactoe.PLAYERX && boardState[3 * row + 1] == Tictactoe.PLAYERX && boardState[3 * row + 2] == Tictactoe.PLAYERX) {
                rowWin = Tictactoe.PLAYERX;
                
            }
        }
        for (int row = 0; row < 3; row++) {
            if (boardState[3 * row] == Tictactoe.PLAYERO && boardState[3 * row + 1] == Tictactoe.PLAYERO && boardState[3 * row + 2] == Tictactoe.PLAYERO) {
                rowWin = Tictactoe.PLAYERO;
            }
        }

        return rowWin;
    }

    public int checkPossibleHorizontal(char symbol) {
        int possible = INVALID;

        for (int row = 0; row < 3; row++) {
            int count = 0;

            for (int col = 0; col < 3; col++) {
                if (boardState[3 * row + col] == symbol) {
                    count++;
                }
            }
            if (count == 2) {
                possible = row;
            }

        }
        return possible;
    }

    public char checkVertical() {
        char columnWin = Tictactoe.EMPTY;
        for (int col = 0; col < 3; col++) {
            if (boardState[col] == Tictactoe.PLAYERX && boardState[col + 3] == Tictactoe.PLAYERX && boardState[col + 6] == Tictactoe.PLAYERX) {
                columnWin = Tictactoe.PLAYERX;
                
            }
        }
        for (int col = 0; col < 3; col++) {
            if (boardState[col] == Tictactoe.PLAYERO && boardState[col + 3] == Tictactoe.PLAYERO && boardState[col + 6] == Tictactoe.PLAYERO) {
                columnWin = Tictactoe.PLAYERO;
            }
        }
        return columnWin;
    }

    public int checkPossibleVertical(char symbol) {
        int possible = INVALID;

        for (int col = 0; col < 3; col++) {
            int count = 0;

            for (int row = 0; row < 3; row++) {
                if (boardState[col + 3 * row] == symbol) {
                    count++;
                }

            }
            if (count == 2) {
                possible = col;
            }

        }
        return possible;
    }

    public char checkDiagonal() {
        char diagWin = Tictactoe.EMPTY;
        if (boardState[0] == Tictactoe.PLAYERX && boardState[4] == Tictactoe.PLAYERX && boardState[8] == Tictactoe.PLAYERX) {
            diagWin = Tictactoe.PLAYERX;
        }
        if (boardState[0] == Tictactoe.PLAYERO && boardState[4] == Tictactoe.PLAYERO && boardState[8] == Tictactoe.PLAYERO) {
            diagWin = Tictactoe.PLAYERO;
        }
        if (boardState[2] == Tictactoe.PLAYERX && boardState[4] == Tictactoe.PLAYERX && boardState[6] == Tictactoe.PLAYERX) {
            diagWin = Tictactoe.PLAYERX;
        }
        if (boardState[2] == Tictactoe.PLAYERO && boardState[4] == Tictactoe.PLAYERO && boardState[6] == Tictactoe.PLAYERO) {
            diagWin = Tictactoe.PLAYERO;
        }
        return diagWin;
    }

    public boolean checkPossibleRightDiagonal(char symbol) {

        int count = 0;

        for (int i = 0; i < 3; i++) {
            if (boardState[4 * i] == symbol) {
                count++;
            }

        }

        if (count == 2) {
            return true;
        } else {
            return false;
        }

    }

    public boolean checkPossibleLeftDiagonal(char symbol) {

        int count = 0;

        for (int i = 0; i < 3; i++) {
            if (boardState[2 * i + 2] == symbol) {
                count++;
            }
        }
        if (count == 2) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validMove(int localBoardSpace) {

        if (boardState[localBoardSpace] == Tictactoe.EMPTY && enabled == true) {
            return true;
        } else {
            return false;
        }

    }

}
