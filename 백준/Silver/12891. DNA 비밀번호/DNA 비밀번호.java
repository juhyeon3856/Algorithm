import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, R, answer, idx1, idx2;
	static int[] ACGT;
	static String str;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		str = br.readLine();
		ACGT = new int[4];
		answer = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			ACGT[i] = Integer.parseInt(st.nextToken());
		}
		idx1 = 0;
		idx2 = R-1;
		for (int i = 0; i < R; i++) {
			count(i, -1);
		}

		while (idx2 < N) {
			if (ACGT[0] <= 0 && ACGT[1] <= 0 && ACGT[2] <= 0 && ACGT[3] <= 0) {
				answer++;
			}
			count(idx1++, 1);
			count(++idx2, -1);
		}
		System.out.println(answer);
	}

	public static void count(int idx, int delta) {
		if(idx >= N) return;
		if (str.charAt(idx)==('A')) {
			ACGT[0] += delta;
		} else if (str.charAt(idx)==('C')) {
			ACGT[1] += delta;
		} else if (str.charAt(idx)==('G')) {
			ACGT[2] += delta;
		} else if (str.charAt(idx)==('T')) {
			ACGT[3] += delta;
		}
	}
}
