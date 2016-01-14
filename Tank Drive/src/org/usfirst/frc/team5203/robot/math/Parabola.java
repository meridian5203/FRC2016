package org.usfirst.frc.team5203.robot.math;

import org.usfirst.frc.team5203.robot.Variables;

public class Parabola {
	
	public double angle(double height, double distance, double velocity, double hInit){
		double angle = 0;
		double gravity = Variables.gravity;
		double time = Math.sqrt((2*(hInit-height))/gravity);
		double Vyi = (height-(.5*gravity*Math.pow(time, 2))-velocity)/time;
		angle = Math.asin(Vyi/velocity);
		
		
		
		return angle;
		
	}
	
	
}
