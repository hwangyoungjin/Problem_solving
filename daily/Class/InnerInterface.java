class MyButton{ //이벤트성을 가지는 클래스
	
	interface onClickEvent{ //중첩 인터페이스
		void onClick();
	}
	
	onClickEvent event; //중첩 인터페이스 타입의 인스턴스멤버
	
	void setOnClickEvent(onClickEvent event) { //중첩인터페이스타입의 멤버변수 연결
		this.event = event;
	}
	
	void touch() { // 중첩인터페이스타입의 멤버변수로 메서드 실행
		if(event != null) {
			event.onClick();
		}
	}//void
}//class


class Add implements MyButton.onClickEvent{
	@Override
	public void onClick() {
		System.out.println("더하기 이벤트 ");
	}
}

class Multiply implements MyButton.onClickEvent{
	@Override
	public void onClick() {
		System.out.println("곱하기 이벤트 ");
	}
}


public class InnerInterface {
	public static void main(String[] args) {
		MyButton btn = new MyButton();
		
		btn.setOnClickEvent(new Add());
		btn.touch();
		
		btn.setOnClickEvent(new Multiply());
		btn.touch();
		
		
		MyButton.onClickEvent btn1 = new MyButton.onClickEvent() {
			
			@Override
			public void onClick() {
				System.out.println("빼기 이벤트");
			}
		};
		
		btn1.onClick();
		
		MyButton.onClickEvent btn2 = new MyButton.onClickEvent() {
			
			@Override
			public void onClick() {
				System.out.println("나누기 이벤트");
			}
		};
		
		btn2.onClick();	
	}
}


