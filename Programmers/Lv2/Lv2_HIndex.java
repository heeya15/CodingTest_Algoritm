package Programmers;
import java.util.*;
/**
	0	1	3	5	6   0회 이상 인용된 논문이 5편
	0	1	3	5	6	1회 이상 인용된 논문이 4편
	0	1	3	5	6	3회 이상 인용된 논문이 3편
	0	1	3	5	6	5회 이상 인용된 논문이 2편
	0	1	3	5	6	6회 이상 인용된 논문이 1편
	citations[i]에서 i값을 증가시키고 < 논문의 수를 감소시키면서 비교 > 했을 때 
	인용 횟수가 [ 논문의 수 이상이 되었을 때 ]의 논문의 수가 H-Index가 된다
**/
public class Lv2_HIndex {
	public static void main(String[] args) {
		int[] numbers = {3, 0, 6, 1, 5};
		System.out.println(solution(numbers)); // 답 : 3
		System.out.println(solution1(numbers)); // 답 : 3
	}

	public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i=0; i < citations.length; i++){
            // i 일때 가장 큰 h 값(논문 편수)
            int h = citations.length -i;
            // 해당 요소의 논문의 인용 횟수 >= h회 이상 인용된 논문 개수
            if(citations[i] >= h){
                answer= h;
                break;
            }
        }
        return answer;
    }
	
	public static int solution1(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i=0; i < citations.length; i++){
            int temp = Math.min(citations[i], citations.length - i);
            answer = Math.max(answer, temp);
        }
        return answer;
    }
}