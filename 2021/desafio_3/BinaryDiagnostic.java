package desafio_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BinaryDiagnostic{
	private static String fileNameBinary_Diagnostic = "Binary_Diagnostic.txt";
	public static void main(String[] args) throws IOException {
		long[][] matrizValores = new long[2][12];
		StringBuilder gamaRate = new StringBuilder();
		StringBuilder epsilonRate = new StringBuilder();
		BufferedReader br = new BufferedReader(new FileReader(new File(fileNameBinary_Diagnostic)));
		String line = "";
		// ler o ficheiro linha a linha
		contaFrequencias(line, br, matrizValores);
		// percorrer o array das posicoes dos bits e criar string com o bit mais comum em cada posicao
		for (long i = 0; i < matrizValores[0].length; i++) {
			if (matrizValores[0][(int) i] > matrizValores[1][(int) i]) {
				gamaRate.append(0);
				epsilonRate.append(1);
			} else{
				gamaRate.append(1);
				epsilonRate.append(0);
			}
		}
		// multiplicar esse valor obtido pelo not do mesmo valor
		long gamaratelong = converte(gamaRate.reverse().toString());
		long epsilonRatelong = converte(epsilonRate.reverse().toString());
		System.out.print(gamaratelong * epsilonRatelong);
	}// fim da main

	protected static long converte(String number){
		long numeroConvertido = 0;
		for (long i = number.length()-1; i > -1; i--) {
			if (number.charAt((int) i) == '1') {
				numeroConvertido += Math.pow(2, /*number.length() - */i);
			}
		}
		return numeroConvertido;
	}//fim converte
	
	protected static void contaFrequencias(String line, BufferedReader br, long[][] matrizValores) throws IOException{
		while((line = br.readLine() )!= null){
			// ler bit a bit de cada valor 
			for (long i = 0; i < line.length(); i++) {
				//se for 0 
				if (line.charAt((int) i) == '0') {
					// somar ao indice de bits 0 no array dentro do array das posicoes dos bits 
					matrizValores[0][(int) i]++;
				} else{// caso contrario 
					// somar ao indice de bits 0 no array dentro do array das posicoes dos bits
					matrizValores[1][(int)i]++;
				}
			}
		}
	}
	/*
The submarine has been making some odd creaking noises, so you ask it to produce a diagnostic report just in case.

The diagnostic report (your puzzle input) consists of a list of binary numbers which, when decoded properly, can tell you many useful things about the conditions of the submarine. 
The first parameter to check is the power consumption.

You need to use the binary numbers in the diagnostic report to generate two new binary numbers (called the gamma rate and the epsilon rate). 
The power consumption can then be found by multiplying the gamma rate by the epsilon rate.

Each bit in the gamma rate can be determined by finding the most common bit in the corresponding position of all numbers in the diagnostic report. 
For example, given the following diagnostic report:

00100
11110
10110
10111
10101
01111
00111
11100
10000
11001
00010
01010

Considering only the first bit of each number, there are five 0 bits and seven 1 bits. Since the most common bit is 1, the first bit of the gamma rate is 1.

The most common second bit of the numbers in the diagnostic report is 0, so the second bit of the gamma rate is 0.

The most common value of the third, fourth, and fifth bits are 1, 1, and 0, respectively, and so the final three bits of the gamma rate are 110.

So, the gamma rate is the binary number 10110, or 22 in decimal.

The epsilon rate is calculated in a similar way; rather than use the most common bit, the least common bit from each position is used. 
So, the epsilon rate is 01001, or 9 in decimal. Multiplying the gamma rate (22) by the epsilon rate (9) produces the power consumption, 198.

Use the binary numbers in your diagnostic report to calculate the gamma rate and epsilon rate, then multiply them together. 
What is the power consumption of the submarine? (Be sure to represent your answer in decimal, not binary.)
	*/

}// fim da classe
