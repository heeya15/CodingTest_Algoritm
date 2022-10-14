package Programmers;

/**
 * 3명의 학생의 모든 경우의 수를 구해 3명 학생의 합이 0이면 삼총사를 만들 수 있다. 
 * 즉, 3명의 학생의 모든 경우의 수 조합 구하기
 */
public class Lv1_삼총사 {
    public static int answer ;
    public static int [] students;
	public static void main(String[] args) throws Exception {
		int [] number = {-2, 3, 0, 2, -5};
		System.out.println(solution(number)); // 답 2
	}

	public static int solution(int[] number) {
        answer = 0;
        students = new int[3]; // 3명의 학생 정수 번호를 저장할 배열 초기화
        comb(0, 0, number);    // 3명의 학생을 뽑을 모든 경우의 수 조합 구하기
        return answer;
    }
    public static void comb(int depth, int start, int [] number){
        if(depth == 3){ // 3명의 학생을 뽑았을 경우
            int sum = 0;
            for(int i = 0; i < students.length; i++) sum += students[i];
            if(sum == 0) answer++; // 3명 학생의 합이 0이면 삼총사를 만들 수 있어서 +1 증가.
            return;
        }
        for(int i = start; i < number.length; i++){
            students[depth] = number[i];
            comb(depth+1, i+1, number);
        }
    }
}
