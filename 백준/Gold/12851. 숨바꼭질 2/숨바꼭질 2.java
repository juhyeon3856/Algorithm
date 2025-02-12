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
			System.out.println(1);
			return;
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(a);
		int answer = 1;

		int[] visited = new int[2*b];
		visited[a] = -1;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			int cnt = 0;
			for (int i = 0; i < size; i++) {
				int q = queue.poll();
				int next = q - 1;
				if (next > 0 && next < b * 2 && visited[next]*(visited[next]-answer)==0) {
					if (next == b)
						cnt++;
					queue.add(next);
					visited[next]=answer;
				}

				next = q + 1;
				if (next > 0 && next < b * 2 && visited[next]*(visited[next]-answer)==0) {
					if (next == b)
						cnt++;
					queue.add(next);
					visited[next]=answer;
				}

				next = q * 2;
				if (next > 0 && next < b * 2 && visited[next]*(visited[next]-answer)==0) {
					if (next == b)
						cnt++;
					queue.add(next);
					visited[next]=answer;
				}

			}
			if (cnt > 0) {
				System.out.println(answer);
				System.out.println(cnt);
				return;
			}
			answer++;
		}
	}
}
