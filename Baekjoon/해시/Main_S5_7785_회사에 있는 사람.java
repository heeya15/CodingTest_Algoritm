package BOJ;
import java.io.*;
import java.util.*;
public class Main_S5_7785_회사에있는사람  {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 기록된 출입 기록 수
		HashSet<String> set = new HashSet<>();
		for(int i = 0; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken();
			String log = st.nextToken();
			// 출근인 경우 set에 해당 사람의 이름을 추가.
			if(log.equals("enter")) set.add(name);
			// set에 해당 이름이 포함 되어 있으면서 , 퇴근인 경우
			else if(log.equals("leave") && set.contains(name)) set.remove(name);		
		}
		StringBuilder sb = new StringBuilder();
		ArrayList<String> result = new ArrayList<>();
		for(String name : set) result.add(name);
		Collections.sort(result,Collections.reverseOrder()); // 내림차순으로 정렬.( 사전의 역순)
		for(String name : result)sb.append(name).append("\n");
		System.out.println(sb.toString());
	}
}
