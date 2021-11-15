package 문자열;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
public class Main_S4_10825_국영수 {
	static class Student implements Comparable<Student> {
		String name;
		int kor;
		int eng;
		int math;
		public Student(String name, int kor, int eng, int math) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}	
		public int compareTo(Student s) {
			int result = s.kor - this.kor;// 내림차순 
			if(result!=0) return result;
			result = this.eng - s.eng;
			if(result !=0) return result;
			result = s.math - this.math;
			if(result != 0) return result;		
			return this.name.compareTo(s.name);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); // 학생 수
		Student[] temp = new Student[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			temp[i] = new Student(name, kor, eng, math);
		}
		Arrays.sort(temp);
		for(int i=0; i<N; i++) {
			sb.append(temp[i].name).append("\n");
		}
		System.out.println(sb);
	}
}
