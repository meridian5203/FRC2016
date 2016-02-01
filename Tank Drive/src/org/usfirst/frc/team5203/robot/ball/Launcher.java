package org.usfirst.frc.team5203.robot.ball;

import org.usfirst.frc.team5203.robot.Robot;
import org.usfirst.frc.team5203.robot.Variables;
import org.usfirst.frc.team5203.robot.math.Scale;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;

public class Launcher {
	
	public static void launcher(VictorSP victorSP, boolean button, boolean otherbutton){
		if(button == true){
			Robot.getMotor().set(Variables.suckSpeed);
		}else if(otherbutton == true){
			Robot.getMotor().set(Variables.fireSpeed);
		}else{
			Robot.getMotor().set(0);
		}
	}
	
}
