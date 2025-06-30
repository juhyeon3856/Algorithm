import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, index;
	static int[] data, dp, asc, desc; // data, i번째 최솟값, (앞에서부터) 증가하는 부분수열 최댓값, (뒤에서부터) 감소하는 부분수열 최솟값

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		dp = new int[N];
		data = new int[N];
		asc = new int[N];
		desc = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

        // 감소하는 부분수열 찾기
		Arrays.fill(dp, 1001);
		for (int i = N - 1; i >= 0; i--) {
			index = -1;
			while (data[i] > dp[++index]) {
			}
			dp[index] = data[i];
			desc[i] = index;
		}
		
        // 증가하는 부분수열 찾기
		Arrays.fill(dp, 1001);
		for (int i = 0; i < N; i++) {
			index = -1;
			while (data[i] > dp[++index]) {
			}
			dp[index] = data[i];
			asc[i] = index;
		}
        
        // 감소와 증가의 합 중 가장 큰 값이 정답 
		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer = Math.max(answer, desc[i] + asc[i]);
		}
		System.out.println(answer + 1);
	}
}
