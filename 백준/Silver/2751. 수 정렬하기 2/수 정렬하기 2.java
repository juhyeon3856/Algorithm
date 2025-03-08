import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] list = new boolean[2000001];
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			list[a+1000000] = true;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 2000001; i++) {
			if(list[i])
			sb.append(i-1000000).append("\n");
		}
		System.out.println(sb);
	}
}
