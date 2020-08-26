
final class Card10{
	String kind;
	int num;
	Card10(){
		this("SPADE",1);
	}
	Card10(String kind, int num){
		this.kind = kind;
		this.num = num;
	}
	
	public String toString(){
		return kind + " : " + num;
	}
	
	interface Dealer{
		void shuffle();
	}

	interface Player{}
	
}


interface CardPlayer{
	String run();
}

public class ClassEx1 {
	
	public static void main(String[] args) throws Exception{
		Card10 c = new Card10("HEART",3);
		Card10 c2 = Card10.class.newInstance();
		
		Class cObj = c.getClass();
		
		System.out.println(c);
		System.out.println(c2);
		System.out.println(cObj.getName());
		System.out.println(cObj.toGenericString());
		System.out.println(cObj.toString());
		
		System.out.println("\n====================interface====================\n");
		
		CardPlayer player1 = new CardPlayer() {
			
			@Override
			public String run() {
				return "게임참가";
			}
		};
		
		//CardPlayer player2 = CardPlayer.class.newInstance();
		
		Class pObj = player1.getClass();
	
		System.out.println(player1.run());
		System.out.println(pObj.getName());
		System.out.println(pObj.toGenericString());
		System.out.println(pObj.toString());
		
	}
}

