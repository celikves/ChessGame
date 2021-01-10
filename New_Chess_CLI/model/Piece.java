package model;
//Piece Object declared Abstract for multiple uses of the getter/setter methods and accessibility
public abstract class Piece {

	//Variables
	private String color;
	private int xPos;
	private int yPos;
	private String name;
	private boolean active = false;
	
	//Default construstor parameters to create a piece
	public Piece(int xPos, int yPos, String color, boolean active) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.color = color;
		this.active = active;
	}
	
	
	//Setter and Getter methods
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getxPos() {
		return xPos;
	}
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	public int getyPos() {
		return yPos;
	}
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	//Methods that will be overidden depending on the function of the piece
	public boolean moveValid(Square toMove, Square piece) {
		return true;
	}
	
	//Method that will be overided depending on the function of the piece
	public boolean powerPiece(Square spaces[]) {
		return true;
	}


	
}
