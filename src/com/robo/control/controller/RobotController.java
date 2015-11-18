package com.robo.control.controller;

import com.robo.control.domain.Position;
import com.robo.control.domain.Robot;
import com.robo.control.domain.Position.OREINTATION;
import com.robo.control.main.constants.RobotControlConstants;
import com.robo.control.validator.RobotControlValidator;

/**
 * This is the controller of the robot,It has a method to take commands and give
 * it to the Robot one by one in a meaningful fashion
 * 
 * @author Badri Srinivasan
 *
 */
public class RobotController {

	// properties
	private Robot robot;

	// default constructor
	public RobotController() {

	}

	public RobotController(Robot robot) {
		this.robot = robot;
	}

	/**
	 * Gets the instance of Robot
	 * 
	 * @return the Robot
	 */
	public Robot getRobot() {
		return robot;
	}

	/**
	 * Used to set the robot
	 * 
	 * @param robot
	 */
	public void setRobot(Robot robot) {
		this.robot = robot;
	}

	/**
	 * This interprets the commands and gives instructions to the robot
	 * 
	 * @param command
	 *            is the full set of instructions to the robot
	 * @return the current position after executing the commands
	 */
	public Position executeRobotCommands(String command) {

		// Check if the command given to the robot is valid
		if (null != command && RobotControlValidator.validateCommand(command)) {
			// parse the command

			char[] commandarry = command.toCharArray();
			int i, j;
			for (i = 0; i < commandarry.length;) {

				StringBuilder numberstr = new StringBuilder("");
				for (j = i + 1; j < commandarry.length;) {
					while (j < commandarry.length
							&& (!(commandarry[j] == 'M' || commandarry[j] == 'L' || commandarry[j] == 'R'))
							&& (Character.isDigit(commandarry[j]))) {
						numberstr.append(commandarry[j]);
						j++;

					} // end of while loop
					break; // break the inner for loop
				} // end of inner for loop

				// No number so we must default to 1
				if (numberstr.length() == 0) {
					if (commandarry[i] == 'M') {
						robot.moveforward(1);
					} else if (commandarry[i] == 'L') {
						robot.rotateLeft(1);
					} else if (commandarry[i] == 'R') {
						robot.rotateRight(1);
					}
					i++;
				} else {
					int count = Integer.valueOf(numberstr.toString());
					if (commandarry[i] == 'M') {
						robot.moveforward(count);
					} else if (commandarry[i] == 'L') {
						robot.rotateLeft(count);
					} else if (commandarry[i] == 'R') {
						robot.rotateRight(count);
					}
					i = j;

				}

			} // end of main for loop

		}

		return robot.getCurrposition();
	}

	/**
	 * Initializes the robot with initial position
	 * 
	 * @param direction
	 *            is one of the values [N,E,W,S]
	 * @param xcoordinate
	 *            is the value of the x coordinate
	 * @param ycoordinate
	 *            is the value of the y coordinate
	 */
	public void initializeRobot(String direction, int xcoordinate, int ycoordinate) {
		OREINTATION oreintation = null;
		if (direction.equals(RobotControlConstants.NORTH)) {
			oreintation = OREINTATION.N;
		} else if (direction.equals(RobotControlConstants.SOUTH)) {
			oreintation = OREINTATION.S;
		} else if (direction.equals(RobotControlConstants.WEST)) {
			oreintation = OREINTATION.W;
		} else {
			oreintation = OREINTATION.E;
		}

		robot = new Robot(new Position(xcoordinate, ycoordinate, oreintation));
		robot.intialiseDircetions();

	}

}
