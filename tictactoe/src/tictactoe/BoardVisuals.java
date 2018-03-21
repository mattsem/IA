/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author semimat19
 */
public class BoardVisuals extends javax.swing.JPanel {

    private Tictactoe parent;
    private MyButton buttons[];

    /**
     * Creates new form BoardVisuals
     */
    public BoardVisuals(Tictactoe parent) {
        initComponents();
        menuButton.setVisible(false);
        this.parent = parent;
        this.setSize(800, 800);
        buttons = new MyButton[81];
        this.setBackground(Color.gray);

        // add all the buttons!
//        int index = 0;
        int boardNum;
        int boardSpace;

        
        //create all 81 buttons and get them layed out properly
        for (int boardRow = 0; boardRow < 3; boardRow++) {
            for (int boardCol = 0; boardCol < 3; boardCol++) {
                for (int rows = 0; rows < 3; rows++) {
                    for (int cols = 0; cols < 3; cols++) {
                        boardNum = 3 * boardRow + boardCol;
                        boardSpace = 3 * rows + cols;
                        buttons[boardNum * 9 + boardSpace] = new MyButton(boardNum, boardSpace);
                        buttons[boardNum * 9 + boardSpace].setLocation(130 + boardCol * 175 + 55 * cols, 130 + boardRow * 175 + 55 * rows);

                        this.add(buttons[boardNum * 9 + boardSpace]);
                        buttons[boardNum * 9 + boardSpace].setText(" ");
                        buttons[boardNum * 9 + boardSpace].setSize(50, 50);

//                        btn.setLocation(130 + boardCol * 175 + 55 * cols, 130 + boardRow * 175 + 55 * rows);
//adds the ability to respond to a click
                        buttons[boardNum * 9 + boardSpace].addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                myButtonActionPerformed(evt);
                            }
                        });
                        buttons[boardNum * 9 + boardSpace].setVisible(true);
                    }
                }
            }
        }
    }

    //if clicked, get the location and info and send to button clicked to decide if a move should be made
    //if it is, disable the button and switch player
    //if AI is on, signal computer move
    public void myButtonActionPerformed(java.awt.event.ActionEvent evt) {
        MyButton btn = (MyButton) evt.getSource();
        if (parent.buttonClicked(btn.getBoard(), btn.getBoardSpace()) == true) {
            setButtonText(btn.getBoard(), btn.getBoardSpace());
            btn.setEnabled(false);
            parent.switchPlayer();
            if (parent.getOnePlayer() == true && parent.getWon() == false) {
                parent.computerMove(btn.getBoardSpace());
            }
        }
    }

    //change button appearence to show play
    public void setButtonText(int board, int space) {
        buttons[board * 9 + space].setText(Character.toString(parent.getPlayer()));
    }

    //reset button color
    public void setButtonsColorWhite() {
        for (int i = 0; i < 81; i++) {
            buttons[i].setBackground(Color.white);
        }
    }

    //reset button text
    public void setButtonsText() {
        for (int i = 0; i < 81; i++) {
            buttons[i].setText(" ");
        }
    }

    
    public void enableAllButtons() {
        for (int i = 0; i < 81; i++) {
            buttons[i].setEnabled(true);
        }
    }

    //if the game is won, change all buttons to show a victory
    public void setButtonsColorWinner(char player) {
        if (player == 'X') {
            for (int i = 0; i < 81; i++) {
                buttons[i].setBackground(Color.DARK_GRAY);
            }
        }
        if (player == 'O') {
            for (int i = 0; i < 81; i++) {
                buttons[i].setBackground(Color.LIGHT_GRAY);
            }
        }
    }

    //when a player wins a board, change the appearence to show that
    public void setBoardColor(int board, char player) {
        if (player == 'X') {
            for (int i = 9 * board; i < 9 * board + 9; i++) {
                buttons[i].setBackground(Color.DARK_GRAY);
            }
        }
        if (player == 'O') {
            for (int i = 9 * board; i < 9 * board + 9; i++) {
                buttons[i].setBackground(Color.LIGHT_GRAY);
            }
        }
    }

    //outline winning buttons colors, unused
    public void setButtonOutline(int board, int boardSpace) {
        buttons[board * 9 + boardSpace].setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
    }

    //outline the won boards, unused
    public void setBoardButtonOutline(int board, char player) {
        if (player == 'X') {
            for (int i = 9 * board; i < 9 * board + 9; i++) {
                buttons[i].setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
            }
        }
        if (player == 'O') {
            for (int i = 9 * board; i < 9 * board + 9; i++) {
                buttons[i].setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));
            }
        }

    }

    //if the board is enabled, outline it
    public void setEnabledOutline(int board) {
        for (int i = 9 * board; i < 9 * board + 9; i++) {
            buttons[i].setBorder(BorderFactory.createLineBorder(Color.black, 2));
        }
    }

    //if all boards are enabled, outline them all
    public void setAllEnabledOutline() {
        for (int i = 0; i < 81; i++) {
            buttons[i].setBorder(BorderFactory.createLineBorder(Color.black, 2));
        }
    }

    //when a button is clicked, and its valid change its color
    public void setButtonColor(int board, int boardSpace, char player) {
        if (player == 'X') {
            buttons[board * 9 + boardSpace].setBackground(Color.DARK_GRAY);
        }
        if (player == 'O') {
            buttons[board * 9 + boardSpace].setBackground(Color.LIGHT_GRAY);
        }
    }

    //get rid of all outline
    public void resetButtonOutline() {
        for (int i = 0; i < 81; i++) {
            buttons[i].setBorder(BorderFactory.createEmptyBorder());
        }
    }

    //show the menu button
    public void setMenuButtonVisible(boolean b) {
        menuButton.setVisible(b);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuButton = new javax.swing.JButton();

        menuButton.setText("Menu");
        menuButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addComponent(menuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(350, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(723, Short.MAX_VALUE)
                .addComponent(menuButton)
                .addGap(52, 52, 52))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void menuButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuButtonMouseClicked
        // TODO add your handling code here:
        parent.showMenu();
        parent.resetAllBoards();
        setButtonsColorWhite();
        setButtonsText();
        parent.enableAllBoards();
        enableAllButtons();
        resetButtonOutline();
    }//GEN-LAST:event_menuButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton menuButton;
    // End of variables declaration//GEN-END:variables
}
