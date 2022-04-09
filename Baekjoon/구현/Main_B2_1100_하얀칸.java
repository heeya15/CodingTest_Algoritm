package BOJ;
import java.io.*;
import java.util.*;
/**
 * 체스판은 8×8크기이고, 검정 칸과 하얀 칸이 번갈아가면서 색칠되어 있다. 가장 왼쪽 위칸 (0,0)은 하얀색이다.
       체스판의 상태가 주어졌을 때, [ 하얀 칸 위에 말이 몇 개 ] 있는지 출력하는 프로그램을 작성하시오.
       즉, 각 좌표의 합이 짝수가 된다면 하얀 칸이라고 정해두고 문제 해결 함.
**/
public class Main_B2_1100_하얀칸 {
	public static void main(String[] args) throws Exception{
		final int row = 8, col = 8;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char map [][] = new char[row][col];
		for (int i = 0; i < row; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < col; j++) {
				map[i][j] = temp[j];
			}
		}
		int result = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
//				   (i + j)를 2로 나눈 나머지가 0인 경우 => 하얀 칸!
				if((i+j) % 2 == 0 && map[i][j] == 'F') result++;
			}
		}
		System.out.println(result);
	}
}
