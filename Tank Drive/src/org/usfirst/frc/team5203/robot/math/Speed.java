package org.usfirst.frc.team5203.robot.math;

public class Speed {

	/**
	 * @param radiusCm
	 * @param rpm
	 * @return linearVelocity
	 */
	public static double getSpeedCm(double radiusCm, double rpm){
		double linearVelocity = (radiusCm*100) * rpm * .10472;
		return linearVelocity;
	}
	
	/**
	 * @param radiusM
	 * @param rpm
	 * @return linearVelocity
	 */
	public static double getSpeedM(double radiusM, double rpm){
		double linearVelocity = radiusM * rpm * .10472;
		return linearVelocity;
	}
	
	
}
