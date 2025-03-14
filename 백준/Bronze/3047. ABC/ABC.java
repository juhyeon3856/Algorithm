import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int[] list = new int[3];
		for (int i = 0; i < 3; i++) {
			list[i] = sc.nextInt();
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		Arrays.sort(list);
		char[] clist = { 'A', 'B', 'C' };
		for (int i = 0; i < 3; i++) {
			map.put(clist[i], list[i]);
		}

		String str = sc.next();
		for (int i = 0; i < 3; i++) {
			System.out.print(map.get(str.charAt(i)) + " ");
		}
	}
}
