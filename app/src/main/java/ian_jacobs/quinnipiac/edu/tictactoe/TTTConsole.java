package ian_jacobs.quinnipiac.edu.tictactoe;

import java.util.Scanner;
/**
 * Tic-Tac-Toe: Two-player console, non-graphics
 * @author relkharboutly
 * @date 1/5/2017
 */
public class TTTConsole  {
                                                     
      public static Scanner in = new Scanner(System.in); // the input Scanner
 
   public static TicTacToe TTTboard = new TicTacToe();
   /** The entry main method (the program starts here) */
   public static void main(String[] args) {
      
	   int currentState = TicTacToe.PLAYING;
	   String userInput;// = in.next();
	   int userChoice;// = Integer.valueOf(userInput);;
	   //game loop
	   do {
         TTTboard.printBoard();
         // Print message if game-over
         /**
          * get player input here and call setMove(). user should input a number between 0-8
          */
         System.out.println("Please input a value 0-8 to make your space selection!:  ");
        userInput = in.next();
        // System.out.println("USer input: " + userInput);
         userChoice = Integer.valueOf(userInput);
         if(userChoice < 0 || userChoice > 8){
        	 System.out.println("Please input a valid location....");
         } else {
        	TTTboard.setMove(1, userChoice);
        	currentState = TTTboard.checkForWinner();
        	
         }
         TTTboard.setMove(2, TTTboard.getComputerMove());
         
         currentState = TTTboard.checkForWinner();
         
         
         if (currentState == ITicTacToe.CROSS_WON) {
            System.out.println("*************************" + "\n" + "X won CONGRADULATIONS!" + "\n" + "*************************");
            TTTboard.printBoard();
         } else if (currentState == ITicTacToe.NOUGHT_WON) {
            System.out.println("***********************************************" + "\n" + "O won YOU ARE NOT SMARTER THAN A COMPUTER!" + "\n" + "***********************************************");
            TTTboard.printBoard();
         } else if (currentState == ITicTacToe.TIE) {
            System.out.println("*************************" + "\n" + "It's a Tie :( Game Over" + "\n" + "*************************");
            TTTboard.printBoard();
         }
         
         
         
      } while ((currentState == ITicTacToe.PLAYING) && (!userInput.equals("q"))); // repeat if not game-over
   }
 
     
}