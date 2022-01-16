package 구현;
import java.util.*;
/**
실패율은 다음과 같이 정의한다.
스테이지에 도달했으나 [ 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수 ]
전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰 있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어짐
실패율이 높은 스테이지부터 내림차순으로 "스테이지의 번호가 담겨있는 배열을 return 하도록" solution 함수를 완성하라.
- Stage가 5까지 있을 때 [4,4,4,4,4]가 주어졌다. 이 때 5에 아무도 도달하지 못했을 경우를 생각해야 한다.
   따로 예외처리하지 않고 테스트하면 아마 실패율에 Nan이 출력 될 거에요.
**/
public class Lv1_실패율 {
	public static class PerCent implements Comparable<PerCent> {
		int idx;
		double fail;
		public PerCent(double fail, int idx) {
			this.fail = fail;
			this.idx = idx;
		}
		// 실패율 내림차순, 그 다음 인덱스 오름차순
		public int compareTo(PerCent o) {
			double res = o.fail - this.fail;
			if (res != 0)
				return Double.compare(o.fail, this.fail);
			int result = this.idx - o.idx;
			return result;
		}
	}
	public static void main(String[] args) {
		int [] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		System.out.println(solution(5, stages)); // [3, 4, 2, 1, 5]
		int [] stages1 = {4,4,4,4,4};
		System.out.println(solution(4, stages1));// [4, 1, 2, 3]
		int [] stages2 = {4,4,4,4,4};
		System.out.println(solution(5, stages2));// [4, 1, 2, 3, 5]
	}
	public static String solution(int N, int[] stages) {
		PerCent[] pr = new PerCent[N];
		int index = 0;
		for (int i = 1; i <= N; i++) {
			int cnt = 0; // 해당 스테이지에 아직 클리어 하지 못한 사람의 수
			double fail_rate = 0.0; // 실패율
			double person = stages.length; // 도전자 수
			for (int j = 0; j < stages.length; j++) {
				if (stages[j] == i) cnt++; // 아직 클리어 하지 못한 사람을 증가
				// 해당 스테이지(i) 보다 현재 멈춰 있는 스테이지 번호가 더 작을 경우 [ 도전자의 수를 깎음. ]
				if (stages[j] < i) person--;
			}
			fail_rate = cnt / person;
			if (person == 0) fail_rate = 0.0;
			pr[index++] = new PerCent(fail_rate, i); // 해당 클래스에 실패율과 해당 스테이지 번호를 담아 넣어줌
		}
		int[] stage = new int[N]; // 실패율이 높은 스테이지의 번호부터 담을 배열 초기화
		Arrays.sort(pr); // 실패율 내림차순, 실패율이 같다면 스테이지 번호 오름차순으로 정렬.
		for (int i = 0; i < N; i++) stage[i] = pr[i].idx; // 실패율이 높은 스테이지 번호 저장.
		return Arrays.toString(stage);
	}

}
