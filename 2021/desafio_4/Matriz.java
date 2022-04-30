package desafio_4;

public class Matriz {
	private int[][] matriz;
	private int linhas;
	private int colunas;
	private int ultimoElemRemovido;
	public Matriz(int linhas, int colunas){
		this.linhas = linhas;
		this.colunas = colunas;
		matriz = new int[linhas][colunas];
		ultimoElemRemovido = -1;
	}

	public int getLinhas(){
		return linhas;
	}

	public int getColunas(){
		return colunas;
	}

	public int getValue(int linha, int coluna){
		return matriz[linha][coluna];
	}

	public int somaElemsNaoMarcados(){
		int soma = 0;
		for (int i = 0; i <matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				int value  = matriz[i][j];
				if (value != -1) {
					soma += matriz[i][j];
				}
			}
		}
		return soma;
	}

	public void addLine(String lineToAdd, int lineNumber){
		String[] splittedLine = lineToAdd.split(" ");
		for (int j = 0; j < splittedLine.length; j++) {
			matriz[lineNumber - 1][j] = Integer.parseInt(splittedLine[j]);
		}
	}

	protected boolean cincoEmColuna() {
		boolean emColuna = true;
		for (int i = 0; i < matriz[0].length; i++) {
			for (int j = 0; j < matriz.length && emColuna; j++) {
				if (matriz[j][i] != -1) {
					emColuna = false;
				}
			}
			if (emColuna) {
				return true;
			} else {
				emColuna = true;
			}
		}
		return false;
	}

	protected boolean cincoEmLinha() {
		boolean emColuna = true;
		for (int i = 0; i <matriz[0].length; i++) {
			for (int j = 0; j < matriz.length && emColuna; j++) {
				if (matriz[i][j] != -1) {
					emColuna = false;
				}
			}
			if (emColuna) {
				return true;
			} else{
				emColuna = true;
			}
		}
		return false;
	}

	public void removeValue(int line, int column){
		ultimoElemRemovido = matriz[line][column];
		matriz[line][column] = -1;
	}

	public void containsValue(int value){
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if (matriz[i][j] == value) {
					removeValue(i, j);
				}
			}
		}
	}
	
	public boolean containsValueBool(int value){
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if (matriz[i][j] == value) {
					return true;
				}
			}
		}
		return false;
	}

	public int getUltimoElemRemovido(){
		return ultimoElemRemovido;
	}
}
