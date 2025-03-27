import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] weight, walls, min;
	static int N, M, inf;
	static long K, sum;

	public static void main(String[] args) throws Exception {

		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Long.parseLong(st.nextToken());
		inf = 0;
		sum = 0;
		weight = new int[N];
		walls = new int[M];
		min = new int[M]; // 공사장 M개, 그럼 M개의 그룹이 생김

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
			inf = inf < weight[i] ? weight[i] : inf;
		}

		// 공사하는 곳이 0개이거나 1개이면 그냥 무조건 YES
		if (M == 1 || M == 0) {
			System.out.println("YES");
			return;
		}

		// wall[i] 까지 가면 다음으로 못넘어감
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if ((a == 1 && b == N) || (a == N && b == 1)) {
				walls[i] = 0;
			} else {
				walls[i] = a < b ? a : b;
			}
		}
		Arrays.sort(walls);

		// M개의 그룹으로 갈 수 있는 최소의 돌맹이 개수 찾기
		int wall = walls[0];
		boolean isEnd = false;
		for (int i = 0; i < M; i++) {
			min[i] = inf;
			isEnd = i == M - 1;
			while (wall < walls[(i + 1) % M] || isEnd) {
				min[i] = weight[wall] < min[i] ? weight[wall] : min[i];
				wall++;
				wall %= N;
				if(wall==0) {
					isEnd = false;
				}
			}
			sum += min[i];
		}
//		System.out.println(Arrays.toString(min));

		// 최소의 합이 가진 개수보다 작으면 갈YES, 아니면 NO
		if (sum <= K) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

}
