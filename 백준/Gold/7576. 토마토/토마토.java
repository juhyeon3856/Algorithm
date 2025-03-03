import java.util.*;
import java.io.*;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception{
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
		int[][] box = new int[N][M];
		int count = 0;
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 0)
					count++;
				if (box[i][j] == 1)
					queue.add(new int[] { i, j, 0 });
			}
		}
		if (count == 0) {
			System.out.println(0);
			return;
		}

		while (!queue.isEmpty()) {
			int[] index = queue.poll();
            for(int d = 0; d < 4 ; d++){
				int r = index[0] + dr[d], c = index[1] + dc[d];
				if (r >= 0 && r < N && c >= 0 && c < M && box[r][c] == 0) {
					box[r][c] = 1;
					count--;
					queue.add(new int[] { r, c, index[2] + 1 });
				}
			}
			if (count == 0) {
				System.out.println(index[2] + 1);
				return;
			}
		}
		System.out.println(-1);

	}
}