package org.usfirst.frc.team5203.robot.gameStates;

import org.usfirst.frc.team5203.robot.Robot;
import org.usfirst.frc.team5203.robot.Variables;
import org.usfirst.frc.team5203.robot.auton.Record;
import org.usfirst.frc.team5203.robot.ball.Launcher;
import org.usfirst.frc.team5203.robot.dashboard.Dashboard;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TeleOp {
	//Stores whether or not the autonomous is recording. Unfinished
	public static boolean isRecording;
	//The amount of times that the teleop loop has run
	public static int loopCount;
	//The joystick used for controlling the robot
	public static Joystick j;
	//The right encoder object
	static Encoder rEncoder;
	//The left encoder object
	static Encoder lEncoder;
	
	//Encoder Variables
	static boolean leftEncoderDirection;
	static boolean rightEncoderDirection;
	static double leftEncoderCount;
	static double rightEncoderCount;

	//Runs when teleop is initialized
	public static void init(RobotDrive robot) {
		j = Robot.getController();
	}


	public static void update() {
		//Increase the loop count
		loopCount++;
		//Set buttonB to true if button is pressed, false if not pressed
		boolean buttonB = (Robot.getController().getRawButton(2)) ? true : false;
		//Set fire to true if the trigger is pressed more than halfway, or vice versa
		boolean fire = (Robot.getController().getRawAxis(3) >= .5) ? true : false;

		//Publish values to the dashboard
		dashboard(Robot.getController());
		/*
		 * Use arcade drive using:
		 *	Axis 1:
		 *		Inverted, cubed
		 *	Axis 0:
		 *		Inverted, cubed, 85%
		 */
		Robot.getRobot().arcadeDrive(-1*Math.pow(Robot.getController().getRawAxis(1),3),
				-.85*Math.pow(Robot.getController().getRawAxis(0), 3));
		//Runs the launcher function, running the wheels
		Launcher.launcher(buttonB, fire);
		//Lowers the launcher if button 6 is pressed, but raises it otherwise
		if(j.getRawButton(6)){
			Robot.getSolenoid()[2].set(false);
			Robot.getSolenoid()[3].set(true);
		}else{
			Robot.getSolenoid()[2].set(true);
			Robot.getSolenoid()[3].set(false);
		}
		
		//If isRecording is true, write to a file (UNFINISHED)
		if (isRecording) {
			Record.write(loopCount);
		}
	}

	/**
	 * @param j The joystick
	 */
	public static void dashboard(Joystick j) {
		rEncoder = Robot.getrEncoder();
		lEncoder = Robot.getlEncoder();
		rightEncoderDirection = rEncoder.getDirection();
		leftEncoderDirection = lEncoder.getDirection();
		rightEncoderCount = rEncoder.getDistance();
		leftEncoderCount = lEncoder.getDistance();
		
		Dashboard.putDouble("Gyro", Robot.getGyro().getAngle());
		Variables.fireSpeed = SmartDashboard.getNumber("Fire Speed");
		Dashboard.putBoolean("Right Encoder Direction", rightEncoderDirection);
		Dashboard.putBoolean("Left Encoder Direction", leftEncoderDirection);
		Dashboard.putDouble("Right Encoder Distance", rightEncoderCount);
		Dashboard.putDouble("Left Encoder Distance", leftEncoderCount);


	}

}
