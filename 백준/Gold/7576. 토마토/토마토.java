
import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt(), N = sc.nextInt();
		int[][] box = new int[N][M];
		int count = 0;
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				box[i][j] = sc.nextInt();
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
			for (int[] _index : new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } }) {
				int r = index[0] + _index[0], c = index[1] + _index[1];
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