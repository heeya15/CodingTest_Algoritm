package BaekJoon_self;
import java.io.*;
import java.util.*;
/**
 * 재현시는 크기가 N×N인 격자로 나타낼 수 있다
 * 격자의 각 칸은 구역을 의미하고, r행 c열에 있는 구역은 (r, c)로 나타낼 수 있다
 * 구역을 다섯 개의 선거구로 나눠야 하고, 각 구역은 다섯 선거구 중 하나에 포함되어야 한다. 
 * 선거구는 구역을 적어도 하나 포함해야 하고, 한 선거구에 포함되어 있는 구역은 모두 연결되어 있어야 한다. 
 * 
 [ 구현 방법 ] 
 1. 4 중 for 문으로 (r, c, d1, d2) 5선거구 구역 경계의 길이 경우의 수를 전부 구한다.
 2. (x, y) 좌표에서 시작하여 d1, d2 를 기준으로 경계선만 체크한다.
 3. 5번 선거구 경계선을 기준으로 1, 2, 3, 4 구역의 인구수를 주어진 조건에 따라 구한다.
 4. 5 구역은 (전체 인구수 - 나머지 구역의 인구수) 로 계산한다.
 5. 각 구역 인구수를 [ 오름차순으로 정렬 ]한 뒤에 [ 최대값에서 최소값 ]을 빼고 기존 Min 값과 비교해서 최소값을 구한다.
 */
public class Main_G4_17779_게리맨더링2 {
	static int N;
	static int [][] map;
	static int total_People;
	static int Min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		StringTokenizer st;
		for(int i =1; i <= N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				total_People += map[i][j];
			}
		}
		
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				for (int d1 = 1; d1 <= N; d1++) {
					for (int d2 = 1; d2 <= N; d2++) {
						// 1. 기준점 경계의 길이 d1, d2  
						// 1 ≤ x < x+d1+d2 ≤ N
						// 1 ≤ y-d1 < y < y+d2 ≤ N
						if(r + d1 + d2 > N)continue;
						if(c-d1 < 1 || c+d2 > N) continue;
						solution(r,c,d1,d2);
					}
				}
			}
		}
		System.out.println(Min);
	}
	static void solution(int x, int y, int d1, int d2) {
		boolean [][] visit = new boolean[N+1][N+1];
		/**
		 * 2. 다음 칸은 경계선이다.
			(x, y), (x+1, y-1), ..., (x+d1, y-d1)
			(x, y), (x+1, y+1), ..., (x+d2, y+d2)
			(x+d1, y-d1), (x+d1+1, y-d1+1), ... (x+d1+d2, y-d1+d2)
			(x+d2, y+d2), (x+d2+1, y+d2-1), ..., (x+d2+d1, y+d2-d1)
		 */
		// 사각형 왼쪽 경계선 체크
		for (int i = 0; i <= d1; i++) {
			visit[x+i][y-i] = true;
		}
		
		// 사각형 오른쪽 경계선 체크
		for (int i = 0; i <= d2; i++) {
			visit[x+i][y+i] = true;
		}
		
		// 사각형 왼쪽 아래 경계선 체크
		for (int i = 0; i <= d2; i++) {
			visit[x+d1+i][y-d1+i] = true;
		}
		// 사각형 오른쪽 아래 경계선 체크
		for (int i = 0; i <= d1; i++) {
			visit[x+d2+i][y+d2-i] = true;
		}
		
		/** 
		    4.5번 선거구에 포함되지 않은 구역 (r, c)의 선거구 번호는 다음 기준을 따른다. 
			   1번 선거구: 1 ≤ r < x+d1, 1 ≤ c ≤ y
			   2번 선거구: 1 ≤ r ≤ x+d2, y < c ≤ N 
			   3번 선거구: x+d1 ≤ r ≤ N, 1 ≤ c < y-d1+d2
			   4번 선거구: x+d2 < r ≤ N, y-d1+d2 ≤ c ≤ N --> [ x+d2+1 < r <= N ] 이 되야함
		 */
		
		int [] people_Sum = new int[6];
		// 1번 선거구 번호 표시
		for(int i = 1; i < x+d1 ; i++ ) {
			for (int j = 1; j <= y; j++) {
				if(visit[i][j])break;
				people_Sum[1] += map[i][j];
			}
		}
		
		// 2번 선거구 번호 표시
		for(int i = 1; i <= x+d2 ; i++ ) {
			for (int j = N; j > y; j--) {
				if(visit[i][j])break;
				people_Sum[2] += map[i][j];
			}
		}
		// 3번 선거구 번호 표시
		for(int i = x+d1; i<=N ; i++ ) {
			for (int j = 1; j < (y-d1)+d2; j++) {
				if(visit[i][j])break;
				people_Sum[3] += map[i][j];
			}
		}
	
		// 4번 선거구 번호 표시
		for(int i = x+d2+1; i<=N ; i++ ) {
			for (int j = N; j >= (y- d1)+d2; j--) {
				if(visit[i][j])break;
				people_Sum[4] += map[i][j];
			}
		}
		people_Sum[5] = total_People;
		
		/** 3.경계선과 경계선의 안에 포함되어있는 곳은 5번 선거구 총 인구수 이다. **/
		// 1번 선거구~ 4번 선거구 까지의 인구수 합을 전체 총 인구수에서 빼주면 [ 5번 선거구 인구수가 됨. ]
		for(int i = 1 ; i <5 ; i++) people_Sum[5] -= people_Sum[i];
		
		// 인구가 가장 적은수 부터 오름차순 정렬.
		Arrays.sort(people_Sum);
		/** 5. 인구가 [ 가장 많은 선거구 ]와 [ 가장 적은 선거구 ]의 인구 차이의 최솟값을 구해보자. **/
		Min = Math.min(Min,people_Sum[5] - people_Sum[1]);	
	}
}
