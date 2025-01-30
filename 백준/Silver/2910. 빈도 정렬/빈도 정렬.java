
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Map<Integer, int[]> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			int n =  Integer.parseInt(st.nextToken());
			if(!map.containsKey(n)) {
				map.put(n, new int[] {0, i});
			}
			map.get(n)[0]++;
		}
		//정렬을 위해 map을 list로 변환 (key는 순서를 가지지 않기 때문)
		List<Map.Entry<Integer, int[]>> sortedList = new ArrayList<>(map.entrySet());
		
		//정렬
		sortedList.sort(
				Comparator.comparing((Map.Entry<Integer, int[]> e) -> -e.getValue()[0])
						  .thenComparing(e -> e.getValue()[1])
				);
		
		for (Map.Entry<Integer, int[]> entry : sortedList) {
			int value =  entry.getKey();
			int frequency = entry.getValue()[0];
			for (int i = 0; i < frequency; i++) {
				System.out.print(value + " ");
			}
		}
	}
}