import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static char[] p;
	static int N, R;
	static int[] nums;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		p = new char[N];
		nums = new int[R];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			p[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(p);
		sb = new StringBuilder();

		combi(0, 0);
		System.out.println(sb);

	}

	private static void combi(int depth, int start) {
		if (depth == R && check()) {
			for (int i = 0; i < R; i++) {
				sb.append(p[nums[i]]);
			}
			sb.append("\n");
			return;
		} else if (depth < R) {
			for (int i = start; i < N; i++) {
				nums[depth] = i;
				combi(depth + 1, i + 1);
				nums[depth] = 0;
			}
		}

	}

	private static boolean check() {
		int cntA = 0;
		int cntB = 0;
		for (int n : nums) {
			if (contains(p[n])) {
				cntA++;
			} else {
				cntB++;
			}
		}
		return cntA >= 1 && cntB >= 2;
	}

	private static boolean contains(char c) {
		char[] aeiou = { 'a', 'e', 'i', 'o', 'u' };
		for (int i = 0; i < 5; i++) {
			if (c == aeiou[i])
				return true;
		}
		return false;
	}

}
