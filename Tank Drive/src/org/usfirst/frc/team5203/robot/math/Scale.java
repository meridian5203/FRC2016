package org.usfirst.frc.team5203.robot.math;

public class Scale {

	public static int to255(double base){
		Double solution = base*255;
		return solution.intValue();
	}
	
}
