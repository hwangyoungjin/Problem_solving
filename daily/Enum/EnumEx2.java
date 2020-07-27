package ch12;

enum Direction1 {
	//EAST변수는 value가 1이고 symbol은 ">"
	EAST(1,">"), SOUTH(2,"v"), WEST(3,"<"), NORTH(4,"^");
	
	private static final Direction1[] DIR_ARR =  Direction1.values();
	private final int value;
	private final String symbol;
	
	Direction1(int value,String symbol){ //접근제어자 private 생략됨
		this.value = value;
		this.symbol = symbol;
	}
	
	public int getValue() {
		return value;
	}
	public String getSymbol() {
		return symbol;
	}
	
	public static Direction1 of(int dir) {
		if(dir < 1 || dir > 4) {
			throw new IllegalArgumentException("Invalid value : "+ dir);
		}
		return DIR_ARR[dir -1];
	}

	//방향을 회전시키는 메서드. num의 갑만큼 90도 씩 시계방향으로 회전
	public Direction1 rotate(int num) {
		num = num % 4;
		if(num<0) {
			num+=4;
		}
		return DIR_ARR[(value-1+num)%4];
	}
	
}// enum end

public class EnumEx2 {
	public static void main(String[] args) {
		for(Direction1 d : Direction1.values()) {
			System.out.printf("%s=%d\n", d.name(), d.ordinal());
		}
		
		System.out.println();
		Direction1 d1 = Direction1.EAST;
		Direction1 d2 = Direction1.of(6);
		System.out.printf("%s=%d\n", d1.name(), d1.getValue());
		System.out.printf("%s=%d\n", d2.name(), d2.getValue());
		
		System.out.println();
		System.out.println(Direction1.EAST.rotate(1));
		System.out.println(Direction1.EAST.rotate(2));
		System.out.println(Direction1.EAST.rotate(-1));
		System.out.println(Direction1.EAST.rotate(-2));

		
	}
}
