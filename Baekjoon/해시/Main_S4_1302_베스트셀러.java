package BOJ;
import java.io.*;
import java.util.*;
public class Main_S4_1302_베스트셀러 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); // 팔린 책의 개수 입력
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for(int i = 0; i<N ;i++ ) {
			String title = br.readLine(); // 책 제목
			if(!map.containsKey(title)) map.put(title, 1);
			else map.put(title, map.get(title)+1);
		}
		// 가장 많이 팔린 책의 개수를 max 변수에 저장.
		int max = Integer.MIN_VALUE;
		for(String title : map.keySet()) max = Math.max(max, map.get(title));
		
		// 가장 많이 팔린 책의 제목을 ArrayList에 저장.
		ArrayList<String> result = new ArrayList<String>();
		for(String title : map.keySet()) {
			if(max == map.get(title)) result.add(title);
		}
		// 가장 많이 팔린 책이 여러개일 경우 사전 순으로 가장 앞서는 제목 1나를 출력.
		if(result.size() >1) Collections.sort(result);

		sb.append(result.get(0)).append("\n");
		System.out.println(sb.toString());
	}
}
