import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int H;
	static int[][] map;
	static int answer;
	static boolean isEnd;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
		}
		answer = -1;
		isEnd = false;
		for (int i = 0; i <= 3; i++) {
			combi(0, i);
			if (isEnd) {
				answer = i;
				break;
			}

		}
		System.out.println(answer);
	}

	public static void combi(int depth, int goal) {
		if (depth == goal) {
			if(check()) {
				isEnd = true;
			}
			return;
		}
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j < N; j++) {
				if ((map[i][j] == 1) || (map[i][j - 1] == 1) || (map[i][j + 1] == 1)) {
					continue;
				}
				map[i][j] = 1;
				combi(depth + 1, goal);
				map[i][j] = 0;
			}
		}
	}

	public static boolean check() {
		for (int i = 1; i <= N; i++) {
			if (i != down(i)) {
				return false;
			}
		}
		return true;
	}

	public static int down(int start) {
		for (int h = 0; h < H; h++) {
			if (map[h + 1][start] == 1) {
				start++;
			} else if (start - 1 >= 1 && map[h + 1][start - 1] == 1) {
				start--;
			}
		}
		return start;
	}
}