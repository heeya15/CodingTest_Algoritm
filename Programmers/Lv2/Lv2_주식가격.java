package Programmers;

import java.util.*;

/**
 * 스택/큐 자료구조를 활용한 문제
 * 
 * [ 문제 풀이 방법 ]
 * 
 * 문제를 보자마자 이중 반복문으로 풀면 되겠다 생각 했음.
 * 0번 index부터 반복문을 돌며 < 해당하는 index 다음에 감소하는 주식 가격이 나올 때까지 > 
 * answer[index]값을 증가시켜준다면 해결. 
 * -> 하지만 이중 for문은 n^2 시간 복잡도에 의해 최악의 경우 100억, 약 100초 시간이 소요 됨.
 * 이 문제에선 해당되는 테케가 없어서 통과 된 것 같았다. 따라서 다시 스택, 큐를 활용하여 다시 해결해 보려고 함.
 **/
public class Lv2_주식가격 {
	public static void main(String[] args) {
		int[] prices = { 1, 2, 3, 2, 3 };
		System.out.println(Arrays.toString(solution(prices))); // 답 : [4, 3, 1, 1, 0]
		System.out.println(Arrays.toString(solution1(prices))); // 답 : [4, 3, 1, 1, 0]
	}
    // 2중 for문을 활용한 방법
	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				answer[i]++;
				if (prices[i] > prices[j]) break;
			}
		}
		return answer;
	}
	// Stack 자료구조를 활용한 방법
	public static int[] solution1(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack  = new Stack<>();
        
        for(int i = 0; i < prices.length; i++){
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                answer[stack.peek()] = i - stack.peek();
                stack .pop(); // 떨어지지 않은 기간을 구했으니 해당 주식 가격 인덱스 제거.
            }
            stack .push(i);
        }
        // 값을 구하지 못한 index를 활용하여 끝까지 가격이 떨어지지 않은 주식 초를 구하는 부분.
        while (!stack.isEmpty()) { // 값을 구하지 못한 index == 끝까지 가격이 떨어지지 않은 주식
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }
        return answer;
    }
}