import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] nums, oper, visited;
	static int N;
	static int min, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		oper = new int[N];
		visited = new int[4];
		min = 1000000000;
		max = -1000000000;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			visited[i] = Integer.parseInt(st.nextToken());
		}

		perm(1);
		System.out.println((int) max);
		System.out.println((int) min);

	}

	private static void perm(int depth) {
		if (depth == N) {
			int c = calc();
			min = min > c ? c : min;
			max = max < c ? c : max;
			return;
		}
		for (int i = 0; i < 4; i++) {
			if(visited[i]==0) continue;
			visited[i]--;
			oper[depth] = i;
			perm(depth+1);
			visited[i]++;
		}

	}

	private static int calc() {
		int result = nums[0];
		for (int i = 1; i < N; i++) {
			if (oper[i] == 0) {
				result += nums[i];
			} else if (oper[i] == 1) {
				result -= nums[i];
			} else if (oper[i] == 2) {
				result *= nums[i];
			} else if (oper[i] == 3) {
				result /= nums[i];
			}
		}
		return result;
	}

}