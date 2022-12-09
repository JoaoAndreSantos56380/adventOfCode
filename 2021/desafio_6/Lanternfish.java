package desafio_6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
//After  1 day:  2,3,2,0,1
/*
 * 0:1
 * 1:1
 * 2:2
 * 3:
 */
/**
 * Lanternfish
 */
public class Lanternfish {
	private static String input = "desafio_6\\input.txt";
	private static String inputTeste = "desafio_6\\inputTeste.txt";
	public static void main(String[] args) {
		HashMap<Long, Long> listaLanternFish = new HashMap<>();
		String line;
		String[] lineArr;
		long sum = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(new File(input)))) {
			if ((line = br.readLine()) != null) {
				lineArr = line.split(",");
				for (int i = 0; i < lineArr.length; i++) {
					if (!listaLanternFish.containsKey(Long.parseLong(lineArr[i]))) {
						listaLanternFish.put(Long.parseLong(lineArr[i]), 1L);
					} else {
						listaLanternFish.put(Long.parseLong(lineArr[i]), listaLanternFish.get(Long.parseLong(lineArr[i]))+1);
					}
				}
				Long[] items;
				long zeros = -1;
				Set<Long> keySet = new HashSet<Long>(listaLanternFish.keySet());
				items = new Long[keySet.size()];
				items = keySet.toArray(new Long[keySet.size()]);
				for (int i = 1; i <= 256; i++) {
					if (listaLanternFish.containsKey(0L)) {
						zeros = listaLanternFish.get(0L);
					}
					for (int j = 0; j < items.length; j++) {
						long key = items[j];
						if (key == 0) {
							continue;
						} else {
							listaLanternFish.put(key-1, listaLanternFish.get(key));
							listaLanternFish.put(key,0L);
						}
					}
					if (items[0] == 0L) {
						if (listaLanternFish.containsKey(6L)) {
							listaLanternFish.put(6L, zeros + listaLanternFish.get(6L));
						} else{
							listaLanternFish.put(6L, zeros);
						}
						listaLanternFish.put(8L, zeros);
					}
					keySet = new HashSet<Long>(listaLanternFish.keySet());
					items = new Long[keySet.size()];
					items = keySet.toArray(new Long[keySet.size()]);
				}
				for (Long key : keySet) {
					sum += listaLanternFish.get(key);
				}
			}
			System.out.println(sum);
		} catch (IOException e) {
			System.out.println("No file found!");
		}
	}
}

//352195

//funciona mas rebenta com a RAM
/*
public static void main(String[] args) {
		ArrayList<Integer> listaLanternFish = new ArrayList<>();
		String line;
		String[] lineArr;
		int size;
		int sum = 0;
		int index;
		try (BufferedReader br = new BufferedReader(new FileReader(new File(input)))) {
			if ((line = br.readLine()) != null) {
				lineArr = line.split(",");
				for (int i = 0; i < lineArr.length; i++) {
					listaLanternFish.add(Integer.parseInt(lineArr[i]));
					for (int k = 1; k <= 256; k++) {
						size = listaLanternFish.size();
						//System.out.println("iteracao " + k );
						for (int j = 0; j < size; j++) {
						index = listaLanternFish.get(j);
							if (index > 0) {
								listaLanternFish.set(j, --index);
							} else {
								listaLanternFish.set(j,  6);
								listaLanternFish.add(8);
							}
						}
					}
					System.out.println(listaLanternFish.size());
					sum += listaLanternFish.size();
					listaLanternFish.clear();
				}
			}
			System.out.println(listaLanternFish.size());
			System.out.println(sum);
		} catch (IOException e) {
			System.out.println("No file found!");
		}
	}
*/
