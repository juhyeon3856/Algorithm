import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, d, k, c, answer, dist, coupon;
	static int[] table;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		table = new int[N + k];
		dist = 0;
		answer = 0;
		for (int i = 0; i < N; i++) {
			table[i] = Integer.parseInt(br.readLine());
		}

		coupon = 0;
		for (int i = 0; i < k; i++) {
			table[N + i] = table[i];
			dist++;
			if (table[i] == c) {
				coupon++;
			}
			for (int j = 0; j < i; j++) {
				if (table[j] == table[i]) {
					dist--;
					break;
				}
			}
		}
		if (coupon == 0) {
			dist++;
		}
		answer = Math.max(answer, dist);
//		System.out.println("coupon : " + coupon);
//		System.out.println("dist : " + dist);
//		System.out.println("answer : " + answer);
//		System.out.println(answer);

		for (int i = k; i < N + k; i++) {
			if (table[i - k] == c) {
				coupon--;
				if (coupon == 0) {
					dist++;
				}
			}
//			if (coupon == 0) {
//				dist++;
//			}
			dist--;
			for (int j = 1; j < k; j++) {
				if (table[i - k + j] == table[i - k]) {
					dist++;
					break;
				}
			}
			dist++;
			for (int j = 1; j < k; j++) {
				if (table[i - k + j] == table[i]) {
					dist--;
					break;
				}
			}
			if (table[i] == c) {
				coupon++;
				if (coupon == 1) {
					dist--;
				}
			}
//			if (coupon == 0) {
//				dist++;
//			}
			answer = Math.max(answer, dist);

//			System.out.println();
//			System.out.println("coupon : " + coupon);
//			System.out.println("dist : " + dist);
//			System.out.println("answer : " + answer);
		}
		System.out.println(answer);

	}
}