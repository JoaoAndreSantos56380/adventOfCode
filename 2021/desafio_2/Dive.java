package desafio_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Dive {
	private static String forward = "forward";
	private static String down = "down";
	private static String up = "up";
	private static int horizontalPosition = 0;
	private static int depth = 0;

	/*
    forward X increases the horizontal position by X units.
    down X increases the depth by X units.
    up X decreases the depth by X units.
	*/
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("input_dive.txt")));
		String line;
		while( ( line = br.readLine() ) != null){
			String [] lineArray = line.split(" ");
			if (lineArray[0].equals(forward)) {
				horizontalPosition += Integer.parseInt(lineArray[1]);
			} else if (lineArray[0].equals(up)) {
				depth -= Integer.parseInt(lineArray[1]);
			} else{
				depth += Integer.parseInt(lineArray[1]);
			}
		}
		System.out.println(horizontalPosition * depth);
	}
}
