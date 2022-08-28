package 백트래킹;

import java.util.*;
import java.io.*;

/**
 * ( 문제 이해 )
 * 각 계란에는 내구도와 무게가 정해져있다. 
 * 계란으로 계란을 치게 되면 각 계란의 내구도는 < 상대 계란의 무게만큼 깎이게 > 된다. 
 * 그리고 내구도가 0 이하가 되는 순간 계란은 깨지게 된다.
 * 계란 1 내구도 7 무게 5
 * 계란 2 내구도 3 무게 4
 * 계란1로 계란 2를 치면
 * 계란 1: 내구도 3가 됨 -> 계란 2의 무게 4를 계란 1에 내구도에서 빼기 때문
 * 계란 2: 내구도 -2가 됨 -> 마찬가지로 계산 .
 * 즉, 충돌 결과 계란 1은 아직 멀쩡, 계란 2는 깨짐.
 * 
 * ( 구체적인 과정 설명 )
 * 일렬로 놓여있는 계란에 대해 < 왼쪽부터 차례로 들어서 한 번씩만 > 다른 계란을 쳐 < 최대한 많은 계란을 깨는 문제 >였다.
 * 
 * 1. 가장 왼쪽의 계란을 든다.
 * 2. 손에 들고 있는 계란으로 깨지지 않은 다른 계란 중에서 하나를 친다. 
 *    단, 손에 든 계란이 깨졌거나 깨지지 않은 다른 계란이 없으면 치지 않고 넘어간다. 
 *    이후 손에 든 계란을 원래 자리에 내려놓고 3번 과정을 진행한다.
 * 3. 가장 최근에 든 계란의 한 칸 오른쪽 계란을 손에 들고 2번 과정을 다시 진행한다. 
 *    단, 가장 최근에 든 계란이 가장 오른쪽에 위치한 계란일 경우 계란을 치는 과정을 종료한다.
 *    
 * ( 출력 )
 * < 최대 몇 개의 계란을 깰 수 있는지 > 알아맞춰보자
 * 
 * ( 문제 풀이 )
 * 계란에는 내구도(Durability)와 무게(Weight)가 있다.
 * 계란을 계란끼리 치면 계란의 내구도(Durability)는 다른 계란의 무게(Weight)만큼 깎인다.
 * 계란의 내구도(Durability)가 0 이하가 되면 깨진다.
 * 1. 계란을 가장 왼쪽부터 차례로 손에 들고 < 다른 계란들을 랜덤으로 > 선택한다.
 * 2. 손에 든 계란이 깨져있거나 "다른 계란들 전부가 깨져있어 " 깰 것이 없다면 아무일도 하지 않고 넘어간다. 
 * 3. 랜덤으로 선택된 계란 중 깨지지 않은 계란과 부딪히게 한다.
 * 4. 최근에 손에 든 계란의 바로 오른쪽 계란을 선택하여 손으로 들고 위의 과정을 반복한다.
 * 5. 왼쪽부터 차례로 든 계란으로 한 번 씩만 다른 계란과 부딪히게 하여 [ 최대한 많은 계란을 깬 수를  ] max 변수에 갱신 시켜줌으로 써 해결.
 */
public class Main_S1_16987_계란으로계란치기 {
	static int N, max;
	static boolean visited;
	static int[] Durability, Weight;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		max = Integer.MIN_VALUE;
		N = Integer.parseInt(br.readLine()); // 계란의 수 입력
		Durability = new int[N]; // 내구도
		Weight = new int[N]; // 무게
		// 계란의 내구도와 무게에 대한 정보가 주어짐.
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			Durability[i] = Integer.parseInt(st.nextToken());
			Weight[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0); // 0번째 계란부터 시작
		System.out.println(max);
	}

	public static void dfs(int depth) {
		// 마지막 계란까지 다 체크 했을 경우
		if (depth == N) {
			int count = 0;
			for (int i = 0; i < N; i++) {
				// 깨져있는 계란의 수를 세어줌.
				if(Durability[i] <=0)count++;
			}
			max = Math.max(max, count); // 최댓값 갱신
			return;
		}
		
		// 손에 들고 있는 계란이 깨져있는 경우
		if(Durability[depth] <=0 ) { 
			dfs(depth+1); // 치지 않고 그냥 넘어감.
			return;
		}
		boolean broken_egg = false; // 깰 수 있는 계란이 있는 경우를 확인하는 < 상태 변수 >
		for (int i = 0; i < N; i++) {
			// 참고 : depth 가 현재 손에 들고 있는 계란, i가 부딪혀 보러는 타겟 계란
			// 손으로 들고 있는 계란과 부딪히려고 하는 계란이 같은 계란이라면 무시
			if (i == depth) continue;
			// 부딪혀 보려고 하는 계란이 이미 깨져있다면 무시
			if (Durability[i] <= 0) continue;
			
			broken_egg = true;// 깰 수 있는 계란이 있다.
			
			// 계란끼리 부딪혀봄 (현재 손에 들고 있는 계란의 내구도에, 부딪혀보려는 타겟 계란의 무게를 빼줌)
			Durability[depth] -= Weight[i];
			// (부딪혀 보려는 타겟 계란의 내구도에, 손에 들고 있는 계란의 무게를 빼줌)
			Durability[i] -= Weight[depth];
			
			// 재귀 호출 -> 다음 계란 들어 봄
			dfs(depth + 1);
		
			// 다음 경우의 수 를 위해 < i 값을 복구 > 시켜 준다
			Durability[depth] += Weight[i];
			Durability[i] += Weight[depth];
			
		}
//		다른 계란들이 전부 깨졌을 경우 ( 깨지지 않은 다른 계란이 없는 경우 ) -> 즉, 깰 수 있는 계란이 없는 경우
		if(broken_egg == false) dfs(depth+1);
	}
}
