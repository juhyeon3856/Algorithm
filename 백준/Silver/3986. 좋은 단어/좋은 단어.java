import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		for (int i = 0; i < N; i++) {
			List<Character> stack = new LinkedList<Character>();
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				if(stack.isEmpty()) {
					stack.add(0, c);
				} else if(stack.get(0)==c){
					stack.remove(0);
				} else {
					stack.add(0, c);
				}
			}
			if(stack.isEmpty())
				answer++;
		}
		System.out.println(answer);
	}

}
