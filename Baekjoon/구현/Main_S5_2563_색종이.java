package 구현;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*2563 색종이
<  입력  >
3
3 7
15 7
5 2
< 출력 >
 */
public class Main_S5_2563_색종이 {
	static boolean[][] isSelected = new boolean[100][100];

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		1. 색종이 수 입력.
		int n = Integer.parseInt(br.readLine()); 
		int sum = 0; // 영역의 넓이 저장 변수.
		for (int a = 0; a < n; a++) { // 색종이 수 만큼 반복.
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		2. 정사각형 모양 색종이 만들어서 넓이를 구하는 부분.
			int x = Integer.parseInt(st.nextToken()); // 색종이 왼쪽 변과 [ 도화지의 왼쪽변 ] 사이의 거리
			int y = Integer.parseInt(st.nextToken()); // 색종이의 아래쪽 변과 [ 도화지의 아래쪽변 ] 사이의 거리.
			for (int i =x ; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					if (isSelected[i][j] == false) { // 방문하지 않았을 경우
						isSelected[i][j] = true; // 방문 처리.
						sum++;
					}
				}
			}
		}		
//      3. 검은색 영역 넓이 출력
		System.out.println(sum);
	}
}
