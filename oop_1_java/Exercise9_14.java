package java_jungsuk3_PracticeProblem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 다음은 화면으로부터 전화번호의 일부를 입력받아 일치하는 전화번호를 주어진
 * 문자열 배열에서 찾아서 출력하는 프로그램이다. 알맞은 코드를 넣어 프로그램을 완성하시오.
 * @author USER
 *
 */
public class Exercise9_14 {
	public static void main(String[] args) {
		String[] phoneNumArr = {
								"012-3456-7890",
								"099-2456-7980",
								"088-2346-9870",
								"013-3456-7890"
								};
		ArrayList list = new ArrayList();
		Scanner s = new Scanner(System.in);
		while(true) {
			System.out.print(">>");
			String input = s.nextLine().trim();
			
			if(input.equals("")) {
				continue;
			} 
			else if(input.equalsIgnoreCase("Q")) {
				System.exit(0);
			}
			/*
			(1) 알맞은 코드를 넣어 완성하시오.
			*/
			else {
				for(int i=0; i<phoneNumArr.length; i++) {
					if(phoneNumArr[i].indexOf(input) != -1) { //해당 String 에 input 값 존재하는지 확인
						list.add(phoneNumArr[i]);
					}
				}
			}
			
			if(list.size()>0) { // list한에 결과 있으면 
				System.out.println(list); // 출력 후 
				list.clear(); // 삭제
			} else {
				System.out.println("일치하는 번호가 없습니다.");
			}
		}
	} // main
}//class

