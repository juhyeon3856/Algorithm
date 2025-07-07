import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] data = br.readLine().trim().split(" ");
		if(data[0].equals("")) {
			System.out.println(0);
		} else {
			System.out.println(data.length);
		}
	}

}
