import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static boolean[] visited;
	static int[] p;
	static boolean check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		p = new int[9];
		visited = new boolean[9];
		for (int i = 0; i < 9; i++) {
			p[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(p);
		subset(0, 0, 0);
	}

	private static void subset(int depth, int start, int tot) {
		if (depth == 7) {
			if (!check && tot == 100) {
				for (int i = 0; i < 9; i++) {
					if (visited[i])
						System.out.println(p[i]);
				}
				check=true;
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			visited[i] = true;
			subset(depth + 1, i + 1, tot + p[i]);
			visited[i] = false;
		}

	}
}
