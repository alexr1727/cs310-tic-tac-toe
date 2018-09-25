package edu.jsu.mcis;

public class TicTacToeView {

    private TicTacToeModel model;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
        
    }
	
    public void viewModel() {
        
        /* Print the board to the console (see examples) */
        System.out.print("\n\n  ");
		for(int i = 0; i < model.getWidth(); i++){
			System.out.print(i);
		}
		System.out.print("\n\n");
		 for(int j = 0; j < model.getWidth(); j++){
			System.out.print(j);
			System.out.print(" ");
			for(int k = 0; k < model.getWidth(); k++){
				System.out.print(model.getMark(j,k));
			}
			System.out.print("\n");
		}
		System.out.print("\n\n");
    }
		

    public void showNextMovePrompt() {

        /* Display a prompt for the player's next move (see examples) */

		System.out.print("Enter the row and column numbers, separated by a space:");
		
    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */

        System.out.println("That is not a valid input!");

    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }
	
}