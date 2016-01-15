package org.usfirst.frc.team5203.robot;


import java.util.logging.Logger;

import org.usfirst.frc.team5203.robot.gameStates.Autonomous;
import org.usfirst.frc.team5203.robot.gameStates.Disabled;
import org.usfirst.frc.team5203.robot.gameStates.TeleOp;
import org.usfirst.frc.team5203.robot.gameStates.Test;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TalonSRX;

public class Robot extends IterativeRobot {
    RobotDrive robot;
    Joystick controller;
    TalonSRX[] launchWheels = new TalonSRX[2];
    Solenoid[] solenoid = new Solenoid[1];
    public Compressor compressor = new Compressor();
    public Robot() {
        robot = new RobotDrive(0, 1);
        robot.setExpiration(0.1);
        controller = new Joystick(0);
        robot.setSafetyEnabled(true);
        solenoid[0] = new Solenoid(0);
    }

    public void robotInit(){
    launchWheels[0] = new TalonSRX(Variables.leftMotorPort);	
    launchWheels[1] = new TalonSRX(Variables.rightMotorPort);
    }
    public void teleopInit() {
    	TeleOp.init(robot);
    }
    public void teleopPeriodic(){
    	TeleOp.update(robot, compressor, launchWheels, solenoid, controller);
    }
    public void autonomousInit(){
    	Autonomous.init(robot);
    }
    public void autonomousPeriodic(){
    	Autonomous.update(robot);
    }
    public void disabledInit(){
    	Disabled.init(robot);
    }

    public void testInit(){
    	Test.init(robot);
    }
    public void testPeriodic(){
    	Test.update(robot);
    }
}
