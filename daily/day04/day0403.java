package day04;

import java.util.Scanner;

public class day0403 {
	/*
	 * # 카카오 택시
	 * 1. 손님을 태워 목적지까지 이동하는 게임이다.
	 * 2. -10~10 사이의 랜덤 숫자 2개를 저장해 목적지로 설정한다.
	 * 3. 메뉴는 아래와 같다.
	 * 		1) 속도설정 : 1~3까지만 가능
	 * 		2) 방향설정 : 동(1)서(2)남(3)북(4)
	 * 		3) 이동하기 : 설정된 방향으로 설정된 속도만큼 이동
	 * 4. 거리 2칸 당 50원씩 추가되어 요금도 출력한다.
	 * 예) 1(50) 2(50) 3(100) 4(100) ...
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 목적지(destination)
		int desX = (int)(Math.random()*20-10);
		int desY = (int)(Math.random()*20-10);
		
		// 현재 위치
		int x = 0;
		int y = 0;
		
		// 방향(direction)
		int dir = 0;
		
		// 속도
		int speed = 0;
		
		// 요금
		int fee = 0;
		
		//이동거리
		int move = 0;
		boolean run = true;
		while(run) {
			
			System.out.println("= 카카오 택시 =");
			System.out.println("목적지 : " + desX + "," + desY);
			System.out.println("현위치 : " + x + "," + y);
			System.out.println("방   향 : " + dir);
			System.out.println("속   도 : " + speed);
			System.out.println("============");
			
			System.out.println("1.방향설정");
			System.out.println("2.속도설정");
			System.out.println("3.이동하기");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1) { // 방향설정
				System.out.print("방향 입력 ( 동(1)서(2)남(3)북(4) ) :");
				dir = scan.nextInt(); // dir 은 1,2,3,4 중 1개
				
			}
			else if(sel == 2) {
				System.out.print("속도 입력 ( 1~3 ) : ");
				speed = scan.nextInt();
			}
			else if(sel == 3) {
					switch(dir) {
					case 1 : // 동쪽 - x축 양의방향
						x += speed;
						break;
					case 2 : // 서쪽 - x축 음의방향
						x -= speed;
						break;
					case 3 : // 남쪽 - y축 음의방향
						y -= speed;
						break;
					case 4 : // 북쪽 - y축 양의방향
						y += speed;
						break;
					}					
					move += speed;
					System.out.println("현재 위치 : ["+x+","+y+"]");
			
				if(x == desX && y==desY) { //목적지 도착했는지 보기
					System.out.println("목적지 도착");
					if((move)%2 == 0 ) {//2의 배수
						fee += ((move)/2)*50;
					}
					else if ((move)%2 == 1){
						fee += ((move)/2)*50;
					}
					System.out.println("택시 요금 : "+fee);
					run = false;
				}
			}
		}
	}
}
