package org.usfirst.frc.team5203.robot;

import org.usfirst.frc.team5203.robot.gameStates.Autonomous;
import org.usfirst.frc.team5203.robot.gameStates.Disabled;
import org.usfirst.frc.team5203.robot.gameStates.TeleOp;
import org.usfirst.frc.team5203.robot.gameStates.Test;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Josh Bacon
 *
 */
public class Robot extends IterativeRobot {
	static RobotDrive robot;
	static Joystick controller;
	static VictorSP launchWheel1;
	static VictorSP launchWheel2;
	static Solenoid[] solenoid = new Solenoid[4];
	static Compressor compressor;
	static Encoder rEncoder;
	static Encoder lEncoder;
	CameraServer server;
	static AnalogGyro gyro;

	public static AnalogGyro getGyro() {
		return gyro;
	}
	/**
	 * @author joshua.bacon
	 * 
	 */
	public Robot() {
		//Assigns the robot variable to a RobotDrive object using PWM ports 0 and 1
		robot = new RobotDrive(0, 1);
		/*
		 * I believe that this sets how long the motors will go without a signal being 
		 * sent to them before defaulting to 0
		 */
		robot.setExpiration(0.1);
		//Assigns the controller variable to a Joystick object using the joystick plugged into port 0
		controller = new Joystick(0);
		//Sets motor safety to be enabled so if the expiration happens, it will default the motors to 0
		robot.setSafetyEnabled(true);
		//Pusher In
		solenoid[0] = new Solenoid(0);
		//Pusher Out
		solenoid[1] = new Solenoid(1);
		//Lift down
		solenoid[2] = new Solenoid(2);
		//Lift up
		solenoid[3] = new Solenoid(3);
		//Assigns compressor variable to Compressor 0
		compressor = new Compressor(0);
		//Assigns rEncoder to a new Encoder object using 2 ports
		rEncoder = new Encoder(Variables.RightDriveEncoder, Variables.RightDriveEncoderGround);
		//Assigns lEncoder to a new Encoder object using 2 ports
		lEncoder = new Encoder(Variables.LeftDriveEncoder, Variables.LeftDriveEncoderGround);
		SmartDashboard.putNumber("Fire Speed", .9);
		SmartDashboard.putNumber("Autonomous Mode", 2);
		//Assigns variable server to a new CameraServer object
		server = CameraServer.getInstance();
		//Starts video streaming to camera named "cam0"
		server.startAutomaticCapture("cam0");
		//Sets gyro to the Analog Port 0, which is the default port for the built in gyro
		gyro = new AnalogGyro(0);
		//Calibrates the gyroscope so that it can be used later
		gyro.calibrate();
	}
	/*
	 * When robot is initialized, initialize the launch wheels using VictorSP motor controllers
	 */
	public void robotInit() {
		launchWheel1 = new VictorSP(Variables.leftMotorPort);
		launchWheel2 = new VictorSP(Variables.rightMotorPort);
	}

	/*
	 * When teleop is initialized, start compressor loop and run the init function in the Teleop class
	 */
	public void teleopInit() {
		compressor.setClosedLoopControl(true);
		TeleOp.init(robot);
	}
	/*
	 * When teleop is running, update and run the update function in the Teleop class
	 */
	public void teleopPeriodic() {
		TeleOp.update();
	}

	/*
	 * When autonomous is initialized, start compressor loop and run the init function in the Autonomous class
	 */
	public void autonomousInit() {
		compressor.setClosedLoopControl(true);
		Autonomous.init(robot);
	}

	/* 
	 * When autonomous is running, update and run the update function in the Autonomous class
	 */
	public void autonomousPeriodic() {
		Autonomous.update(robot);
	}

	/*
	 * When robot is disabled, run the init function in the Disabled class and stop compressor loop
	 */
	public void disabledInit() {
		Disabled.init(robot);
		compressor.setClosedLoopControl(false);
	}

	/*
	 * When test mode is initialized, run the init function in the Test class and start the compressor loop
	 */
	public void testInit() {
		compressor.setClosedLoopControl(true);
		Test.init(robot);
	}
	
	/* 
	 * When test is running, update and run the update function in the Test class
	 */
	public void testPeriodic() {
		Test.update(robot);
	}

	/**
	 * @return The robot variable
	 */
	public static RobotDrive getRobot() {
		return robot;
	}

	/**
	 * @return The controller variable
	 */
	public static Joystick getController() {
		return controller;
	}

	/**
	 * @return The launch wheel object
	 */
	public static VictorSP getLaunchWheel1() {
		return launchWheel1;
	}

	/**
	 * @return The launch wheel object
	 */
	public static VictorSP getLaunchWheel2() {
		return launchWheel2;
	}

	/**
	 * @return The solenoid array
	 */
	public static Solenoid[] getSolenoid() {
		return solenoid;
	}

	/**
	 * @return The compressor object
	 */
	public static Compressor getCompressor() {
		return compressor;
	}

	/**
	 * @return The right encoder object
	 */
	public static Encoder getrEncoder() {
		return rEncoder;
	}

	/**
	 * @return The left encoder object
	 */
	public static Encoder getlEncoder() {
		return lEncoder;
	}

}