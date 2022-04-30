package desafio_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SonarSweepOne{

	public static int calculateNumberOfIncreases(String filename) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
		String currentMeasurement;
		int currentMeasurementInt;
		int previousMeasurement = Integer.parseInt(br.readLine());
		int count = 0;
		int numberOfLines = 0;
		while((currentMeasurement = br.readLine()) != null){
			currentMeasurementInt = Integer.parseInt(currentMeasurement);
			if (currentMeasurementInt > previousMeasurement) {
				count++;
			}
			numberOfLines++;
			previousMeasurement = currentMeasurementInt;
		}
		br.close();
		return count;
	}
/* 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("input_Sonar_Sweep.txt")));
		String currentMeasurement;
		int currentMeasurementInt;
		int previousMeasurement = Integer.parseInt(br.readLine());
		int count = 0;
		int numberOfLines = 0;
		while((currentMeasurement = br.readLine()) != null){
			currentMeasurementInt = Integer.parseInt(currentMeasurement);
			if (currentMeasurementInt > previousMeasurement) {
				count++;
			}
			numberOfLines++;
			previousMeasurement = currentMeasurementInt;
		}
		System.out.println(count + " " + numberOfLines);
	} */
	/*
	ler valor a valor ficheiro 
	se for o primeiro 
		guardar
	caso contrario
		comparar atual com antigo
			se o atual for maior
				atualizar contador 
			caso contrario
				nada
	*/
	/*
	You're minding your own business on a ship at sea when the overboard alarm goes off! You rush to see if you can help. Apparently, one of the Elves tripped and accidentally sent the sleigh keys flying into the ocean!

	Before you know it, you're inside a submarine the Elves keep ready for situations like this. It's covered in Christmas lights (because of course it is), and it even has an experimental antenna that should be able to track the keys if you can boost its signal strength high enough; there's a little meter that indicates the antenna's signal strength by displaying 0-50 stars.

	Your instincts tell you that in order to save Christmas, you'll need to get all fifty stars by December 25th.

	Collect stars by solving puzzles. Two puzzles will be made available on each day in the Advent calendar; the second puzzle is unlocked when you complete the first. Each puzzle grants one star. Good luck!

	As the submarine drops below the surface of the ocean, it automatically performs a sonar sweep of the nearby sea floor. On a small screen, the sonar sweep report (your puzzle input) appears: each line is a measurement of the sea floor depth as the sweep looks further and further away from the submarine.

	For example, suppose you had the following report:

	199
	200
	208
	210
	200
	207
	240
	269
	260
	263

	This report indicates that, scanning outward from the submarine, the sonar sweep found depths of 199, 200, 208, 210, and so on.

	The first order of business is to figure out how quickly the depth increases, just so you know what you're dealing with - you never know if the keys will get carried into deeper water by an ocean current or a fish or something.

	To do this, count the number of times a depth measurement increases from the previous measurement. (There is no measurement before the first measurement.) In the example above, the changes are as follows:

	199 (N/A - no previous measurement)
	200 (increased)
	208 (increased)
	210 (increased)
	200 (decreased)
	207 (increased)
	240 (increased)
	269 (increased)
	260 (decreased)
	263 (increased)

	In this example, there are 7 measurements that are larger than the previous measurement.

	How many measurements are larger than the previous measurement?
	*/
}
