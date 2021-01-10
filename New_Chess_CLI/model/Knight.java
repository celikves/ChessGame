package model;
//Inherits Piece class methods and variables
public class Knight extends Piece {

	//Variables
	private String name = "Night";
	
	//Inherited Constructor
	public Knight(int xPos, int yPos, String color, boolean active) {
		super(xPos, yPos, color, active);
		this.setName(name);
	}

	
	//Inherited Method overloaded
	public boolean moveValid(Square toMove, Square piece) {
		boolean validMove = false;
		
		//Checks the parameters of the Knight to make sure the move is legal
		if(this.getxPos() + 2 == toMove.getPiece().getxPos() && this.getyPos() + 1 == toMove.getPiece().getyPos()) {
			validMove = true;
		}else if(this.getxPos() + 2 == toMove.getPiece().getxPos() && this.getyPos() - 1 == toMove.getPiece().getyPos()){
			validMove = true;
		}else if(this.getxPos() + 1 == toMove.getPiece().getxPos() && this.getyPos() + 2 == toMove.getPiece().getyPos() ) {
			validMove = true;
		}else if(this.getxPos() + 1 == toMove.getPiece().getxPos() && this.getyPos() - 2 == toMove.getPiece().getyPos()) {
			validMove = true;
		}else if(this.getxPos() - 2 == toMove.getPiece().getxPos() && this.getyPos() - 1 == toMove.getPiece().getyPos()){
			validMove = true;
		}else if(this.getxPos() - 1 == toMove.getPiece().getxPos() && this.getyPos() + 2 == toMove.getPiece().getyPos() ) {
			validMove = true;
		}else if(this.getxPos() - 1 == toMove.getPiece().getxPos() && this.getyPos() - 2 == toMove.getPiece().getyPos()) {
			validMove = true;
		}else if(this.getxPos() - 2 == toMove.getPiece().getxPos() && this.getyPos() + 1 == toMove.getPiece().getyPos()) {
			validMove = true;
		}
		
		//Makes sure the Knight is unable to move on a square occupied by the same color as itself
		if(this.getColor().equalsIgnoreCase(toMove.getPiece().getColor())) {
			validMove = false;
		}
		//If the move is legal set the new position of the Knight
		if(validMove) {
			this.setxPos(toMove.getPiece().getxPos());
			this.setyPos(toMove.getPiece().getyPos());
		}
		//returns results
		return validMove;
	}	
}
