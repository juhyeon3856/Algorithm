import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main  {
	static int N, K, count;
	static int[] visited, answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();
		count = 0;
		visited = new int[2 * K];
		Arrays.fill(visited, -2);

		// 만약 동생이 있는 위치가 더 왼쪽인 경우 x-1로만 가야함
		if (N >= K) {
			System.out.println(N - K);
			for (int i = N; i >= K; i--) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}

		// 동생 위치가 더 오른쪽인경우 3가지 경우로 다 가봄
		Queue<Integer> queue = new LinkedList<>();
		visited[N] = -1;
		queue.offer(N);

		while (!queue.isEmpty()) {
			int size = queue.size();
			count++;
			for (int i = 0; i < size; i++) {
				int q = queue.poll();
				if (q == K) {
					queue.clear();
					break;
				}
				if (q >= 2 * K) {
					continue;
				}
				// 2배 가는경우
				if (2 * q < 2 * K && visited[2 * q] == -2) {
					visited[2 * q] = q;
					queue.offer(2 * q);
				}

				// +1하는 경우
				if (q + 1 < 2 * K && visited[q + 1] == -2) {
					visited[q + 1] = q;
					queue.offer(q + 1);
				}

				// -1하는 경우
				if (q - 1 >= 0 && visited[q - 1] == -2) {
					visited[q - 1] = q;
					queue.offer(q - 1);
				}
			}
			
		}

		answer = new int[count];
		System.out.println(count-1);
		while (count > 0) {
			answer[--count] = K;
			K = visited[K];
		}

		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}

	}

}
