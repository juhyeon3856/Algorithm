import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static int N;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			char[] cst = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = cst[j] - '0';
			}
		}

		int cnt = 0;
		int[] cntList = new int[N*N];
//		List<Integer> cntList = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					cnt++;
					cntList[cnt-1] = bfs(i, j, cnt + 1);
//					cntList.add(bfs(i, j, cnt + 1));
				}				
			}
		}
		
		cntList = Arrays.copyOf(cntList, cnt);
		Arrays.sort(cntList);
//		Collections.sort(cntList);
//		cntList.sort((num1, num2) -> Integer.compare(num1, num2));
		
		StringBuilder sb = new StringBuilder();
		System.out.println(cnt);
		for (int i = 0; i < cnt; i++) {
			sb.append(cntList[i]).append("\n");
//			System.out.println(cntList[i]);
		}
		System.out.println(sb);
	}

	public static int bfs(int cr, int cc, int g) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] { cr, cc });
		map[cr][cc] = g;
		int result = 1;

		while (!que.isEmpty()) {
			int[] cur = que.poll();
			int r = cur[0];
			int c = cur[1];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (!check(nr, nc))
					continue;
				if (map[nr][nc] == 1) {
					que.offer(new int[] { nr, nc });
					map[nr][nc] = g;
					result++;
				}
			}
		}
		return result;
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
