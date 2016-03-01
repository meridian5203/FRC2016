package org.usfirst.frc.team5203.robot.auton;

import java.io.IOException;
import java.util.ArrayList;

import org.usfirst.frc.team5203.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * @author Josh Bacon
 * An unfinished class that is designed to record an autonomous system.
 */
public class Record {

	public static ArrayList<Command> actions = new ArrayList<Command>();
	static boolean button[];
	static double axis[];

	public static void write(int loopCount) {
		Joystick j = Robot.getController();
		for (int i = 0; i < 6; i++) {
			axis[i] = j.getRawAxis(i);
		}
		for (int i = 1; i < 11; i++) {
			button[i] = j.getRawButton(i);
		}
		actions.add(new Command(axis, button));

		try {
			FileIO.getBw().write(Integer.toString(loopCount));
			FileIO.getBw().write(",");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		for (int i = 0; i < 6; i++) {
			CommandWriter.write(axis[i]);
		}
		for (int i = 0; i < 11; i++) {
			CommandWriter.write(button[i]);
		}
		try {
			FileIO.getBw().newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void read(int index) {
		actions.get(index);
	}

}
