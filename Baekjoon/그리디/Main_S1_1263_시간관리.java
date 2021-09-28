package 그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Time implements Comparable<Time> {
	int start;
	int end;

	public Time(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Time o) { // 내림차순으로 정렬
		return o.end - this.end;
	}
}

public class Main_S1_1263_시간관리 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// ti시간 걸리고, si 시 내에 일을 처리하여야 한다는 것을 담음
		// 0시 부터 활동을 시작 가능 --> 두 개 이상의 일을 같은 시간에 처리 x.

		// 진영이가 일을 모두 끝마칠 수 있는 가장 늦은 시간을 출력.
		// endTime 내림차순 정렬.
		ArrayList<Time> list = new ArrayList<>(N);
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			int start, end;
			st = new StringTokenizer(br.readLine());
			start = Integer.valueOf(st.nextToken());
			end = Integer.valueOf(st.nextToken());
			list.add(new Time(start, end));
		}
		Collections.sort(list); // 마감시간이 큰 것 부터 정렬.
		
		int start = list.get(0).end - list.get(0).start; // 처음 일을 시작할 수 있는 가장 늦은 시간으로 시작 시간 갱신.
		/**
		 * 시작 시간     걸리는 시간    끝 시간
		 * 15        5         20
		 * 14        1         15
		 * 6         8         14
		 * 2         3         5
		 */
		for (int i = 1; i < N; i++) {				
			if (start < list.get(i).end) 
				start = start - list.get(i).start;
			else 
				start = list.get(i).end - list.get(i).start;	
		}
		if (start < 0) { // 0시 부터 시작하여도 일을 끝 마칠 수 없다면
			System.out.println(-1);
		} else System.out.println(start); // 모두 마감 시간 내에 처리할 수 있는 범위 내에서 최대한 늦게 일을 시작할 수 있는 시간.
	}
}
