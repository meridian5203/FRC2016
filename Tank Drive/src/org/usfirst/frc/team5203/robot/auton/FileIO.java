package org.usfirst.frc.team5203.robot.auton;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class FileIO {

	public static BufferedWriter bw;
	public static Writer fw;
	public static Reader reader;
	public static BufferedReader br;
	
	public static void fileStart() {
		try {
			File file = new File("auto.csv");
			file.setWritable(true);
			
			fw = new FileWriter(file.getAbsolutePath());
			bw = new BufferedWriter(fw);
			br = new BufferedReader(reader);
			
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static BufferedWriter getBw() {
		return bw;
	}

	public static Writer getFw() {
		return fw;
	}
	
	public static Reader getReader(){
		return reader;
	}
	
	public static BufferedReader getBr(){
		return br;
	}
}
