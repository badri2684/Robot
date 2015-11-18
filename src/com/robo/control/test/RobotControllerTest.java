package com.robo.control.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.robo.control.controller.RobotController;
import com.robo.control.domain.GridLayout;
import com.robo.control.domain.Position;
import com.robo.control.domain.Position.OREINTATION;
import com.robo.control.domain.Robot;

/**
 * Tests the various operations of the robot like 1. Move Forward 2. Rotate Left
 * 3. Rotate Right the appropriate error message
 * 
 * @author Badri Srinivasan
 *
 */
public class RobotControllerTest {
	Robot robo;
	RobotController controller;
	Position currposition;

	@Before
	/**
	 * Initializes the grid layout and the robot
	 */
	public void initializeRobot() {
		GridLayout.setGridLayout(100, 100);
		// configureRobotInitialPosition();

	}

	/**
	 * Method to configure the robots initial position
	 */
	public void configureRobotInitialPosition(int x, int y, OREINTATION oreintation) {
		currposition = new Position(x, y, oreintation);
		robo = new Robot(currposition);
		robo.intialiseDircetions();
		controller = new RobotController(robo);

	}

	/**
	 * Test to do multiple operations like Forward,Left and Right
	 */
	@Test
	public void testMultipleCommands() {
		String command="M1RM4L3M2";
		configureRobotInitialPosition(0, 0, OREINTATION.N);
		Position expectedposition=new Position(4,99,OREINTATION.S);
		Position actualposition=controller.executeRobotCommands(command);
		assertEquals(expectedposition, actualposition);
	}

	

}
