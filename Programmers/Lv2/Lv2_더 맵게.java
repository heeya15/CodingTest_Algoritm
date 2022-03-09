package Programmers;
import java.util.*;
/**
  - 모든 음식의 스코빌 지수를 K 이상
  - 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 
    [ 스코빌 지수가 가장 낮은 두 개의 음식 ]을 아래와 같이 [ 특별한 방법으로 섞어 ] 새로운 음식을 만듭니다.
  - 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
  - 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
  - 모든 음식의 [ 스코빌 지수를 K 이상으로 만들기 위해 ] "섞어야 하는 최소 횟수"를 return 하도록 solution 함수를 작성해주세요.
**/
public class Lv2_더맵게 {
	static int size, answer;
	public static void main(String[] args) {
		int [] scoville = {1, 2, 3, 9, 10, 12};
		System.out.println(solution(scoville, 7));  // 2 출력 
		int [] scoville1 = {1,2};
		System.out.println(solution(scoville1, 7)); // -1 출력 ( K이상으로 만들 수 없음 )	
	}
	public static int solution(int[] scoville, int K) { // 스코빌 지수가 담긴 배열, 원하는 스코빌 지수 K 인자로 주어짐
        int answer = 0;
        // 가장 작은값을 두 개 뽑아야 해서 자동 오름차순 정렬이 되는 우선순위 큐를 사용할 생각을 가짐.
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for(int i = 0; i < scoville.length; i++) heap.add(scoville[i]);

        while(heap.peek() < K){
            /** 
             - 아래 조건은 스코빌 배열의 길이가 2인 1,2 가 들어왔고, 원하는 스코빌 지수는 7이라고 가정하자.
             - 처음 가장 작은 값 2개를 섞은 음식의 스코빌 지수는 5가 되지만 우선 순위큐의 사이즈는 현재 1인 상태가 되며,
                            다음 K보다 작은 값 2개를 뽑을 수도 없고, 원하는 스코빌 지수(7) 보다도 작다.
             - 따라서 K이상으로 만들 수 없기 때문에 -1 을 return 해줌.
            **/
            if(heap.size() == 1) return -1;
            // 가장 작은 값 2개를 뽑는다.
            int temp1 = heap.poll();
            int temp2 = heap.poll();
            int mix_shu = temp1 + (temp2 * 2); // 섞은 음식의 스코빌 지수 
            heap.offer(mix_shu);
            answer++;
        }
        return answer;
    }
}