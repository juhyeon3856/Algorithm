import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		while (!str.equals(".")) {
			boolean isVPS = true;
			List<Character> stack = new LinkedList<Character>();
			int idx = 0;
			char c = str.charAt(idx);
			while (c != '.') {

				if (c == '(' || c == '[') {
					stack.add(0, c);
				} else if (c == ')') {
					if (stack.isEmpty() || stack.remove(0) != '(') {
						isVPS = false;
						break;
					}
				} else if (c == ']') {
					if (stack.isEmpty() || stack.remove(0) != '[') {
						isVPS = false;
						break;
					}
				}
				idx++;
				if (idx == str.length()) {
					idx = 0;
					str = br.readLine();
				}
				c = str.charAt(idx);
			}
			if (isVPS && stack.isEmpty()) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
			str = br.readLine();

		}
	}
}