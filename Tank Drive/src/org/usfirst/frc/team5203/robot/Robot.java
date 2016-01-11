package org.usfirst.frc.team5203.robot;


import org.usfirst.frc.team5203.robot.gameStates.Autonomous;
import org.usfirst.frc.team5203.robot.gameStates.Disabled;
import org.usfirst.frc.team5203.robot.gameStates.TeleOp;
import org.usfirst.frc.team5203.robot.gameStates.Test;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

public class Robot extends IterativeRobot {
    RobotDrive robot;
    Joystick controller;
    public Compressor compressor = new Compressor();
    public Robot() {
        robot = new RobotDrive(0, 1);
        robot.setExpiration(0.1);
        controller = new Joystick(0);
        robot.setSafetyEnabled(true);
    }

    /* (non-Javadoc)
     * @see edu.wpi.first.wpilibj.IterativeRobot#teleopInit()
     */
    public void teleopInit() {
    	TeleOp.init(robot);
    }
    /* (non-Javadoc)
     * @see edu.wpi.first.wpilibj.IterativeRobot#teleopPeriodic()
     */
    public void teleopPeriodic(){
    	TeleOp.update(robot, compressor);
    }
    /* (non-Javadoc)
     * @see edu.wpi.first.wpilibj.IterativeRobot#autonomousInit()
     */
    public void autonomousInit(){
    	Autonomous.init(robot);
    }
    /* (non-Javadoc)
     * @see edu.wpi.first.wpilibj.IterativeRobot#autonomousPeriodic()
     */
    public void autonomousPeriodic(){
    	Autonomous.update(robot);
    }
    /* (non-Javadoc)
     * @see edu.wpi.first.wpilibj.IterativeRobot#disabledInit()
     */
    public void disabledInit(){
    	Disabled.init(robot);
    }
    /* (non-Javadoc)
     * @see edu.wpi.first.wpilibj.IterativeRobot#testInit()
     */
    public void testInit(){
    	Test.init(robot);
    }
    /* (non-Javadoc)
     * @see edu.wpi.first.wpilibj.IterativeRobot#testPeriodic()
     */
    public void testPeriodic(){
    	Test.update(robot);
    }
}
