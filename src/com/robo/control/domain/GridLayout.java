package com.robo.control.domain;
/**
 * This class represents the layout/grid on which the robot is going to move
 *  length is the total number of grids on the X axis
 *  width is the total number of grids on the Y axis
 * @author Badri Srinivasan
 *
 */
public class GridLayout {

	//properties
	static private int length;
	static private int width;

	/**
	 * Sets the layout of the grid
	 * @param length is the number of grids in the x axis
	 * @param width is the number of grids in the y axis
	 */
	public static void setGridLayout(int length, int width) {
		GridLayout.length = length-1;
		GridLayout.width = width-1;
	}

	/**
	 * Gets the length of the grid
	 * @return length of the grid
	 */
	public static int getLength() {
		return length;
	}
	/**
	 * Gets the width of the grid
	 * @return the width of the grid
	 */
	public static int getWidth() {
		return width;
	}

}
