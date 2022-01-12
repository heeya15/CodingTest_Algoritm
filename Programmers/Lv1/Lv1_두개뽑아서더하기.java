package 백트래킹;
import java.io.*;
import java.util.*;
/**
 * [ 문제 설명 ]
 * 정수 배열 numbers가 주어집니다. 
 * numbers에서 서로 다른 인덱스에 있는 '두 개의 수를 뽑아 더해서 만들 수 있는 모든 수'를 
 * 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
 * 
 * [ 입력  ]
 * [2,1,3,4,1]
 * [5,0,2,7]
 * 
 * [ 결과  ]
 * [2, 3, 4, 5, 6, 7]
 * [2, 5, 7, 9, 12]
 */
public class Lv1_두개뽑아서더하기 {
    static HashSet<Integer> set;
    static int [] num = new int[2];
	public static void main(String[] args) {
		int [] numbers = {2,1,3,4,1};
		System.out.println(Arrays.toString(solution(numbers)));
		int [] numbers1 = {5,0,2,7};
		System.out.println(Arrays.toString(solution(numbers1)));
	}
	public static int[] solution(int[] numbers) {
		set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(numbers);
        //System.out.println(Arrays.toString(numbers));
        comb(0, 0, numbers);        
        for(int num : set){
            list.add(num);
        }
        Collections.sort(list);
        int size = list.size();
        int[] answer = new int[size];
        for(int i =0; i< size; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    public static void comb(int start, int depth, int [] numbers){
        if(depth == 2){
            int sum = 0;
            for(int n : num){
                sum += n;
            }
            set.add(sum);
            return;
        }
        
        for(int i = start; i<numbers.length; i++ ){
            num[depth] = numbers[i];
            comb(i+1, depth+1, numbers);
        }
    }

}
