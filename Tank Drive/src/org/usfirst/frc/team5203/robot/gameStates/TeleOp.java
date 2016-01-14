package org.usfirst.frc.team5203.robot.gameStates;

import org.usfirst.frc.team5203.robot.ball.Launcher;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TalonSRX;

public class TeleOp {

	public static void init(RobotDrive robot){
		
	}
	/**
	 * @param robot
	 * @param compressor
	 */
	public static void update(RobotDrive robot, Compressor compressor, TalonSRX[] motors, Solenoid[] solenoid, Joystick j){
		boolean buttonA = (j.getRawButton(0)) ? true : false;
		boolean buttonB = (j.getRawButton(1)) ? true: false;
		
		Launcher.fire(motors, buttonA, solenoid[0]);
		Launcher.suck(motors, buttonB);
		
	}
	
}
