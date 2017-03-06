package ian_jacobs.quinnipiac.edu.tictactoe;

import java.util.ArrayList;
import java.util.List;

/**
 * TicTacToe class implements the interface
 * @author Ian Jacobs
 * @date 2/2/2017
 */
public class  TicTacToe implements ITicTacToe {
		 
	   // The game board and the game status
	   private static final int ROWS = 3, COLS = 3; // number of rows and columns
	   private int[][] board = new int[ROWS][COLS]; // game board in 2D array
	   int HUMAN_PLAYER;
	   int COMPUTER_PLAYER;
	  
	/**
	 * clear board and set current player   
	 */
	public TicTacToe(){
		clearBoard();
	    HUMAN_PLAYER = 1;
		COMPUTER_PLAYER = 2;
		
	}

	/*
	Method to clear the board set all location to empty
	 */
	@Override
	public void clearBoard() {
		for(int i = 0; i < board.length; i++){						//iterate throught the board
			for(int j = 0; j < board[0].length; j++){
				board[i][j] = EMPTY;								//set each location to EMPTY
			}
		}

	}

	//method used to take the board and set to a string
	@Override
	public String getBoard(){
		String out = "";
		for(int i = 0; i < board.length; i++){						//iterate throught the board
			for(int j = 0; j < board[0].length; j++){
				out += board[i][j];									//create the stirng
			}
		}
		return out;
	}

	//set the board from a string
	public void setUP(String s){
		board[0][0] = Integer.parseInt(s.substring(0,1).toString());
		board[0][1] = Integer.parseInt(s.substring(1,2).toString());
		board[0][2] = Integer.parseInt(s.substring(2,3).toString());
		board[1][0] = Integer.parseInt(s.substring(3,4).toString());
		board[1][1] = Integer.parseInt(s.substring(4,5).toString());
		board[1][2] = Integer.parseInt(s.substring(5,6).toString());
		board[2][0] = Integer.parseInt(s.substring(6,7).toString());
		board[2][1] = Integer.parseInt(s.substring(7,8).toString());
		board[2][2] = Integer.parseInt(s.substring(8).toString());
	}

	/*
	@param int player int location this method takes in a player and a location
	and sets the players move at that locatoin on the board.
	 */
	@Override
	public boolean setMove(int player, int location) {
		
		//board location
		int x = 0;
		int y = 0;
		
		//player value
		int p = 0;

		//create boolean for valid location
		boolean isOk = false;
		
		//set board coord based upon user input
		switch(location) {
			case 0: x = 0; y = 0; break;
			case 1: x = 0; y = 1; break;
			case 2: x = 0; y = 2; break;
			case 3: x = 1; y = 0; break;
			case 4: x = 1; y = 1; break;
			case 5: x = 1; y = 2; break;
			case 6: x = 2; y = 0; break;
			case 7: x = 2; y = 1; break;
			case 8: x = 2; y = 2; break;
		}	
		
		//set the mark of the player
		switch(player) {
			case 1: p = CROSS; break;
			case 2: p = NOUGHT; break;
		}
		
		//check if board space is empty prior to placement
		if(board[x][y] == EMPTY){
			board[x][y] = p;
			isOk = true;
		}
		return isOk;							//return if the move is legal

	}

	/*
	Method to choose a location for the computer player based upon game status
	 */
	@Override
	public int getComputerMove() {
		//get the move variables
		int moveLocation = 0;
		int moveY = 0;
		int moveX = 0;
		
		//handle the first row if the 
		int nc1 = 0;
		int nc2 = 0;
		int nn1 = 0;
		int nn2 = 0;

		//best stratagie is to take the middle location
		if(board[1][1] == EMPTY){
			return 4;
		}
		
		/*
		This series of loops check if the computer has two of a kind in a row
		if this is the case the computer will choose the final location and win
		if not the method will check if the oppoenet has two in  a row and will
		block that player. Else it will return the next open locatoin as the move
		location going from bottom right to top left.
		 */
		for(int r = 0; r < board.length; r++){							//start iterating thought board
			nc1 = 0;
			nn1 = 0;
			for(int i1 = 0; i1 < board[0].length; i1++){				//if a CROSS is found add it to the count
				if(board[r][i1] == CROSS){
					nc1++;
				}
				
				if(board[r][i1] == NOUGHT){								//if a NOUGHT is found add it to the count
					nn1++;
				}
				//check if there two noughts and you can win
				if(nn1 == 2){
					for(int i11 = 0; i11 < board.length; i11++){		//if there are two noughts find the location that is empty and can win
						if(board[r][i11] == EMPTY){
							moveX = r;
							moveY = i11;
							nn1 = 0;
							return getMove(moveX, moveY);				//return that location
						}
					}
				}
				//check if two crosses and a block is required
				if(nc1 == 2){
					for(int i11 = 0; i11 < board.length; i11++){		//find the spot that needs to be blocked
						if(board[r][i11] == EMPTY){
							moveX = r;
							moveY = i11;
							nc1 = 0;
							return getMove(moveX, moveY);				//return that location
						}
					}
				}
			}
		}
		
		
		for(int y = 0; y < board.length; y++){							//start the iteration
			nc2 = 0;													//set counts to zero
			nn2 = 0;
			for(int i = 0; i < board.length; i++){						//if a CROSS is found add to count
				if(board[i][y] == CROSS){
					nc2++;
				}
				
				if(board[i][y] == NOUGHT){								//if a nought is found add to count
					nn2++;
				}
				
				if(nn2 == 2){											//if two noughts and can win
					for(int i11 = 0; i11 < board.length; i11++){		//find the location where its empty and can win
						if(board[i11][y] == EMPTY){
							moveX = i11;
							moveY = y;
							nn2 = 0;
							return getMove(moveX, moveY);				//return that location
						}
					}
				}
				
				if(nc2 == 2){											//if two crosses and a block is requirted
					for(int i11 = 0; i11 < board.length; i11++){		//find the spot where the cross is
						if(board[i11][y] == EMPTY){
							moveX = i11;
							moveY = y;
							nc2 = 0;
							return getMove(moveX, moveY);				//return the location
						}
					}
				} else {
					for(int a = 0; a < board.length; a++){				//else find the next available location and return that value
						for(int b = 0; b < board[0].length; b++){
							if(board[a][b] == EMPTY){
								moveY = b;
								moveX = a;
							}
						}
					}
				}
			
			}
		}

		for(int z = 0; z < board.length; z++){							//turn the x and y corridinates into a single int that will be mapped to the board
			for(int j = 0; j < board[0].length; j++){
				moveLocation++;
				if(z == moveX && j == moveY){
					moveLocation--;
					return moveLocation--;
				}
			}
		}

	return moveLocation;												//return the move location
	}

	//method that takes in corrdinates and returns
	//a single interger thats maps to the board
	public int getMove(int moveX, int moveY){
		int moveLocation = 0;
		for(int z = 0; z < board.length; z++){
			for(int j = 0; j < board[0].length; j++){
				moveLocation++;
				if(z == moveX && j == moveY){
					moveLocation--;
					return moveLocation--;
				}
			}
		}
		return moveLocation;
	}


	/*
	Method that check the board for any possible winners
	this is accomplished througth taking the board and taking
	a string of the board and breaking it into sections that can
	be check for wining cases.
	 */
	@Override
	public int checkForWinner() {

		//create nesseccsary strings and arraylists
		String raw1 = "";
		String raw2 = "";
		String temp = "";
		String temp2 ="";
		List<String> rList = new ArrayList<String>();
		List<String> cList = new ArrayList<String>();

		//
		//check the columns
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				raw1 += board[i][j];
			}
		}
		//break the string into individual collumns
		for(int i = 0; i < raw1.length()-2; i+=3){
			temp = raw1.substring(i, i+3);
			rList.add(temp);							//add each case to an arraylist
		}

		//check the list of lines and check if that have a winning condition
		for(String check : rList){
			
			if(check.equals("111")){
				return CROSS_WON;
			}else{
				if(check.equals("222")){
					return NOUGHT_WON;
				}
			}
		}
		
		//chech the rows
		temp = "";
		for(int i = 0; i < board[0].length; i++){
			for(int j = 0; j < board.length; j++){
				raw2 += board[j][i];
			}
		}

		//break the string into individual rows
		for(int i = 0; i < raw2.length()-2; i+=3){
			temp = raw2.substring(i, i+3);
			cList.add(temp);
		}
		//check if any row has a win condition
		for(String check : cList){
			if(check.equals("111")){
				return CROSS_WON;
			}else{
				if(check.equals("222")){
				 return NOUGHT_WON;
				}
			}
		}
		
		//check if board filled an a tie
		if(!raw1.contains("0")){
			return TIE;
		}
		
		//check diagnols
		temp ="";
		temp2 = "";
		temp += Integer.toString(board[0][0]) + Integer.toString(board[1][1]) + Integer.toString(board[2][2]);
		temp2 += Integer.toString(board[2][0]) + Integer.toString(board[1][1]) + Integer.toString(board[0][2]);
		if(temp.equals("111") || temp2.equals("111")){
			return CROSS_WON;
		}else{
			if(temp.equals("222") || temp2.equals("222")){
			 return NOUGHT_WON;
			}
		}
		
		return PLAYING;
	}
	
	  /**
	   *  Print the game board 
	   */
	   public  void printBoard() {
	      for (int row = 0; row < ROWS; ++row) {
	         for (int col = 0; col < COLS; ++col) {
	            printCell(board[row][col]); // print each of the cells
	            if (col != COLS - 1) {
	               System.out.print("|");   // print vertical partition
	            }
	         }
	         System.out.println();
	         if (row != ROWS - 1) {
	            System.out.println("-----------"); // print horizontal partition
	         }
	      }
	      System.out.println();
	   }
	 
	   /**
	    * Print a cell with the specified "content" 
	    * @param content either CROSS, NOUGHT or EMPTY
	    */
	   public  void printCell(int content) {
	      switch (content) {
	         case EMPTY:  System.out.print("   "); break;
	         case NOUGHT: System.out.print(" O "); break;
	         case CROSS:  System.out.print(" X "); break;
	      }
	   }

}
