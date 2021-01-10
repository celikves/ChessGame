package model;

//Extends the Piece class
public class Rook extends Piece {

	private String name = "Rook";
	
	//Default constructor inherited from super class
	public Rook(int xPos, int yPos, String color, boolean active) {
		super(xPos, yPos, color, active);
		this.setName(name);
	}

	//Overriding needed class
	@Override
	public boolean powerPiece(Square[] spaces) {
		//Parameters that will be used to check correct movement
		boolean validMove = true;
		boolean xAxis = false;
		boolean yAxis = false;
	
		
		//Checks if the piece position and new position are on the same X Axis
		if(spaces[0].getPiece().getxPos() != spaces[spaces.length - 1].getPiece().getxPos()) {

		}else{
			xAxis = true;
		}
	
		//Checks if the piece position and new piece are on the same Y Axis
		if(spaces[0].getPiece().getyPos() != spaces[spaces.length - 1].getPiece().getyPos()) {
			
		}else{
			yAxis = true;
		}
		
		//Makes Sure not to include itself when checking the spaces
		int startPoint = 0;
		
		for(int i = 0; i < spaces.length; i++) {
			if(spaces[i].getPiece().getName().equals(name)) {
				startPoint += 1;
				
			}
		}
	
		//Checks if the pieces new space is on same X  or Y axis
		if(xAxis || yAxis) {
			//Loops through the spaces moving over
			for(int i = startPoint; i < spaces.length - 1; i++) {
				//Makes sure the piece moving is the correct color i.e has been activated
				if(spaces[0].getPiece().isActive()) {
					
					//If the space the piece is moving over is not empty will not be a valid move
					if(!spaces[i].getPiece().getName().equalsIgnoreCase(" blank") || !spaces[i].getPiece().getColor().equalsIgnoreCase(" blank")) {
						validMove = false;
					
					}else {
						//If valid set the new position of the piece to the last space
						this.setxPos(spaces[spaces.length - 1].getPiece().getxPos());
						this.setyPos(spaces[spaces.length - 1].getPiece().getyPos());
					}
				}else {
					validMove = false;
				}
			}
		
		//Ensures the piece is unable to take it's own color
		if(this.getColor().equalsIgnoreCase(spaces[spaces.length - 1].getPiece().getColor())) {
			validMove = false;
		}
		}else {
			validMove = false;
		}
		
		//Returns the move result
		return validMove;
	}
	
}