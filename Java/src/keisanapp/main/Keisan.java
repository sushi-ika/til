
package keisanapp.main;

public class Keisan {

	public static void main(String[] args) {
		int a = 10;
		int b = 7;
		int sum = keisanapp.logics.KeisanLogic.tasu(a, b);
		int minus = keisanapp.logics.KeisanLogic.hiku(a, b);
		System.out.println("加算結果:" + sum + "減算結果:" + minus);
	}

}
