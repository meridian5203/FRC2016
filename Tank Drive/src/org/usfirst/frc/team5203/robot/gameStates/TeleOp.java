package org.usfirst.frc.team5203.robot.gameStates;

import org.usfirst.frc.team5203.robot.Robot;
import org.usfirst.frc.team5203.robot.Variables;
import org.usfirst.frc.team5203.robot.ball.Launcher;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TeleOp {
	public static DigitalInput limitSwitch;
	public static void init(RobotDrive robot){
		//Encoder encoder;
		limitSwitch = new DigitalInput(Variables.dio0);
	}
	
	
	
	/**
	 * @param robot
	 * @param compressor
	 * @param launchWheels
	 * @param solenoid
	 * @param j
	 */
	public static void update(){
		boolean buttonA = (Robot.getController().getRawButton(1)) ? true : false;
		boolean buttonB = (Robot.getController().getRawButton(2)) ? true : false;
		if(limitSwitch.get()){
			SmartDashboard.putBoolean("Limit Switch", true);
		}else{
			SmartDashboard.putBoolean("Limit Switch", false);
		}
		
		
		Robot.getRobot().arcadeDrive(Robot.getController());
		Launcher.launcher(Robot.getLaunchWheels(), buttonB,buttonA);
		
	}



	public static DigitalInput getLimitSwitch() {
		return limitSwitch;
	}
	
}
