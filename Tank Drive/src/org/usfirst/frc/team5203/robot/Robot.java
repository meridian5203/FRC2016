package org.usfirst.frc.team5203.robot;

import org.usfirst.frc.team5203.robot.gameStates.Autonomous;
import org.usfirst.frc.team5203.robot.gameStates.Disabled;
import org.usfirst.frc.team5203.robot.gameStates.TeleOp;
import org.usfirst.frc.team5203.robot.gameStates.Test;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	static RobotDrive robot;
	static Joystick controller;
	static VictorSP launchWheels;
	static Solenoid[] solenoid = new Solenoid[1];
	static CANTalon motor;
	static Compressor compressor = new Compressor();

	public Robot() {
		robot = new RobotDrive(0, 1);
		robot.setExpiration(0.1);
		controller = new Joystick(0);
		robot.setSafetyEnabled(true);
		solenoid[0] = new Solenoid(0);
		motor = new CANTalon(1);
	}

	public void robotInit() {
		launchWheels = new VictorSP(Variables.leftMotorPort);
	}

	public void teleopInit() {
		TeleOp.init(robot);
	}

	public void teleopPeriodic() {
		TeleOp.update();
	}

	public void autonomousInit() {
		Autonomous.init(robot);
	}

	public void autonomousPeriodic() {
		Autonomous.update(robot);
	}

	public void disabledInit() {
		Disabled.init(robot);
	}

	public void testInit() {
		Test.init(robot);
	}

	public void testPeriodic() {
		Test.update(robot);
	}

	public static RobotDrive getRobot() {
		return robot;
	}
	public static Joystick getController() {
		return controller;
	}
	public static VictorSP getLaunchWheels() {
		return launchWheels;
	}
	public static Solenoid[] getSolenoid() {
		return solenoid;
	}
	public static CANTalon getMotor() {
		return motor;
	}
	public static Compressor getCompressor() {
		return compressor;
}

}