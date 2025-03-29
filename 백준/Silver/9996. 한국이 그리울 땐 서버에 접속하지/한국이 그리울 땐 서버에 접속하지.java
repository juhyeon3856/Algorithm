import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String p = br.readLine();
		int M = p.length();
		String first = "";
		String last = "";

		for (int i = 0; i < M; i++) {
			if (p.charAt(i) == '*') {
				first = p.substring(0, i);
				last = p.substring(i + 1, M);
			}
		}
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if(str.matches(first + ".*" + last)) {
				System.out.println("DA");
			} else {
				System.out.println("NE");
			}
		}

	}
}
