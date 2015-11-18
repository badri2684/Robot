package com.robo.control.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.robo.control.domain.GridLayout;
import com.robo.control.validator.RobotControlValidator;
/**
 * Tests the negative inputs to the program, that cause the program to exit with
 * the appropriate error message
 * @author Badri Srinivasan
 *
 */
public class RobotControlValidatorTest {
	
	@Before
	/**
	 * Initializing the grid layout
	 */
	public void initialise(){
		GridLayout.setGridLayout(100, 100);
	}
	/**
	 * Tests to check the first String can be only N,S,W,E
	 */
	@Test
	public void testWrongIntialPositionOrientation() {
		String initialpos="Q 10 20";
		boolean actual=RobotControlValidator.validateInitialPosition(initialpos);
		assertFalse(actual);
	}
	/**
	 * Tests to check the first String should start with the orientation
	 */
	@Test
	public void testWrongIntialPositionOrientation2() {
		String initialpos="10 20 Q";
		boolean actual=RobotControlValidator.validateInitialPosition(initialpos);
		assertFalse(actual);
	}
	/**
	 * Tests to check delimiter " " is present between the different input strings
	 **/
	@Test
	public void testWrongIntialPositionFormat() {
		String initialpos="N1020";
		boolean actual=RobotControlValidator.validateInitialPosition(initialpos);
		assertFalse(actual);
	}
	/**
	 * Tests to check the x and the y coordinates should only be numbers
	 **/
	@Test
	public void testWrongIntialPositionForValideCoordinates(){
		String initialpos="N A B";
		boolean actual=RobotControlValidator.validateInitialPosition(initialpos);
		assertFalse(actual);
	}
	/**
	 * Tests to check the x and the y coordinates should only be positive integers
	 */
	@Test
	public void testWrongIntialPositionForValideCoordinatesInteger(){
		String initialpos="N -5 -6";
		boolean actual=RobotControlValidator.validateInitialPosition(initialpos);
		assertFalse(actual);
	}
	/**
	 * Tests to check the x and the y coordinates should only be positive integers
	 */
	@Test
	public void testWrongIntialPositionForValideCoordinatesMaxValue(){
		String initialpos="N 1000 300";
		boolean actual=RobotControlValidator.validateInitialPosition(initialpos);
		assertFalse(actual);
	}
	/**
	 * Tests to check the the command to the Robot can only conatin the characters
	 *  M
	 *  L
	 *  R
	 *  1-100 
	 */
	@Test
	public void testWrongCommandIllegalCharacters(){
		String command="M12LRTY";
		boolean actual=RobotControlValidator.validateCommand(command);
		assertFalse(actual);
	}
	/**
	 * Tests to check the the command to the Robot can only conatin the characters
	 *  M
	 *  L
	 *  R
	 *  1-100 
	 **/
	@Test
	public void testWrongCommandIllegalCharacters1(){
		String command="M12LDDRTY";
		boolean actual=RobotControlValidator.validateCommand(command);
		assertFalse(actual);
	}
	/**
	 * Tests to check the the the number in the command cannot be greater than 100
	 **/
	@Test
	public void testWrongCommandIllegalNumber(){
		String command="M123LRLR";
		boolean actual=RobotControlValidator.validateCommand(command);
		assertFalse(actual);
	}
	/**
	 * Tests to check that the first character cannot be a number
	 **/
	@Test
	public void testWrongCommandIllegalFirstCharcater(){
		System.out.println("Illelegal first characters");
		String command="13LL";
		boolean actual=RobotControlValidator.validateCommand(command);
		assertFalse(actual);
	}
	/**
	 * Tests to validate some correct commands
	 **/
	@Test
	public void testCorrecCommand1(){
		String command="L3ML";
		boolean actual=RobotControlValidator.validateCommand(command);
		assertTrue(actual);
	}
	/**
	 * Tests to validate some correct commands
	 **/
	@Test
	public void testCorrectCommand2(){
		String command="RRRRM33";
		boolean actual=RobotControlValidator.validateCommand(command);
		assertTrue(actual);
	}

}
