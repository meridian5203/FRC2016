package org.usfirst.frc.team5203.robot.gameStates;

import org.usfirst.frc.team5203.robot.Robot;
import org.usfirst.frc.team5203.robot.ball.Launcher;
import org.usfirst.frc.team5203.robot.math.EncoderConversion;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Autonomous {

	private static int index;
	private static RobotDrive drive;
	private static Solenoid[] solenoid;
	private static double leftValue;
	private static double rightValue;
	private static int i;
	private static int j;
	private static int k;
	private static boolean firstLoop;
	private static double time1;
	private static double time2;

	public static void init(RobotDrive robot) {
		// Default index value
		index = 0;
		// Drive system
		drive = Robot.getRobot();
		// Left speed
		leftValue = 0;
		// Right speed
		rightValue = 0;
		// Solenoid value
		solenoid = Robot.getSolenoid();
		// Reset Encoders
		Robot.getlEncoder().reset();
		Robot.getrEncoder().reset();

	}

	public static void update(RobotDrive robot) {
		TeleOp.dashboard(Robot.getController());
		switch ((int) SmartDashboard.getNumber("Autonomous Mode", 1)) {
		case 1:
			auto1(index);
			break;
		case 2:
			auto2(index);
			break;
		case 3:
			auto3(index);
			break;

		}
		index++;
	}

	private static void auto1(int index) {
		switch(i){
		case 0:
			Robot.getlEncoder().reset();
			Robot.getrEncoder().reset();
		if(Robot.getlEncoder().getDistance() < EncoderConversion.inchToRev(EncoderConversion.leftEncoder, 243.909)){
			leftValue = .8;
		}
		else{
			leftValue = 0;
			j=1;
		}
		if(Robot.getrEncoder().getDistance() > EncoderConversion.inchToRev(EncoderConversion.rightEncoder, 243.909)){
			rightValue = .8;
		}
		else{
			rightValue = 0;
			k=1;
		}
		if(j==1 && k==1){
			i = 1;
			j=0;
			k=0;
		}
		break;
		case 1:
			Robot.getlEncoder().reset();
			Robot.getrEncoder().reset();
			if(Robot.getlEncoder().getDistance() < EncoderConversion.arcInch(EncoderConversion.leftEncoder, 30.75, 60)){
				leftValue = .6;
			}
			else{
				leftValue = 0;
				j =1;
			}
			if(j==1){
				i=2;
				j=0;
			}
			break;
		case 2:
			Robot.getlEncoder().reset();
			Robot.getrEncoder().reset();
			if(firstLoop){
				firstLoop = false;
				time1 = Timer.getFPGATimestamp();
				Launcher.launcher(false, false);
			}
			
			if(Timer.getFPGATimestamp() <= time1+3 && !firstLoop){
				Launcher.launcher(false, true);
			}
			if(Timer.getFPGATimestamp() > time1+3 && !firstLoop){
				firstLoop = true;
				i = 3;
			}
		case 3:
			Robot.getlEncoder().reset();
			Robot.getrEncoder().reset();
			if(Robot.getlEncoder().getDistance() > EncoderConversion.arcInch(EncoderConversion.leftEncoder, 30.75, -60)){
				leftValue = -.6;
			}
			else{
				leftValue = 0;
				j =1;
			}
			if(j==1){
				i=4;
				j=0;
			}
			break;
		case 4:
			Robot.getlEncoder().reset();
			Robot.getrEncoder().reset();
		if(Robot.getlEncoder().getDistance() > EncoderConversion.inchToRev(EncoderConversion.leftEncoder, -243.909)){
			leftValue = -.8;
		}
		else{
			leftValue = 0;
			j=1;
		}
		if(Robot.getrEncoder().getDistance() < EncoderConversion.inchToRev(EncoderConversion.rightEncoder, -243.909)){
			rightValue = -.8;
		}
		else{
			rightValue = 0;
			k=1;
		}
		if(j==1 && k==1){
			i = 5;
			j=0;
			k=0;
		}
			
	}
		Robot.getRobot().tankDrive(leftValue, rightValue);
		
	}

	private static void auto2(int index) {
		if (Robot.getlEncoder().getDistance() < EncoderConversion.inchToRev(EncoderConversion.leftEncoder, 96)) {
			leftValue = .8;
		} else {
			leftValue = 0;
		}
		if (Robot.getrEncoder().getDistance() > EncoderConversion.inchToRev(EncoderConversion.rightEncoder, 96)) {
			rightValue = .8;
		} else {
			rightValue = 0;
		}
		Robot.getRobot().tankDrive(leftValue, rightValue);
	}

	private static void auto3(int index) {
		// 1 Seconds
		if (index >= 0 && index < 1000) {

		}
		// 2 Second
		if (index >= 1000 && index < 2000) {

		}
		// 3 Seconds
		if (index >= 2000 && index < 3000) {

		}
		// 4 Seconds
		if (index >= 3000 && index < 4000) {

		}
		// 5 Seconds
		if (index >= 4000 && index < 5000) {

		}
		// 6 Seconds
		if (index >= 5000 && index < 6000) {

		}
		// 7 Seconds
		if (index >= 6000 && index < 7000) {

		}
		// 8 Seconds
		if (index >= 7000 && index < 8000) {

		}
		// 9 Seconds
		if (index >= 8000 && index < 9000) {

		}
		// 10 Seconds
		if (index >= 10000 && index < 11000) {

		}
		// 11 Seconds
		if (index >= 11000 && index < 12000) {

		}
		// 12 Seconds
		if (index >= 12000 && index < 13000) {

		}
		// 13 Seconds
		if (index >= 13000 && index < 14000) {

		}
		// 14 Seconds
		if (index >= 14000 && index < 15000) {

		}
		// End
		if (index == 15000) {

		}
	}
}
