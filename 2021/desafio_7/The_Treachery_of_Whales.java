package desafio_7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class The_Treachery_of_Whales {
	private static String input = "desafio_7\\input.txt";
	private static String inputTeste = "desafio_7\\input_teste.txt";
	public static void main(String[] args) {
		String line;
		int[] numbersLineArr;
		float sum = 0;
		int minFuelAmount = Integer.MAX_VALUE;
		HashMap<Integer, Integer> horizontalPosition_Fuel = new HashMap<>();

		try (BufferedReader br = new BufferedReader(new FileReader(new File(input)))) {
			if ((line = br.readLine()) == null) {
				return;
			}
			numbersLineArr = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
			//Arrays.sort(numbersLineArr);
			for (int i = 0; i < numbersLineArr.length; i++) {
				for (int j = 0; j < numbersLineArr.length; j++) {
					if (i == j) {
						continue;
					}
					if (horizontalPosition_Fuel.containsKey(j)) {
						horizontalPosition_Fuel.put(j, horizontalPosition_Fuel.get(j) + somaDeUmAN(Math.abs(numbersLineArr[i] - numbersLineArr[j])));
					} else{
						horizontalPosition_Fuel.put(j, somaDeUmAN(Math.abs(numbersLineArr[i] - numbersLineArr[j])));
					}
				}
			}
			Set<Integer> values = horizontalPosition_Fuel.keySet();
			for (Integer value : values) {
				if(horizontalPosition_Fuel.get(value) < minFuelAmount){
					minFuelAmount = horizontalPosition_Fuel.get(value);
				}
			}
			System.out.println(minFuelAmount);
		} catch (IOException e) {
			System.out.println("No file found!");
		}
	}

	private static int somaDeUmAN(int numeroN){
		return numeroN * (numeroN+1) / 2;
	}
}
//
