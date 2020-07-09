package java_jungsuk3_PracticeProblem;

/**
 * 섯다카드 20장을 포함하는 섯다카드 한 벌(SutdaDeck클래스)을 정의한 것이다. 
 * 섯다카드 20장을 담는 SutdaCard배열을 초기화하시오. 
 * 단, 섯다카드는 1부터 10까지의 숫자가 적힌 카드가 한 쌍씩 있고,
 * 숫자가 1, 3, 8인 경우에는 둘 중의 한 장은 광(Kwang)이어야 한다. 
 * 즉, SutdaCard의 인스턴스변수 isKwang의 값이 true이어야 한다.
 * +
 * SutdaDeck클래스에 다음에 정의된 새로운 메서드를 추가
 * @author USER
 *
 */
class SutdaDeck{
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	SutdaDeck(){ // 섯다카드 생성
		for(int i=0; i<cards.length; i++) {
			int num = i%10+1;
			boolean isKwang = (i<10) && (num==1||num==3||num==8);
			cards[i] = new SutdaCard(num,isKwang);
		}
	}
	
	void shuffle() { // 배열에 담긴 카드의 위치 섞기
		for(int i=0; i<cards.length; i++) {
			int num = (int)Math.random()*20;
			SutdaCard tmp = cards[i];
			cards[i] = cards[num];
			cards[num] = tmp;
		}	
	}
	
	SutdaCard pick() {
		int num1 = (int)Math.random()*20;
		return pick(num1);
	}
	
	SutdaCard pick(int index) {
		if(index < 0 || index >= CARD_NUM) {
			return null;
		}
		return cards[index];
	}
	
	
}//sutdaDeck

// 생성되면 숫자와 iskwang는 바뀌면 안된다.
class SutdaCard{
	final int NUM;
	final boolean IS_KWNAG;
	
	SutdaCard(){
		this(1,true);
	}
	
	//원래 final 변수는 선언과 동시에 초기화 해야하지만
	//인스턴스 변수의 경우 선언시 초기화 하지않고 생성자에서 초기화한다.
	//상수이므로 생성시 초기화 하면 이후 다신 바꿀 수 없다.
	SutdaCard(int num, boolean isKwang){
		this.NUM = num;
		this.IS_KWNAG = isKwang;
	}
	public String toString() {
		return NUM + (IS_KWNAG ? "K":"");
	}
}
public class Exercise7_1 {
	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();
		
		System.out.println(deck.pick(0));
		System.out.println(deck.pick());
		deck.shuffle();
		
		for(int i=0; i<deck.cards.length; i++) {
			System.out.print(deck.cards[i]+",");
		}
		
		System.out.println();
		System.out.println(deck.pick(0));
	}
}
