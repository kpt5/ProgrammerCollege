package person;

public class Test {

	public static void main(String[] args) {
		Person taro = new Person();
		taro.name = "山田太郎";
		taro.age = 20;
		taro.phoneNumber = "123-456-789";
		taro.address = "半蔵門";

		System.out.println("名前：　" + taro.name);
		System.out.println("年齢：　" + taro.age);
		System.out.println("電話番号：　" + taro.phoneNumber);
		System.out.println("住所：　" + taro.address);
		System.out.println();

		Person jiro = new Person();
		Person hanako = new Person();
		Person ryo = new Person();
		jiro.name = "木村次郎";
		hanako.name = "鈴木花子";
		ryo.name = "板垣遼";
		jiro.age = 18;
		hanako.age = 16;
		ryo.age = 30;

		System.out.println(jiro.name + "、" +  jiro.age + "歳");
		System.out.println(hanako.name + "、" +  hanako.age + "歳");
		System.out.println(ryo.name + "、" +  ryo.age + "歳");
		System.out.println();

		taro.talk();
		taro.walk();
		taro.run();
		System.out.println();

		Robot aibo = new Robot();
		Robot asimo = new Robot();
		Robot pepper = new Robot();
		aibo.name = "アイボ";
		asimo.name = "アシモ";
		pepper.name = "ペッパー";

		aibo.talk();
		aibo.walk();
		aibo.run();
		System.out.println();

		asimo.talk();
		asimo.walk();
		asimo.run();
		System.out.println();

		pepper.talk();
		pepper.walk();
		pepper.run();
		System.out.println();

	}

}
