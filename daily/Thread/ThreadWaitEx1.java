package ch13;

import java.util.ArrayList;

public class ThreadWaitEx1 {
	public static void main(String[] args) {
		Table table = new Table(); // 여러 쓰레드가 공유하는 객체
		new Thread(new Cook(table),"COOK1").start();
		new Thread(new Customer(table, "donut"),"CUST1").start();
		new Thread(new Customer(table, "burger"),"CUST2").start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.exit(0);
	}
}

class Customer implements Runnable{
	private Table table;
	private String food;
	
	Customer(Table table, String food){
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


class Cook implements Runnable{ 
	private Table table;
	Cook(Table table){
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

class Table{
	String[] dishNames = {"donut", "donut", "burger"}; 
	final int MAX_FOOD = 6; // 테이블에 놓을 수 있는 최대 음식의 개수
	
	private ArrayList<String> dishes = new ArrayList<>();
	
	
	
	public synchronized void add(String dish) {
		//테이블에 음식이 가득 찼다면 테이블에 음식을 추가하지X
		if(dishes.size() >= MAX_FOOD) {
			String name = Thread.currentThread().getName();
			System.out.println(name+" is waiting because food is full");
			
			try { /**중요---------------------------------*/
				wait(); // cook 쓰레드를 기다리게 한다.
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		dishes.add(dish);
		notify(); // 기다리고 있는 cust를 꺠운다.
		System.out.println("Dishes : " + dishes.toString());	
	}
	
	public boolean remove (String dishName) { // 제거 성공하면 true
		//지정된 오리와 일치하는 요리를 테이블에서 제거한다.
		synchronized (this) {
			String name = Thread.currentThread().getName();
			
			while(dishes.size() == 0) {
				System.out.println(name + " is waiting because food not exist");
				try {
					wait(); // cust 쓰레드를 기다리게 한다.
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
						notify(); // 자리가 1개 비워지니 잠자고 있는 COOK을 꺠우기 위함 
						return true;
					}
				}
				
				//원하는 음식 못찾음
				try {
					System.out.println(name + " is waiting because your's food not found");
					wait(); // 원하는 음식이 없는 cust쓰레드를 기다리게 한다.
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO: handle exception
				}	
			}//while end
		}//synchronized end
	}
	public int dishNum() {return dishNames.length;}
}