import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[][] wall;
	static int[] drone;
	static HashMap<Character, Integer> map;
	static int[][] dd = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) throws Exception {
		map = new HashMap<Character, Integer>();
		map.put('U', 0);
		map.put('D', 1);
		map.put('R', 2);
		map.put('L', 3);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		wall = new int[N][2];
		drone = new int[2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			wall[i][0] = Integer.parseInt(st.nextToken());
			wall[i][1] = Integer.parseInt(st.nextToken());
		}

		String str = br.readLine();
		for (int i = 0; i < K; i++) {
			char c = str.charAt(i);
			int idx = map.get(c);
			int nr = drone[0] + dd[idx][0];
			int nc = drone[1] + dd[idx][1];
			if (isWall(nr, nc))
				continue;
			drone[0] = nr;
			drone[1] = nc;
		}
		System.out.println(drone[0] + " " + drone[1]);

	}

	private static boolean isWall(int r, int c) {
		for (int i = 0; i < N; i++) {
			if (wall[i][0] == r && wall[i][1] == c) {
				return true;
			}
		}
		return false;
	}
}
