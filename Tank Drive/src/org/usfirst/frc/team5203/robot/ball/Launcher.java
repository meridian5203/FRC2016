package org.usfirst.frc.team5203.robot.ball;

import org.usfirst.frc.team5203.robot.Variables;
import org.usfirst.frc.team5203.robot.math.Scale;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TalonSRX;

public class Launcher {
	
	public static void suck(TalonSRX[] motor, boolean button){
		if(button == true){
			motor[0].setRaw(Scale.to255(Variables.suckSpeed));
			motor[1].setRaw(Scale.to255(Variables.suckSpeed));
		}else{
			motor[0].setRaw(0);
			motor[1].setRaw(1);
		}
	}
	
	public static void fire(TalonSRX[] motor, boolean button,Solenoid solenoid){
		if(button == true){
			solenoid.equals(true);
			
			motor[0].setRaw(Scale.to255(Variables.fireSpeed));
			motor[1].setRaw(Scale.to255(Variables.fireSpeed));
		}else{
			solenoid.equals(false);
			motor[0].setRaw(0);
			motor[1].setRaw(1);
		}
	}
	
}
