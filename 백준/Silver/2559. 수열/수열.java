
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		int[] nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			sum += nums[i];
		}
		int max = sum;
		
		for (int i = K; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			sum += nums[i] - nums[i-K];
			if(sum > max) {
				max = sum;
			}
		}
		System.out.println(max);
	}
}
