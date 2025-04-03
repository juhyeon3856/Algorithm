import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] zero = new long[N + 1];
		long[] one = new long[N + 1];

		one[1] = 1;

		for (int i = 2; i <= N; i++) {
			one[i] = zero[i - 1];
			zero[i] = zero[i - 1] + one[i - 1];
		}
		
		System.out.println(one[N] + zero[N]);

	}
}
