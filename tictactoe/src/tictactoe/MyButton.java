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
    
    public MyButton(int index) {
        this.index = index;
    }
    
    public int getIndex(){
        return index;
    }
}
