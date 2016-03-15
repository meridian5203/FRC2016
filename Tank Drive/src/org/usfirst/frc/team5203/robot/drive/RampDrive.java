package org.usfirst.frc.team5203.robot.drive;

import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.Timer;

public class RampDrive {

	public static final int k_FrontLeft = 0;
	public static final int k_FrontRight = 1;
	public static final int k_BackLeft = 2;
	public static final int k_BackRight = 3;
	
	public static TalonSRX m_FrontLeft;
	public static TalonSRX m_FrontRight;
	public static TalonSRX m_BackLeft;
	public static TalonSRX m_BackRight;
	
	boolean firstLoopDrive;
	boolean firstLoopRotate;
	double time1Drive;
	double time1Rotate;
	
	double initialSpeed;
	double finalSpeed;
	double initialRotate;
	double finalRotate;
	double rotate;
	double speed;
	
	final int speedCycleDivision = 20;
	final int rotateCycleDivision = 20;
	
	public RampDrive(){
		m_FrontLeft = new TalonSRX(0);
		m_FrontRight = new TalonSRX(1);
		firstLoopDrive = true;
		firstLoopRotate = true;
		finalSpeed = 0;
		initialSpeed = 0;
		finalRotate = 0;
		initialRotate = 0;
		rotate = 0;
		speed = 0;
	}
	
	public void rampDrive(double driveInput, double rotateInput, double driveRamp, double rotateRamp){
		if(firstLoopDrive){
			time1Drive = Timer.getFPGATimestamp();
			firstLoopDrive = false;
		}
		else
		{
			if(time1Drive>driveRamp/speedCycleDivision){
				finalSpeed = driveInput;
				speed = driveInput + ((finalSpeed-initialSpeed)/speedCycleDivision);
				initialSpeed = speed;
				firstLoopDrive = true;
			}
			else
			{
				speed = speed;
			}
		}
		if(firstLoopRotate){
			time1Rotate = Timer.getFPGATimestamp();
			firstLoopRotate = false;
		}
		else
		{
			if(time1Rotate>driveRamp/rotateCycleDivision){
				finalRotate = rotateInput;
				rotate = driveInput + ((finalRotate-initialRotate)/speedCycleDivision);
				initialRotate = rotate;
				firstLoopRotate = true;
			}
			else
			{
				rotate = rotate;
			}
		}
		drive(speed, rotate);
		
	}
	
	public static void drive(double drive, double rotate){
		
	}
	
	
	
}
