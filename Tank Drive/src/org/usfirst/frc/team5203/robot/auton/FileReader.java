package org.usfirst.frc.team5203.robot.auton;

import java.io.IOException;

public class FileReader {
	public static String s;
	public static Command read(){
		try {
			s = FileIO.getBr().readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] items = s.split(",");
		double axis[] = null;
		boolean button[] = null;
		for(int i = 1; i < 7; i++){
			axis[i-1] = Double.parseDouble(items[i]);
		}
		for(int i = 7; i < 17; i++){
			if(items[i]=="1" && items[i] != null){
				button[i-1] = true;
			}else{
				button[i-1] = false;
			}
		}
		Command command = new Command(axis, button);
		return command;
	}
	
}
