import java.math.BigInteger;
import java.util.Scanner;

public class Main  {
	static int N, cnt;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		if(N>20) {
//			System.out.println((int)Math.pow(2, N)-1);
			System.out.println(BigInteger.valueOf(2).pow(N).subtract(BigInteger.ONE)); // 수정: BigInteger로 2^N - 1 계산
			return;
		}

		sb= new StringBuilder();
		dfs(N, 1, 3, 2);
		System.out.println(cnt);
		System.out.println(sb);
	}

	private static void dfs(int depth, int from, int to, int mid) {
		if (depth > 0) {
			cnt++;
			dfs(depth - 1, from, mid, to);
			sb.append(from).append(" ").append(to).append("\n");
			dfs(depth - 1, mid, to, from);
		}

	}

}
