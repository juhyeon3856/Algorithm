import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
	static int N;
	static double answer;
	static Map<Integer, Double> nums;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		nums = new HashMap<Integer, Double>();
		
		for (int i = 0; i < N; i++) {
			nums.put('A'+i, Double.parseDouble(br.readLine()));
		}
		
		List<Double> stack = new LinkedList<Double>();
		
		for (int i = 0; i < str.length(); i++) {
			int num = str.charAt(i);
			if(num >= 'A' && num <= 'Z') {
				stack.add(0, nums.get(num));
			} else {
				double num1 = stack.remove(0);
				double num2 = stack.remove(0);
				if(num=='+') {
					stack.add(0, num2+num1);
				} else if(num=='-') {
					stack.add(0, num2-num1);
				} else if(num=='*') {
					stack.add(0, num2*num1);
				} else if(num=='/') {
					stack.add(0, num2/num1);
				}
			}
		}
		System.out.printf("%.2f", stack.remove(0));
		
		
		
	}
}
