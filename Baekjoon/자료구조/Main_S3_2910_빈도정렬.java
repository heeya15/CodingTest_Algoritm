package BaekJoon_self;

import java.util.*;
import java.io.*;

public class Main_S3_2910_빈도정렬 {
	/**
	 *  만약, 등장하는 횟수가 같다면, 먼저 나온 것이 앞에 있어야 한다.
	 *  이렇게 정렬하는 방법을 빈도 정렬이라고 한다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	
		int N = Integer.parseInt(st.nextToken());  // 메시지 길이
		int C = Integer.parseInt(st.nextToken());  // 수열의 숫자가 C 보다 작거나 같다.
		HashMap<Integer,Integer> map = new LinkedHashMap<>();
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			// 해당 숫자(key)가 존재하면 해당 키에 해당하는 값을 +1
			if(map.containsKey(temp)) map.put(temp, map.get(temp) +1);
			else map.put(temp, 1); // 키가 존재하지 않는다면 해당 키에 값을 1로 셋팅.
		}
	
		// HashMap에 key를 list에 셋팅
		ArrayList<Integer> list = new ArrayList<>(map.keySet());
		Collections.sort(list, new Comparator<Integer>() {
			// b가 list 처음 원소, a는 list 두번째 원소
			public int compare(Integer a, Integer b) {
				// 즉 처음 원소의 빈도수와, 두번째 원소의 빈도수 값이 같거나, 처음 원소의 빈도수가 더 크다면 list 정렬 그대로 유지하고,
				// 처음 원소의 빈도수가  두번째 빈도 수 보다 작을경우 < 해당 key 값을 바꿔 준다. >
				return Integer.compare(map.get(b), map.get(a));
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			int key = list.get(i);
			for (int j = 0; j < map.get(key); j++) {
				sb.append(key).append(" ");
			}	
		}
		System.out.println(sb.toString());
	}
}