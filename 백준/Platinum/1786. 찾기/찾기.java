import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] subTable;
	static char[] t, p;
	static List<Integer> answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = br.readLine().toCharArray();
		p = br.readLine().toCharArray();
//		t = new char[] { 'a', 'b', 'a', 'b', 'a', 'b', 'a', 'b', 'c', 'a', 'b', 'a', 'b', 'a', 'c', 'a', 'a', 'b', 'a',
//				'b', 'a', 'c', 'a' };
//		p = new char[] { 'a', 'b', 'a', 'b', 'a', 'c', 'a' };
		n = t.length;
		m = p.length;

		answer = new ArrayList<Integer>();
		subTable = new int[m];

//		makeTable();
		computeLPS();
//		System.out.println(Arrays.toString(subTable));

		search();
		StringBuilder sb = new StringBuilder();
		sb.append(answer.size()).append("\n");
		for (int ans : answer) {
			sb.append(ans + 1).append(" ");
		}
		System.out.println(sb);
	}

	private static void makeTable() {
		for (int l = 2; l <= m; l++) {
			for (int i = 1; i < l; i++) {
				boolean check = true;
				for (int j = 0; j < i; j++) {
					if (t[j] != p[l - i + j]) {
						check = false;
						break;
					}
				}
				if (check) {
					subTable[l - 1] = i;
				}
			}
		}
	}

	public static void computeLPS() {
		int[] lps = new int[m]; // LPS 배열 생성
		int len = 0; // 현재까지 일치하는 접두사의 길이
		subTable[0] = 0; // 첫 번째 문자는 항상 0
		int i = 1; // 1번 인덱스부터 시작

		while (i < m) {
			if (p[i] == p[len]) {
				// 현재 비교하는 문자가 이전에 일치했던 문자의 다음 문자와 같다면, len을 증가시키고 LPS[i]에 기록
				len++;
				subTable[i] = len;
				i++;
			} else {
				if (len != 0) {
					// 불일치할 경우, 이전에 계산했던 LPS 값을 활용하여 len을 재조정하고, 비교를 다시 시도
					len = subTable[len - 1];
					// i는 그대로 두고 비교 (여기서 반복문은 len 값을 갱신한 후 다시 비교)
				} else {
					// len이 0이면, 일치하는 접두사가 없는 것이므로 LPS[i]는 0이고, i를 증가
					subTable[i] = 0;
					i++;
				}
			}
		}
	}

	private static void search() {
		int i = 0;
		int j = 0;
		while (i < n) {
			if (t[i] != p[j]) {
				if (j == 0) {
					i++;
				} else {
					j = subTable[j - 1];
				}
			} else {
				i++;
				j++;
			}
			if (j == m) {
				answer.add(i - m);
				j = subTable[j - 1];
			}
//			if (j == m && i != n) {
//				answer.add(i - m);
//				j = 0;
//				i = i - m + 1;
//			} else if (j == m) {
//				answer.add(i - m);
//			}
		}
//		if (j == m) {
//			answer.add(i - m);
//			return i - m;
//		} else {
//			return i;
//		}
	}
}