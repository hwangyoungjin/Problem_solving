package ch13;

public class Thread20 {
	public static void main(String[] args) {
		ThreadEx20_1 gc = new ThreadEx20_1();
		gc.setDaemon(true); // main의 데모 쓰레드로 지정
		gc.start();
		
		int requiredMemory = 0;
		
		for(int i=0; i<20; i++) { // 필요한 메모리 계속 입력
			requiredMemory = (int)(Math.random()*10)*20;
			
			if(gc.freeMemory() < requiredMemory || gc.freeMemory() < gc.totalMemory() *0.4 ) {
				//필요한 메모리가 사용할 수 있는 양보다 크거나, 남은메모리가 전체 메모리의 40%보다 적으면
				gc.interrupt(); // 잠자고 있는 쓰레드 깨운다.
				//gc가 수행되기전 main이 수행되는것을 방지하기위해
				try {
					gc.join(100);
				} catch (InterruptedException e) {}
			}
			
			gc.usedMemory += requiredMemory; // gc의 사용된 메모리에 계속추가 
			System.out.println("-----------------usedMemory ++ "+requiredMemory);
			System.out.println("usedMemory : " + gc.usedMemory);
			System.out.println();
		}
	}
}

class ThreadEx20_1 extends Thread{
	final static int MAX_MEMORY = 1000;
	int usedMemory = 0;
	
	public void run() { // 10초마나 garbage collecter 수행 
		while(true) {
			try {
				Thread.sleep(1000*10); // 10초 대기
			} catch (InterruptedException e) {
				System.out.println("Awaken by interrupted().");
			}
			
			gc(); 
			System.out.println("Garbage Collected. Free memory : " + freeMemory());
			System.out.println();
		}
	}
	
	public void gc() { //가비지컬렉터 - 사용된 메모리 양 줄이기 
		usedMemory -= 300;
		System.out.println("-----------------usedMemory -300! ");
		if(usedMemory < 0) {
			usedMemory = 0;
		}
	}
	public int totalMemory() { // 총 메모리양
		return MAX_MEMORY;
	}
	public int freeMemory() { // 현재까지 남은 메모리
		return MAX_MEMORY - usedMemory;
	}
}