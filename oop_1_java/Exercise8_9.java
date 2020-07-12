package java_jungsuk3_PracticeProblem;

/**
 * 다음과 같은 조건의 예외클래스를 작성하고 테스트하시오.
 * [참고] 생성자는 실행결과를 보고 알맞게 작성해야한다.
 * 클래스명 : UnsupportedFuctionException
 * 조상클래스명 : RuntimeException
 * 멤버변수 :
 * 이 름 : ERR_CODE
 * 저장값 : 에러코드
 * 타 입 : int
 * 기본값 : 100
 * 제어자 : final private
 * 메서드 :
	1. 메서드명 : getErrorCode
	기 능 : 에러코드(ERR_CODE)를 반환한다.
	반환타입 : int
	매개변수 : 없음
	제어자 : public
	2. 메서드명 : getMessage
	기 능 : 메세지의 내용을 반환한다.(Exception클래스의 getMessage()를 오버라이딩)
	반환타입 : String
	매개변수 : 없음
	제어자 : public


[실행결과]
Exception in thread "main" UnsupportedFuctionException: [100]지원하지 않는 기능입니다.
at Exercise8_9.main(Exercise8_9.java:5)
 * @author USER
 *
 */

class UnsupportedFuctionException extends RuntimeException{
	final private int ERROR_CODE;
	
	UnsupportedFuctionException(String msg ,int errCode){
		super(msg); // 조상의 생성자를 통해 msg 초기화한다.
		ERROR_CODE = errCode;
	}
	
	UnsupportedFuctionException(String msg){
		this(msg, 100); // 기본 errorCode = 100
	}
	
	public int getErrorCode() {
		return ERROR_CODE;
	}
	public String getMessage() { //Exception의 getMessage 오버라이딩
		return "["+getErrorCode()+"]"+ super.getMessage(); //super.getMessage 역시 조상의 메서드를 재활용
	}
	
}

public class Exercise8_9 {
	public static void main(String[] args) throws Exception
	{
		throw new UnsupportedFuctionException("지원하지 않는 기능입니다.",100);
	}
}
