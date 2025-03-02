import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M, R, r;
	static char[] oper;
	static int[] nums;
	static int max;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = N / 2 + 1;
		R = M / 2; // 괄호 묶을 수 있는 최대 개
		oper = new char[M + 1];
		nums = new int[M + 1];
		visited = new boolean[M + 1];
		max = Integer.MIN_VALUE;

		String str = sc.next();
		nums[0] = str.charAt(0) - '0';

		for (int i = 1; i < M; i++) {
			nums[i] = str.charAt(2 * i) - '0';
			oper[i] = str.charAt(2 * i - 1);
		}

		// 입력완료 로직 시작
		for (int i = 0; i <= R; i++) {	
			r = i;
			combi(0, 1);
		}
		System.out.println(max);
	}

	private static void combi(int depth, int start) {
		if (depth == r) {
			int result = baseCondition();
			max = max < result ? result : max;
			return;
		}
		for (int i = start; i < M; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			visited[i - 1] = true;
			visited[i + 1] = true;
			int num1 = nums[i - 1];
			int num2 = nums[i];
			char oper1 = oper[i];
			nums[i - 1] = calc(num1, num2, oper1);
			oper[i] = '/';
			combi(depth + 1, i);
			visited[i] = false;
			visited[i - 1] = false;
			visited[i + 1] = false;
			nums[i - 1] = num1;
			oper[i] = oper1;
		}

	}

	private static int baseCondition() {
		int result = nums[0];
		for (int i = 1; i < M; i++) {
			if (oper[i] == '/')
				continue;
			result = calc(result, nums[i], oper[i]);
		}
		return result;
	}

	private static int calc(int num1, int num2, char oper1) {
		if (oper1 == '+')
			return num1 + num2;
		if (oper1 == '*')
			return num1 * num2;
		if (oper1 == '-')
			return num1 - num2;
		return 0;
	}

}
