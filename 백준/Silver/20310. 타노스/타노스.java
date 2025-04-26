import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = str.length();
		boolean[] isOne = new boolean[N];
		boolean[] inUse = new boolean[N];
		int one = 0;
		for (int i = 0; i < N; i++) {
			if (str.charAt(i) == '1') {
				isOne[i] = true;
				one++;
			}
		}
		int zero = (N - one) / 2;
		one /= 2;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			if (!isOne[i] && zero-- > 0) {
				sb.append(0);
			}
			if (isOne[i] && --one < 0) {
				sb.append(1);
			}
		}
		System.out.println(sb);
	}
}