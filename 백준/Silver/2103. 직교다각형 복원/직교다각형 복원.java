import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] points = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			points[i][0] = Integer.parseInt(st.nextToken());
			points[i][1] = Integer.parseInt(st.nextToken());
		}
		int answer = 0;

		Arrays.sort(points, (o1, o2) -> {
			return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]; // 첫번째 숫자 기준 오름차순 {1,30}{2,10}{3,50}{4,20}{5,40}
		});

		int now = points[0][0];
		int prev = points[0][1];
		boolean isSum = true;
		for (int i = 1; i < N; i++) {
			if (now != points[i][0]) {
				now = points[i][0];
				isSum = true;
				prev = points[i][1];
				continue;
			}
			if (isSum) {
				answer += points[i][1] - prev;
				prev = points[i][1];
				isSum = false;
			} else {
				prev = points[i][1];
				isSum = true;
			}
		}
//		System.out.println(answer);
//		System.out.println(Arrays.deepToString(points));

		Arrays.sort(points, (o1, o2) -> {
			return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0]; // 첫번째 숫자 기준 오름차순 {1,30}{2,10}{3,50}{4,20}{5,40}
		});

		now = points[0][1];
		prev = points[0][0];
		isSum = true;
		for (int i = 1; i < N; i++) {
			if (now != points[i][1]) {
				now = points[i][1];
				isSum = true;
				prev = points[i][0];
				continue;
			}
			if (isSum) {
				answer += points[i][0] - prev;
				prev = points[i][0];
				isSum = false;
			} else {
				prev = points[i][0];
				isSum = true;
			}
		}
//		System.out.println(Arrays.deepToString(points));

		System.out.println(answer);

	}
}