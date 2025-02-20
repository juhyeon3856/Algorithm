import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = Integer.MIN_VALUE;

		StringTokenizer st = new StringTokenizer(br.readLine());
		int nums = Integer.parseInt(st.nextToken());
		int sumAll = nums;
		int sum1 = 0;
		answer = nums;

		for (int i = 1; i < N; i++) {
			nums = Integer.parseInt(st.nextToken());
			sum1 = sum1 + nums > sumAll ? sum1 + nums : sumAll;
			sumAll = sumAll < 0 ? nums : sumAll + nums;
			answer = answer < sum1 ? sum1 : answer;
			answer = answer < sumAll ? sumAll : answer;
		}
		System.out.println(answer);
	}
}
