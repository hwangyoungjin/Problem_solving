package day02;

public class day0209 {
	public static void main(String[] args) {
		int su = (int)(Math.random()*50+1);
		int count = 0; //짝 개수 값 저장
		if (su/10 == 3 || su/10 == 6 || su/10 == 9 ) {
			count++;
		}
		if(su%10==3 || su%10==6 || su%10== 9) {
			count++;
		}
		if(count != 0) {
			System.out.print(su+" : ");
			for(int i=0; i<count; i++) {
				System.out.print("짝");
			}
		}
		else if(count==0) {
			System.out.print(su+" : "+su);
		}
	}
}
