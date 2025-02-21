import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int N;
	static int[] nums;
	static boolean[] visited;

	static int maxScore;
	static BufferedReader br;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][9];
		nums = new int[9];
		visited = new boolean[9];
		nums[3] = 0;
		maxScore = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		perm(0);
		System.out.println(maxScore);
	}

	private static void perm(int depth) throws IOException {
		if (depth == 9) {
			maxScore = Math.max(game(), maxScore);
			return;
		}
		if (depth == 3) {
			perm(depth + 1);
			return;
		}
		for (int i = 1; i < 9; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			nums[depth] = i;
			perm(depth + 1);
			visited[i] = false;
		}

	}

	private static int game() throws IOException {

		int idx = 0;
		int round = 0;
		int score = 0;
		while (round < N) {
			int flag = 0;
			int out = 0;
			while (out < 3) {
				int s = map[round][nums[idx]];
				if (s == 0) {
					out++;
				} else {
					flag = flag << s;
					flag = flag | (1 << (s - 1));
					int endFlag = flag >> 3;
					flag = flag % 8;
					for (int i = 0; i < 4; i++) {
						if ((endFlag & (1 << i)) != 0)
							score++;
					}
				}
				idx = (idx + 1) % 9;
			}
			round++;
		}
		return score;

	}

}
