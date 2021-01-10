package board;

import model.*;
//Chess board object
public class ChessBoard {

	//Variables
	private Square square[][];
	private String color = "";
	
	//Chessboard constructor when a copy is made a new board with default spots are created
	public ChessBoard() {
		//Declares the size of the 2D array
		square = new Square[8][8];
		
		//Loops through the 2D array
		for(int i = 0; i < square.length; i ++) {
			for(int j = 0; j < square.length; j++) {
				
				//depending on the position of the board will assign colors
				if(i == 0 || i == 1) {
					color = "white";

				}else if(i == 6|| i == 7) {
					color = "black";

				}
				
				//Assigns the pieces to the board depending on the position
				if(i == 0 || i == 7) {
					
					if(j == 0 || j == 7) {
						
						square[i][j] = new Square(new Rook(i, j, color, true));
					}else if(j == 1 || j == 6) {
						square[i][j] = new Square(new Knight(i, j, color, true));
					}else if(j == 2 || j == 5) {
						square[i][j] = new Square(new Bishop(i, j, color, true));
					}else if(j == 3) {
						square[i][j] = new Square(new Queen(i, j, color, true));
					}else if(j == 4) {
						square[i][j] = new Square(new King(i, j, color, true));
					}
					
				}else if(i == 1 || i == 6) {
					square[i][j] = new Square(new Pawn(i, j, color, true));
				}else {
					square[i][j] = new Square(i, j);
				}
			}
		}
		
	}

	//Getter/ Setter mthods
	public Square[][] getSquare() {
		return square;
	}

	public void setSquare(Square[][] board) {
		this.square = board;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}
