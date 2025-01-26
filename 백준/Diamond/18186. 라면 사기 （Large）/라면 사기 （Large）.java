import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		long pay = 0;
		int idx = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine()); // 한 줄에서 N개의 숫자 입력
		int N = Integer.parseInt(st.nextToken()); // 첫 번째 입력: N
		long B = Long.parseLong(st.nextToken()); // 첫 번째 입력: N
		long C = Long.parseLong(st.nextToken()); // 첫 번째 입력: N

		long[] nums = new long[N + 3]; // 크기를 N으로 설정
		st = new StringTokenizer(br.readLine()); // 한 줄에서 N개의 숫자 입력
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		if (B < C) {
			for (int i = 0; i < N; i++) {
				pay += nums[i];
			}
			System.out.println(pay * B);
			return;
		}

		while (idx < N) {
			if (nums[idx] == 0) {
				idx++;
			} else {
				if (nums[idx + 1] < nums[idx]) {
					pay += B * (nums[idx] - nums[idx + 1]);
					nums[idx] = nums[idx + 1];
				} else if (nums[idx + 2] < nums[idx + 1]) {
					long small = nums[idx] > nums[idx + 1] - nums[idx + 2] ? nums[idx + 1] - nums[idx + 2] : nums[idx];
					pay += (B + C) * small;
					nums[idx + 1] -= small;
					nums[idx] -= small;
				} else {
					pay += (B + 2 * C) * nums[idx];
					nums[idx + 2] -= nums[idx];
					nums[idx + 1] -= nums[idx];
					nums[idx] = 0;
				}
			}
		}
		System.out.println(pay);
	}
}