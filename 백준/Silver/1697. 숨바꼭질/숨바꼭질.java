import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		if (a >= b) {
			System.out.println(a - b);
			return;
		}

		boolean[] visited = new boolean[b * 2];

		Queue<Integer> queue = new LinkedList<>();
		queue.add(a);
		visited[a] = true;
		int answer = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int q = queue.poll();
				if (q == b) {
					System.out.println(answer);
					return;
				}

				int next = q + 1;
				if (next > 0 && next < b * 2 && !visited[next]) {
					queue.add(next);
					visited[next] = true;
				}

				next = q - 1;
				if (next > 0 && next < b * 2 && !visited[next]) {
					queue.add(next);
					visited[next] = true;
				}

				next = q * 2;
				if (next > 0 && next < b * 2 && !visited[next]) {
					queue.add(next);
					visited[next] = true;
				}

			}
			answer++;
		}
		System.out.println(answer);
	}
}
