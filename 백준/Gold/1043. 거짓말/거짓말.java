import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, answer;
	static int[] p;
	static int[][] input;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		p = new int[N+1];
		input = new int[M][];
		makeSet();
		answer = 0;

		// 소문을 아는사람 연결 기록하기(보스 다 0으로 만들었음)
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			union(0, Integer.parseInt(st.nextToken()));
		}

		// 파티원 연결하기, 단 갈 수 있는지 확인해야하니 input에 저장하며 보스 0으로 만들기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			T = Integer.parseInt(st.nextToken());
			input[i] = new int[T];
			input[i][0] = Integer.parseInt(st.nextToken());
			for (int t = 1; t < T; t++) {
				input[i][t] = Integer.parseInt(st.nextToken());
				union(input[i][0], input[i][t]);
			}
		}

		// 파티 한번 더 순회하면서 boss가 0인 사람이 있는지 확인(확인 전 find필수)
		for (int i = 0; i < M; i++) {
			boolean isknow = false;
			for (int num : input[i]) {
				if (find(num) == 0) {
					isknow = true;
					break;
				}
			}
			if(!isknow) {
				answer++;
			}
		}
		System.out.println(answer);
	}
	

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x > y) {
			p[x] = y;
		} else {
			p[y] = x;
		}
	}

	private static int find(int x) {
		if (p[x] == x) {
			return x;
		}
		return p[x] = find(p[x]);
	}

	private static void makeSet() {
		for (int i = 0; i <= N; i++) {
			p[i] = i;
		}
	}

}
