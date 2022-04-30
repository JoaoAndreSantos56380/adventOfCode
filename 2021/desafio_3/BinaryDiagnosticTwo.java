package desafio_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BinaryDiagnosticTwo {
	private static String fileNameBinary_Diagnostic = "Binary_Diagnostic.txt";
	public static void main(String[] args) throws IOException {
		ArrayList<String> numerosO2 = new ArrayList<String>();
		ArrayList<String> numerosCO2 = new ArrayList<String>();
		String line = "";
		BufferedReader br = new BufferedReader(new FileReader(new File (fileNameBinary_Diagnostic)));
		long[][] matrizContagem = new long[2][12];
		BinaryDiagnostic.contaFrequencias(line, br, matrizContagem);
		br.close();
		// ler valores do ficheiro para um arraylist
		BufferedReader br2 = new BufferedReader(new FileReader(new File (fileNameBinary_Diagnostic)));
		while( ( line = br2.readLine() ) != null){
			numerosO2.add(line);
			numerosCO2.add(line);
		}
		// Criar duas funcoes distintas para calcular o O2gen e o CO2scr
		long O2gen = calcularO2gen(numerosO2, matrizContagem);
		long CO2src = calcularCO2src(numerosCO2, matrizContagem);
		System.out.println(O2gen * CO2src);
	}

	//To find oxygen generator rating, determine the most common value (0 or 1) in the current bit position, and keep only numbers with that bit in that position. 
		//If 0 and 1 are equally common, keep values with a 1 in the position being considered.
	private static long calcularO2gen(ArrayList<String> lista, long[][] matrizContagem){
		char bitMaisComum = '2';
		// percorrer as contagens dos bits
		for (int i = 0; i < matrizContagem[0].length && lista.size() > 1; i++) {
			bitMaisComum = matrizContagem[0][i] > matrizContagem[1][i] ? '0' : '1';
			// percorrer o arraylist 
			for (int j = 0; j < lista.size(); j++) {
				// se o indice nao tiver o bit x igual ao bit mais comum
				if ( lista.get(j).charAt(i) != ( bitMaisComum) ) {
					//apaga-se do arrayList 
					lista.remove(j);
					j--;
				}
			}
			atualizaFrequencias(matrizContagem, lista);
		}
		return (BinaryDiagnostic.converte(new StringBuilder(lista.get(0)).reverse().toString()));
	}
	//To find CO2 scrubber rating, determine the least common value (0 or 1) in the current bit position, and keep only numbers with that bit in that position. 
		//If 0 and 1 are equally common, keep values with a 0 in the position being considered.
	private static long calcularCO2src(ArrayList<String> lista, long[][] matrizContagem){
		char bitMenosComum = '2';
		// percorrer as contagens dos bits
		for (int i = 0; i < matrizContagem[0].length && lista.size() > 1; i++) {
			bitMenosComum = matrizContagem[0][i] > matrizContagem[1][i] ? '1' : '0';
			// percorrer o arraylist 
			for (int j = 0; j < lista.size(); j++) {
				// se o indice nao tiver o bit x igual ao bit mais comum
				if ( lista.get(j).charAt(i) != ( bitMenosComum ) ) {
					//apaga-se do arrayList 
					lista.remove(j);
					j--;
				}
			}
			atualizaFrequencias(matrizContagem, lista);
		}
		return (BinaryDiagnostic.converte(new StringBuilder(lista.get(0)).reverse().toString()));
	}

	protected static void atualizaFrequencias(long[][] matrizContagem, ArrayList<String> lista){
		String line;
		for (int i = 0; i < matrizContagem.length; i++) {
			for (int j = 0; j < matrizContagem[0].length; j++) {
				matrizContagem[i][j] = 0;
			}
		}
		for (int i = 0; i < lista.size(); i++) {
			// ler bit a bit de cada valor 
			line = lista.get(i);
			for (long j = 0; j < line.length(); j++) {
				//se for 0 
				if (line.charAt((int) j) == '0') {
					// somar ao indice de bits 0 no array dentro do array das posicoes dos bits 
					matrizContagem[0][(int) j]++;
				} else{// caso contrario 
					// somar ao indice de bits 0 no array dentro do array das posicoes dos bits
					matrizContagem[1][(int)j]++;
				}
			}
		}
	}
/*
The bit criteria depends on which type of rating value you want to find:


To find CO2 scrubber rating, determine the least common value (0 or 1) in the current bit position, and keep only numbers with that bit in that position. 
	If 0 and 1 are equally common, keep values with a 0 in the position being considered.
*/
}
