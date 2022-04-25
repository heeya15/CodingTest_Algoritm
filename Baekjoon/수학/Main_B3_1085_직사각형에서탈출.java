package BOJ;
import java.io.*;
import java.util.*;
/**
 * 
 * 한수는 지금 (x, y)에 있다. 
 * 직사각형은 각 변이 좌표축에 평행하고, 왼쪽 아래 꼭짓점은 (0, 0), 오른쪽 위 꼭짓점은 (w, h)에 있다. 
 * 직사각형의 경계선까지 가는 `거리의 최솟값`을 구하는 프로그램을 작성하시오.
 *
 */
public class Main_B3_1085_직사각형에서탈출 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// x, y, w, h 가 주어진다.
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		// 직사각형을 탈출하는 최소거리는 4가지 방법 중 하나.
		// 위, 아래, 좌, 우 중 `최솟값`만 찾으면 되는 것이다.
		int min_x = Math.min(x, w-x); // 좌 , 우
		int min_y = Math.min(y, h-y); // 위, 아래
		System.out.println(Math.min(min_x, min_y));
	}
}
