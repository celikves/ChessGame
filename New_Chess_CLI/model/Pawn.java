package model;
//Inherits all methods and variables from Piece class
public class Pawn extends Piece {

	//Variables
	private String type = "Pawn";
	
	//Super constructor inherited
	public Pawn(int xPos, int yPos, String color, boolean active) {
		super(xPos, yPos, color, active);
		
		this.setName(type);
	}
	
	
	//Overrides for method overloading from super class for logic
	@Override
	public boolean moveValid(Square toMove, Square piece) {
		//Used to check if move is valid
		boolean okMove = false;
		
		//Ensures the piece is moving on the right turn
		if(this.isActive()) {
			//Because pawns only move in one direction we declare the rules for each color
			if(this.getColor().equalsIgnoreCase("white")) {
				
				//Checks the space to ensure its empty and makes sure the space is on the same Y axis
				if(toMove.getName().equalsIgnoreCase(" blank") && toMove.getPiece().getyPos() == piece.getPiece().getyPos()) {
					
					//Allows pawn to move two spaces on the first move
					if(toMove.getPiece().getxPos() > piece.getPiece().getxPos() && toMove.getPiece().getxPos() < piece.getPiece().getxPos() + 2) {
						this.setxPos(toMove.getPiece().getxPos());
						return okMove = true;
						
						//Allows pawn to move 1 space on the first move
					}else if(piece.getPiece().getxPos() == 1) {
						if(toMove.getPiece().getxPos() > piece.getPiece().getxPos() && toMove.getPiece().getxPos() < piece.getPiece().getxPos() + 3) {
						this.setxPos(toMove.getPiece().getxPos());
						return okMove = true;
						
						}
						//If the pawn wants to take a piece it can only more there if a piece is there 

					}else if(piece.getPiece().getxPos() > 1 && toMove.getPiece().getxPos() - 1 == piece.getPiece().getxPos()) {
						this.setxPos(toMove.getPiece().getxPos());
						return okMove = true;
					
					}
					
					//If pawn makes it to other side of the it becomes a queen
					if(toMove.getPiece().getxPos() == 7 || toMove.getPiece().getxPos() == 0) {
						this.setName("Queen");
					}
					
					
					//Allows the piece to take other pieces on the diagonal
				}else if(!toMove.getName().contentEquals(" blank") && toMove.getPiece().getxPos() - 1 == piece.getPiece().getxPos()) {
					if(toMove.getPiece().getyPos() - 1 == piece.getPiece().getyPos() || toMove.getPiece().getyPos() + 1 == piece.getPiece().getyPos()) {
						this.setxPos(toMove.getPiece().getxPos());
						this.setyPos(toMove.getPiece().getyPos());
						return okMove = true;
	
					}
				}
				
				
			//The code is the same as white only reversed so black and also utilize it!
				
				
			}else if(this.getColor().equalsIgnoreCase("black")) {
				if(toMove.getName().equalsIgnoreCase(" blank") && toMove.getPiece().getyPos() == piece.getPiece().getyPos()) {
					
					
					if(toMove.getPiece().getxPos() < piece.getPiece().getxPos() && toMove.getPiece().getxPos() > piece.getPiece().getxPos() - 2) {
						this.setxPos(toMove.getPiece().getxPos());
						return okMove = true;
						
					}else if(piece.getPiece().getxPos() == 6) {
						if(toMove.getPiece().getxPos() < piece.getPiece().getxPos() && toMove.getPiece().getxPos() > piece.getPiece().getxPos() - 3) {
							this.setxPos(toMove.getPiece().getxPos());
							return okMove = true;
						
						}
					}
					
					if(toMove.getPiece().getxPos() == 7) {
						this.setName("Queen");
					}
				}else if(!toMove.getName().contentEquals(" blank") && toMove.getPiece().getxPos() + 1 == piece.getPiece().getxPos()) {
					if(toMove.getPiece().getyPos() - 1 == piece.getPiece().getyPos() || toMove.getPiece().getyPos() + 1 == piece.getPiece().getyPos()) {
						this.setxPos(toMove.getPiece().getxPos());
						this.setyPos(toMove.getPiece().getyPos());
						
						if(toMove.getPiece().getxPos() == 7) {
							this.setName("Queen");
						}
						return okMove = true;
	
					}
				}
			}
			
			
		}
		
		return okMove;
	}

	
}
