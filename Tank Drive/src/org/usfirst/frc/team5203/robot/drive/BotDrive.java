package org.usfirst.frc.team5203.robot.drive;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.communication.UsageReporting;
import edu.wpi.first.wpilibj.communication.FRCNetworkCommunicationsLibrary.tInstances;
import edu.wpi.first.wpilibj.communication.FRCNetworkCommunicationsLibrary.tResourceType;

public class BotDrive extends RobotDrive{

	public BotDrive(int leftMotorChannel, int rightMotorChannel) {
		super(leftMotorChannel, rightMotorChannel);
		// TODO Auto-generated constructor stub
	}
	
	public void tankDrive(double leftValue, double rightValue, boolean squaredInputs) {

	    if (!kTank_Reported) {
	      UsageReporting.report(tResourceType.kResourceType_RobotDrive, getNumMotors(),
	          tInstances.kRobotDrive_Tank);
	      kTank_Reported = true;
	    }
	}
	public void tankDrive(double leftValue, double rightValue) {
	    tankDrive(leftValue, rightValue, true);
	  }
	public void arcadeDrive(){}

	
	
}
