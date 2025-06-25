import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] map;
	static int[] paperCount = { 0, 5, 5, 5, 5, 5 };
	static boolean[][] paperData;
	static int answer, endCount, N = 10;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		paperData = new boolean[N][N];
		map = new boolean[N][N];
		answer = 26;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken())==1; // 색종이를 붙여야 하는 곳에는 true
				if (map[i][j]) { // 색종이를 붙여야 하는 곳의 개수를 세는 로직
					endCount++;
				}
			}
		}

		// dfs 호출
		dfs(endCount, 0, 0);
		if (answer < 26)
			System.out.println(answer);
		else
			System.out.println(-1);
	}

	private static void dfs(int exist, int index, int count) {
		if (exist == 0) {
			answer = Math.min(answer, count);
			return;
		}
		int cr = index / N;
		int cc = index % N;

		// 몇 부터 붙일 수 있는지 리턴하는 함수
		int stickNum = findStickNum(cr, cc);

		for (int i = stickNum; i > 0; i--) {

			// 만약 색종이가 남아있지 않으면
			if (paperCount[i] == 0)
				continue;
            // 백트래킹
			stick(cr, cc, i, true);
			paperCount[i]--;
			dfs(exist - i * i, index + i, count + 1);
			paperCount[i]++;
			stick(cr, cc, i, false);
		}

		// 종이가 없거나 이미 색종이가 붙어있으면
		if (!map[cr][cc] || paperData[cr][cc]) {
			dfs(exist, index + 1, count);
		}
	}

	private static void stick(int r, int c, int num, boolean delta) {
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				paperData[r + i][c + j] = delta;
			}
		}
	}

	private static int findStickNum(int r, int c) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				int nr = r + j;
				int nc = c + j;

				// 색종이를 붙일 때는 종이의 경계 밖으로 나가서는 안되고,
				if (!check(nr, c + i))
					return i;
				if (!check(r + i, nc))
					return i;
				// 겹쳐도 안 된다.
				if (paperData[nr][c + i])
					return i;
				if (paperData[r + i][nc])
					return i;
				// 0이 적힌 칸에는 색종이가 있으면 안 된다.
				if (!map[nr][c + i])
					return i;
				if (!map[r + i][nc])
					return i;
			}
		}
		return 5;
	}

	private static boolean check(int r, int c) {
		return r < N && c < N;
	}

}
