
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	static String st;
	static int N;
	static int[] answer;
	static boolean[] contain;
	static boolean end;

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = br.readLine();
		if (st.length() == 0)
			return;

		// 로직
		N = st.length() < 10 ? st.length() : (st.length() - 9) / 2 + 9;

		answer = new int[N];
		contain = new boolean[N + 1];
		contain[0] = true;

		dfs(1, 0);

	}

	public static void dfs(int stIdx, int idx) {

		if (stIdx >= st.length()) {
			answer[N - 1] = answer[N - 1] == 0 ? st.charAt(stIdx - 1) - '0' : answer[N - 1];
			print();
			end = true;
			return;
		}
		char c1 = st.charAt(stIdx - 1);
		char c2 = st.charAt(stIdx);
		int num1 = c1 - '0';
		int num2 = (c1 - '0') * 10 + c2 - '0';


		if (!end && num2 <= N && !contain[num2]) {
			contain[num2] = true;
			answer[idx] = num2;
			dfs(stIdx + 2, idx + 1);
			contain[num2] = false;
			answer[idx] = 0;
		}
		if(c2=='0') return;
		if (!end && !contain[num1]) {
			contain[num1] = true;
			answer[idx] = num1;
			dfs(stIdx + 1, idx + 1);
			contain[num1] = false;
			answer[idx] = 0;
		}

	}

	public static void print() {// 출력
		StringBuilder sb = new StringBuilder();
		for (int a : answer) {
			sb.append(a).append(" ");
		}
		System.out.println(sb);

	}

}
