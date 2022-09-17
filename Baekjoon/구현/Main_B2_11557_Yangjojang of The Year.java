package 구현;

import java.util.*;
import java.io.*;

public class Main_B2_11557_YangjojangofTheYear {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // 테케 수
	
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine()); // 학교의 숫자
			HashMap<String,Integer> map = new HashMap<>();
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				String school_name = st.nextToken(); // 학교 이름
				int consume_amount_alcohol = Integer.parseInt(st.nextToken()); // 소비한 술의 양
				if(!map.containsKey(school_name)) {
					map.put(school_name, consume_amount_alcohol);
				}else map.put(school_name, map.get(school_name) + consume_amount_alcohol);
			}
			String max_consume_alcohol_school_name = ""; // 가장 소비한 술이 많은 학교 이름을 저장하는 변수
			for (String name : map.keySet()) {
				if(max_consume_alcohol_school_name.equals("")) {
					max_consume_alcohol_school_name = name;
				}else {
					int before_max_value = map.get(max_consume_alcohol_school_name);
					int now_value = map.get(name);
					// 이전 최대 소비한 술의 양이, 현재 학교의 소비한 술 양보다 많으면 -> 그대로 학교이름 유지, 그렇지 않으면 현재 학교 이름으로 갱신
					max_consume_alcohol_school_name = before_max_value > now_value?max_consume_alcohol_school_name : name;
				}
			}
			sb.append(max_consume_alcohol_school_name).append("\n");
		}
		System.out.println(sb.toString());
	}
}