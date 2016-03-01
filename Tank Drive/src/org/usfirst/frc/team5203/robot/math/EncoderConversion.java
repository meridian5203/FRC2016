package org.usfirst.frc.team5203.robot.math;

public class EncoderConversion {

	public static String leftEncoder = "Left Encoder";
	public static String rightEncoder = "Right Encoder";
	public static double dubble;
	public static double inchToRev(String s, double inch){
		switch(s){
		case "Left Encoder":
			inch = inch*-1;
			dubble = -205.83/inch;
			break;
		case "Right Encoder":
			dubble = 196.32/inch;
			break;
		}
		
		return dubble;
	}
	
	public static double revToInch(String s, double rev){
		switch(s){
		case "Left Encoder":
			dubble = rev/-205.83;
			rev = Math.abs(rev);
			break;
		case "Right Encoder":
			dubble = rev/196.32;
			break;
		}
		return dubble;
	}
	
	public static double arcInch(String s, double length, double angleDeg){
		switch(s){
		case "Left Encoder":
			dubble = length*Math.toRadians(angleDeg);
			dubble = dubble * -1;
			break;
		case "Right Encoder":
			dubble = length*Math.toRadians(angleDeg);
			break;
		}
		return dubble;
	}
	
}
