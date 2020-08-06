package ch13;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadWaitEx4 {
	public static void main(String[] args) {
		Table1 table = new Table1(); // 여러 쓰레드가 공유하는 객체
		new Thread(new Cook1(table),"COOK1").start();
		new Thread(new Customer1(table, "donut"),"CUST1").start();
		new Thread(new Customer1(table, "burger"),"CUST2").start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.exit(0);
	}
}

class Customer1 implements Runnable{
	private Table1 table;
	private String food;
	
	Customer1(Table1 table, String food){
		this.table = table;
		this.food = food;
	}
	
	public void run() { //0.1초 마다 음식 먹기
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			
			String name = Thread.currentThread().getName();
			
			if(eatFood()) {
				System.out.println(name + " ate a " + food);
			}
			else {
				System.out.println(name + " failed to eat. : ( ");
			}
		}
	}

	boolean eatFood() {
		return table.remove(food);
	}
}


class Cook1 implements Runnable{ 
	private Table1 table;
	Cook1(Table1 table){
		this.table = table;
	}
	
	public void run() { // 0.01초 마다 음식 추가하기
		while(true) {
			//임의의 요리를 하나 선택해서 table에 추가한다.
			int idx = (int)(Math.random()*table.dishNum());
			table.add(table.dishNames[idx]);
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}

class Table1{
	String[] dishNames = {"donut", "donut", "burger"}; 
	final int MAX_FOOD = 6; // 테이블에 놓을 수 있는 최대 음식의 개수
	
	private ArrayList<String> dishes = new ArrayList<>();
	
	private ReentrantLock lock = new ReentrantLock();
	private Condition forCook = lock.newCondition();
	private Condition forCust = lock.newCondition();
	
	
	public  void add(String dish) {
		
		lock.lock();
		
		try { //임계영역
			while(dishes.size() >= MAX_FOOD) {
			//테이블에 음식이 가득 찼다면 테이블에 음식을 추가하지X
				String name = Thread.currentThread().getName();
				System.out.println(name+" is waiting because food is full");
				
				try { /**중요---------------------------------*/
					forCook.await(); // cook 쓰레드를 기다리게 한다.
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
			}
			//음식 채워넣을 수 있음
			dishes.add(dish);
			forCust.signal(); // 음식 채웠으니 기다리고 있는 cust를 꺠운다.
			System.out.println("Dishes : " + dishes.toString());	

		} finally {
			lock.unlock();
		}		
	}
	
	public boolean remove (String dishName) { // 제거 성공하면 true
		//지정된 오리와 일치하는 요리를 테이블에서 제거한다.
		lock.lock();  //synchronized (this)
		
		try { //critical Section
		
			String name = Thread.currentThread().getName();
			
			while(dishes.size() == 0) {
				System.out.println(name + " is waiting because food not exist");
				try {
					forCust.await(); // cust 쓰레드를 기다리게 한다.
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
			}//while end
			
			//음식 존재
			while(true) {
				for(int i=0; i<dishes.size(); i++) {
					if(dishName.equals(dishes.get(i))){
						dishes.remove(i);
						forCook.signal(); // 자리가 1개 비워지니 잠자고 있는 COOK을 꺠우기 위함 
						return true;
					}
				}
				//원하는 음식 못찾음
				try {
					System.out.println(name + " is waiting because your's food not found");
					forCust.await(); // 원하는 음식이 없는 cust쓰레드를 기다리게 한다.
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO: handle exception
				}	
			}//while end
			
		} finally {
			lock.unlock();
		}//synchronized end
	}
	public int dishNum() {return dishNames.length;}
}