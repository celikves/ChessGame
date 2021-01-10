package model;

//inherits pieces methods and variables
public class Bishop extends Piece{

	//Variables
	private String name = "Bishop";
	//Inherited constructor params
	public Bishop(int xPos, int yPos, String color, boolean active) {
		super(xPos, yPos, color, active);
		this.setName(name);
		// TODO Auto-generated constructor stub
	}

	//Overriding super class method
	@Override
	public boolean powerPiece(Square[] spaces) {
		
		//Checks needed to ensure the move is legal
		boolean validMove = true;
		boolean positivePositive = false;
		boolean positiveNegative = false;
		boolean negativeNegative = false;
		boolean negativePositive = false;
		int startPoint = 0;
		int count = 0;
		int checker = 0;
		
		//Ensures that the diagonal moved is symetrical i.e 3x3/ 2x2 4x4 by getting the total amount of numbers on
		// a single axis
		for(int i = 0; i < spaces.length; i++) {
			if(this.getxPos() == spaces[i].getPiece().getxPos()) {
				count += 1;
				System.out.println(count);
			}
		}
		
		//Creates a new Square array to sort the valid moves
		Square diag[] = new Square[count];

		
		//This is to check each diagonal that will be used and to store the result that match on the diagonal relative
		//To the piece that will be moved
		//Checks if the piece moving is greater than the final position it wants to move
		//Checks the x/ y axis of both the piece and the final space
		if(spaces[0].getPiece().getxPos() > spaces[spaces.length - 1].getPiece().getxPos()) {
			if(spaces[0].getPiece().getyPos() > spaces[spaces.length - 1].getPiece().getyPos()) {
				//If valid the piece wants to move to the bottom right cornor of the board
				negativeNegative = true;
				
				//Then loops through the count which is the total amount of moves that are allowed to reach the end 
				//Space and the total amount of spaces spaces obtained in the perimiter
				for(int i = 0; i < count; i++) {		
					for(int j = 0; j < spaces.length; j++) {
						//If the space is on the top left diagonal will add it to the new array
						if(this.getxPos() - i == spaces[j].getPiece().getxPos() && this.getyPos() - i == spaces[j].getPiece().getyPos()) {
							diag[i] = spaces[j];						

							checker += 1;
						}
					}
				}
			}else if(spaces[0].getPiece().getyPos() < spaces[spaces.length - 1].getPiece().getyPos()){
				positiveNegative = true;
				//If valid the piece wanted to move to the bottom left
				
				//Then loops through the count which is the total amount of moves that are allowed to reach the end 
				//Space and the total amount of spaces spaces obtained in the perimiter
				for(int i = 0; i < count; i++) {
					for(int j = 0; j < spaces.length; j++) {
						//If the space is on the top left diagonal will add it to the new array

						if(this.getxPos() - i == spaces[j].getPiece().getxPos() && this.getyPos() + i == spaces[j].getPiece().getyPos()) {
							diag[checker] = spaces[j];						

							checker += 1;
						}
					}
				}
			}
		}
		//If valid the piece wanted to move to the Top left

		if(spaces[0].getPiece().getxPos() < spaces[spaces.length - 1].getPiece().getxPos()) {
			if(spaces[0].getPiece().getyPos() > spaces[spaces.length - 1].getPiece().getyPos()) {
				negativePositive = true;
				//Then loops through the count which is the total amount of moves that are allowed to reach the end 
				//Space and the total amount of spaces spaces obtained in the perimiter
				for(int i = 0; i < count; i++) {
					for(int j = 0; j < spaces.length; j++) {
						//If the space is on the top left diagonal will add it to the new array

						if(this.getxPos() + i == spaces[j].getPiece().getxPos() && this.getyPos() - i == spaces[j].getPiece().getyPos()) {
							diag[checker] = spaces[j];						

							checker += 1;
						}
					}
				}
			//If valid the piece wanted to move to the Top Right
			}else if(spaces[0].getPiece().getyPos() < spaces[spaces.length - 1].getPiece().getyPos()){
				positivePositive = true;
				//Then loops through the count which is the total amount of moves that are allowed to reach the end 
				//Space and the total amount of spaces spaces obtained in the perimiter
				for(int i = 0; i < count; i++) {
					for(int j = 0; j < spaces.length; j++) {
						//If the space is on the top left diagonal will add it to the new array

						if(this.getxPos() + i == spaces[j].getPiece().getxPos() && this.getyPos() + i == spaces[j].getPiece().getyPos()) {
							diag[i] = spaces[j];						

							checker += 1;
						}
					}
				}
			}
		}
			
		//Checks if the piece is trying to move in a diagonal
		if(positivePositive || positiveNegative || negativePositive || negativeNegative) {
			//Checks if the piece is activated
			if(this.isActive()) {
				System.out.println(diag[1].getName());
				//Makes sure not to include itself in the check
				for(int i = 0; i < diag.length; i++) {
					if(diag[i].getName().equalsIgnoreCase(name)) {
						startPoint += 1;
	
					}
				}
				//makes sure that the move being made is a diagonal if not is a false move
				if(spaces.length / count != count) {
					validMove = false;
					
				}else {
				
					//Checks if any other pieces are between the piece and the space it's moving to if yes invalid move
					for(int i = startPoint; i < diag.length - 1; i++) {
					
		
						if(!diag[i].getPiece().getName().equalsIgnoreCase(" blank") || !diag[i].getPiece().getColor().equalsIgnoreCase(" blank")) {
							validMove = false;
						
						}else {
							this.setxPos(diag[diag.length - 1].getPiece().getxPos());
							this.setyPos(diag[diag.length - 1].getPiece().getyPos());
						}	
						
						
					}
					//Ensures the space piece is moving to doesn't contain a piece of the same color
					if(this.getColor().equalsIgnoreCase(spaces[diag.length - 1].getPiece().getColor())) {
						validMove = false;
					}
						
				}
			
			}else {
				validMove = false;
			}
		}else {
			validMove = false;
		}

		//returns results
		return validMove;

	}
}
