import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] p;
	static int N, N2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		N2 = (int) Math.pow(2, N);
		p = new int[N2 + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N2; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { 0, N2 / 2 });

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < Math.pow(2, i); j++) {
				int[] q = queue.poll();
				if (q[1] == 0)
					return;
				System.out.print(p[q[0] + q[1]] + " ");
				queue.offer(new int[] { q[0], q[1] / 2 });
				queue.offer(new int[] { q[0] + q[1], q[1] / 2 });
			}
			System.out.println();
		}

	}

}
