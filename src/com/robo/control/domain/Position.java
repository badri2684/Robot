package com.robo.control.domain;

/**
 * This class represents the position of the robot representing the 1. X
 * coordinate 2. Y coordinate 3. Orientation (N,S,W,E)
 * 
 * @author Badri Srinivasan
 *
 */
public class Position {

	public enum OREINTATION {
		N, W, E, S
	};

	// Properties
	private int xcoordinate;
	private int ycoordinate;
	private OREINTATION direction;

	// Constructor
	public Position(int xcoordinate, int ycoordinate, OREINTATION direction) {
		this.xcoordinate = xcoordinate;
		this.ycoordinate = ycoordinate;
		this.direction = direction;
	}

	// Getter methods
	public OREINTATION getDirection() {
		return direction;
	}

	public int getXcoordinate() {
		return xcoordinate;
	}

	public int getYcoordinate() {
		return ycoordinate;
	}

	// Setter methods
	public void setDirection(OREINTATION direction) {
		this.direction = direction;
	}

	public void setXcoordinate(int xcoordinate) {
		this.xcoordinate = xcoordinate;
	}

	public void setYcoordinate(int ycoordinate) {
		this.ycoordinate = ycoordinate;
	}

	/**
	 * Overriding the toString() to print the current position
	 * 
	 */
	public String toString() {
		return direction.toString() + " " + xcoordinate + " " + ycoordinate;
	}

	/**
	 * Overriding the equals method to check if 2 positions are equal
	 */
	public boolean equals(Object obj) {

		if (obj instanceof Position) {
			Position compareto = (Position) obj;
			if (this.xcoordinate == compareto.xcoordinate && this.ycoordinate == compareto.ycoordinate
					&& this.direction.equals(compareto.direction)) {
				return true;
			}

		}

		return false;
	}

}
