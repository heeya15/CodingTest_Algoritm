package Programmers;
import java.util.*;
import java.lang.*;
public class Lv2_다리를지나는트럭 {

	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int [] truck_weights = {7,4,5,6};
		
		System.out.println(solution(bridge_length,weight,truck_weights));

	}
	 // 다리에 올라갈 수 있는 트럭 수, 다리가 견딜수 있는 무게, 트럭 무게들 인자로 받음.
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
    	int answer = 0;
         
 		Queue<Integer> q = new LinkedList<Integer>();
 		int sum = 0; // 다리를 건너는 트럭들의 무게 합
 		
 		for(int i = 0; i < truck_weights.length ; i ++) {	
 			while(true) {
 				//큐가 비어있다면 다음 트럭 삽입
 				if(q.isEmpty()) {
 					q.offer(truck_weights[i]);
 					sum += truck_weights[i];
 					answer++;
 					break;
 				}
 				//큐의 사이즈와 '다리의 길이'가 같다면 큐에서 큐에서 처음 값을 빼고 최대 무게 -
 				else if(q.size() == bridge_length) {
 					sum -= q.poll();
 				}
 				//큐가 비어있지 않을 때
 				else {
 					//다음 트럭이 최대 무게 초과
 					if(sum + truck_weights[i] > weight) {
 						q.offer(0);
 						answer++;
 					}
 					//다음 트럭이 최대 무게 이내
 					else {
 						q.offer(truck_weights[i]);
 						sum += truck_weights[i];
 						answer++;
 						break;
 					}
 				}
 			}
 		}
 		//걸린 시간 + 마지막 트럭의 통과시간(다리의 길이)
 		return answer + bridge_length;
    }
}
