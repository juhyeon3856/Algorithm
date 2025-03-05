import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main  {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		List<Character> stack = new LinkedList<>();
		int N = str.length();
		char[] strList = new char[N];
		String answer = "";

		for (int i = 0; i < N; i++) {
			strList[i] = str.charAt(i);
		}
		Arrays.sort(strList);

		for (int i = 0; i < N; i++) {
			char c = strList[i];
			if (stack.isEmpty()) {
				stack.add(0, c);
			} else if (c == stack.get(0)) {
				stack.remove(0);
				answer += c;
			} else {
				stack.add(0, c);
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(answer).reverse();
		if (stack.size() == 0) {
			System.out.println(answer + sb);
		} else if (stack.size() == 1) {
			System.out.println(answer + stack.get(0) + sb);
		} else {
			System.out.println("I'm Sorry Hansoo");
		}
	}

}
