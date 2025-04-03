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
		long zero = 0;
		long one = 1;

		for (int i = 2; i <= N; i++) {
			long temp = zero;
			zero = one + zero;
			one = temp;
		}
		
		System.out.println(one + zero);

	}
}
