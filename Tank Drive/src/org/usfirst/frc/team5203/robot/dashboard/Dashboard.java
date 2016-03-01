package org.usfirst.frc.team5203.robot.dashboard;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.TableKeyNotDefinedException;

public class Dashboard {
	public static double getDouble(String name) {
		try {
			double d = SmartDashboard.getNumber(name);
			return d;
		} catch (TableKeyNotDefinedException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static void putDouble(String name, double d) {
		SmartDashboard.putNumber(name, d);
	}

	public static void putBoolean(String name, boolean b) {
		SmartDashboard.putBoolean(name, b);
	}

	public static void putText(String name, String s) {
		SmartDashboard.putString(name, s);
	}

	public static void putInt(String name, int i) {
		SmartDashboard.putNumber(name, i);
	}

	public static void putJoystick(Joystick j) {

		putDouble("Left Joystick X Value", j.getRawAxis(0));
		putDouble("Left Joystick Y Value", j.getRawAxis(1));
		putBoolean("A Button", j.getRawButton(1));
		putBoolean("B Button", j.getRawButton(2));
		putBoolean("X Button", j.getRawButton(3));
		putBoolean("Y Button", j.getRawButton(4));
		putBoolean("Left Bumper", j.getRawButton(5));
		putBoolean("Right Bumper", j.getRawButton(6));
		putBoolean("Back", j.getRawButton(7));
		putBoolean("Start", j.getRawButton(8));
		putBoolean("Left Stick", j.getRawButton(9));
		putBoolean("Right Stick", j.getRawButton(10));

	}

}
