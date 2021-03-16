package beakjoon;

import java.util.HashMap;
import java.util.Scanner;

public class P1157 {
	/**
	 * 1. 알파벳 모두 대문자로
	 * 2. 해쉬맵으로
	 * 3. 
	 */
	static String solution(String str) {
		String newStr = str.toUpperCase(); // 1. 모든 문자 모두 대문자로
		//System.out.println("str input : " + newStr);
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for(int i=0; i<newStr.length(); i++) { //2. map에 없으면  0  있으면 +1 
			hm.put(Character.toString(newStr.charAt(i)),hm.getOrDefault(Character.toString(newStr.charAt(i)), 0)+1);
		}
		
		//3. 알파벳 (key)에 대해 최대값 찾기 
		int max = 0;
		String key = "";
		for(String alpha : hm.keySet()) {
			int num = hm.get(alpha);
			if(max<num) {
				max = num;
				key = alpha;
			}
		}
		//System.out.println(key+"의 개수는 : "+ max);
		
		//해당 alpah에 대한 value 삭제후 동일한 최대값이 있는지 확인
		hm.remove(key);
		if(hm.containsValue(max)) { //동일한 값있으면
			return "?";
		}
		//없으면
		return key;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        		String str = sc.nextLine();
		System.out.println(solution(str));
	}
}
