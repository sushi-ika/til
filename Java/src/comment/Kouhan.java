package comment;

public class Kouhan {
	public static void callShimobe() {
		System.out.println("<魔王>いでよ、わがしもべたち。勇者一味をかわいがってやるのだ。");
	}
	public static void goBattle() throws Exception{
		System.out.println("<勇者>これまで共に戦ってくれた仲間のみんな、");
		System.out.println("<勇者>最後まで力を合わせて平和を取り戻すんだ。");
		Thread.sleep(2000);
		Zenhan.doIsami();
	}

}
