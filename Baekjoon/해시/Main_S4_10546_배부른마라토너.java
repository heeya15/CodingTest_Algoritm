package BOJ;
import java.io.*;
import java.util.*;
public class Main_S4_10546_배부른마라토너 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); // 참가자 수 입력
		
		// 참가자의 이름이 주어짐. -> 이름은  알파벳 소문자로만 이루어져 있다. -> 동명 이인이 있을 수도 있다.
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for(int i = 0; i < N ; i++) {
			String name = br.readLine();
			if(!map.containsKey(name)) map.put(name, 1);
			else map.put(name, map.get(name) + 1);
		}
		// 완주한 참가자들의 이름이 주어짐. -> 완주한 참가자인 경우 해당 key의 값을 -1 시켜줌.
		for(int i = 0; i < N-1 ; i++) {
			String name = br.readLine();
			if(map.containsKey(name)) map.put(name,map.get(name) -1);
		}
		// 완주하지 못한 사람이 있다면 StringBuilder에 추가 시켜줌.
		for(String name : map.keySet()) if(map.get(name) == 1)sb.append(name);
		// 완주하지 못한 사람 출력.
		System.out.println(sb.toString());
		
//		시간 초과난 코드 .. 테스트 케이스 답은 맞게 나왔다..
		
//		LinkedList<String>  names = new LinkedList<>();
//		
//		for(int i = 0; i < N ; i++) names.add(br.readLine());
//		
//		for(int i = 0; i < N-1 ; i++) {
//			String name = br.readLine();
//			if(names.contains(name)) names.remove(name);
//		}
//		for(String name : names) sb.append(name);
//		System.out.println(sb.toString());
	}
}
