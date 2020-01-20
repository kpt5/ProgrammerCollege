package rensyu;
import java.util.ArrayList;
import java.util.List;

public class ListSample {

	public static void main(String[] args) {
//		List<[要素の型]> 変数名 = new ArrayList<[要素の型]>( );
		List<String> list = new ArrayList<String>();

		//値の記憶は add メソッドを利用
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");

		//値の取得
		for (int i = 0; i < list.size(); i++) {
//		for (int i = 0; i < list.length; i++) {	XX
			//値の取得はget メソッドを利用
			System.out.println(list.get(i));
		}

//		要素を削除する
		list.remove(0);

//		インディックスを指定して値を上書きするには？
		list.set(1, "22");

//		要素をすべて削除する
//		list.clear();

		//拡張 for 文を利用するともっと簡単
		for (String s : list) {
			System.out.println(s);
		}

	}

}
