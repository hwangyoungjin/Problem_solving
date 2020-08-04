package ch13;

import javax.swing.JOptionPane;

public class ThreadEx13 {
	public static void main(String[] args) {
		ThreadEx13_1 th1 = new ThreadEx13_1();
		th1.start(); //th1 의 interrupted 상태 false 
		
		String input = JOptionPane.showInputDialog("아무값이나 입력");
		
		th1.interrupt(); // 입력을 받으면 interrupt()호출  -> th1 의 interrupted 상태 true 
		System.out.println("isInterrupted : "+ th1.isInterrupted());
	}
}

class ThreadEx13_1 extends Thread {
	public void run() {
		int i = 10;
		while(i != 0 && !isInterrupted()) { 
			// interrupt() 호출되면 interrupted 상태 true로 바뀌어서 while문 break!
			
			System.out.println(i--);
			
			try { // 시간 1초 지연
				Thread.sleep(1000);
			} catch (InterruptedException e) { 
				// interrupt() 호출시 InterruptedException 예외 catch하지만 
				//카운트 종료시키기 위해 다시 interrupt() 호출 
				//-> interrupted 상태 true -> while문 break!
				interrupt();
			} 
		}
		System.out.println("카운트 종료");
	}
}