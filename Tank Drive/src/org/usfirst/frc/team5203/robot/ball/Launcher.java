package org.usfirst.frc.team5203.robot.ball;

import org.usfirst.frc.team5203.robot.Variables;
import org.usfirst.frc.team5203.robot.math.Scale;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;

public class Launcher {
	
	public static void suck(VictorSP motor, boolean button, boolean otherbutton){
		if(button == true){
			motor.set(Variables.suckSpeed);
		}else if(otherbutton == true){
			motor.set(Variables.fireSpeed);
		}else{
			motor.set(0);
		}
	}
	
}
