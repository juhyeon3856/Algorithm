import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, answer1, answer2, cnt;
	static List<int[]> points; // x좌표, cnt
	static int[][] map;
	static int idx;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		answer1 = 0;
		answer2 = 0;
		idx = 0;
		cnt = 1;
		points = new ArrayList<>();
		map = new int[N + 1][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		map[N][0] = map[0][0];
		map[N][1] = map[0][1];

		int w = map[idx][1];
		while (w > 0) {
			w = map[++idx][1];
		}

		int prevY = map[idx][1];
		for (int i = 1; i <= N; i++) {
			int x = map[(idx + i) % N][0];
			int y = map[(idx + i) % N][1];
			if (prevY > 0 && y < 0) { // down
				points.add(new int[] { x, cnt++ });
			} else if (prevY < 0 && y > 0) { // up
				points.add(new int[] { x, cnt });
			}
			prevY = y;
		}

		points.sort((o1, o2) -> Integer.compare(o1[0], o2[0]));

		int initN = -1;
		int prevNum = points.get(0)[1];

		for (int i = 1; i < points.size(); i++) {
			if (points.get(i - 1)[1] == points.get(i)[1]) {
				answer2++;
			}
			if (prevNum == initN) {
				prevNum = points.get(i)[1];
			} else if (points.get(i)[1] == prevNum) {
				answer1++;
				prevNum = initN;
			}
		}
		System.out.println(answer1 + " " + answer2);

	}

}
