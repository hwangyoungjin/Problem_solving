package java_jungsuk3_PracticeProblem;


class Student1{
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	
	Student1(String name, int ban, int no, int kor, int eng, int math){
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	String info() {
		return name
				+","+ban
				+","+no
				+","+kor
				+","+eng
				+","+math
				+","+getTotal()
				+","+getAverage()
				;
	}
	
	int getTotal() {
		return kor+eng+math;
	}
	float getAverage() {
		return ((int)(getTotal()/3f * 10+ 0.5)/10f);
	}
}


public class Exercise6_5 {
	public static void main(String[] args) {
		Student1 s = new Student1("홍길동",1,1,100,60,76);
		System.out.println(s.info());
	}
}
