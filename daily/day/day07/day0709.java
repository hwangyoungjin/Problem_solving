package day07;

/*
 * # 숫자 야구 게임
 * 1. me에 1~9 사이의 숫자 3개를 저장
 *    (단, 중복되는 숫자는 저장 불가)
 * 2. com과 me를 비교해 정답을 맞출 때까지 반복
 * 3. 숫자와 자리가 같으면 		strike += 1
 *    숫자만 같고 자리가 틀리면 	ball += 1
 * 예)
 * 정답 : 1 7 3
 * 3 1 5		: 2b
 * 1 5 6		: 1s
 * ...
 */

public class day0709 {
	public static void main(String[] args) {
		int[] com = {1, 7, 3};
		
		while(true) {
			int[] me = new int[3];
			int[] mecnt = new int[9]; //1~9사이 값 중복성 체크
			int index=0;
			while(index<3) { //me에 숫자저장
				int ran = (int)(Math.random()*9);
				if(mecnt[ran]==0) {
					mecnt[ran]=1;
					me[index]=ran+1;
					index++;
				}
			}
			int ball =0;
			int strike =0;
			
			//숫자 맞추기 
			for(int i=0; i<com.length; i++) {
				for(int j=0; j<me.length; j++) {
					if(com[i]==me[j]){ //값 동일
						if(i==j) {
							strike++;
						}
						else {
							ball++;
						}
					}
				}
			}
			if(strike==3) {
				System.out.println(java.util.Arrays.toString(me)+" : 3s");
				System.exit(0);
			}
			if(strike>0 || ball>0) {
				System.out.print(java.util.Arrays.toString(me)+" : "+strike+"s, "+ball+"b");
				System.out.println();
			}
		}
	}
}
