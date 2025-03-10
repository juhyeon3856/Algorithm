import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i = Integer.parseInt(br.readLine());
		i = i - ((i >> 1) & 0x55);
		i = (i & 0x33) + ((i >> 2) & 0x33);
		i = (i + (i >> 4)) & 0x0f;
		System.out.println(i & 0xf);
	}
}
