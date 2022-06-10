package Programmers;

public class Lv1_음양더하기 {
	public static void main(String[] args) {
		int [] absolutes = {4,7,12};
		boolean [] signs = {true,false,true};
		System.out.println(solution(absolutes,signs));
		int [] absolutes1 = {1,2,3};
		boolean [] signs2 = {false,false,true};
		System.out.println(solution(absolutes1,signs2));
	}
	public static int solution(int[] absolutes, boolean[] signs) {
		int answer = 0;
		for (int i = 0; i < signs.length; i++) { // signs 길이는 absolutes의 길이와 동일.
			if (signs[i]) answer += absolutes[i]; // 참이면 양수
			else answer -= absolutes[i]; // 거짓이면 음수
		}
		return answer;
	}
}
