package desafio_4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GiantSquid{
	private static String t = "desafio_4//input_Giant_Squid.txt";
	private static String t2 = "teste.txt";
	public static void main(String[] args) {
		
		Matriz ultimaMatrizRemovida = null;
		String line;
		String[] linhaNumeros = null;
		int winningNumber = -1;
		int numeroDeLinhas = 1;
		boolean fimDoJogo = false;
		int somaElemsNaoMarcados = 0;
		ArrayList<Matriz> matrizes = new ArrayList<>();
		ArrayList<Matriz> matrizesRecurso = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(new File(t)))) {
			// ler os numeros para um array
			linhaNumeros = br.readLine().split(",");
			// ler todas as matrizes
			while((line = br.readLine()) != null){
				if (!line.equals("")) {
					if (numeroDeLinhas <= 5) {
						if (matrizes.size() > 0) {
							matrizes.get(matrizes.size()-1).addLine(line, numeroDeLinhas);
							numeroDeLinhas++;
						} else{
							matrizes.add(new Matriz(5, 5));
							matrizes.get(0).addLine(line, numeroDeLinhas);
							numeroDeLinhas++;
						}
					} else {
						matrizes.add(new Matriz(5, 5));
						numeroDeLinhas = 1;
						matrizes.get(matrizes.size()-1).addLine(line, numeroDeLinhas);
						numeroDeLinhas++;
					}
				}
			}
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("No file found!");
		}
		restabelece(matrizesRecurso, matrizes);
		int valor = -1;
		//este ciclo da o score do ultimo tabuleiro a vencer o jogo
		/*
		while(matrizes.size() > 0){
			valor = resultado(matrizes, linhaNumeros, matrizesRecurso);
			//System.out.println(valor);
		}
		*/
		valor = resultado(matrizes, linhaNumeros, matrizesRecurso);
		System.out.println("Feito! \n" + valor);
	}//fim da main

	protected static boolean verificaVitoria(ArrayList<Matriz> matrizes){
		for (int i = 0; i < matrizes.size(); i++) {
			if (matrizes.get(i).cincoEmLinha()) {
				return true;
			} else if(matrizes.get(i).cincoEmColuna()){
				return true;
			}
		}
			return false;
	}

	private static int resultado(ArrayList<Matriz> matrizes, String[] linhaNumeros, ArrayList<Matriz> matrizesRecurso){
		boolean fimDoJogo = false;
		int winningNumber = -1;
		int somaElemsNaoMarcados = 0;
		for (int i = 0; i < linhaNumeros.length && !fimDoJogo; i++) {
			winningNumber = Integer.parseInt(linhaNumeros[i]);
			for (int j = 0; j < matrizes.size() && !fimDoJogo; j++) {
				// se existir
				// remover da matriz
				matrizes.get(j).containsValue(Integer.parseInt(linhaNumeros[i]));
				// perguntar se ha algum vencedor
				fimDoJogo = verificaVitoria(matrizes);
				if (fimDoJogo) {
					// se houver guardar o ultimo numero que foi colocado
					// somar todos os elementos nao marcados
					somaElemsNaoMarcados = matrizes.get(j).somaElemsNaoMarcados();
					matrizes.remove(j);
					matrizesRecurso.remove(j);
					//linhaNumeros = Arrays.copyOfRange(linhaNumeros, descobreValor(linhaNumeros, winningNumber), linhaNumeros.length);
					//multiplicar os dois valores obtidos
						//System.out.println(winningNumber * somaElemsNaoMarcados);
					/*
					ultimaMatrizRemovida = matrizes.remove(j);
					fimDoJogo = false;
					*/
					return winningNumber * somaElemsNaoMarcados;
				}
			}
		}
		return -1;
	}

	private static void restabelece (ArrayList<Matriz> a, ArrayList<Matriz> aRecurso){
		for (int i = 0; i < aRecurso.size(); i++) {
			a.add(new Matriz(5, 5));
			a.set(i, aRecurso.get(i));
		}
	}
}
/*
Sera que funciona guardar na matriz (classe) o ultimo elementos que lhe foi removido.
Assim removemos todas as primerias matrizes e guardamos a matriz removida.
Depois somamos os elementos não marcados e multiplicamos pelo ultimo elemento removido.
*/
