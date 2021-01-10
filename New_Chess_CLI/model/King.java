package model;
//Inherits from the Piece class all methods and variables
public class King extends Piece{

	//Variables
	private String name = "King";
	
	//Inherits constructor from super class
	public King(int xPos, int yPos, String color, boolean active) {
		super(xPos, yPos, color, active);
		this.setName(name);
		// TODO Auto-generated constructor stub
	}

	//Overrides using method overloading from super classes
	@Override
	public boolean moveValid(Square toMove, Square piece) {
		
		//Checking parameters for legality of the move
		boolean okMove = false;
		
		//Checks the starting point of the King  needs to switches parameters of x and y on first move
		if(this.getxPos() < 1 && this.getColor().equalsIgnoreCase("white") || this.getxPos() > 6 && this.getColor().equalsIgnoreCase("black")) {
			int x = toMove.getPiece().getxPos();
			toMove.getPiece().setxPos(toMove.getPiece().getyPos());
			toMove.getPiece().setyPos(x);
		}
		
		//Checks to ensure piece is activated to move legally (If it's there turn to move)
		if(this.isActive()) {

			//Parameters to allow king to move one square only if it's empty or if the square has a piece of the other
			//Team
				if(toMove.getName().equalsIgnoreCase(" blank") || !toMove.getPiece().getColor().equalsIgnoreCase(this.getColor())) {
					
					
					if(toMove.getPiece().getxPos() == this.getxPos() + 1 && toMove.getPiece().getyPos() == this.getyPos() + 1) {

						return okMove = true;
						
					}else if(toMove.getPiece().getxPos() == this.getxPos() - 1 && toMove.getPiece().getyPos() == this.getyPos() - 1) {


						return okMove = true;
						
						
					}else if(toMove.getPiece().getxPos() == this.getxPos() + 1 && toMove.getPiece().getyPos() == this.getyPos() - 1) {


						return okMove = true;
					
					}else if(toMove.getPiece().getxPos() == this.getxPos() - 1 && toMove.getPiece().getyPos() == this.getyPos() + 1) {


						return okMove = true;
					
					}else if(toMove.getPiece().getxPos() == this.getxPos() && toMove.getPiece().getyPos() == this.getyPos() + 1) {


						return okMove = true;
					
					}else if(toMove.getPiece().getxPos() == this.getxPos() && toMove.getPiece().getyPos() == this.getyPos() - 1) {


						return okMove = true;
					
					}else if(toMove.getPiece().getxPos() == this.getxPos() - 1 && toMove.getPiece().getyPos() == this.getyPos()) {


						return okMove = true;
					
					}else if(toMove.getPiece().getxPos() == this.getxPos() + 1 && toMove.getPiece().getyPos() ==this.getyPos()) {


						return okMove = true;
					
					}
					
					//Assigns the king to new square
					if(okMove) {
						this.setxPos(toMove.getPiece().getxPos());
						this.setyPos(toMove.getPiece().getyPos());
					}
				}
		}
		//Returns results
		return okMove;
	}
	


}
