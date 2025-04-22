import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		boolean[] stack = new boolean[str.length()];
		int answer = 0;
		int top=0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				stack[top++] = true;
			} else {
				if(top==0) {
					answer++;
				} else {
					top--;
				}
			}
		}
		answer += top;
		System.out.println(answer);

	}
}