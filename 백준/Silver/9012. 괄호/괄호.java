
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			boolean isVPS = true;
			List<Character> stack = new LinkedList<Character>();
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '(') {
					stack.add(0, '(');
				} else if (stack.isEmpty()) {
					isVPS = false;
					break;
				} else {
					stack.remove(0);
				}
			}
			if (isVPS && stack.isEmpty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}
	}
}