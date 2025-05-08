import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;

		String base = br.readLine();
		int[] baseCount = new int[26];
		int M = base.length();
		for (int i = 0; i < M; i++) {
			baseCount[base.charAt(i) - 'A']++;
		}

		for (int i = 1; i < N; i++) {
			int diff = 0;
			String check = br.readLine();
			int checkLen = check.length();
			int[] checkCount = new int[26];
			for (int j = 0; j < checkLen; j++) {
				checkCount[check.charAt(j) - 'A']++;
			}
			for (int j = 0; j < 26; j++) {
				diff += Math.abs(baseCount[j] - checkCount[j]);
			}
			if (M == checkLen) {
				if (diff <= 2) {
					answer++;
				}
			} else {
				if (diff <= 1) {
					answer++;
				}
			}
		}
		System.out.println(answer);

	}
}
