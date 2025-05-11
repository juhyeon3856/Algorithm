import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int N, M, wordsSize;
	static class Word implements Comparable<Word> {
		int count;
		String text;
		public Word(int count, String text) {
			this.count = count;
			this.text = text;
		}
		@Override
		public String toString() {
			return "Word [count=" + count + ", text=" + text + "]";
		}
		
		@Override
		public int compareTo(Word o) {
			if(this.count == o.count) {
				if(this.text.length() == o.text.length()) {
					// 3. 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
					return this.text.compareTo(o.text);
				} else {
					// 2. 해당 단어의 길이가 길수록 앞에 배치한다.
					return -Integer.compare(this.text.length(), o.text.length());
				}
			}
			// 1. 자주 나오는 단어일수록 앞에 배치한다.
			return -Integer.compare(this.count, o.count);
		}
		
	
	}
	static List<Word> words;
	static Map<String, Integer> wordMap;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		words = new ArrayList<Word>();
		wordMap = new HashMap<String, Integer>();
		wordsSize = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if(str.length() < M ) {
				continue;
			}
			if(wordMap.containsKey(str)) {
				int index = wordMap.get(str);
				words.get(index).count++;
			} else {
				words.add(new Word(1, str));
				wordMap.put(str, wordsSize++);
			}
		}
		Collections.sort(words);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < wordsSize; i++) {
			sb.append(words.get(i).text).append("\n");
		}
		System.out.println(sb);
		
		
	}

}
