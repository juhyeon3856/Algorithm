import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, ans;
	static int[][] map, dp;
	static PriorityQueue<Cell> pq;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	static class Cell implements Comparable<Cell>{
		int value;
		int r;
		int c;

		public Cell(int value, int r, int c) {
			super();
			this.value = value;
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Cell [value=" + value + ", r=" + r + ", c=" + c + "]";
		}


		@Override
		public int compareTo(Cell o) {
			return -Integer.compare(this.value, o.value);
		}
		
		
	}

	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N];
		ans = 0;
		pq = new PriorityQueue<Cell>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int v = Integer.parseInt(st.nextToken());
				map[i][j] = v;
				pq.add(new Cell(v, i, j));
			}
		}
		
		while(!pq.isEmpty()) {
			Cell cell = pq.poll();
			int cv = cell.value;
			int cr = cell.r;
			int cc = cell.c;
			int mv = 0;
			
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				// 범위 밖
				if (!check(nr, nc)) {
					continue;
				}
				
				// 자신보다 대나무가 작거나 같으면 
				if (map[nr][nc] <= cv) {
					continue;
				}
				
				
				// 나머지 경우 max처리 (범위 내 && 대나무가 많은 곳)
				mv = dp[nr][nc] > mv ? dp[nr][nc]: mv;
			}
			
			mv++;
			dp[cr][cc] = mv;
			ans = mv > ans ? mv : ans;
		}
		
		System.out.println(ans);

	}

	private static boolean check(int r, int c) {
		return 0<= r && r < N && 0<=c && c<N;
	}
	
	


}
