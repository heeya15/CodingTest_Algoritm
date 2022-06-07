package BaekJoon_self;
import java.io.*;
import java.util.*;
public class Main_S1_13335_트럭 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken()); // 다리를 건너는 트럭의 수
		int w = Integer.parseInt(st.nextToken()); // 다리의 길이
		int L = Integer.parseInt(st.nextToken()); // 최대하중
		
		int truck_weight [] = new int[n];
		st = new StringTokenizer(br.readLine()," ");
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			truck_weight[i] = Integer.parseInt(st.nextToken());
		}
		int time = 0;
		
		int sum = 0; // 다리 위에 올라갈 수 있는 트럭 최대 무게 합
		for (int i = 0; i < truck_weight.length; i++) {
			while(true) {
				if(q.isEmpty()) { // 다리위에 올라간 트럭이 없다면
					q.offer(truck_weight[i]);
					sum += truck_weight[i];
					time++;
					break;
				} 
				else {
					if(q.size() == w ) {
						sum-= q.poll();
					}
					if(sum + truck_weight[i] <= L ) {
						q.offer(truck_weight[i]);
						sum += truck_weight[i];
						time++;
						break;
					}else {
						q.offer(0);
						time++;	
					}
				}
			}
		}
		System.out.println(time+w);
			
	}
}
