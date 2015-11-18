package com.robo.control.workflow;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.robo.control.controller.RobotController;
import com.robo.control.domain.GridLayout;
import com.robo.control.domain.Position;
import com.robo.control.main.constants.RobotControlConstants;
import com.robo.control.validator.RobotControlValidator;

/**
 * This class ties all the pieces together, the controller,validator It also
 * exposes a single method to be called from the client
 * 
 * @author Badri Srinivasan
 *
 */
public class WorkFlowManager {
	RobotController controller;

	public WorkFlowManager() {
		// System.out.println("Default Constructor");
	}

	/**
	 * Is the method, that is invoked by the client class It takes the input
	 * from the client Brings the different components of the application
	 * together like the controller and the validator
	 */
	public void start() {

		System.out.println("*******Robort Control Simulation Program*******");
		Scanner sc = new Scanner(System.in);
		String position = null;
		String command = null;
		
		//Taking user input until correct format
		do {
			System.out.println("Enter the robots intial position::");
			position = sc.nextLine();
		} while (!RobotControlValidator.validateInitialPosition(position));

		// Extracting the data using REGEX pattern for initial position
		Pattern p = Pattern.compile("(^[NSWE])[ ]([0-9])[ ]([0-9])");
		Matcher matcher = p.matcher(position);
		matcher.matches();
		String direction = matcher.group(1);
		int xcoordinate = Integer.parseInt(matcher.group(2));
		int ycoordinate = Integer.parseInt(matcher.group(3));

		
		// Initializing the parameters required for setup
		intialiseParameters(direction, xcoordinate, ycoordinate);
		
		//Taking user input until correct format
		do {
			System.out.println("Enter the instruction::");
			command = sc.nextLine();
		} while (!RobotControlValidator.validateCommand(command));

		Position finalpos = controller.executeRobotCommands(command);
		System.out.println("Final Position:::" + finalpos);

		// Closing the scanner object
		sc.close();

	}

	/**
	 * Initializes/Prepares the Robot to take instructions
	 * 
	 * @param direction
	 *            is the initial direction one of [N,S,W,E]
	 * @param xcoordinate
	 *            is the value of the x coordinate
	 * @param ycoordinate
	 *            is the value of the y coordinate
	 */

	private void intialiseParameters(String direction, int xcoordinate, int ycoordinate) {

		// Initializing the grid layout to (100 * 100)
		GridLayout.setGridLayout(100, 100);
		controller = new RobotController();
		controller.initializeRobot(direction, xcoordinate, ycoordinate);
	}

}
