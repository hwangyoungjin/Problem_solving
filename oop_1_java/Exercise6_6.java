package java_jungsuk3_PracticeProblem;

/* 6_6~6_7
 * 
 * 두 점 거리 계산*/
class MyPoint{
	int x;
	int y;
	
	MyPoint(int x, int y){
		this.x = x;
		this.y = y;
	}
	double getDistance(int x1, int y1) {
		//x,y는 인스턴스 변수
		return Math.sqrt((x-x1)*(x-x1)+(y-y1)*(y-y1));
	}
}

public class Exercise6_6 {
	public static void main(String[] args) {
		MyPoint p = new MyPoint(1,1);
		// p와 (2,2)의 거리구하기
		System.out.println(p.getDistance(2, 2));
	}
}
