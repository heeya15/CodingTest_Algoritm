package 해시;
import java.util.*;
import java.io.*;
public class Main_S4_1764_듣보잡 {
	static int N, M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 듣도 못한 사람의 수 N
		M = Integer.parseInt(st.nextToken()); // 보도 못한 사람의 수 M
		StringBuilder sb = new StringBuilder();
		HashMap<String,Integer> map = new HashMap();
		//  "N개의 줄에 걸쳐" [ 듣도 못한 사람의 이름과 ],	
		for(int i = 0; i < N; i++) map.put(br.readLine(), i);
		
		ArrayList<String> list = new ArrayList<>();
		// [ N+2째 줄부터 ] 보도 못한 사람의 이름이 순서대로 주어진다.
		for(int j=0; j<M; j++) {
			String line = br.readLine();
			if(map.containsKey(line)) { // 해당하는 보도 못한 사람이, 듣도 못한 사람의 이름에 있다면
				list.add(line); // 듣보잡임으로 듣보잡의 명단 리스트에 추가.
			}
		}
		Collections.sort(list); // 명단을 사전순으로 정렬.
		sb.append(list.size()).append("\n"); // 듣보잡의 수 저장.
		// 명단을 사전순으로 저장.
		for(int i = 0; i< list.size();i++) {
			sb.append(list.get(i)).append("\n");
		}
		// 듣보잡의 수와 그 명단을 사전순으로 출력.
		System.out.print(sb);
	}
}
