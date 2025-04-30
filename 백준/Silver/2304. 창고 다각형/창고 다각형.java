import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, max, answer, now, maxIdx, minIdx;
	static int[] data;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		max = 0;
		data = new int[1001];
		answer = 0;
		now = 0;
		maxIdx = 0;
		minIdx = 1001;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			data[idx] = Integer.parseInt(st.nextToken());
			max = Math.max(max, data[idx]);
			minIdx = Math.min(minIdx, idx);
			maxIdx = Math.max(maxIdx, idx);
		}
//		System.out.println(Arrays.toString(data));
//		System.out.println("minIdx : " + minIdx);
//		System.out.println("maxIdx : " + maxIdx);
//		System.out.println("max : " + max);
		int startMaxIdx = 0;
		int endMaxIdx = 0;

		now = data[minIdx];
		for (int i = minIdx; i <= maxIdx; i++) {
			now = Math.max(now, data[i]);
			if (now == max) {
				startMaxIdx = i;
				break;
			}
			answer += now;
//			System.out.println(answer);
		}
//		System.out.println();
		now = data[maxIdx];
		for (int i = maxIdx; i >= minIdx; i--) {
			now = Math.max(now, data[i]);
			if (now == max) {
				endMaxIdx = i;
				break;
			}
			answer += now;
//			System.out.println(answer);

		}

		System.out.println(answer + max*(endMaxIdx - startMaxIdx + 1));

	}
}
