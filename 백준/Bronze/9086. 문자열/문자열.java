import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			sb.append(str.charAt(0)).append(str.charAt(str.length() - 1)).append("\n");
		}
		System.out.println(sb);
	}

}
