package BOJ;
import java.io.*;
import java.util.*;
/**
 *  스타트링크 걸리버스의 4번타자가 끝내기 홈런을 쳐서 "졌다"
 *  림 제미니스의 열렬한 팬인 지수는 속으로 화를 참으며 어떤 선수 때문에 졌는지 생각
 *	지수는 팀이 [ 역전패 ]를 했다면 불펜 '투수의 책임'이고, 그렇지 않다면 '타자와 선발 투수의 책임' 이라고 생각했다.
 *	지수를 도와 오늘 경기에서 울림 제미니스가 역전패를 했는지 구하는 프로그램을 작성하여라. 
 *  [ 역전패가 성립 ]하려면 경기 도중 [ 울림 제미니스가 이기고 있는 순간 ]이 있어야 한다.
 *  
 *  
 *  [ 입력 ]
 *  첫 번째 줄에는 9개의 정수가 주어지는데, 오늘 경기에서 '울림 제미니스'가 1회 초, 2회 초, ..., 9회 초에 낸 득점이 주어진다.
 *  두 번째 줄에도 9개의 정수가 주어지는데, 스타트링크 걸리버스가 1회 말, 2회 말, ..., 9회 말에 낸 득점이 주어진다.
 *  한 팀이 한 회에 낸 득점은 모두 0 이상 20 이하이며, [ 스타트링크 걸리버스의 총 득점 ]이 울림 제미니스의 총 득점보다 많다.
 *  경기는 1회 초->1회 말->2회 초->...->9회 초->9회 말 순서로 진행된다.
 */
public class Main_S5_14582_오늘도졌다 {
	
	public static void main(String[] args) throws Exception{
		final int size = 9; 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int [] yolim = new int[size];
		int [] start_link = new int[size];
		int yolim_score = 0;
		int start_link_score = 0;
		for (int i = 0; i < size; i++) yolim[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < size; i++) start_link[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < size; i++) {
			yolim_score += yolim[i]; // i 회 초
			// 한번이라도 울림쪽이 이기고 있다면 YES 출력
			if(yolim_score > start_link_score) {
				System.out.println("Yes");
				return ;
			}
			start_link_score += start_link[i]; // i 회 말
		}	
		// 한번 도 울림쪽이 이기고 있는 경우가 없는 경우.
		System.out.println("No");
	}
}
