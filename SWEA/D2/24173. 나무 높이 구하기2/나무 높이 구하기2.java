
// 컬렉션 사용을 위해 import // 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

	static class TreeGap {
		int index;
		int gap;

		TreeGap(int index, int gap) {
			this.index = index;
			this.gap = gap;
		}

		@Override
		public String toString() {
			return "" + gap;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] test = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				test[i] = Integer.parseInt(st.nextToken());
			}
			System.out.println("#" + t + " " + solveTestCase(test));
		}
		// 예제 테스트 케이스 배열 //
//		int[][] testCases = { { 3, 5, 2, 6, 4 }, //
//				{ 4, 4, 4, 8 }, //
//				{ 1, 3, 2 }, //
//				{ 2, 2, 5, 3 }, //
//				{ 7, 1, 4, 3 }, //
//				// ----5-------
//				{ 10 }, //
//				{ 5, 5, 5, 5 }, //
//				{ 10, 9, 8, 7, 6 }, //
//				{ 1, 2, 3, 4, 5 }, //
//				{ 1, 1, 2, 3, 4, 5 }, //
//				// --------10----------------
//				{ 1, 1, 1, 10 }, //
//				{ 6, 2, 5, 1, 9, 7 }, //
//				{ 100, 1, 1, 1 }, //
//				{ 1, 2, 3, 4, 5, 100 }, //
//				{ 50, 40, 30, 20, 10 }, //
//				// -------15-----------
//				{ 100, 90, 80, 70, 60, 50, 40, 30 }, //
//				{ 7, 7, 7, 7, 7, 7, 20 }, //
//				{ 12, 10, 4 } }; //
//
//		// 각 테스트 케이스 실행 //
//		for (int t = 0; t < testCases.length; t++) { // 각 예제에 대해 반복 //
////			System.out.println("예제 " + (t + 1) + ":"); // 예제 번호 출력 //
//			System.out.println("테스트케이스 : " + Arrays.toString(testCases[t]));
//			System.out.println("#" + (t + 1) + " " + solveTestCase(testCases[t]) + "일 걸림"); // 예제 간 빈 줄 추가 //
//			System.out.println();
//		}
	}

	// 하나의 테스트 케이스를 해결하는 메서드 //
	static int solveTestCase(int[] treeHeights) {
		int count1 = 0; // 1 사용 개수 초기화 //
		int count2 = 0; // 2 사용 개수 초기화 //
		int count3 = 0; // 3 사용 개수 초기화 //

		// 입력받은 트리 높이 배열에서 최대 높이 계산 //
		int maxHeight = 0; // 최대 높이 초기화 //
		for (int h : treeHeights) { // 각 트리 높이에 대해 //
			if (h > maxHeight)
				maxHeight = h; // 최대 높이 업데이트 //
		}

		// 각 트리별로 최대 높이와의 gap(차)를 계산하여 리스트에 저장 //
		List<TreeGap> gaps = new ArrayList<>(); // TreeGap 리스트 생성 //
		for (int i = 0; i < treeHeights.length; i++) { // 각 트리에 대해 //
			int gap = maxHeight - treeHeights[i]; // gap 계산 //
			gaps.add(new TreeGap(i, gap)); // 리스트에 추가 //
		}

		// gap을 오름차순(작은 gap부터) 정렬 //
		Collections.sort(gaps, Comparator.comparingInt(a -> a.gap)); // 정렬 //
//		System.out.println("자라야 하는 나무 높이 : " + gaps);

		// 각 트리의 gap을 채운 결과를 저장할 Map (트리 인덱스 -> 사용된 조각 리스트) //
		Map<Integer, List<Integer>> fillResult = new HashMap<>(); // 결과 맵 생성 //

		// 오름차순으로 정렬된 각 트리 gap에 대해 조각들을 채움 //
		for (TreeGap tg : gaps) { // 각 TreeGap에 대해 //
			int gap = tg.gap; // 현재 트리의 gap //
			List<Integer> piecesUsed = new ArrayList<>(); // 이 트리에서 사용될 조각 리스트 //
			while (gap > 0) { // gap이 0이 될 때까지 반복 //
				int pieceToUse = -1; // 선택할 조각 초기화 //
				int minCount = Integer.MAX_VALUE; // 최소 사용 횟수를 매우 큰 수로 초기화 //

				if (3 <= gap && count3 < minCount) { // 3이 가능하면 //
					pieceToUse = 3; // 3 선택 //
					minCount = count3; // 최소 사용 횟수 갱신 //
				}
				if (2 <= gap && count2 < minCount) { // 2가 가능하면 //
					pieceToUse = 2; // 2 선택 //
					minCount = count2; // 최소 사용 횟수 갱신 //
				}
				// gap 이하인 조각 중에서 전역 사용 횟수가 가장 작은 조각 선택 //
				if (1 <= gap && count1 < minCount) { // 1이 가능하면 //
					pieceToUse = 1; // 1 선택 //
					minCount = count1; // 최소 사용 횟수 갱신 //
				}
				// gap > 0이면 항상 적어도 1은 선택 가능하므로 pieceToUse가 -1인 경우는 없음 //
				if (pieceToUse == -1) {
					break; // 예외 상황 처리 //
				}
				piecesUsed.add(pieceToUse); // 선택된 조각을 리스트에 추가 //

				// 전역 사용 횟수 업데이트 //
				if (pieceToUse == 1) {
					count1++; // 1 사용 횟수 증가 //
				} else if (pieceToUse == 2) {
					count2++; // 2 사용 횟수 증가 //
				} else if (pieceToUse == 3) {
					count3++; // 3 사용 횟수 증가 //
				}

				gap -= pieceToUse; // 선택한 조각 값만큼 gap 감소 //
			}
			fillResult.put(tg.index, piecesUsed); // 해당 트리의 결과를 맵에 저장 //
		}

		// 결과 출력: 각 트리별로 채운 조각들과 최종 사용된 1, 2, 3의 개수 출력 //
//		for (int i = 0; i < treeHeights.length; i++) { // 각 트리에 대해 //
//			System.out.println("트리 " + i + " (높이: " + treeHeights[i] + "): " + fillResult.get(i)); // 출력 //
//		}

		while (count1 + 1 < count2) {
			count1 += 2;
			count2--;
		}

		while (count1 < count3 && count2 < count3) {
			count1++;
			count2++;
			count3--;
		}

		int answer = 0;
		if (count1 > count2) {
			// count1이 가장 클 경우
			if (count1 > count3) {
				answer = count1 * 3 - 2;
			} else { // count3이 가장 큰 경우
				answer = count3 * 3;
			}
		} else {
			if (count2 > count3) {
				answer = count2 * 3 - 1;
			} else { // count3이 가장 큰 경우
				answer = count3 * 3;
			}
		}

//		System.out.println("최종 사용 개수 -> 1: " + count1 + "개, 2: " + count2 + "개, 3: " + count3 + "개"); // 출력 //
		return answer;
	}

}
