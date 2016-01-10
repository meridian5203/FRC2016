package org.usfirst.frc.team5203.robot;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

public class Robot extends IterativeRobot {
    RobotDrive myRobot;
    Joystick controller;
    public Robot() {
        myRobot = new RobotDrive(0, 1);
        myRobot.setExpiration(0.1);
        controller = new Joystick(0);
        myRobot.setSafetyEnabled(true);
    }

    /**
     * Runs when the teleop period begins
     */
    public void TeleopInit() {}
    /**
     * Runs when autonomous is run
     */
    public void AutonomousInit(){}
    /**
     * Runs when robot is disabled
     */
    public void DisabledInit(){}
    

}
