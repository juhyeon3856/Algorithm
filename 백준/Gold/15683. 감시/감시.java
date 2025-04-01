import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<int[]> cctvs; // cctv의 인덱스 r, c와 종류 type저장
	static int[][] map; // 방에 있는 벽 =-1, 나머지는 0, 감시 할 수 있는 곳은 +1하면서 0->1될 때 answer--, 1->0될 때 answer++
	static int N, M, answer, cctvCount, minAnswer;
	static BufferedReader br;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[] dcctv = { 0, 4, 2, 4, 4, 1 };
	// type 1,2,3,4,5
	static int[][][] cctvtypes = { { { 0 } }, // 0타입의 cctv는 없다. 그냥 트릭
			{ { 0 }, { 1 }, { 2 }, { 3 } }, // 1타입은 4방향 -> dcctv 4
			{ { 0, 2 }, { 1, 3 } }, { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } },
			{ { 3, 0, 1 }, { 0, 1, 2 }, { 1, 2, 3 }, { 2, 3, 0 } }, { { 0, 1, 2, 3 } } };

	public static void main(String[] args) throws Exception {

		// 입력받기
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = N * M;
		cctvs = new ArrayList<>();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int type = Integer.parseInt(st.nextToken());
				if (type == 6) {
					map[i][j] = 9;
					answer--;
				} else if (type > 0) {
					map[i][j] = 10;
					answer--;
					cctvs.add(new int[] { i, j, type });
				} else {
					map[i][j] = type;
				}
			}
		}
		minAnswer = answer;
		cctvCount = cctvs.size();
		// 로직 시작
		dfs(0); // dfs(cctv_index)
		System.out.println(minAnswer);

	}

	private static void printMap() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}

	}

	private static void dfs(int index) throws Exception {
//		printMap();
//		System.out.println("answer : " + answer);
//		System.out.println("minAnswer : " + minAnswer);
//		br.readLine();
		
		if (index == cctvCount) {
			minAnswer = answer < minAnswer ? answer : minAnswer;
			return;
		}
		
		int[] cctv = cctvs.get(index);
		int r = cctv[0];
		int c = cctv[1];
		if (cctv[2] == 1) {
			// 오른쪽으로 쭉
			look(r, c, 1, 0, 1);
			dfs(index + 1);
			look(r, c, 1, 0, -1);
			// 왼쪽으로 쭉
			look(r, c, -1, 0, 1);
			dfs(index + 1);
			look(r, c, -1, 0, -1);
			// 위쪽으로 쭉
			look(r, c, 0, -1, 1);
			dfs(index + 1);
			look(r, c, 0, -1, -1);
			// 아래쪽으로 쭉
			look(r, c, 0, 1, 1);
			dfs(index + 1);
			look(r, c, 0, 1, -1);
		} else if (cctv[2] == 2) {
			// 좌,우로 쭉
			look(r, c, 1, 0, 1);
			look(r, c, -1, 0, 1);
			dfs(index + 1);
			look(r, c, 1, 0, -1);
			look(r, c, -1, 0, -1);

			// 상, 하로 쭉
			look(r, c, 0, -1, 1);
			look(r, c, 0, 1, 1);
			dfs(index + 1);
			look(r, c, 0, -1, -1);
			look(r, c, 0, 1, -1);
		} else if (cctv[2] == 3) {
			// 상, 우
			look(r, c, 0, -1, 1);
			look(r, c, 1, 0, 1);
			dfs(index + 1);
			look(r, c, 0, -1, -1);
			look(r, c, 1, 0, -1);
			// 하, 우
			look(r, c, 0, 1, 1);
			look(r, c, 1, 0, 1);
			dfs(index + 1);
			look(r, c, 0, 1, -1);
			look(r, c, 1, 0, -1);
			// 상, 좌
			look(r, c, 0, -1, 1);
			look(r, c, -1, 0, 1);
			dfs(index + 1);
			look(r, c, 0, -1, -1);
			look(r, c, -1, 0, -1);
			// 하, 좌
			look(r, c, 0, 1, 1);
			look(r, c, -1, 0, 1);
			dfs(index + 1);
			look(r, c, 0, 1, -1);
			look(r, c, -1, 0, -1);
		} else if (cctv[2] == 4) {
			// 상, 우, 하
			look(r, c, 0, -1, 1);
			look(r, c, 0, 1, 1);
			look(r, c, 1, 0, 1);
			dfs(index + 1);
			look(r, c, 0, -1, -1);
			look(r, c, 0, 1, -1);
			look(r, c, 1, 0, -1);

			// 우, 하, 좌
			look(r, c, 0, 1, 1);
			look(r, c, -1, 0, 1);
			look(r, c, 1, 0, 1);
			dfs(index + 1);
			look(r, c, 0, 1, -1);
			look(r, c, -1, 0, -1);
			look(r, c, 1, 0, -1);

			// 하, 좌, 상
			look(r, c, 0, -1, 1);
			look(r, c, 0, 1, 1);
			look(r, c, -1, 0, 1);
			dfs(index + 1);
			look(r, c, 0, -1, -1);
			look(r, c, 0, 1, -1);
			look(r, c, -1, 0, -1);

			// 좌, 상, 우
			look(r, c, 0, -1, 1);
			look(r, c, -1, 0, 1);
			look(r, c, 1, 0, 1);
			dfs(index + 1);
			look(r, c, 0, -1, -1);
			look(r, c, -1, 0, -1);
			look(r, c, 1, 0, -1);
		} else if (cctv[2] == 5) {
			// 좌, 상, 우, 하
			look(r, c, 0, 1, 1);
			look(r, c, 0, -1, 1);
			look(r, c, -1, 0, 1);
			look(r, c, 1, 0, 1);
			dfs(index + 1);
			look(r, c, 0, 1, -1);
			look(r, c, 0, -1, -1);
			look(r, c, -1, 0, -1);
			look(r, c, 1, 0, -1);
		}

	}

	private static void look(int r, int c, int dr, int dc, int delta) {
		int nr = r+dr;
		int nc = c+dc;

		while (check(nr, nc) && map[nr][nc] != 9) {
			if (map[nr][nc] == 0 && delta == 1) {
				answer--;
			} else if (map[nr][nc] == 1 && delta == -1) {
				answer++;
			}
			map[nr][nc] += delta;
			nr += dr;
			nc += dc;
		}

	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
