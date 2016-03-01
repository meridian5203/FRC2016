package org.usfirst.frc.team5203.robot.ball;

import org.usfirst.frc.team5203.robot.Robot;
import org.usfirst.frc.team5203.robot.Variables;
import org.usfirst.frc.team5203.robot.math.Scale;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Launcher {

	/**
	 * Boolean that stores whether the automated launch sequence is being started
	 */
	static boolean firstLoop;
	/**
	 * Stores the initial time when the automated launch sequence is started
	 */
	static double time1;
	/**
	 * @param button The button that is pressed to suck up the ball
	 * @param otherbutton The button that is pressed to fire the ball
	 */
	public static void launcher(boolean button, boolean otherbutton) {
		SmartDashboard.putBoolean("First Loop", firstLoop);
		SmartDashboard.putNumber("Time 1", time1);
		SmartDashboard.putNumber("Current Time", Timer.getFPGATimestamp());
		
		/* If the suck button is true, set both motors to the suck state
		 * If the suck button is pushed, set the firstLoop variable to true to reset it,
		 * fixing the problem where if suck is pushed when firing, it will continue to store the time.
		 */
		if (button == true) {
			Robot.getLaunchWheel1().set(-1*Variables.suckSpeed);
			Robot.getLaunchWheel2().set(Variables.suckSpeed);
			firstLoop = true;
		} 
		/*
		 * If fire button is pushed, set wheels to fire.
		 * Also, set the time1 variable to store the game time when the button was pushed so that it can be referenced later.
		 * After 2 seconds (time1+2), push out the launch piston, but only if the time is less than 3 seconds (time1+3).
		 * After 3 seconds, pull the piston back in, and set firstLoop to true, reseting the system.
		 */
		else if (otherbutton == true) {
			Robot.getLaunchWheel1().set(-1*Variables.fireSpeed);
			Robot.getLaunchWheel2().set(Variables.fireSpeed);
			if(firstLoop){
				firstLoop = false;
				time1 = Timer.getFPGATimestamp();
			}
			if(Timer.getFPGATimestamp() >= time1+2 && Timer.getFPGATimestamp() < time1+3 && !firstLoop){
				Robot.getSolenoid()[0].set(false);
				Robot.getSolenoid()[1].set(true);
				SmartDashboard.putBoolean("Shooter Out", true);
			}
			if(Timer.getFPGATimestamp() >= time1+3 && !firstLoop){
				Robot.getSolenoid()[0].set(true);
				Robot.getSolenoid()[1].set(false);
				SmartDashboard.putBoolean("Shooter Out", false);
				firstLoop = true;
			}
			
			/*
			 * This will set lights on the dashboard to have a countdown for when
			 * the ball will launch. 
			 */
			if(Timer.getFPGATimestamp() >= time1){
				SmartDashboard.putBoolean("Shoot 1", true);
			}
			if(Timer.getFPGATimestamp() >= time1+1){
				SmartDashboard.putBoolean("Shoot 2", true);
			}
			if(Timer.getFPGATimestamp() >= time1+2){
				SmartDashboard.putBoolean("Shoot 3", true);
			}
			if(Timer.getFPGATimestamp() == time1){
				SmartDashboard.putBoolean("Shoot 1", false);
				SmartDashboard.putBoolean("Shoot 2", false);
				SmartDashboard.putBoolean("Shoot 3", false);
			}
			
		} 
		/*
		 * If neither the fire button nor the suck button are pushed, set the wheel speeds to 0.
		 * Also, pull the piston in.
		 */
		else {
			Robot.getLaunchWheel1().set(0);
			Robot.getLaunchWheel2().set(0);
			Robot.getSolenoid()[0].set(true);
			Robot.getSolenoid()[1].set(false);
			firstLoop = true;
		}
	}
	/**
	 * @param suck The boolean to use if you want to suck the ball.
	 * @param shoot The boolean to use if you want to shoot the ball.
	 */
	public static void launcherAuto(boolean suck, boolean shoot) {
		if (suck == true) {
			Robot.getLaunchWheel1().set(-1*Variables.suckSpeed);
			Robot.getLaunchWheel2().set(Variables.suckSpeed);
		} else if (shoot == true) {
			Robot.getLaunchWheel1().set(-1*Variables.fireSpeed);
			Robot.getLaunchWheel2().set(Variables.fireSpeed);
		} else {
			Robot.getLaunchWheel1().set(0);
			Robot.getLaunchWheel2().set(0);
		}
	}

}
