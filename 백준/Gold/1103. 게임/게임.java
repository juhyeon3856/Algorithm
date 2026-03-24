import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int ans;
	static int N, M;
	static boolean[][] visited, finished;
	static int[][] board, dp;
//	static Deque<int[]> queue;
//	static Deque<int[]> stack;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static List<int[]>[][] adj;
	static boolean isCycle;

	static int H = 'H' - '0';

	public static void main(String[] args) throws Exception {
		//System.setIn(new java.io.FileInputStream("./src/sample_input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 초기화
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		ans = 0;
		visited = new boolean[N][M];
		finished = new boolean[N][M];
		board = new int[N][M];
//		queue = new ArrayDeque<int[]>();
		adj = new ArrayList[N][M];
		dp = new int[N][M];
		isCycle = false;
		
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				adj[r][c] = new ArrayList<int[]>();
			}
		}
		

        // board 입력
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

		

		// 그래프 만들기
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (board[r][c] == H)
					continue;
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d] * board[r][c];
					int nc = c + dc[d] * board[r][c];

					if (!check(nr, nc))
						continue;
					if (board[nr][nc] == H)
						continue;
					adj[r][c].add(new int[] { nr, nc });
				}

			}
		}

//		for (int r = 0; r < N; r++) {
//			for (int c = 0; c < M; c++) {
//				for (int[] temp : adj[r][c]) {
//					System.out.print(Arrays.toString(temp) + "\t");
//				}
//				System.out.println();
//			}
//			System.out.println("----------------------------");
//		}

		// 그래프가 사이클이 있는지 확인하기
		// 방문했던 곳을 다시 갈 수 있으면 사이클이다.
		ans = dfs(0, 0);
		
		if (isCycle) {
			ans = -2;
		}
	
		System.out.println(ans+1);

	}

	private static int dfs(int r, int c) {
		if (isCycle) return 0;

		// 현재 경로에서 다시 방문 => 사이클
		if (visited[r][c]) {
			isCycle = true;
			return 0;
		}

		// 이미 계산 완료된 노드면 재사용
		if (finished[r][c]) {
			return dp[r][c];
		}

		visited[r][c] = true;

		int max = 0;
		for (int[] next : adj[r][c]) {
			int nr = next[0];
			int nc = next[1];
			max = Math.max(max, dfs(nr, nc) + 1);
			if (isCycle) return 0;
		}

		visited[r][c] = false;
		finished[r][c] = true;
		dp[r][c] = max;

		return dp[r][c];
	}

	private static boolean check(int r, int c) {
		// TODO Auto-generated method stub
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
