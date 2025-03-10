import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		int i = 0, c;
		while ((c = System.in.read()) >= '0' && c <= '9') {
			i = i * 10 + (c - '0'); // 입력된 숫자를 변환
		}
		i = i - ((i >> 1) & 0x55555555);
		i = (i & 0x33333333) + ((i >> 2) & 0x33333333);
		i = (i + (i >> 4)) & 0x0f0f0f0f;
		System.out.println(i & 0xf);
	}
}
