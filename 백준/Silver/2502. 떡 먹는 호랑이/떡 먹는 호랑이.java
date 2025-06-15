import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] p = { 1, 0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946,
				17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040 };

		int day = Integer.parseInt(st.nextToken()) - 2;
		int num = Integer.parseInt(st.nextToken());
		if (day == 1) {
			System.out.println(1);
			System.out.println(num - 1);
			return;
		}

		int b = 1;
		while (true) {
			if ((num - p[day + 1] * b) % p[day] == 0 && (num - p[day + 1] * b) / p[day] < b) {
				System.out.println((num - p[day + 1] * b) / p[day]);
				System.out.println(b);
				break;
			} else {
				b++;
			}
		}

	}

}
