package model;

//Square object space on the chessboard
public class Square {

	//Variables
	private Piece piece;
	private boolean containsPiece;
	private String name = " blank";
	private String color = " blank";
	
	//Can instantiate empty Square
	public Square() {
		
	}
	//Overloading the constructor for flexibility
	public Square(int x, int y) {
		
		piece = new Blank(x, y, color, false);
	}
	
	//Another Overloaded constructor to assign a piece to he square
	public Square(Piece piece) {
		
		this.piece = piece;
		this.name = piece.getName();
	}

	//Setter/ getter methods
	public Piece getPiece() {
		return this.piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public boolean isContainsPiece() {
		return containsPiece;
	}

	public void setContainsPiece(boolean containsPiece) {
		this.containsPiece = containsPiece;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
