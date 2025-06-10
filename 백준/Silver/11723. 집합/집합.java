import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int flag = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String oper = st.nextToken();
			int num = 0;
			if(!oper.equals("all") && !oper.equals("empty")) {
				num = Integer.parseInt(st.nextToken());
			}
			switch (oper) {
			case "add":
				flag |= 1 << num;
				break;
			case "remove":
				flag &= ~(1 << num);
				break;
			case "check":
				sb.append((flag & (1 << num)) == 0 ? 0 : 1).append("\n");
				break;
			case "toggle":
				flag ^= 1 << num;
				break;
			case "all":
				flag = (1 << 21) - 1;
				break;
			case "empty":
				flag = 0;
				break;
			default:
				break;
			}
		}
		System.out.println(sb);
	}

}
