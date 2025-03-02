import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main  {
	static int N = 10, R;
	static boolean[] big, visited;
	static int[] nums, max, min;
	static boolean isFirst;
	static long[] E = { 1000000000L, 100000000L, 10000000L, 1000000L, 100000L, 10000L, 1000L, 100L, 10L, 1L };
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		R = Integer.parseInt(br.readLine()) + 1;
		big = new boolean[R]; // 뒤에가 큰가?
		nums = new int[R];
		max = new int[R];
		min = new int[R];
		isFirst = true;
		sb = new StringBuilder();
		visited = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < R; i++) {
			if (st.nextToken().equals("<"))
				big[i] = true;
		}
		perm(0);
		for (int i = 0; i < R; i++) {
			sb.append(max[i]);
		}
		sb.append("\n");
		for (int i = 0; i < R; i++) {
			sb.append(min[i]);
		}
		System.out.println(sb);

	}

	private static void perm(int depth) {
		if (depth == R) {
			if (isFirst) {
				for (int i = 0; i < R; i++) {
					min[i] = nums[i];
				}
				isFirst = false;
			} else {
				for (int i = 0; i < R; i++) {
					max[i] = nums[i];
				}
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			if (depth == 0) {
				nums[depth] = i;
				visited[i] = true;
				perm(depth + 1);
				visited[i] = false;
				continue;
			}
			if (big[depth] && nums[depth - 1] < i) {
				nums[depth] = i;
				visited[i] = true;
				perm(depth + 1);
				visited[i] = false;
			} else if (!big[depth] && nums[depth - 1] > i) {
				nums[depth] = i;
				visited[i] = true;
				perm(depth + 1);
				visited[i] = false;
			}
		}
	}
}
