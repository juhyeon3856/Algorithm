import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int myMileage = Integer.parseInt(st.nextToken()); // 나의 총 마일리지
		int[] minMileage = new int[N]; // N개의 수업 각각을 듣기위한 최소 마일리지
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken()); // 수강 신청한 인원 수
			int M = Integer.parseInt(st.nextToken()); // 정원
			int[] mileages = new int[p]; // 수강신청한 사람들이 낸 마일리지 값
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < p; j++) {
				mileages[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(mileages);
			if (p < M) { // 정원 미달
				minMileage[i] = 1;
			} else {
				minMileage[i] = mileages[p - M];
			}
		}
//		System.out.println(Arrays.toString(minMileage));
		Arrays.sort(minMileage);
		int answer = 0;
		while (myMileage >= 0) {
			if(answer == N) {
				answer++;
				break;
			}
			myMileage -= minMileage[answer++];
		}
		System.out.println(--answer);

	}
}
