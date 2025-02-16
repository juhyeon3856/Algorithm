import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] tree;
	static boolean[] visited;
	static int[] par;
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		par = new int[N+1];
		visited = new boolean[N+1];
		
		tree = new LinkedList[N+1];
		for (int i = 1; i < N+1; i++) {
			tree[i] = new LinkedList<Integer>();
		}
		
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		}
				
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		
		while(!queue.isEmpty()) {
			int q = queue.poll();
			for (int i = 0; i < tree[q].size(); i++) {
				int next = tree[q].get(i);
				if(!visited[next]){
					queue.offer(next);
					par[next] = q;
					visited[next] = true;
				}
			}
		}
		
		for (int i = 2; i <= N; i++) {
			System.out.println(par[i]);
		}
		
		
		
	}

}
