/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author Matt
 */
public class MyButton extends javax.swing.JButton {

    private int index;
    private int board;
    private int boardSpace;

    public MyButton(int board, int boardSpace) {
        this.index = index;
        this.board = board;
        this.boardSpace = boardSpace;
    }

    public int getIndex() {
        return index;
    }

    public int getBoard() {
        return board;
    }

    public int getBoardSpace() {
        return boardSpace;
    }

}
