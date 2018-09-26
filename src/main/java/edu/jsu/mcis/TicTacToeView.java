package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import edu.jsu.mcis.TicTacToeModel.Result;
import edu.jsu.mcis.TicTacToeModel.Mark;


public class TicTacToeView extends JPanel implements ActionListener {
    
    TicTacToeModel model;

    private JButton[][] squares;
    private JPanel squaresPanel;
    private JLabel resultLabel;
    private int MarkRow;
    private int MarkCol;


    public TicTacToeView(TicTacToeModel model) {

        this.model = model;

        int width = model.getWidth();

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        squares = new JButton[width][width];
        squaresPanel = new JPanel(new GridLayout(width,width));
        resultLabel = new JLabel();
        resultLabel.setName("ResultLabel");
        
        for (int row = 0; row < width; row++){
            
            for (int col = 0; col < width; col++){
                
                squares[row][col] = new JButton(); 
                squares[row][col].addActionListener(this);
                squares[row][col].setName("Square" + row + col);
                squares[row][col].setPreferredSize(new Dimension(64,64));
                squaresPanel.add(squares[row][col]);
                
            }
            
        }

        this.add(squaresPanel);
        this.add(resultLabel);
        
        resultLabel.setText("Welcome to Tic-Tac-Toe!");

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        
        /* Handle button clicks.  Extract the row and col values from the name
           of the button that was clicked, then make the mark in the grid using
           the Model's "makeMark()" method.  Finally, use the "updateSquares()"
           method to refresh the View.  If the game is over, show the result
           (from the Model's "getResult()" method) in the result label. */
        
        String name = ((JButton) event.getSource()).getName(); // Get button name
        
        

        //int row
        int row = 0;

        //int column
        int col = 0;

        // int uniCode for row at point 6
		int rowCode = name.codePointAt(6);

        // int uniCode for column at point 7
		int colCode = name.codePointAt(7);
		
        // column unicode ==
        if (colCode == 48) {col = 0;}
		if (colCode == 49) {col = 1;}
		if (colCode == 50) {col = 2;}
		

        // row unicode ==
		if (rowCode == 48) {row = 0;}
		if (rowCode == 49) {row = 1;}
		if (rowCode == 50) {row = 2;}
		
        
        //mark
		model.makeMark(row, col);
		MarkRow = row;
		MarkCol = col;
		
		//update the squares!
		updateSquares();
		

		//has game ended? check.
		if (model.getResult() == Result.X) {
			resultLabel.setText("X");
			model.isGameover();
		}
		if (model.getResult() == Result.O) {
			resultLabel.setText("O");
			model.isGameover();
		}
		if (model.getResult() == Result.TIE) {
			resultLabel.setText("TIE");
			model.isGameover();
		}
		
    
    }
        
    public void updateSquares() {

        /* Loop through all View buttons and (re)set the text of each button
           to reflect the grid contents (use the Model's "getMark()" method). */

           String MarkKind = "ERROR";

           if (model.getMark(MarkRow, MarkCol) == Mark.O) {
    		MarkKind = "O";
    		}

            if (model.getMark(MarkRow, MarkCol) == Mark.X) {
    		MarkKind = "X";

    		}
  
    	System.out.println(MarkRow + " " + MarkCol);
    	squares[MarkRow][MarkCol].setText(MarkKind);
    }
        
    public void showResult(String message) {
        resultLabel.setText(message);
    }

}
