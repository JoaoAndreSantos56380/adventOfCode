package desafio_5;


public class Diagram {
	private int[][] values;

	public Diagram() {
		values = new int[1000][1000];
	}

	public void escreveVertical(int x1, int y1, int x2, int y2) {
		if (y1 < y2) {
			for (int j = y1; j <= y2; j++) {
				//values[j][x1]++;
				values[x1][j]++;
			}
		} else {
			for (int j = y1; j >= y2; j--) {
				//values[j][x1]++;
				values[x1][j]++;
			}
		}
	}

	public void escreveHorizontal(int x1, int y1, int x2, int y2) {
		if (x1 < x2) {
			for (int j = x1; j <= x2; j++) {
				//values[y1][j]++;
				values[j][y1]++;
			}
		} else {
			for (int j = x1; j >= x2; j--) {
				//values[y1][j]++;
				values[j][y1]++;
			}
		}
	}

	public int twoLinesOverlap() {
		int count = 0;
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values[0].length; j++) {
				if (values[i][j] >= 2) {
					count++;
				}
			}
		}
		return count;
	}

	public void print() {
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values[0].length; j++) {
				System.out.print(values[i][j]);
			}
			System.out.println();
		}
	}

	public void reset() {
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values[0].length; j++) {
				values[i][j] = 0;
			}
		}
	}

	public void escreveDiagonal(int x1, int y1, int x2, int y2) {
		// se x1 < x2
		if (x1 < x2) {
			// se y1 < y2
			if (y1 < y2) {
				int x1DaWish = x1;
				// percorremos as linhas crescentemente
				for (int i = x1DaWish; i <= x2; i++) {//usado e funciona
					// percorremos as colunas crescentemente
						values[x1++][y1++]++;
				}
			} else if(y1 > y2){
				// se y1 > y2
				int x1DaWish = x1;
				for (int i = x1DaWish; i <= x2; i++) {//usado e funciona
					// percorremos as colunas decrescentemente
					//values[y1--][x1++]++;
					values[x1++][y1--]++;
				}
			}
		} else if(x1 > x2){ // se x1 > x2
			// se y1 > y2
			if (y1 > y2) {
				int x1DaWish = x1;
				// percorremos as linhas decrescentemente
				for (int i = x1DaWish; i >= x2; i--) {//usado e funciona
					// percorremos as colunas decrescentemente
					//values[y1--][x1--]++;
					values[x1--][y1--]++;
				}
			} else{
				// se y1 < y2
				int x1DaWish = x1;
				for (int i = x1DaWish; i >= x2; i--) {//usado e funciona
					// percorremos as colunas crescentemente
					//values[x1--][y1++]++;
					values[x1--][y1++]++;
				}
			}
		}
	}
}
