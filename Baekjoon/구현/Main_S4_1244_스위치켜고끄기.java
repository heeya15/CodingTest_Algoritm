package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 구현+ 시뮬레이션
public class Main_S4_1244_스위치켜고끄기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine())+1; // 스위치 개수 -- 인덱스 계산을 위해. +1 해줌.
		int [] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 스위치 상태 저장.
		for (int i = 1; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int num = Integer.parseInt(br.readLine()); // 학생 수 주어짐.
		
		for (int i = 0; i < num; i++) {
			st= new StringTokenizer(br.readLine()," ");
			int gender = Integer.parseInt(st.nextToken()); // 성별
			int sangte = Integer.parseInt(st.nextToken()); // 스위치 상태
			if(gender==1) { //남학생
				for (int j = 1; j < N; j++) {
					if(j%sangte ==0 && arr[j]==0)arr[j]=1;
					else if(j%sangte ==0 && arr[j]==1)arr[j]=0;
				}
			}else if(gender==2) { // 여학생
				int left = sangte-1;
				int right = sangte+1;
				while(true) {
					if(left >0 && right <N && arr[left]==arr[right]) {
						left -=1;
						right+=1;
					}else if(left <=0 || right >=N ||arr[left]!=arr[right]) {
						left +=1;
						right -=1;
						break;
					}
				}
				for (int j = left; j <= right; j++) {
					if(arr[j]==0) arr[j]=1;
					else if(arr[j]==1) arr[j]=0;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N; i++) {
			sb.append(arr[i]+" ");
			if(i%20 == 0) {
				sb.append("\n");
			}	
		}
		System.out.println(sb);
	}
}
