package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lv2_게임맵최단거리 {
	public static class Pos{
	    int r,c,time; 
	    Pos(int r, int c, int time){
	        this.r = r;
	        this.c = c;
	        this.time = time;
	    }
	}
	static int maps[][] = {{1,0,1,1,1},
	                       {1,0,1,0,1},
	                       {1,0,1,1,1},
	                       {1,1,1,0,1},
	                       {0,0,0,0,1}};
	
	// 델타 배열 : 상, 하, 좌, 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static int answer = Integer.MAX_VALUE;
	static int end_r,end_c;
	public static void main(String[] args) throws Exception {
		 end_r = maps.length -1;
	     end_c = maps[0].length -1;
	     System.out.println(end_r+" " +end_c);
	     visited = new boolean[end_r+1][end_c+1];
	     bfs(0,0,maps);
		 // 도착지 이동 불가능 할때 -1
		 if (answer == Integer.MAX_VALUE)System.out.println(-1);
		 else System.out.println(answer); // 도착지에 도착하였을때 최단 거리 출력
	}

	private static void bfs(int sr, int sc, int maps[][]) {
		  Queue<Pos > q = new LinkedList<>();
	        q.offer(new Pos(sr,sc,1));
	        visited[sr][sc] = true;
	        while(!q.isEmpty()){
	            Pos temp = q.poll();
	            int r = temp.r;
	            int c = temp.c;
	            int time = temp.time;
	            if(r== end_r && c == end_c){
	                answer = Math.min(answer,time);
	            }
	            for(int i=0; i < 4 ; i++){
	                int nr = r + dr[i];
	                int nc = c + dc[i];
	                if(nr < 0 || nc < 0  || nr > end_r || nc > end_c )continue;
	                
	                if(maps[nr][nc] ==1&& !visited[nr][nc]){
	                     visited[nr][nc] = true;
	                     q.offer(new Pos(nr,nc, time+1));
	                }
	            }
	      }
	}
}
