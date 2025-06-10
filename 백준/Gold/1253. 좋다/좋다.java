import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		long[][] sums = new long[N][N]; // r < c 인 부분에는 r번째 수와 c번째 수의 합
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;

		// 입력 받기 및 sums 초기화
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			Arrays.fill(sums[i], Long.MAX_VALUE);
		}
		Arrays.sort(nums);

		// 입력 받은 값의 합을 sums에 저장하는 중...
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				sums[i][j] = nums[i] + nums[j];
			}
		}


		// 가능한 두 수의 합 중 i번째로 입력 받은 sums[i][i]가 있는지 확인. 있으면 answer++;
		int[] index = new int[N];
		for (int i = 0; i < N; i++) {
			int num = nums[i];
			aa : for (int j = 0; j < N; j++) {
				while (index[j] < j) {
					if (sums[j][index[j]] < num) {
						index[j]++;
					} else {
						break;
					}
				}
				if (sums[j][index[j]] == num && j != i) {
					if (index[j] == i) {
						int _index = index[j] + 1;
						while (_index < j && sums[j][_index] <= num) {
							if (sums[j][_index] == num) {
								answer++;
								break aa;
							} else {
								_index++;
							}
						}
					} else {
						answer++;
						break;
					}
				}
			}
		}
		System.out.println(answer);
	}

}
