package Programmers;

/**
 *  2018 KAKAO BLIND RECRUITMENT - 문자열 처리 문제
    ( 문제 해석 )
	1. 점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재
	   각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 으로 계산
	2. 스타상(*) , 아차상(#)이 존재
	   스타상(*) = [ 해당 점수 ] 와 [ 바로 전에 얻은 점수 ]를 각 2배로 만든다. 
	   아차상(#) = 당첨 시 [ 해당 점수는 마이너스 ]
	   < 스타상(*)은 첫 번째 기회 >에서도 나올 수 있다. 이 경우 [ 첫 번째 스타상(*)의 점수만 2배 ]
	   < 스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩 > 이 경우 중첩된 스타상 점수 4배
	   스타상(*)의 효과는 아차상(#)의 효과와 중첩 = 중첩된 아차상(#)의 점수는 -2배가 된다.
	3. Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재
	4. [ 3번의 기회에서 얻은 점수 합계 ]에 해당하는 정수값을 출력한다.
**/
public class Lv1_1차다트게임 {
	public static void main(String[] args) {
		System.out.println(solution("1S2D*3T"));  // 답 : 37
		System.out.println(solution("1D2S#10S")); // 답 : 9
		System.out.println(solution("1D2S0T"));   // 답 : 3
		System.out.println(solution("1S2D*3T"));  // 답 : 23
	}

	public static int solution(String dartResult) {
		int answer = 0;
		int[] sum = new int[3];
		String num = "";
		int index = 0;
		for (int i = 0; i < dartResult.length(); i++) {
			char temp = dartResult.charAt(i);
			switch (temp) {
			// index는 S,D,T 처리 후 증가하기 때문에 (index-1)번째 배열에 접근하는 것!
			// *인 경우는 자신과 이전의 점수 *2, index-2 * 2 --> # 과 * 중첩될 수 있다. 라는 지문에 해당 되기도 함.
			case '*':
				sum[index - 1] *= 2; // 처음에 나온 경우
				if (index > 1) sum[index - 2] *= 2; // * 나, # 이 중첩될 경우
				break;
			// #은 자신의 점수를 음수로 만든다.
			case '#':
				sum[index - 1] = sum[index - 1] * -1;
				break;
			// S는 1제곱, 다음 점수를 위해 index를 증가시키고 정수를 저장하는 num을 초기화.
			case 'S':
				sum[index++] = (int) Math.pow(Integer.parseInt(num), 1);
				num = "";
				break;
			// D는 2제곱, 다음 점수를 위해 index를 증가시키고 정수를 저장하는 num을 초기화.
			case 'D':
				sum[index++] = (int) Math.pow(Integer.parseInt(num), 2);
				num = "";
				break;
			// T는 3제곱, 다음 점수를 위해 idx를 증가시키고 정수를 저장하는 num을 초기화.
			case 'T':
				sum[index++] = (int) Math.pow(Integer.parseInt(num), 3);
				num = "";
				break;
			// 그 외의 정수들은 num 변수에 저장해 둔다.
			default:
				num += temp;
				break;
			}
		}
		// 3번의 기회에서 얻은 [ 점수 합계 계산 ]
		for (int i = 0; i < sum.length; i++) answer += sum[i];
		return answer;
	}
}
