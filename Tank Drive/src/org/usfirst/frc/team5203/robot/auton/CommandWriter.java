package org.usfirst.frc.team5203.robot.auton;

import java.io.BufferedWriter;
import java.io.IOException;

public class CommandWriter {

	public static void write(double d){
		BufferedWriter bw = FileIO.getBw();
		String s = Double.toString(d);
		try {
			bw.write(s);
			bw.write(",");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void write(boolean b){
		BufferedWriter bw = FileIO.getBw();
		String s;
		if(b == true){
			s = "1";
		}else{
			s = "0";
		}
		try {
			bw.write(s);
			bw.write(",");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
