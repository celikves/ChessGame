package model;
//Inherits from the piece Class all methods and variables
public class Queen extends Piece{

	//Variables
	private String name = "Queen";
	
	//inherited constructor from Super class
	public Queen(int xPos, int yPos, String color, boolean active) {
		super(xPos, yPos, color, active);
		this.setName(name);
		// TODO Auto-generated constructor stub
	}
	
	//Method Overloading from the Super Class
	@Override
	public boolean powerPiece(Square[] spaces) {
		
		
		/**
		 * This Method utilizes both the logic from the rook class and the bishop classes and checks all parameters to
		 * ensure that the queen can move, Because the queen has the ability to use the powers of both
		 * the rook and knight
		 */
		
		
		boolean validMove = true;
		boolean xAxis = false;
		boolean yAxis = false;
		boolean positivePositive = false;
		boolean positiveNegative = false;
		boolean negativeNegative = false;
		boolean negativePositive = false;
		int startPoint = 0;
		int count = 0;
		
		
		for(int i = 0; i < spaces.length; i++) {
			if(this.getxPos() == spaces[i].getPiece().getxPos()) {
				count += 1;
			}
		}
		
		Square diag[] = new Square[count];

		if(spaces[0].getPiece().getxPos() > spaces[spaces.length - 1].getPiece().getxPos()) {
			if(spaces[0].getPiece().getyPos() > spaces[spaces.length - 1].getPiece().getyPos()) {
				negativeNegative = true;
				
				for(int i = 0; i < count; i++) {		
					for(int j = 0; j < spaces.length; j++) {

						if(this.getxPos() - i == spaces[j].getPiece().getxPos() && this.getyPos() - i == spaces[j].getPiece().getyPos()) {
							diag[i] = spaces[j];						

						}
					}
				}
			}else if(spaces[0].getPiece().getyPos() < spaces[spaces.length - 1].getPiece().getyPos()){
				positiveNegative = true;

				for(int i = 0; i < count; i++) {
					for(int j = 0; j < spaces.length; j++) {
						if(this.getxPos() - i == spaces[j].getPiece().getxPos() && this.getyPos() + i == spaces[j].getPiece().getyPos()) {
							diag[i] = spaces[j];						

						}
					}
				}
			}
		}
		
		if(spaces[0].getPiece().getxPos() < spaces[spaces.length - 1].getPiece().getxPos()) {
			if(spaces[0].getPiece().getyPos() > spaces[spaces.length - 1].getPiece().getyPos()) {
				negativePositive = true;

				for(int i = 0; i < count; i++) {
					for(int j = 0; j < spaces.length; j++) {

						if(this.getxPos() + i == spaces[j].getPiece().getxPos() && this.getyPos() - i == spaces[j].getPiece().getyPos()) {
							diag[i] = spaces[j];						

						}
					}
				}
					
			}else if(spaces[0].getPiece().getyPos() < spaces[spaces.length - 1].getPiece().getyPos()){
				positivePositive = true;

				for(int i = 0; i < count; i++) {
					for(int j = 0; j < spaces.length; j++) {
						if(this.getxPos() + i == spaces[j].getPiece().getxPos() && this.getyPos() + i == spaces[j].getPiece().getyPos()) {
							diag[i] = spaces[j];						

						}
					}
				}
			}
		}
		
		if(positivePositive || positiveNegative || negativePositive || negativeNegative) {
			if(this.isActive()) {
				System.out.println(diag[1].getName());
				for(int i = 0; i < diag.length; i++) {
					if(diag[i].getName().equalsIgnoreCase(name)) {
						startPoint += 1;
	
					}
				}

				
				if(spaces.length / count != count) {
					validMove = false;
					
				}else {
				
					for(int i = startPoint; i < diag.length - 1; i++) {
						
							System.out.println(diag[0].getName());
						if(!diag[i].getPiece().getName().equalsIgnoreCase(" blank") || !diag[i].getPiece().getColor().equalsIgnoreCase(" blank")) {
							validMove = false;
						
						}else {
							this.setxPos(diag[diag.length - 1].getPiece().getxPos());
							this.setyPos(diag[diag.length - 1].getPiece().getyPos());
						}	
						
						
					}
					
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
		

		if(spaces[0].getPiece().getxPos() != spaces[spaces.length - 1].getPiece().getxPos()) {

		}else{
			xAxis = true;
		}
	
	
		if(spaces[0].getPiece().getyPos() != spaces[spaces.length - 1].getPiece().getyPos()) {
			
		}else{
			yAxis = true;
		}
		
	 startPoint = 0;
	
	for(int i = 0; i < spaces.length; i++) {
		if(spaces[i].getPiece().getName().equals(name)) {
			startPoint += 1;
			
		}
	}

	if(xAxis || yAxis) {
		if(xAxis && yAxis != true) {
			for(int i = startPoint; i < spaces.length - 1; i++) {
				if(spaces[0].getPiece().isActive()) {	
					if(!spaces[i].getPiece().getName().equalsIgnoreCase(" blank") || !spaces[i].getPiece().getColor().equalsIgnoreCase(" blank")) {
						validMove = false;
					
					}else {
						this.setxPos(spaces[i].getPiece().getxPos());
						this.setyPos(spaces[i].getPiece().getyPos());
						validMove = true;
					}
				}else {
					validMove = false;
				}
			}
			
			if(this.getColor().equalsIgnoreCase(spaces[spaces.length - 1].getPiece().getColor())) 
				validMove = false;	
		}
		
	}else 
		validMove = false;
	
		return validMove;

	}

	}