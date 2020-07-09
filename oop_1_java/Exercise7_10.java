package java_jungsuk3_PracticeProblem;

/**
 * MyTv2클래스의 멤버변수 isPowerOn, channel, volume을 클래스 외부에서 접근할수 
 * 없도록 제어자를 붙이고 대신 이 멤버변수들의 값을 어디서나 읽고 변경할 수 있도록
 * getter와 setter메서드를 추가하라.
 * 
 * +
 * MyTv2클래스에 이전 채널(previous channel)로 이동하는 기능의 메서드를 추가
 * 
 * @author USER
 *
 */
class MyTv2{
	private boolean isPowerOn;
	private int channel;
	private int volumn;
	private int preChannel;
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) { //반드시 유효성검사
		if(channel < MIN_CHANNEL || channel > MAX_CHANNEL ) {
			return;
		}
		this.preChannel = this.channel; // 이전채널 저장
		this.channel = channel;
	}
	public int getVolumn() {
		return volumn;
	}
	public void setVolumn(int volumn) { //반드시 유효성검사
		if(volumn < MIN_VOLUME || volumn > MAX_VOLUME)
		this.volumn = volumn;
	}
	
	void gotoPrevChannel() {
		setChannel(this.preChannel);
	}
}
public class Exercise7_10 {
	public static void main(String[] args) {
		MyTv2 t = new MyTv2();
		
		t.setChannel(2);
		System.out.println("CH : "+t.getChannel());
		
		t.setVolumn(20);
		System.out.println("VOL : "+t.getVolumn());
	
		t.gotoPrevChannel();
		System.out.println("CH : "+t.getChannel());
		
		t.gotoPrevChannel();
		System.out.println("CH : "+t.getChannel());
		
	}

}
