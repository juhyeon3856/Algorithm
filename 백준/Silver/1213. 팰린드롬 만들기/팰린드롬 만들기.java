import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = str.length();
		char[] stack = new char[N];
		int top = 0;
		char[] strList = new char[N];
		String answer = "";

		for (int i = 0; i < N; i++) {
			strList[i] = str.charAt(i);
		}
		Arrays.sort(strList);

		for (int i = 0; i < N; i++) {
			char c = strList[i];
			if (top == 0) {
				stack[top++] = c;
			} else if (c == stack[top-1]) {
				top--;
				answer += c;
			} else {
				stack[top++] = c;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(answer).reverse();
		if (top == 0) {
			System.out.println(answer + sb);
		} else if (top == 1) {
			System.out.println(answer + stack[0] + sb);
		} else {
			System.out.println("I'm Sorry Hansoo");
		}
	}

}
