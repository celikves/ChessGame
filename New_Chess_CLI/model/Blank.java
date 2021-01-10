package model;

public class Blank extends Piece{

	String name = " blank";
	String color = " blank";
	public Blank(int xPos, int yPos, String color, boolean active) {
		super(xPos, yPos, color, active);
		// TODO Auto-generated constructor stub
		this.setName(name);
	}


	@Override
	public boolean moveValid(Square toMove, Square piece) {
		// TODO Auto-generated method stub
		return false;
	}

}
