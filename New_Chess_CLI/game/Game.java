package game;
import board.ChessBoard;
import model.Square;

import java.util.Scanner;
public class Game implements Runnable{

	
	//Declare Variables 
	private Scanner scan;
	private ChessBoard chessboard;
	private boolean startGame = false;
	private Thread gameThread = new Thread(this);
	private int turn;
	
	//Threads runnable method to execute code
	public void run() {
		
		turn = 1;
		
		while(startGame) {
			
			//Prints and updates board
			System.out.println("     A   B   C   D   E   F   G   H");
			for(int i = 0; i <chessboard.getSquare().length; i++) {
				System.out.println("   ---------------------------------");
				System.out.print(" ");
				System.out.print(i + 1);
				for(int j = 0; j < chessboard.getSquare().length; j++) {
					if(chessboard.getSquare()[i][j].getPiece().getColor().equalsIgnoreCase("white")) {
						System.out.print(" | " + chessboard.getSquare()[i][j].getName().charAt(0));
					}else {
						System.out.print(" | " + chessboard.getSquare()[i][j].getName().toLowerCase().charAt(0));

					}
					if(j == 7) {
						System.out.print(" | ");
						System.out.print(i + 1);
						System.out.println();
					}
				}
					
			}
			System.out.println("   ---------------------------------");
			System.out.println("     A   B   C   D   E   F   G   H");
			System.out.println();
			
			//Goes to logic formulation methods
			turnSelector();
			
			//Checks the board if the Game is over
			int check = 0;
			for(int i = 0; i < chessboard.getSquare().length; i++) {
				for(int j = 0; j < chessboard.getSquare().length; j++) {
					if(chessboard.getSquare()[i][j].getPiece().getName().equalsIgnoreCase(" blank")) {
						
					}else {
						check += 1;
					}
				}
			}
			
			if(check == 1) {
				endGame();
			}
			
			
		}
	}

	//Game constructor
	public Game() {
		
		//Initializes a new Game and Scanner then runs the init method
		chessboard = new ChessBoard();
		scan = new Scanner(System.in);
		init();
		
	}
	
	//Checks to see if the game is running if not it will start the game
	private void init() {
		
		if(!startGame) {
			startGame = true;
		}
		gameThread.start();
	}
	
	//Gets the x Position that player has typed
	private int getXPos(String piece) {
		
		char xChar = piece.charAt(0);
		//casts the char into a int and starts at the beginning of the ascii alphabet
		return (int)xChar - 65;
		
	}
	
	//Gets the y Position the player has entered
	private int getYPos(String piece) {
		
		//Converts the char into a number
		char yChar = piece.charAt(1);
		String yString = Character.toString(yChar);
		return Integer.parseInt(yString) - 1;
	}
	
	//End game method checking if the player wants to play again
	private void endGame() {
		
		boolean isFinished = true;
		System.out.println();
		System.out.println("//////| The Game has Ended!|/////////");
		System.out.print("Play Again? Y / N|:>| ");
		String choice = scan.nextLine();
		System.out.println();

		//Trys to run code based on user input
		try {
			while(isFinished){
				if(choice.equalsIgnoreCase("y")) {
					isFinished = false;
					chessboard = new ChessBoard();
				}else if(choice.equalsIgnoreCase("n")) {
					isFinished = false;
					startGame = false;
				}else {
					System.out.println("Invalid Option! Try Again!");
				}
			}
		}catch(Exception e) {
			System.out.println("Invalid input! Please try again!");
		}
	}
	
	//Game Logic Method dictates whose turn and if the moves are valid or not
	private void turnSelector() {
		boolean move = false;
		//In case of error try/ catch block
		try {	
		
		//Sets the moveable pieces to true or false based on whose turn it is so only one player can move at a time	
		if(turn == 1) {
				System.out.println("Whites move!");
				//Loops through the 2d array of the chessboard
				for(int i = 0; i < chessboard.getSquare().length; i++) {
					for(int j =0; j <chessboard.getSquare().length; j++) {
						
						//Changes the activate status based on the piece color
						if(chessboard.getSquare()[i][j].getPiece().getColor().equalsIgnoreCase("white")) {
							chessboard.getSquare()[i][j].getPiece().setActive(true);						
							
						}else if(chessboard.getSquare()[i][j].getPiece().getColor().equalsIgnoreCase("black")) {
							chessboard.getSquare()[i][j].getPiece().setActive(false);						

						}
					}
				}
		//Sets the moveable pieces to true or false based on whose turn it is so only one player can move at a time	
		}else if(turn == -1) {
			System.out.println("Blacks move!");
			
			//Loops through the 2d array of the chessboard
			for(int i = 0; i < chessboard.getSquare().length; i++) {
				for(int j =0; j <chessboard.getSquare().length; j++) {
					
					//Changes the activate status based on the piece color
					if(chessboard.getSquare()[i][j].getPiece().getColor().equalsIgnoreCase("black")) {
						chessboard.getSquare()[i][j].getPiece().setActive(true);						
					
					}else if(chessboard.getSquare()[i][j].getPiece().getColor().equalsIgnoreCase("white")) {
						chessboard.getSquare()[i][j].getPiece().setActive(false);						

					}
				}
			}
		}
		//Will run this code until the player makes a valid move
		do {
			System.out.print("Enter the location of the piece:|>: ");
			String selectedPiece = scan.nextLine().toUpperCase();
			System.out.print("Enter the new location of the piece:|>: ");
			String placement = scan.nextLine().toUpperCase();
			
			//stores the player inputs into variables that are then decrypted in other methods
			int xSelected = getXPos(selectedPiece);
			int ySelected = getYPos(selectedPiece);
			
			int xPlacement = getXPos(placement);
			int yPlacement = getYPos(placement);
	
			//Stores the piece that was choosen from the board into an object
			Square piece = chessboard.getSquare()[ySelected][xSelected];
			//Stores the place the piece wants to go into an object
			Square moveableSpace = chessboard.getSquare()[yPlacement][xPlacement];
			
			
			//checks if the piece is allowed to move in the space it wants
			if(piece.getPiece().moveValid(moveableSpace, piece)) {	
				if(piece.getPiece().powerPiece(countSpace(xSelected, ySelected, xPlacement, yPlacement))) {
					//If its allowed to set the piece in the new place
					//Than Removes the piece from the old square
					chessboard.getSquare()[ySelected][xSelected] = new Square(ySelected, xSelected);
					chessboard.getSquare()[yPlacement][xPlacement] = piece;
					move = true;
					turn = -turn;
				}else {
					//If false ask again
					System.out.println();
					System.out.println("Invalid Move! Please Try Again!");
					System.out.println();

				}
				
			}else {
				//If false ask again
				System.out.println();
				System.out.println("Invalid Move! Please Try Again!");
				System.out.println();

			}
			
		}while(!move);
	}catch(Exception e) {
		//If the positions the player entered is invalid this will run
		System.out.println();
		System.out.println("////////////////////////////////////////");
		System.out.println("      Invalid Input! Try Again!");
		System.out.println("////////////////////////////////////////");

	}
	
		
	}
	
	//Gets all the squares between the piece that will be moved and the place where the piece will go
	private Square[] compileSpace(int xSelected, int ySelected, int xPlacement, int yPlacement, int count) {
		
		Square distance[] = new Square[count];
		boolean checked = false;
		int totalCount = 0;
		
		if(!checked) {
			//double for loop to check the array multiple times to get all the squares in a perimeter between the piece
			// And the square the piece will move
			//Gets all squares that are less than or equal to the X position(Row)
			//And all squares that are greater than and less than its Y position
			
			for(int i = xSelected; i <= xPlacement; i++) {
				for(int j = ySelected; j <= yPlacement; j++) {

					distance[totalCount] = chessboard.getSquare()[j][i];
					totalCount+=1;
					checked = true;
				}
				
				for(int j = ySelected; j >= yPlacement; j--) {
					distance[totalCount] = chessboard.getSquare()[j][i];
					checked = true;
					totalCount+=1;

				}
			}
		}
		//double for loop to check the array multiple times to get all the squares in a perimeter between the piece
		// And the square the piece will move
		//Gets all squares that are greater than or equal to the X position(Row)
		//And all squares that are greater than and less than its Y position
		if(!checked) {
			for(int i = xSelected; i >= xPlacement; i--) {
				for(int j = ySelected; j >= yPlacement; j--) {
					distance[totalCount] = chessboard.getSquare()[j][i];
					checked = true;
					totalCount+=1;

				}
				
				for(int j = ySelected; j <= yPlacement; j++) {
					distance[totalCount] = chessboard.getSquare()[j][i];
					checked = true;
					totalCount+=1;

				}
			}
		}
		//Returns the group of spaces to check the parameters in the pieces
		return distance;
		
		
	}
	//Method created to calculate what the size of the array will be 
	// That will be sent to be tested by the pieces
	private Square[] countSpace(int xSelected, int ySelected, int xPlacement, int yPlacement) {
		boolean checked = false;
		int totalCount = 0;
		
		if(!checked) {
			for(int i = xSelected; i <= xPlacement; i++) {

				for(int j = ySelected; j <= yPlacement; j++) {

					totalCount+=1;
					checked = true;
				}
				
				for(int j = ySelected; j >= yPlacement; j--) {

					checked = true;
					totalCount+=1;

				}
			}
		}
		
		if(!checked) {
			for(int i = xSelected; i >= xPlacement; i--) {

				for(int j = ySelected; j >= yPlacement; j--) {

					checked = true;
					totalCount+=1;

				}
				
				for(int j = ySelected; j <= yPlacement; j++) {

					checked = true;
					totalCount+=1;

				}
			}
		}
		//will return the Square Array of the group of possible moves
		return compileSpace(xSelected, ySelected, xPlacement, yPlacement, totalCount);
		
		
		

	}
	
	//Main method
	public static void main(String args[]) {
		//Creates a new game object
		Game game = new Game();
		
	}



	
}
