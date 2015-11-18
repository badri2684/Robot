package com.robo.control.domain;

import com.robo.control.domain.Position.OREINTATION;

/**
 * This class represents the robot, that actually moves on the grid It has a
 * property called position,which tells the Robot, details about current
 * position and also guides the robot to move in different directions
 * 
 * @author Badri Srinivasan
 *
 */
public class Robot {
	// current position of the robot
	private Position currposition;

	// List of all possible directions
	public enum DIRECTION {
		LEFT, RIGHT, UP, DOWN
	};

	public DIRECTION direction;

	public Robot(Position currposition) {
		this.currposition = currposition;

	}

	/**
	 * Initializes the orientation of the robot based on initial position
	 */
	public void intialiseDircetions() {

		switch (currposition.getDirection()) {
		case N:
			direction = DIRECTION.UP;
			break;
		case E:
			direction = DIRECTION.RIGHT;
			break;
		case W:
			direction = DIRECTION.LEFT;
			break;
		default:
			direction = DIRECTION.DOWN;
		}

	}

	/**
	 * Returns the current position of the robot
	 * 
	 * @return current position of the robot
	 */
	public Position getCurrposition() {
		return currposition;
	}

	/**
	 * Setter method to set the current position of the robot
	 * 
	 * @param currposition
	 */
	public void setCurrposition(Position currposition) {
		this.currposition = currposition;
	}

	/**
	 * Is used by the robot to move forward
	 * 
	 * @param steps
	 *            is the number of steps to move forward
	 * @return the current position of the robot
	 */
	public Position moveforward(int steps) {
		int xcord = currposition.getXcoordinate();
		int ycord = currposition.getYcoordinate();
		switch (direction) {
		case LEFT:
			int templeft = xcord - steps;
			if (templeft < 0) {
				// Need to calculate X coordinate
				currposition.setXcoordinate(GridLayout.getWidth() + templeft + 1);
			} else {
				currposition.setXcoordinate(templeft);
			}
			break;
		case RIGHT:
			int tempright = xcord + steps;
			if (tempright > GridLayout.getWidth()) {
				// Need to calculate X coordinate
				int diff = tempright - GridLayout.getWidth();
				currposition.setXcoordinate(diff - 1);
			} else {
				currposition.setXcoordinate(tempright);
			}
			break;
		case UP:
			int tempup = ycord + steps;
			if (tempup > GridLayout.getLength()) {
				// Need to calculate Y coordinate
				int diff = tempup - GridLayout.getLength();
				currposition.setYcoordinate(diff - 1);
			} else {
				currposition.setYcoordinate(tempup);
			}

			break;
		default:
			int tempdown = ycord - steps;
			if (tempdown < 0) {
				// Need to calculate X coordinate
				currposition.setYcoordinate(GridLayout.getLength() + tempdown + 1);
			} else {
				currposition.setYcoordinate(tempdown);
			}
		}

		return currposition;
	}

	/**
	 * Is used by the robot to move left by number of times
	 * 
	 * @param times
	 *            is the number of times the operation needs to be repeated
	 * @return
	 */

	public Position rotateLeft(int times) {

		int mod = times % 4;

		switch (direction) {
		case LEFT:
			switch (mod) {
			case 0:
				direction = DIRECTION.LEFT;
				break;
			case 1:
				direction = DIRECTION.DOWN;
				break;
			case 2:
				direction = DIRECTION.RIGHT;
				break;
			case 3:
				direction = DIRECTION.UP;
			}

		case RIGHT:
			switch (mod) {
			case 0:
				direction = DIRECTION.RIGHT;
				break;
			case 1:
				direction = DIRECTION.UP;
				break;
			case 2:
				direction = DIRECTION.LEFT;
				break;
			case 3:
				direction = DIRECTION.DOWN;
			}
			break;
		case UP:
			switch (mod) {
			case 0:
				direction = DIRECTION.UP;
				break;
			case 1:
				direction = DIRECTION.LEFT;
				break;
			case 2:
				direction = DIRECTION.DOWN;
				break;
			case 3:
				direction = DIRECTION.RIGHT;
			}
			break;
		default:
			switch (mod) {
			case 0:
				direction = DIRECTION.DOWN;
				break;
			case 1:
				direction = DIRECTION.RIGHT;
				break;
			case 2:
				direction = DIRECTION.UP;
				break;
			case 3:
				direction = DIRECTION.LEFT;
			}

		}
		//Set the orientation after the rotating left
		setOreintation(direction);	

		return currposition;
	}

	/**
	 * Is used by the robot to move right by number of times
	 * 
	 * @param times
	 *            is the number of times the operation needs to be repeated
	 * @return
	 */
	public Position rotateRight(int times) {
		int mod = times % 4;

		switch (direction) {
		case LEFT:
			switch (mod) {
			case 0:
				direction = DIRECTION.LEFT;
				break;
			case 1:
				direction = DIRECTION.UP;
				break;
			case 2:
				direction = DIRECTION.RIGHT;
				break;
			case 3:
				direction = DIRECTION.DOWN;
			}
			break;
		case RIGHT:
			switch (mod) {
			case 0:
				direction = DIRECTION.RIGHT;
				break;
			case 1:
				direction = DIRECTION.DOWN;
				break;
			case 2:
				direction = DIRECTION.LEFT;
				break;
			case 3:
				direction = DIRECTION.UP;
			}
			break;
		case UP:
			switch (mod) {
			case 0:
				direction = DIRECTION.UP;
				break;
			case 1:
				direction = DIRECTION.RIGHT;
				break;
			case 2:
				direction = DIRECTION.DOWN;
				break;
			case 3:
				direction = DIRECTION.LEFT;
			}
			break;
		default:
			switch (mod) {
			case 0:
				direction = DIRECTION.DOWN;
				break;
			case 1:
				direction = DIRECTION.LEFT;
				break;
			case 2:
				direction = DIRECTION.UP;
				break;
			case 3:
				direction = DIRECTION.RIGHT;
			}

		}
		//Set the orientation after the rotation
		setOreintation(direction);	
		
		return currposition;
	}
	/**
	 * Sets the final orientation after the robot rotates left/right 
	 * @param direction is the final direction 
	 */
	private void setOreintation(DIRECTION direction){
		switch (direction) {
		case UP:
			currposition.setDirection(OREINTATION.N);
			break;
		case DOWN:
			currposition.setDirection(OREINTATION.S);
			break;
		case RIGHT:
			currposition.setDirection(OREINTATION.E);
			break;
		default:
			currposition.setDirection(OREINTATION.W);
		}
	}
}