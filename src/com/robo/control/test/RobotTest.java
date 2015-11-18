package com.robo.control.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import com.robo.control.domain.GridLayout;
import com.robo.control.domain.Position;
import com.robo.control.domain.Position.OREINTATION;
import com.robo.control.domain.Robot;

public class RobotTest {
	//Instance of the robot
	Robot robo;
	//Current position
	Position currposition;
	/**
	 * Method to configure the robots initial position
	 */
	public void configureRobotInitialPosition(int x, int y, OREINTATION oreintation) {
		currposition = new Position(x, y, oreintation);
		robo = new Robot(currposition);
		robo.intialiseDircetions();
		
	}
	@Before
	/**
	 * Initializes the grid layout and the robot
	 */
	public void initializeRobot() {
		GridLayout.setGridLayout(100, 100);
		// configureRobotInitialPosition();

	}

	/**
	 * Testing single command to move forward
	 */
	@Test
	public void testMoveForwardPositiveScenario() {
		configureRobotInitialPosition(0, 0, OREINTATION.N);
		Position expectedposition = new Position(0, 3, OREINTATION.N);
		Position actualposition = robo.moveforward(3);
		assertEquals(expectedposition, actualposition);

	}

	/**
	 * Testing single command to move forward
	 */
	@Test
	public void testMoveForwardNegativeScenario() {
		int steps = 3;
		configureRobotInitialPosition(0, 0, OREINTATION.N);
		Position expectedposition = new Position(0, 6, OREINTATION.N);
		Position actualposition = robo.moveforward(steps);
		assertNotEquals(expectedposition, actualposition);

	}

	/**
	 *  Test Single command to rotate left
	 */
	@Test
	public void testRotateLeft() {
		int roatenotimes = 3;
		configureRobotInitialPosition(0, 0, OREINTATION.N);
		Position expectedposition = new Position(0, 0, OREINTATION.E);
		Position actualposition = robo.rotateLeft(roatenotimes);
		assertEquals(expectedposition, actualposition);
	}

	/**
	 * Test single command to rotate right
	 */
	@Test
	public void testRotateRight() {
		int roatenotimes = 3;
		configureRobotInitialPosition(0, 0, OREINTATION.N);
		Position expectedposition = new Position(0, 0, OREINTATION.W);
		Position actualposition = robo.rotateRight(roatenotimes);
		assertEquals(expectedposition, actualposition);
	}



}
