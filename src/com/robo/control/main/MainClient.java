package com.robo.control.main;

import com.robo.control.workflow.WorkFlowManager;

/**
 * The Main program is the starting point and delegates the entire process to the
 * WorkFlowManager class to do set up the input and guide the Robot
 *
 * @author Badri Srinivasan
 * @version 1.0
 */
public class MainClient {
	public static void main(String[] args) {

		new WorkFlowManager().start();

	}
}
