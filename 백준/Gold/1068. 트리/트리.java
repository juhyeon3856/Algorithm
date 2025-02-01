
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static Queue<Integer> queue;
	static List<Integer> leafNode;
	static int[] nodes;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		nodes = java.util.Arrays.stream(br.readLine().split(" ")) // 입력 받은 한 줄을 공백 기준으로 분리하여 스트림 생성
				.mapToInt(Integer::parseInt) // 각 문자열을 int로 변환
				.toArray(); // int 배열로 변환 // 한 줄로 int[] 변환
		int delIdx = Integer.parseInt(br.readLine());

		if(nodes[delIdx] == -1) {
			System.out.println(0);
			return;
		}
		leafNode = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			leafNode.add(i);
		}
		for (int node : nodes) {
			removeLeafNode(node);
		}

		queue = new LinkedList<Integer>();
		queue.add(delIdx);
		while (!queue.isEmpty()) {
			int q = queue.poll();
			removeLeafNode(q);
			find(q);
			int nodeQ = nodes[q];
			nodes[q] = -2;
			if(nodes[nodeQ]!=-2 && isLeafNode(nodeQ)) leafNode.add(nodeQ);
		}

		System.out.println(leafNode.size());

	}
	
	public static boolean isLeafNode(int num) {
		for(int node:nodes) {
			if(node==num) return false;
		}
		return true;
	}

	public static void removeLeafNode(int num) {
		for (int i = 0; i < leafNode.size(); i++) {
			if (num == leafNode.get(i))
				leafNode.remove(i);
		}
	}

	public static void find(int num) {
		for (int i = 0; i < N; i++) {
			if (nodes[i] == num) {
				queue.add(i);
			}
		}
	}

}