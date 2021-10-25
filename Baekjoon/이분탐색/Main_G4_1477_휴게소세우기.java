package 이분탐색;
import java.util.*;
import java.io.*;
/**
 * 다솜이는 "이미 휴게소가 있는 곳에" 휴게소를 또 세울 수 없고, 
 * 고속도로의 "끝에도 휴게소를 세울 수 없다". 휴게소는 "정수 위치"에만 세울 수 있다.
 * 다솜이는 이 고속도로를 이용할 때, 모든 휴게소를 방문
 * 다솜이는 휴게소를 M개 더 지어서 < 휴게소가 없는 구간의 길이의 최댓값을 > 최소로 하려고 한다.( 반드시 M개를 모두 더 지어야 함 )
 * 
 * (주의할 점 )
 * - 0으로 나눠질 수가 있어서 while을 바로 탈출하게 휴게소의 개수를 세어주는 변수에 M+1로 탈출 시켜줌
 * - 휴게소의 개수가 0이 들어올 수 있는 히든 테케 때문에 고생함. 0이 들어올 경우 입력 받을 필요없게 구별 시켜줌
 * - 0 99 100 일때 계산흐름
 * 휴게소 개수(m개 개수와 같아질때)     					간격(mid)			결과(left)				right
 * 	1 							50 			0 				100
	4 							24 			0 				49
	9 							11 			0 				23
	19 							5 			0 				10
	49 							2 			0 				4
	간격이 결국 0이 될 경우 (m+1)을 휴게소 수로 해줌.
	100							0 			0 				1
	99 							1 			1 				0

99 휴게소 개수인 경우 right가 0이 된 이유는 (else 부분에 의해 0이되어 while문 탈출)    <<- 휴게소 m개만큼 더 지었을경우 구간 길이의 최댓값은 left가 됨.
 * 
 */
public class Main_G4_1477_휴게소세우기 {
	static int N, M , L ; 
	static int [] loc;
	static int left, right, result = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken()); // 휴게소의 개수
		M = Integer.parseInt(st.nextToken()); // 더 지으려고 하는 휴게소의 개수
		L = Integer.parseInt(st.nextToken()); // 고속도로의 길이
		
		loc = new int[N+2];
		// 휴게소 0의 위치와, 휴게소 가장 끝점 위치를 가정해 둠.
		loc[0] = 0; 	// 휴게소 시작 위치
		loc[N+1] = L;   // 휴게소 끝 위치
		if(N!=0) {
			// 현재 휴게소의 위치 입력 -- 모든 휴게소의 위치는 중복X.
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 1; i< N+1; i++) {
				loc[i] = Integer.parseInt(st.nextToken()); 
			}
		}
		Arrays.sort(loc); // 이분 탐색 처음엔 정렬후 시작.
		binarySearch( loc[0], loc[N+1]);
	}
	static void binarySearch(int start, int end) {
		 left = start;
		 right = end;
		 
		 // M=3개가 될때 3개중 가장긴 휴게소 간격 1나를 구해서 출력하는 부분.
		 while(left <= right) {
	            int mid = (left + right) / 2; // 휴게소를 세울 간격을 의미
	           
//	            mid = 500(간격) 인경우 701 - 200 = 501 이여서 1나 세울 수 있음!
	            int rest_area = 0; // 휴게소를 세울 수 있는 수
	            
	            for(int i=1; i < N+2; i++) { 
	            	int dis = loc[i]- loc[i-1];
	            	
	            	if(mid!=0) { // mid가 0이 아니라면
	            		rest_area += dis / mid;
//	            	 	나누어 떨어지면 휴게소 위치 겹친다는 의미.
	            		if( dis % mid == 0) rest_area--;   // 따라서 세울 휴게소의 수 감소.   	   	
	            	}
	            	else { // 간격이 결국 0이게 되면 그냥 while문 탈출하게 만듬.
	            		rest_area = M+1;   	       
	            	}
	            }	              
//	        	 더 지으려는 휴게소의 개수보다 ( 더 많이 짓게 된다면 )        
	            if(rest_area > M) left = mid+1;	 
//	                        더 지으려는 휴게소의 수보다 [ 작거나 같을 경우 ] 간격 - 1 처리.   
	            else right = mid-1;          
	        }
	        System.out.println(left);
		}
}
