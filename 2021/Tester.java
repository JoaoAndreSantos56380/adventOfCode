public class Tester {
	public static void main(String[] args) {
		long j = 0;
		String num = "";
		for (int i = 0; i < 2147000000; i++) {
			j++;
			num = Integer.toString(i);
		}
		System.out.println(j);
		System.out.println(num);
	}
}
