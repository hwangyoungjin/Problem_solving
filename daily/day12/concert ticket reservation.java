package java_jungsuk3_PracticeProblem;

import java.util.Arrays;
import java.util.Scanner;

import javax.sound.midi.SysexMessage;

/**
 * 1. 공연하루에 한번
 * 2. 좌석 S, A, B 각각 10개씩
 * 3. 메뉴는 
 *   -예약 
 *   -조회 
 *   -취소 
 *   -끝내기
 * 4. 예약은 한자리만 가능
 *   - 좌석타입
 *   - 예약자 이름
 *   - 좌석 번호
 *   순서대로 입력
 * 5. 조회는 모든 좌석을 출력
 * 6. 취소는 예약자 이름을 입력받아 취소
 * 7. 없는 이름, 번호, 메뉴, 잘못된 취소에 대해선 오류 메세지 출력 후 사용자는 다시 시도
 * @author USER
 *
 */
public class Concert {
	public static void main(String[] args) {
		String[] Sseat = new String[10];
		String[] Aseat = new String[10];
		String[] Bseat = new String[10];
		
		for(int i=0; i<Sseat.length; i++) {
			Sseat[i] = "---";
			Aseat[i] = "---";
			Bseat[i] = "---";
		}
		
		int input = 0; //메뉴
		int seatType = 0; //좌석 3가지 
		String name = ""; //이름
		int seatNumber = 0; //좌석번호
		
		Scanner scan = new Scanner(System.in);
		
		
		while(input != 4) {
			System.out.println("명품콘서트홀 예약 시스템입니다.");
			System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4 >>");
			input = scan.nextInt();
			switch(input) {
			case 1: // 예약
				System.out.print("좌석구분 S(1), A(2), B(3) >> ");
				seatType = scan.nextInt();
				scan.nextLine();//개행(엔터)문자 제거
				switch(seatType) {
				case 1: // S석 상태
					System.out.println("S>> "+ Arrays.toString(Sseat));
					System.out.print("이름 >> ");
					name = scan.nextLine();
					System.out.print("번호 >> ");
					seatNumber = scan.nextInt();
					if((Sseat[seatNumber].equals("---"))) {
						Sseat[seatNumber-1] = name;
					}
					else {
						System.out.println("예약된 좌석입니다.");
					}
					break;
				case 2: // A석 상태
					System.out.println("A>> "+ Arrays.toString(Aseat));
					System.out.print("이름 >> ");
					name = scan.nextLine();
					System.out.print("번호 >> ");
					seatNumber = scan.nextInt();
					if(Aseat[seatNumber].equals("---")) {
						Aseat[seatNumber] = name;
					}
					else {
						System.out.println("예약된 좌석입니다.");
					}
					break;
				case 3: // B석 상태
					System.out.println("B>> "+ Arrays.toString(Bseat));
					System.out.print("이름 >> ");
					name = scan.nextLine();
					System.out.print("번호 >> ");
					seatNumber = scan.nextInt();
					if(Bseat[seatNumber].equals("---")) {
						Bseat[seatNumber] = name;
					}
					else {
						System.out.println("예약된 좌석입니다.");
					}
					break;
				}
				break;
			case 2: //조회
				//데이터 출력
				System.out.println("S>> "+ Arrays.toString(Sseat));
				System.out.println("A>> "+ Arrays.toString(Aseat));
				System.out.println("B>> "+ Arrays.toString(Bseat));
				break;
			case 3: //취소
				//데이터 출력
				System.out.println("S>> "+ Arrays.toString(Sseat));
				System.out.println("A>> "+ Arrays.toString(Aseat));
				System.out.println("B>> "+ Arrays.toString(Bseat));
				System.out.print("이름 >> ");
				name = scan.next();
				int changCheck = 0;
				for(int i=0; i<Sseat.length; i++) {
					if( Sseat[i].equals(name)) {
						Sseat[i] = "---";
						System.out.println(name+"님 취소완료");
						changCheck = 1;
						break;
					}
					else if(Aseat[i].equals(name)) {
						Aseat[i] = "---";
						System.out.println(name+"님 취소완료");
						changCheck = 1;
						break;
					}
					else if(Bseat[i].equals(name)) {
						Bseat[i] = "---";
						System.out.println(name+"님 취소완료");
						changCheck = 1;
						break;
					}	
				}
				if(changCheck == 0) {
					System.out.println(name+"님과 일치한 이름이 없습니다.");
				}
				break;
			}
		}//while
	}//main
	
}
