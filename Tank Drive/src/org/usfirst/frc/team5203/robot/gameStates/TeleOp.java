package org.usfirst.frc.team5203.robot.gameStates;

import org.usfirst.frc.team5203.robot.ball.Launcher;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.VictorSP;

public class TeleOp {

	public static void init(RobotDrive robot){
		
	}
	/**
	 * @param robot
	 * @param compressor
	 * @param launchWheels
	 * @param solenoid
	 * @param j
	 */
	public static void update(RobotDrive robot, Compressor compressor, VictorSP launchWheels, Solenoid[] solenoid, Joystick j){
		boolean buttonA = (j.getRawButton(1)) ? true : false;
		boolean buttonB = (j.getRawButton(2)) ? true : false;
		
		robot.arcadeDrive(j);
		Launcher.suck(launchWheels, buttonB,buttonA);
		
	}
	
}
