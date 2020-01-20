package person2;

public class Capsule {

	public static void main(String[] args) {
		Person taro = new Person("山田太郎",20);
//		System.out.println(taro.name);
		System.out.println(taro.getName());

		taro.setName("花子");
		System.out.println(taro.getName());

		System.out.println("年齢：" + taro.getAge());
		taro.setAge(30);
		System.out.println("年齢：" + taro.getAge());

	}

}
