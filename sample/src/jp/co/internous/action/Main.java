package jp.co.internous.action;

public class Main {

	public static void main(String[] args){
		System.out.println("Hello World");
//		※変数とメソッドのデータ型は一致させる
		int total =gokei();
		System.out.println(total);
		System.out.println(gokei());
		System.out.println(gokei2(2,3));
		System.out.println(gokei2(5,7));
		System.out.println(circle(5));
		System.out.println(hikizan(10,10));
		System.out.println(kakezan(10,10));
		System.out.println(warizan(10,10));
	}
	public static int gokei() {
		return 1+1;
	}
	public static int gokei2(int number1, int number2) {
		return number1 + number2;
	}
	public static double circle(int hankei) {
		return hankei * hankei * 3.14;
	}
	public static int hikizan(int number1, int number2) {
		return number1 - number2;
	}
	public static int kakezan(int number1, int number2) {
		return number1 * number2;
	}
	public static int warizan(int number1, int number2) {
		return number1 / number2;
	}
}
