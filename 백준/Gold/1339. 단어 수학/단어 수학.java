import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N, M, R;
	static int ans;
	static boolean[] visited, exist;
	static int[] values;
	static String[] words;

	public static void main(String[] args) throws Exception {
		//System.setIn(new java.io.FileInputStream("./src/sample_input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 초기화
		N = Integer.parseInt(br.readLine());
		M = 26;
		visited = new boolean[M];
		exist = new boolean[M];
		values = new int[M];
		words = new String[N];

		// 입력
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			words[i] = str;
			for (int j = 0; j < str.length(); j++) {
				int ci = str.charAt(j) - 'A';
				if (!exist[ci]) {
					exist[ci] = true;
					R++;
				}
			}
		}

		// 로직
		perm(R);

		System.out.println(ans);

	}

	private static void perm(int depth) {
		if (depth == 0) {
			ans = Math.max(calc(), ans); // 결과 계산
			return;
		}

		for (int i = 0; i < M; i++) {
			if (visited[i])
				continue;
			if (!exist[i])
				continue;

			values[i] = 10 - depth;
			visited[i] = true;
			perm(depth - 1);
			visited[i] = false;
			values[i] = 0;
		}
	}

	private static int calc() {
		int result = 0;
		for (String word : words) {
			int val = 0;
			for (int j = 0; j < word.length(); j++) {
				val *= 10;
				int ci = word.charAt(j) - 'A';
				val += values[ci];
			}
			result += val;
		}
		return result;
	}

}
