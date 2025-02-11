import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] pay = {0, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		st = new StringTokenizer(br.readLine());
		int[] car1 = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		st = new StringTokenizer(br.readLine());
		int[] car2 = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		st = new StringTokenizer(br.readLine());
		int[] car3 = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		int min = Math.min(car1[0], Math.min(car2[0], car3[0]));
		int max = Math.max(car1[1], Math.max(car2[1], car3[1]));
		int answer = 0;
		
		int cnt = 0;
		for (int i = min; i < max; i++) {
			if(car1[0]==i) cnt++;
			if(car2[0]==i) cnt++;
			if(car3[0]==i) cnt++;
			
			if(car1[1]==i) cnt--;
			if(car2[1]==i) cnt--;
			if(car3[1]==i) cnt--;
			answer += cnt * pay[cnt];
		}
		System.out.println(answer);
	}
}